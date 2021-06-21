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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="livreur")
public class Livreur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_livreur")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="position")
	private String position;
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private com.pi.entities.enum2.role role;
	public Collection<Livraison> getLivraisons() {
		return livraisons;
	}
	public void setLivraisons(Collection<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	@Column(name="disponibility")
	@Enumerated(EnumType.STRING)
	private com.pi.entities.enum2.disponibility disponibility;
	
	@OneToMany(mappedBy = "idLivreur")
	@JsonIgnore
	private Collection<Livraison> livraisons;
	
	
	public com.pi.entities.enum2.disponibility getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(com.pi.entities.enum2.disponibility disponibility) {
		this.disponibility = disponibility;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public com.pi.entities.enum2.role getRole() {
		return role;
	}
	public void setRole(com.pi.entities.enum2.role role) {
		this.role = role;
	}
	public Livreur(long id, String name, String position, com.pi.entities.enum2.role role,
			com.pi.entities.enum2.disponibility disponibility) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.role = role;
		this.disponibility = disponibility;
	}
	
	public Livreur(String name, String position, com.pi.entities.enum2.role role) {
		super();
		this.name = name;
		this.position = position;
		this.role = role;
	}
	public Livreur(String name, String position, com.pi.entities.enum2.role role,
			com.pi.entities.enum2.disponibility disponibility) {
		super();
		this.name = name;
		this.position = position;
		this.role = role;
		this.disponibility = disponibility;
	}
	public Livreur() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
	

}
