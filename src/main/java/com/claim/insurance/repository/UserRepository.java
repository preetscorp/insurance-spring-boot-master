package com.claim.insurance.repository;

import org.springframework.data.repository.CrudRepository;

import com.claim.insurance.persistence.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
