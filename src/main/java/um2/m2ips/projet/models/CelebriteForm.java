package um2.m2ips.projet.models;

import java.util.List;

import um2.m2ips.projet.entities.Celebrite;

public class CelebriteForm {
	private int numCelebrite;
	private String nom;
	private String prenom;
	private String nationalite;
	private String epoque;
	private List<Celebrite> celebrites;
	
	public CelebriteForm(int numCelebrite, String nom, String prenom, String nationalite, String epoque) {
		super();
		this.numCelebrite = numCelebrite;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
	}
	
	
	
	public CelebriteForm() {
		super();
	}



	//Getters et Setters
	
	
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
	public List<Celebrite> getCelebrites() {
		return celebrites;
	}
	public void setCelebrites(List<Celebrite> celebrites) {
		this.celebrites = celebrites;
	}
	public int getNumCelebrite() {
		return numCelebrite;
	}
	public void setNumCelebrite(int numCelebrite) {
		this.numCelebrite = numCelebrite;
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
