package com.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.entities.Decision;

public interface DecisionRepository extends JpaRepository<Decision, Long> {

}
