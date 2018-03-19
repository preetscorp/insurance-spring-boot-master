package com.claim.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.claim.insurance.service.UserService;

public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/getRoleBasedOnUserId/{userId}")
	public String getRoleBasedOnUserId(@PathVariable("userId") Integer id) {
		return service.getRoleBasedOnUserId(id);
	}
}
