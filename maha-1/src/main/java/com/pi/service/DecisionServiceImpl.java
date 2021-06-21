package com.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.entities.Claim;
import com.pi.entities.Decision;
import com.pi.repository.DecisionRepository;

@Service
public class DecisionServiceImpl implements IDecisionService {
	
	@Autowired
DecisionRepository DecisionRep;
	
	
	 public Decision addDecision(Decision  Decision){
		 DecisionRep.save(Decision);
		 return Decision;
	 }
	 
	 public List<Decision> listDecision(){
		 return (List<Decision>) DecisionRep.findAll();
	 }
	 
	 public Decision updateDecision(Decision Decision){
		 DecisionRep.save(Decision);
			return Decision;
		}
	 
	 public void deleteDecisionById(Long idDec){
			Decision decisionManagementEntity=DecisionRep.findById((long) idDec).get();
			DecisionRep.delete(decisionManagementEntity);
		}
}
