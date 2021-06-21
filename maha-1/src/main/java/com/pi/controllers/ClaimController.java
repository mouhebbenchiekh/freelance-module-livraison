package com.pi.controllers;

import com.pi.service.ClaimServiceImpl;
import com.pi.service.CommandeServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.pi.entities.Claim;
import com.pi.entities.commande;

@RestController
public class ClaimController {
	
	@Autowired
	ClaimServiceImpl ClaimServiceImpl;
	
	@Autowired
	CommandeServiceImpl com;

	//http://localhost:8082/maha/servlet/addClaim
	@PostMapping("/addClaim/{id}")
	public Claim addClaim(@RequestBody Claim Claim,@PathVariable long id) {
		commande comm=com.getcommandeById(id);
		Claim.setIdCommande(comm);
		Claim c= ClaimServiceImpl.addClaim(Claim);
		return c;

	}
		@GetMapping("/Claim/{id}")
		public Claim test(@PathVariable long id) {
			return ClaimServiceImpl.getClaimById(id);
		}
	
	// http://localhost:8082/maha/servlet/listClaim
		@GetMapping("/listClaim")
		public List<Claim> listClaim() {
			List<Claim> listC=ClaimServiceImpl.listClaim();
	        return listC;
		}
		
		// http://localhost:8082/maha/servlet/updateClaim
		@PutMapping("/updateClaim")
		public Claim updateClaim(Claim Claim) {
			return ClaimServiceImpl.updateClaim(Claim);
		}
		// http://localhost:8082/maha/servlet/deleteClaim
		@DeleteMapping("/deleteClaim/{idClaim}")
		@ResponseBody
		public void deleteClaim(@PathVariable("idClaim") long IdCl) {
			ClaimServiceImpl.deleteClaimById(IdCl);
		}

}
