package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Voiture.
 */
@Entity
public class Voiture {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The modele. */
	private String modele;
	
	/** The marque. */
	private String marque;
	
	@JsonIgnore
	/** The personne. */
	@ManyToOne(fetch = FetchType.EAGER)
	private Personne personne;

	/**
	 * Instantiates a new voiture.
	 *
	 * @param id the id
	 * @param modele the modele
	 * @param marque the marque
	 * @param personne the personne
	 */
	public Voiture(Integer id, String modele, String marque, Personne personne) {
		super();
		this.id = id;
		this.modele = modele;
		this.marque = marque;
		this.personne = personne;
	}

	/**
	 * Instantiates a new voiture.
	 */
	public Voiture() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * Gets the modele.
	 *
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * Sets the modele.
	 *
	 * @param modele the new modele
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * Gets the marque.
	 *
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Sets the marque.
	 *
	 * @param marque the new marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Gets the personne.
	 *
	 * @return the personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * Sets the personne.
	 *
	 * @param personne the new personne
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", modele=" + modele + ", marque=" + marque + ", personne=" + personne + "]";
	}
	
	
	
	
}
