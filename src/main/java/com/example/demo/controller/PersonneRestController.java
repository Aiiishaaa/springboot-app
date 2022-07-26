package com.example.demo.controller;

import java.util.List;

import com.example.demo.models.Personne;
import com.example.demo.services.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonneRestController.
 */
@RestController
public class PersonneRestController {

    /** The personne service. */
    @Autowired
    private IService<Personne> personneService;

    // retourne une liste de personne
    /**
     * Show all.
     *
     * @return the response entity
     */
    // http://localhost:8080/personnes
    @GetMapping(value = "/personnes")
    public ResponseEntity<List<Personne>> showAll() {
        return new ResponseEntity<>(personneService.findAll(), HttpStatus.OK);
    }

    // enregistre un objet de type personnes en bdd
    /**
     * Save.
     *
     * @param p the p
     * @return the personne
     */
    // http://localhost:8080/personnes
    @PostMapping(value = "/personnes")
    public Personne save(@RequestBody Personne p) {
        return personneService.save(p);
    }
    
    /**
     * Gets the one.
     *
     * @param id the id
     * @return the one
     */
    // retourne une personne selon son identifiant
    @GetMapping(value = "/personnes/{id}")
    public ResponseEntity<Personne> getOne(@PathVariable int id) {
        Personne p = personneService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + id));
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    // met à jour un objet Personne selon son identifiant
    /**
     * Put.
     *
     * @param id the id
     * @param p  the p
     * @return the response entity
     */
    // http://localhost:8080/personnes
    @PutMapping("/personnes/{id}")
    public ResponseEntity<Personne> put(@PathVariable int id, @RequestBody Personne p) {
        Personne pToUpdate = personneService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + id));
        pToUpdate.setAge(p.getAge());
        pToUpdate.setNom(p.getNom());
        pToUpdate.setPrenom(p.getPrenom());
        return new ResponseEntity<Personne>(personneService.update(pToUpdate), HttpStatus.OK);
    }

    // supprime une personne selon son ID
    /**
     * Delete.
     *
     * @param id the id
     * @return the response entity
     */
    // http://localhost:8080/personnes
    @DeleteMapping("/personnes/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Personne pToDelete = personneService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id : " + id));
        personneService.delete(pToDelete.getId());
        return new ResponseEntity<>("La personne avec l'id : " + id + " a été supprimé", HttpStatus.OK);

    }

}