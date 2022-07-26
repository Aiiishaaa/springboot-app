package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Personne;

// La couche Controller gère les requêtes des utilisateurs. 
// Elle est responsable de retourner une réponse avec l’aide mutuelle 
// des couches Model et Vue
@Controller
public class HomeController {

	// http://localhost:8080/home
	// @RequestMapping(value = "/home", method = RequestMethod.GET)
	@GetMapping(value = "/home")
	public String home(ModelMap model) {
		Personne p1 = new Personne("Nom1", "Prenom1", 54);
		Personne p2 = new Personne("Nom2", "Prenom2", 43);

		model.addAttribute("perso", p1);

		List<Personne> personnes = new ArrayList<Personne>();
		personnes.add(p1);
		personnes.add(p2);

		model.addAttribute("personnes", personnes);

		return "jsp/home";
	}

	// Parametres de Requetes
	// http://localhost:8080/index?nom=John
	@GetMapping(value = "/index")
	public String home(@RequestParam(value = "nom", required = false, defaultValue = "Doe") String nom, Model model) {
		model.addAttribute("nom", nom);
		return "jsp/home";
	}

	// Variable de chemin
	// http://localhost:8080/hello/Doe
	@GetMapping(value = "/hello/{nom}")
	public ModelAndView hello(@PathVariable(value = "nom") String nom) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/home");
		mv.addObject("nom", nom);
		return mv;
	}

}
