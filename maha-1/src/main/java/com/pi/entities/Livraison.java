package com.pi.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livraison")
public class Livraison {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_livraison")
	private long id;
	@ManyToOne
	@JoinColumn(name="idCommande")
	private commande idCommande;
	@ManyToOne
	@JoinColumn(name="idLivreur")
	private Livreur idLivreur;
	@Column
	private double distance;
	@Column
	private double frais;
	@Column
	private Date date;
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public commande getIdCommande() {
		return idCommande;
	}



	public void setIdCommande(commande idCommande) {
		this.idCommande = idCommande;
	}



	public Livreur getIdLivreur() {
		return idLivreur;
	}



	public void setIdLivreur(Livreur idLivreur) {
		this.idLivreur = idLivreur;
	}



	public double getDistance() {
		return distance;
	}



	public void setDistance(double distance) {
		this.distance = distance;
	}



	public double getFrais() {
		return frais;
	}



	public void setFrais(double frais) {
		this.frais = frais;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Livraison() {
		// TODO Auto-generated constructor stub
	}

}
