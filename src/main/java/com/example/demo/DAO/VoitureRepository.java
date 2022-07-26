package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {
	
	List<Voiture> findByPersonneId(Integer personneId);
	
	Optional<Voiture> findByIdAndPersonneId(Integer id, Integer PersonneId);

}
