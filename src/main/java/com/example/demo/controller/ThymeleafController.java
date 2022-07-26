package com.example.demo.controller;



import com.example.demo.DAO.PersonneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "/thymeleaf")
public class ThymeleafController {

	
	@Autowired
	private PersonneRepository personneRepository;
	
	
	// http://localhost:8080/thymeleaf/message
	@GetMapping( value = "message")
	public String ShowView (Model model) {
		model.addAttribute("message", "Hello");
		model.addAttribute("personnes", personneRepository.findAll());
		model.addAttribute("personne", personneRepository.findById(1).orElse(null));
		return "thymeleaf/index";
	}
}
