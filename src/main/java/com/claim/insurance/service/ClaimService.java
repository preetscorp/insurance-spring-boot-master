package com.claim.insurance.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.insurance.model.ClaimRequest;
import com.claim.insurance.persistence.Claim;
import com.claim.insurance.repository.ClaimRepository;

@Service
public class ClaimService {

	@Autowired
	ClaimRepository claimRepo;

	Logger logger = Logger.getLogger(ClaimService.class);

	public Integer fileClaim(ClaimRequest request) {

		Claim c = claimRepo.save(new Claim(request.getUserId(), request.getPolicyNo(), request.getVehicleNo(),
				request.getDlNo(), request.getClaimAmt(), request.getInsuranceCompanyid(), request.getCreateBy(),
				LocalDateTime.now()));

		logger.info("Claim id :" + c.getClaimId());

		return c.getClaimId();
	}

	public void updateClaim(Integer custId) {
		Optional<Claim> c = claimRepo.findById(custId);
		Claim claim = c.get();
		claim.setClaimStatus("APPROVED");
		claim.setUpdateBy("INSPR");
		claim.setUpdateTs(LocalDateTime.now());
		claimRepo.save(c.get());
	}

	public Claim getClaimById(Integer custId) {
		return claimRepo.findById(custId).get();
	}

	public String getClaimStatus(Integer custId) {
		return claimRepo.findById(custId).get().getClaimStatus();
	}

	public List<Claim> getAllClaims() {
		return claimRepo.findAll();
	}

	public List<Claim> getAllClaims(String dateStr) {
		LocalDateTime date = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("MMddyyyy"));
		return claimRepo.findByCreateTs(date);
	}

}
