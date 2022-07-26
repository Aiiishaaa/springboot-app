package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Personne;
import com.example.demo.models.Voiture;
import com.example.demo.services.IService;
import com.example.demo.services.IVoitureService;

@RestController
@CrossOrigin(origins = "*")
public class VoitureRestController {

	@Autowired
	private IService<Personne> personneService;

	@Autowired
	private IVoitureService voitureService;

	@GetMapping(value = "/personnes/{personneId}/voitures")
	public ResponseEntity<List<Voiture>> getAllVoituresByPersonne(@PathVariable("personneId") Integer personneId) {
		personneService.findById(personneId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + personneId));
		List<Voiture> voitures = voitureService.getVoituresByPersonne(personneId);
		return new ResponseEntity<>(voitures, HttpStatus.OK);
	}

	@GetMapping(value = "/personnes/{personneId}/voitures/{voitureId}")
	public ResponseEntity<Voiture> getOneVoitureByPersonne(@PathVariable("personneId") Integer personneId,
			@PathVariable("voitureId") Integer voitureId) {
		personneService.findById(personneId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + personneId));

		Voiture v = voitureService.getOneVoitureById(voitureId, personneId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Voiture not found with id : " + voitureId));

		return new ResponseEntity<>(v, HttpStatus.OK);
	}

	@PostMapping(value = "/personnes/{personneId}/voitures")
	public ResponseEntity<Voiture> saveOneVoitureByPersonne(@RequestBody Voiture voiture,
			@PathVariable("personneId") Integer personneId) {
		voitureService.saveOneVoitureById(personneId, voiture).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + personneId));
		return new ResponseEntity<>(voiture, HttpStatus.OK);
	}

	@PutMapping(value = "/personnes/{personneId}/voitures/{voitureId}")
    public ResponseEntity<Voiture> saveOneVoitureByPersonne(
            @PathVariable("personneId") Integer personneId,
            @PathVariable("voitureId") Integer voitureId,
            @RequestBody Voiture v) {
        Voiture voitureAModifier = voitureService.getOneVoitureById(voitureId, personneId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id " + personneId));
        voitureAModifier.setModele(v.getModele());
        voitureAModifier.setMarque(v.getMarque());
               voitureService.saveOneVoitureById(personneId, voitureAModifier);
        return new ResponseEntity<Voiture>(voitureAModifier, HttpStatus.OK);
    }
//	
//    @DeleteMapping(value = "/personnes/{personneId}/voitures/{voitureId}")

}
