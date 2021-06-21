package com.pi.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity //table dans la base de données
public class Claim implements Serializable {
	
	@Id //cle primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_claim")//auto increments
	private Long idClaim;
	private String descriptionClaim;
	
	private Date dateClaim;
	@Enumerated(EnumType.STRING)
	@JsonIgnoreProperties
	private com.pi.entities.enum2.typeClaim typeClaim;
	
	
	@ManyToOne
	@JoinColumn(name="idcommande",referencedColumnName = "Id_commande")
	@JsonIgnore
	private commande idCommande;
	
	@OneToOne(mappedBy = "idClaim")
	private Decision decision;
	
	

	public commande getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(commande idCommande) {
		this.idCommande = idCommande;
	}

	public Decision getDecision() {
		return decision;
	}

	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	public Long getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}

	public String getDescriptionClaim() {
		return descriptionClaim;
	}

	public void setDescriptionClaim(String descriptionClaim) {
		this.descriptionClaim = descriptionClaim;
	}

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}

	public com.pi.entities.enum2.typeClaim getTypeClaim() {
		return typeClaim;
	}

	public void setTypeClaim(com.pi.entities.enum2.typeClaim typeClaim) {
		this.typeClaim = typeClaim;
	}

	public Claim() {
		super();
	}

	public Claim(String descriptionClaim, Date dateClaim, com.pi.entities.enum2.typeClaim typeClaim) {
		super();
		this.descriptionClaim = descriptionClaim;
		this.dateClaim = dateClaim;
		this.typeClaim = typeClaim;
	}


	
	
	

	
	
}
