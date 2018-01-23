package um2.m2ips.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import um2.m2ips.projet.entities.Departement;
import um2.m2ips.projet.entities.Lieu;

public class LieuDAO implements ILieuDAO {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Lieu> rechercherLieuxParDep(String nomDep) {
		Query req=em.createQuery("select l from Lieu l where l.departements.nomDep like:x");
		
		req.setParameter("x", "%"+nomDep.trim()+"%");
		System.out.println(nomDep);
		return req.getResultList();
	}

	@Override
	public List<Lieu> recupererTousLesLieux() {
		Query req=em.createQuery("select l from Lieu l");
		return req.getResultList();
	}

	@Override
	public Lieu recupererUnLieu(String codeInsee) {
		return em.find(Lieu.class, codeInsee);
	}

	@Override
	public List<Departement> recupererTousLesDepartements() {
		Query req=em.createQuery("select d from Departement d");
		return req.getResultList();
	}

}
