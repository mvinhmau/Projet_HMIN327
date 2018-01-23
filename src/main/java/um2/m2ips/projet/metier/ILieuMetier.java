package um2.m2ips.projet.metier;

import java.util.List;

import um2.m2ips.projet.entities.Departement;
import um2.m2ips.projet.entities.Lieu;

public interface ILieuMetier {
	List <Lieu> rechercherLieuxParDep (String nomDep);
	List <Lieu> recupererTousLesLieux();
	Lieu recupererUnLieu(String codeInsee);
	List <Departement> recupererTousLesDepartements();
}
