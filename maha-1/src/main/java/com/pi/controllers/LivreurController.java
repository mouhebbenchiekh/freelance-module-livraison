package com.pi.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.entities.Livraison;
import com.pi.entities.Livreur;
import com.pi.entities.enum2.disponibility;
import com.pi.service.LivreurServiceImpl;

@RestController
public class LivreurController {
	
	@Autowired
	LivreurServiceImpl LivreurServiceImpl;

	//http://localhost:8082/maha/servlet/addLivreur
	@PostMapping("/addLivreur")
	public Long addLivreur(@RequestBody Livreur Livreur) {
		Livreur c= LivreurServiceImpl.addLivreur(Livreur);
		return c.getId();

	}
	
	// http://localhost:8082/maha/servlet/listLivreur
		@GetMapping("/listLivreur")
		public List<Livreur> listLivreur() {
			List<Livreur> listC=LivreurServiceImpl.listLivreur();
	        return listC;
		}
		
		@GetMapping("/listLivreurActive")
		public List<Livreur> listLivreurActive() {
			List<Livreur> listC=LivreurServiceImpl.listLivreurActive();
	        return listC;
		}
		@GetMapping("statsLivreur/{id}")
		public List<Livraison> stats(@PathVariable long id){
			return LivreurServiceImpl.stats(id);
		}
		
		@GetMapping("bonusLivreur/{id}")
		public double bonus(@RequestParam Date date,@PathVariable long id) {
		
			System.out.print(date);
			return LivreurServiceImpl.bonus(date,id);
			
		}
		
		@PutMapping("/DesactivateLivreur/{id}")
		public Livreur Desactivate(@PathVariable long id) {
			Livreur l=LivreurServiceImpl.getLivreurById(id);
			l.setDisponibility(disponibility.NOACTIVE);
			return LivreurServiceImpl.updateLivreur(l);
		}
		
		@PutMapping("/ActivateLivreur/{id}")
		public Livreur Activate(@PathVariable long id,@RequestParam(name="position") String pos) {
			Livreur l=LivreurServiceImpl.getLivreurById(id);
			l.setPosition(pos);
			l.setDisponibility(disponibility.ACTIVE);
			return LivreurServiceImpl.updateLivreur(l);
		}
		
		// http://localhost:8082/maha/servlet/updateLivreur
		@PutMapping("/updateLivreur")
		public Livreur updateLivreur(Livreur Livreur) {
			return LivreurServiceImpl.updateLivreur(Livreur);
		}
		// http://localhost:8082/maha/servlet/deleteLivreur
		@DeleteMapping("/deleteLivreur/{idLivreur}")
		@ResponseBody
		public void deleteLivreur(@PathVariable("idLivreur") Long IdCl) {
			LivreurServiceImpl.deleteLivreurById(IdCl);
		}

	public LivreurController() {
		// TODO Auto-generated constructor stub
	}

}
