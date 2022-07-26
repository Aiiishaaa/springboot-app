package com.example.demo.controller;

import java.util.List;

import com.example.demo.DAO.PersonneRepository;
import com.example.demo.models.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonneController {

	// Injection de la dependance DAO (DATA ACCES OBJECT) sur l'entite personne

	@Autowired
	private PersonneRepository personneRepository;

	// public PersonneController(PersonneRepository personneRepository) {
	// this.personneRepository = personneRepository;
	// }

	// http://localhost:8080/showAll
	@GetMapping(value = "/showAll")
	public String showAll(ModelMap model) {
		List<Personne> personnes = personneRepository.findAll();
		model.addAttribute("personnes", personnes);
		return "jsp/home";
	}

	// http://localhost:8080/showSome?nom=HEUILLET
	@GetMapping(value = "/showSome")
	public String home(@RequestParam(value = "nom", required = false, defaultValue = "HEUILLET") String nom,
			Model model) {
		List<Personne> personnesNom = personneRepository.findByNom(nom);
		model.addAttribute("personnesNom", personnesNom);
		return "jsp/home";
	}

	// http://localhost:8080/showSome1?nom=HEUILLET&prenom=cécile
	@GetMapping(value = "/showSome1")
	public String showSome(@RequestParam(value = "nom") String nom, @RequestParam(value = "prenom") String prenom,
			ModelMap model) {
		List<Personne> personnes = personneRepository.findByNomAndPrenom(nom, prenom);
		model.addAttribute("personnes", personnes);
		return "jsp/home";
	}

	// Affiche une liste triee selon le nom decroissant
	// http://localhost:8080/showSort
	@GetMapping(value = "/showSort")
	public String showSort(ModelMap model) {
		List<Personne> personnes = personneRepository.findAll(Sort.by("nom").descending());
		model.addAttribute("personnes", personnes);
		return "jsp/home";
	}
}