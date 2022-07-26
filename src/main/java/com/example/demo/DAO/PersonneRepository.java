package com.example.demo.DAO;

import java.util.List;

import com.example.demo.models.Personne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    List<Personne> findByNomAndPrenom(String nom, String prenom);
    @Query("select p from Personne p where p.nom = ?1")
    List<Personne> findByNom(String nom);
    
}