package com.example.demo.config;


import com.example.demo.DAO.PersonneRepository;
import com.example.demo.models.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerConfig implements CommandLineRunner {

	@Autowired
	private PersonneRepository personneRepository;


	@Override
	public void run(String... args) throws Exception {
		 personneRepository.save( new Personne ("HEUILLET", "Cécile", 22));
		 personneRepository.save( new Personne  ("DI LORENZO", "Lucas", 25));
		 personneRepository.save( new Personne ("BRUNEAU", "Eric", 30));

	}

}
