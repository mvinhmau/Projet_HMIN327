package um2.m2ips.projet.dao;
import java.util.List;

import um2.m2ips.projet.entities.Celebrite;



public interface ICelebriteDAO {
	
	List<Celebrite> recupererToutesLesCelebrites();
	List<Celebrite> rechercherCelebritesParPrenom(String prenom);
	List<Celebrite> rechercherCelebritesParNom(String nom);
	List<Celebrite> rechercherCelebritesParNoms(String nom, String prenom);
	
	
	//List<Celebrite> rechercheCelebritesParLieu(String nomL);
	void ajouterCelebrite(Celebrite c);
	void supprimerCelebrite(int numC);
	Celebrite recupererCelebrite(int numC);
	void miseAJourCelebrite (Celebrite c);
	
	

}
