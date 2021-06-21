package com.pi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.entities.Livraison;
import com.pi.entities.Livreur;
import com.pi.repository.LivreurRepository;
@Service
public class LivreurServiceImpl {
	
	@Autowired
	LivreurRepository LivreurRep;
	
	public Livreur addLivreur(Livreur Livreur){
		LivreurRep.save(Livreur);
		return Livreur;
	}
	
	public List<Livreur> listLivreur(){
		return (List<Livreur>) LivreurRep.findAll();
	}
	
	public List<Livreur> listLivreurActive(){
		return (List<Livreur>) LivreurRep.Active();
	}
	
	public List<Livraison> stats(long id){
		Livreur l=getLivreurById(id);
		return (List<Livraison>) LivreurRep.stats(l);
	}
	
	public double bonus(Date date,long id) {
		List<Livraison> list=stats(id);
		int num=0;
		for(Livraison l:list) {
			if((date.getMonth()==l.getDate().getMonth())&&(date.getYear()==l.getDate().getYear())) {
				num++;
			}
		}
		if(num>3) {
			return (num-3)*5000;
		}
		return 0.0;
	}
	
	
	
	public Livreur updateLivreur(Livreur Livreur){
		LivreurRep.save(Livreur);
		return Livreur;
	}
	
	public void deleteLivreurById(long idCl){
		Livreur LivreurManagementEntity=LivreurRep.findById((long) idCl).get();
		LivreurRep.delete(LivreurManagementEntity);
	}
	
	public Livreur getLivreurById(long idCl){
		Livreur Livreur = LivreurRep.findById((long) idCl).get();
		return Livreur;
	}

	public LivreurServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
