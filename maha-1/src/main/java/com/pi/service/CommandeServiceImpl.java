package com.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.entities.commande;
import com.pi.entities.commande;

import com.pi.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {
	
	@Autowired
	CommandeRepository CommandeRep;
	
	
	public commande addCommande(commande comm){
		CommandeRep.save(comm);
		return comm;
	}
	
	public List<commande> listcommande(){
		return (List<commande>) CommandeRep.findAll();
	}
	
	public commande updatecommande(commande commande){
		CommandeRep.save(commande);
		return commande;
	}
	
	public void deletecommandeById(Long idCl){
		commande commandeManagementEntity=CommandeRep.findById((long) idCl).get();
		CommandeRep.delete(commandeManagementEntity);
	}
	
	public commande getcommandeById(long idCl){
		commande commande = CommandeRep.findById((long) idCl).get();
		return commande;
	}

	public CommandeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<commande> listCommande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public commande updateCommande(commande Commande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommandeById(Long idCl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommandeById(long idCl) {
		// TODO Auto-generated method stub
		return null;
	}

}
