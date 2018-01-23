package um2.m2ips.projet.dao;

import java.util.List;
import um2.m2ips.projet.entities.AssocieA;

public interface IAssociationDAO {
	
		List <AssocieA> recupererToutesLesAssociations();
		void ajouterRelation(AssocieA a);
		void supprimerRelation(int numC, long numM);
		AssocieA recupererRelation(int numC, long numM);
		List<AssocieA> recupererCelebritesParMonument(long numM);
		
}
