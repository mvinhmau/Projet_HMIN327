package um2.m2ips.projet.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import um2.m2ips.projet.dao.IAssociationDAO;
import um2.m2ips.projet.dao.ICelebriteDAO;
import um2.m2ips.projet.entities.AssocieA;

public class AssociationMetier implements IAssociationMetier {

	IAssociationDAO dao;
	
	public void setDao(IAssociationDAO dao)
	{
		this.dao=dao;
	}

	
	@Override
	@Transactional
	public List<AssocieA> recupererToutesLesAssociations() {
		return dao.recupererToutesLesAssociations();
	}

	@Override
	@Transactional
	public void ajouterRelation(AssocieA a) {
		dao.ajouterRelation(a);

	}

	@Override
	@Transactional
	public void supprimerRelation(int numC, long numM) {
		dao.supprimerRelation(numC, numM);

	}

	@Override
	@Transactional
	public AssocieA recupererRelation(int numC, long numM) {
		return dao.recupererRelation(numC, numM);
	}


	@Override
	public List<AssocieA> recupererCelebritesParMonument(long numM) {
		return dao.recupererCelebritesParMonument(numM);
	}

	

}
