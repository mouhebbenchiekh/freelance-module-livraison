package com.pi.controllers;

import java.util.ArrayList;
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

import com.pi.entities.Livraison;


@RestController
public class LivraisonController {

	
	public LivraisonController() {
		// TODO Auto-generated constructor stub
	}	
		@Autowired
		com.pi.service.LivraisonServiceImpl LivraisonServiceImpl;

		//http://localhost:8082/maha/servlet/addLivraison
		@PostMapping("/addLivraison/{idCommande}/{idLivreur}")
		public long addLivraison(@RequestBody Livraison Livraison,@PathVariable("idCommande") long idCom ,@PathVariable("idLivreur") long idLiv) {
			Livraison c= LivraisonServiceImpl.addLivraison(Livraison,idCom,idLiv);
			return c.getId();

		}
		
		// http://localhost:8082/maha/servlet/listLivraison
			@GetMapping("/listLivraison")
			public List<Livraison> listLivraison() {
				List<Livraison> listC=LivraisonServiceImpl.listLivraison();
		        return listC;
			}
			
			@GetMapping("/Livraison/{idLivraison}")
			public Livraison getLivarison(@PathVariable long idLivraison) {
				
				return LivraisonServiceImpl.getLivraisonById(idLivraison);
			}
			
			// http://localhost:8082/maha/servlet/updateLivraison
			@PutMapping("/updateLivraison")
			public Livraison updateLivraison(Livraison Livraison) {
				return LivraisonServiceImpl.updateLivraison(Livraison);
			}
			// http://localhost:8082/maha/servlet/deleteLivraison
			@DeleteMapping("/deleteLivraison/{idLivraison}")
			@ResponseBody
			public void deleteLivraison(@PathVariable("idLivraison") Long IdCl) {
				LivraisonServiceImpl.deleteLivraisonById(IdCl);
			}

	}


