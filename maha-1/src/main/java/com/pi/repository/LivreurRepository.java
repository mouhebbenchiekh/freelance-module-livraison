package com.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pi.entities.Livraison;
import com.pi.entities.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {
	
	@Query("select l from Livreur l where l.disponibility='ACTIVE'  ")
	List<Livreur> Active();
	
	@Query("select l from Livraison l where l.idLivreur like :e")
	List<Livraison> stats(@Param("e")Livreur l);

}
