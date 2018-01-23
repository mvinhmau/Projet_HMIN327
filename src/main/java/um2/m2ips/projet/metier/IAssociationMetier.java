package um2.m2ips.projet.metier;

import java.util.List;

import um2.m2ips.projet.entities.AssocieA;

public interface IAssociationMetier {
	List <AssocieA> recupererToutesLesAssociations();
	void ajouterRelation(AssocieA a);
	void supprimerRelation(int numC, long numM);
	AssocieA recupererRelation(int numC, long numM);
	List<AssocieA> recupererCelebritesParMonument(long numM);
	

}
