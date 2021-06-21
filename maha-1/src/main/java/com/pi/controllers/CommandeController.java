package com.pi.controllers;

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

import com.pi.entities.commande;
import com.pi.service.CommandeServiceImpl;

@RestController
public class CommandeController {
	
	@Autowired
	CommandeServiceImpl commandeServiceImpl;

	//http://localhost:8082/maha/servlet/addcommande
	@PostMapping("/addcommande")
	public commande addcommande(@RequestBody commande commande) {
		
		commande c= commandeServiceImpl.addCommande(commande);
		return c;

	}
	
		
	
	// http://localhost:8082/maha/servlet/listcommande
		@GetMapping("/listcommande")
		public List<commande> listcommande() {
			List<commande> listC=commandeServiceImpl.listcommande();
	        return listC;
		}
		
		// http://localhost:8082/maha/servlet/updatecommande
		@PutMapping("/updatecommande")
		public commande updatecommande(commande commande) {
			return commandeServiceImpl.updatecommande(commande);
		}
		// http://localhost:8082/maha/servlet/deletecommande
		@DeleteMapping("/deletecommande/{idcommande}")
		@ResponseBody
		public void deletecommande(@PathVariable("idcommande") long IdCl) {
			commandeServiceImpl.deletecommandeById(IdCl);
		}

	public CommandeController() {
		// TODO Auto-generated constructor stub
		
	}

}
