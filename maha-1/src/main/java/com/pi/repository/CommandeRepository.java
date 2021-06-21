package com.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pi.entities.commande;

public interface CommandeRepository extends JpaRepository<commande, Long> {

}
