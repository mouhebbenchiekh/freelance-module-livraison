package com.pi.service;

import java.util.List;


import com.pi.entities.commande;

public interface CommandeService {
	public commande addCommande(commande Commande);
	public List<commande> listCommande();
	public commande updateCommande(commande Commande);
	public void deleteCommandeById(Long idCl);
	public String getCommandeById(long idCl);

}
