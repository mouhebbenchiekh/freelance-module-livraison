package com.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.entities.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
