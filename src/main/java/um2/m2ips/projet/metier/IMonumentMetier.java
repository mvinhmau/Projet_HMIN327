package um2.m2ips.projet.metier;
import java.util.List;

import um2.m2ips.projet.entities.Monument;


public interface IMonumentMetier {
	public void ajouterMonument(Monument m);
	public List<Monument> recupererTousLesMonuments();
	public void supprimerMonument(long codeM);
	public Monument recupererMonument (long codeM);
	public List<Monument> recupererTousLesMonumentsParNom (String nomM);
	public void miseAJourMonument (Monument m);
	
	//Requetes 
	public List<Monument> rechercherMonumentsParLieu(String nomCom);
	public List<Monument> rechercherMonumentsParDep(String nomDep);
	public List<Monument> rechercherMonumentsParProp(String nomP);
	public List<Monument> rechercherMonumentsParType(String nomT);
	
	public String calculerLaDistanceEntreDeuxPoints(float lat1, float long1, float lat2, float long2);
	

}
