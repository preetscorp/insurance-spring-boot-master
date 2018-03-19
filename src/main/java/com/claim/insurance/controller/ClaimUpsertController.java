package com.claim.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.claim.insurance.model.ClaimRequest;
import com.claim.insurance.service.ClaimService;

@RestController
public class ClaimUpsertController {

		@Autowired
		ClaimService service;

		@PostMapping(value = "/requestClaim", produces = "application/json", consumes = "application/json")
		public Integer fileClaim(@RequestBody ClaimRequest request) {
			return service.fileClaim(request);
		}

		@PutMapping("/updateClaimStatus/{cId}")
		public void updateClaimStatus(@PathVariable("cId") Integer cId) {
			service.updateClaim(cId);
		}

}
