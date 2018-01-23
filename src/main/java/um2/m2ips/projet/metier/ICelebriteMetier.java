package um2.m2ips.projet.metier;

import java.util.List;
import um2.m2ips.projet.entities.Celebrite;

public interface ICelebriteMetier {
	
	List <Celebrite> recupererToutesLesCelebrites();
	List<Celebrite> rechercherCelebritesParNom(String nom);
	List<Celebrite> rechercherCelebritesParPrenom(String prenom);
	List<Celebrite> rechercherCelebritesParNoms(String nom, String prenom);
	
	//List<Celebrite> rechercherCelebritesParLieu(String nomL);
	void ajouterCelebrite(Celebrite c);
	void supprimerCelebrite(int numC);
	Celebrite recupererCelebrite(int numC);
	void miseAJourCelebrite (Celebrite c);

}
