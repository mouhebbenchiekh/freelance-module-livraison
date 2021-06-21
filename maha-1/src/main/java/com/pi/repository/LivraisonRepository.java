package com.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pi.entities.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

}