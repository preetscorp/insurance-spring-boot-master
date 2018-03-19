package com.claim.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.claim.insurance.repository.UserRepository;

public class UserService {
	@Autowired
	UserRepository userRepo;

	public String getRoleBasedOnUserId(Integer id) {
		return userRepo.findById(id).get().getUserRole();
	}

}
