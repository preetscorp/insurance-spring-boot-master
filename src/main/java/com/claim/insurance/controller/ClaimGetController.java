package com.claim.insurance.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claim.insurance.persistence.Claim;
import com.claim.insurance.service.ClaimService;

@RestController
public class ClaimGetController {

	@Autowired
	ClaimService service;

	@GetMapping("/getAllClaims")
	public List<Claim> getAllClaims() {
		return service.getAllClaims();
	}

	@GetMapping("/getAllClaimsByDate")
	public List<Claim> getAllClaims(@RequestParam String date) {
		LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
		return service.getAllClaims();
	}
	
	@GetMapping("/getClaimById/{custId}")  
	public Claim getClaimById(@PathVariable("custId") Integer id) {
		return service.getClaimById(id);
	}
	
	@GetMapping("/getClaimStatus/{custId}")  /* Requirement 3*/
	public String getClaimStatus(@PathVariable("custId") Integer id) {
		return service.getClaimStatus(id);
	}

}
