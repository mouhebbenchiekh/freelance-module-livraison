package com.pi.service;

import java.util.List;

import com.pi.entities.Decision;

public interface IDecisionService {
	public Decision addDecision(Decision  Decision);
	 public List<Decision> listDecision();
	 public Decision updateDecision(Decision Decision);
	 public void deleteDecisionById(Long idDec);

}
