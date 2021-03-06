package um2.m2ips.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Celebrite")
public class Celebrite implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numCelebrite;
	private String nom;
	private String prenom;
	private String nationalite;
	private String epoque;

	public Celebrite() {
		super();
	}

	public Celebrite(String nom, String prenom, String nationalite, String epoque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
	}
	

	public Celebrite(int numCelebrite, String nom, String prenom, String nationalite, String epoque) {
		super();
		this.numCelebrite = numCelebrite;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
	}

	public int getNumCelebrite() {
		return numCelebrite;
	}

	public void setNumCelebrite(int numCelebrite) {
		this.numCelebrite = numCelebrite;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getEpoque() {
		return epoque;
	}
	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}


}
