package com.claim.insurance.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.claim.insurance.config.CustomAppProperties;
import com.claim.insurance.persistence.Claim;
import com.claim.insurance.service.ClaimService;
import com.claim.insurance.service.utils.MyExcelView;

@RestController
public class DailyReportScheduler {

	@Autowired
	ClaimService service;

	Logger logger = Logger.getLogger(DailyReportScheduler.class);

	@Autowired
	CustomAppProperties prop;

	@Scheduled(cron = "0 6 23 * * *")
	public void genDailySchedReports() throws IOException {
		logger.info("genDailySchedReports :: at {}", LocalDateTime.now(), null);
		List<Claim> claims = service.getAllClaims();

		Map<String, Object> model = new HashMap<String, Object>();
		List<String> headers = new ArrayList<String>();

		headers.add("Claim ID");
		headers.add("User ID");
		headers.add("Vehicle#");
		headers.add("Liscence#");
		headers.add("Amount");
		headers.add("Insurance Company");
		headers.add("Policy#");
		headers.add("Created By");
		headers.add("Created Date");
		headers.add("Updated By");
		headers.add("Updated Date");

		model.put("headers", headers);
		
		/* Key - Status , Value - Records for that Status*/
		Map<String, List<Claim>> statusMapped = claims.stream().collect(Collectors.groupingBy(Claim::getClaimStatus));
		
		List<String> statuses = new ArrayList<>(statusMapped.keySet());
		statuses.forEach(status -> {
			int sheetNo = statuses.indexOf(status) + 1;
			model.put(String.format("sheetname%d", sheetNo), status);
			List<List<Object>> results = new ArrayList<List<Object>>();
			statusMapped.get(status).stream().forEach(claim -> {
				List<Object> rec = new ArrayList<Object>();
				rec.add(claim.getClaimId());
				rec.add(claim.getUserId());
				rec.add(claim.getVehicleNo());
				rec.add(claim.getDlNo());
				rec.add(claim.getClaimAmt());
				rec.add(claim.getInsuranceProviderId());
				rec.add(claim.getPolicyNo());
				rec.add(claim.getCreateBy());
				rec.add(claim.getCreateTs());
				rec.add(claim.getUpdateBy());
				rec.add(claim.getUpdateTs());
				results.add(rec);
			});
			model.put(String.format("results%d", sheetNo), results);
		});

		model.put("totalSheets", statuses.size());
		new MyExcelView().writeToExcelFile(model, prop.getReportFolder() + "/report"
				+ LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + ".xls");

	}
}
