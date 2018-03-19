package com.claim.insurance.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claim.insurance.persistence.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	List<Claim> findByCreateTs(LocalDateTime date);
}
