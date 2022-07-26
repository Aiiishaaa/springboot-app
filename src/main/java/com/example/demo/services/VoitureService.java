package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.DAO.PersonneRepository;
import com.example.demo.DAO.VoitureRepository;
import com.example.demo.models.Voiture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "voitureService")
public class VoitureService implements IVoitureService {

	 @Autowired
	 private PersonneRepository personneRepository;

	 @Autowired
	 private VoitureRepository voitureRepository;
	
	 
	 //Retourne une liste de voiture selon do propriétaire(id)
	@Override
	public List<Voiture> getVoituresByPersonne(Integer personneId) {
		return voitureRepository.findByPersonneId(personneId);
	}

	
	//Retourne une voiture selon son id
	@Override
	public Voiture getVoitureById(Integer voitureId) {
		return voitureRepository.findById(voitureId).get();
	}

	
	//Retourne une voiture(id) selon son propriétaire(id)
	@Override
	public Optional<Voiture> getOneVoitureById(Integer voitureId, Integer personneId) {
		return voitureRepository.findByIdAndPersonneId(voitureId, personneId);
	}


	// le map() est utilisé pour transformer un objet en un autre en appliquant une fonction.
	// Enregistre une voiture selon son proprietaire(id)
	@Override
	public Optional<Voiture> saveOneVoitureById(Integer personneId, Voiture voiture) {
		return personneRepository.findById(personneId).map((personne) -> {
			voiture.setPersonne(personne);
			return voitureRepository.save(voiture);
		});
	}

	// Mettre une voiture selon son proprietaire(id)
	@Override
	public Optional<Voiture> editOneVoitureById(Integer voitureId, Integer personneId, Voiture voiture) {
		return voitureRepository.findByIdAndPersonneId(voitureId, personneId).map((v) -> {
			v.setModele(voiture.getModele());
			v.setMarque(voiture.getMarque());
			return voitureRepository.save(v);
		});
	}

	// supprimer une voiture(id) selon son proprietaire(id)
	@Override
	public Optional<?> deleteOneVoitureById(Integer voitureId, Integer personneId) {
		return voitureRepository.findByIdAndPersonneId(voitureId, personneId).map((v) -> {
			voitureRepository.delete(v);
			return "Deleted";
		});
	}

}
