package um2.m2ips.projet.dao;
import java.util.List;
import um2.m2ips.projet.entities.Monument;

public interface IMonumentDAO {
	public void ajouterMonument( Monument m);
	public List<Monument> recupererTousLesMonuments();
	public List<Monument> recupererTousLesMonumentsParNom(String nomM);
	public void supprimerMonument(long codeM);
	public Monument recupererMonument(long codeM);
	public void miseAJourMonument (Monument m);
	
	
	
	//Requetes de Recherche
	public List<Monument> rechercherMonumentsParLieu(String nomCom);
	public List<Monument> rechercherMonumentsParDep(String nomDep);
	public List<Monument> rechercherMonumentsParProp(String nomP);
	public List<Monument> rechercherMonumentsParType(String nomT);
	
	

}
