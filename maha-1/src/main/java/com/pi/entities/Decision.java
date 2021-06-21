package com.pi.entities;

import java.io.Serializable;
import java.sql.Date;

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

@Entity
public class Decision implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long idDecision;
	
	@DateTimeFormat(style = "yyyy-MM-dd")
	private Date dateRefund;
	
	@DateTimeFormat(style = "yyyy-MM-dd")
	private Date dateExchange;
	
	@DateTimeFormat(style = "yyyy-MM-dd")
	private Date dateRepair;
	
	@DateTimeFormat(style = "yyyy-MM-dd")
	private Date dateLARepair;
	private String devis;
	@Enumerated(EnumType.STRING)
	@JsonIgnoreProperties
	private com.pi.entities.enum2.typeDecision typeDecision;
	
	@OneToOne()
	@JoinColumn(name="idClaim",referencedColumnName = "Id_claim" )
	@JsonIgnore
	private Claim idClaim;
	
	
	

	public Claim getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(Claim idClaim) {
		this.idClaim = idClaim;
	}

	public Long getIdDecision() {
		return idDecision;
	}

	public void setIdDecision(Long idDecision) {
		this.idDecision = idDecision;
	}

	public Date getDateRefund() {
		return dateRefund;
	}

	public void setDateRefund(Date dateRefund) {
		this.dateRefund = dateRefund;
	}

	public Date getDateExchange() {
		return dateExchange;
	}

	public void setDateExchange(Date dateExchange) {
		this.dateExchange = dateExchange;
	}

	public Date getDateRepair() {
		return dateRepair;
	}

	public void setDateRepair(Date dateRepair) {
		this.dateRepair = dateRepair;
	}

	public Date getDateLARepair() {
		return dateLARepair;
	}

	public void setDateLARepair(Date dateLARepair) {
		this.dateLARepair = dateLARepair;
	}

	public String getDevis() {
		return devis;
	}

	public void setDevis(String devis) {
		this.devis = devis;
	}

	public com.pi.entities.enum2.typeDecision getTypeDecision() {
		return typeDecision;
	}

	public void setTypeDecision(com.pi.entities.enum2.typeDecision typeDecision) {
		this.typeDecision = typeDecision;
	}

	public Decision() {
		super();
	}

	public Decision(Date dateRefund, Date dateExchange, Date dateRepair, Date dateLARepair, String devis,
			com.pi.entities.enum2.typeDecision typeDecision) {
		super();
		this.dateRefund = dateRefund;
		this.dateExchange = dateExchange;
		this.dateRepair = dateRepair;
		this.dateLARepair = dateLARepair;
		this.devis = devis;
		this.typeDecision = typeDecision;
	}

	

	
	
	
	

}
