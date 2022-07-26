package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.DAO.PersonneRepository;
import com.example.demo.models.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class PersonneService implements IService<Personne> {

	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}

	@Override
	public Personne save(Personne object) {
		return personneRepository.save(object);
	}

	@Override
	public Personne update(Personne object) {
		return personneRepository.save(object);
	}

	@Override
	public Optional<Personne> findById(int id) {
		return personneRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		personneRepository.deleteById(id);

	}

}