package com.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.entities.Livraison;
import com.pi.entities.Livreur;
import com.pi.entities.commande;
import com.pi.entities.enum2.disponibility;
import com.pi.entities.enum2.state;
import com.pi.repository.CommandeRepository;
import com.pi.repository.LivraisonRepository;
import com.pi.repository.LivreurRepository;

@Service
public class LivraisonServiceImpl {
	
	@Autowired
	LivraisonRepository LivraisonRep;
	@Autowired
	CommandeRepository commRep;
	@Autowired
	LivreurRepository LivRep;
	
	public Livraison addLivraison(Livraison Livraison,long idCom,long idLiv){
		commande c=commRep.getOne(idCom);
		Livreur l= LivRep.getOne(idLiv);
		Livraison.setIdCommande(c);
		Livraison.setIdLivreur(l);
		l.setDisponibility(disponibility.NOACTIVE);
		c.setState(state.encours);
		commRep.save(c);
		LivRep.save(l);
		double frais= Livraison.getDistance()*1000;
		Livraison.setFrais(frais);
		LivraisonRep.save(Livraison);
		
		return Livraison;
	}
	
	public Livraison getOne(long id) {
		return LivraisonRep.getOne(id);
		
	}
	
	public List<Livraison> listLivraison(){
		return (List<Livraison>) LivraisonRep.findAll();
	}
	
	public Livraison updateLivraison(Livraison Livraison){
		LivraisonRep.save(Livraison);
		return Livraison;
	}
	
	public void deleteLivraisonById(Long idCl){
		Livraison LivraisonManagementEntity=LivraisonRep.findById((long) idCl).get();
		LivraisonRep.delete(LivraisonManagementEntity);
	}
	
	public Livraison getLivraisonById(long idCl){
		Livraison Livraison = LivraisonRep.findById((long) idCl).get();
		return Livraison;
	}

	public LivraisonServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
