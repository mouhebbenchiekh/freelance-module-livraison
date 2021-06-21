package com.pi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="commande")
public class commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_commande")
	private long id;
	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private com.pi.entities.enum2.state state;
	@Column
	private String destination;
	@Column
	private Long idClient;
	@OneToMany(mappedBy = "idCommande")
	
	private Collection<Claim> claim;
	
	@OneToMany(mappedBy = "idCommande")
	@JsonIgnore
	private Collection<Livraison> livraison;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public com.pi.entities.enum2.state getState() {
		return state;
	}


	public void setState(com.pi.entities.enum2.state state) {
		this.state = state;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public Collection<Claim> getClaim() {
		return claim;
	}


	public void setClaim(Collection<Claim> claim) {
		this.claim = claim;
	}


	public Collection<Livraison> getLivraison() {
		return livraison;
	}


	public void setLivraison(Collection<Livraison> livraison) {
		this.livraison = livraison;
	}


	public commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public commande(String destination) {
		super();
		this.destination = destination;
	}


	public commande(com.pi.entities.enum2.state state, String destination, Long idClient) {
		super();
		this.state = state;
		this.destination = destination;
		this.idClient = idClient;
	}
	

}
