package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Personne;

public interface IService<T> {
	List<T> findAll();

	Optional<T> findById(int id);

	T save(T object);

	T update(T object);

	void delete(int id);
}