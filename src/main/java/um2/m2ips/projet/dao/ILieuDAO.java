package um2.m2ips.projet.dao;
import java.util.List;
import um2.m2ips.projet.entities.Departement;
import um2.m2ips.projet.entities.Lieu;

public interface ILieuDAO {
	List <Lieu> rechercherLieuxParDep (String nomDep);
	List <Lieu> recupererTousLesLieux ();
	Lieu recupererUnLieu(String codeInsee);
	List <Departement> recupererTousLesDepartements();

}
