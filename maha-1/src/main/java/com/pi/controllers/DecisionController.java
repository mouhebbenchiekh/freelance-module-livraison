package com.pi.controllers;
import com.pi.entities.Claim;
import com.pi.entities.Decision;
import com.pi.entities.enum2.state;
import com.pi.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecisionController {
	
	@Autowired
	DecisionServiceImpl DecisionServiceImpl;
	
	@Autowired
	ClaimServiceImpl claimService;

	//http://localhost:8082/maha/servlet/addDecision
	@PostMapping("/addDecision/{id}")
	public Decision addDecision(@RequestBody Decision Decision,@PathVariable long id){
		Claim c= claimService.getClaimById(id);
		c.getIdCommande().setState(state.blocked);
		Decision.setIdClaim(c);
		Decision d=DecisionServiceImpl.addDecision(Decision);
		return Decision;
		
	}
	 // http://localhost:8082/maha/servlet/listDecision
			@GetMapping("/listDecision")
			public List<Decision> listDecision() {
				List<Decision> listD=DecisionServiceImpl.listDecision();
		        return listD;
			}
			
			/*// http://localhost:8082/maha/servlet/updateDecision
			@PutMapping("/updateDecision")
			public Decision updateDecision(Decision Decision) {
				return DecisionServiceImpl.updateDecision(Decision);
			}
			*/
			// http://localhost:8082/maha/servlet/deleteDecision
			@DeleteMapping("/deleteDecision/{idDecision}")
			@ResponseBody
			public void deleteDecision(@PathVariable("idDecision") long IdDec) {
				DecisionServiceImpl.deleteDecisionById(IdDec);
			}
			
		
}
