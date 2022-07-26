package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Voiture;

public interface IVoitureService {

	List<Voiture> getVoituresByPersonne(Integer personneId);

	Voiture getVoitureById(Integer voitureId);

	Optional<Voiture> getOneVoitureById(Integer voitureId, Integer personneId);

	Optional<Voiture> saveOneVoitureById(Integer personneId, Voiture voiture);

	Optional<Voiture> editOneVoitureById(Integer voitureId, Integer personneId, Voiture voiture);

	Optional<?> deleteOneVoitureById(Integer voitureId, Integer personneId);

}