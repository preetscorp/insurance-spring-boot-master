package com.claim.insurance.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.claim.insurance.config.CustomAppProperties;
import com.claim.insurance.persistence.User;
import com.claim.insurance.repository.UserRepository;

@Component
public class InsuranceCommandLineRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	CustomAppProperties prop;

	Logger logger = Logger.getLogger(InsuranceCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("em.properties loaded :::" + prop.getReportFolder());
		userRepo.save(new User("Preethi", "CUST"));
		userRepo.save(new User("Maha", "SREP"));
		userRepo.save(new User("Hari", "INSPR"));
	}

}
