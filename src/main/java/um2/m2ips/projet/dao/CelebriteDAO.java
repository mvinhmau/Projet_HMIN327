package um2.m2ips.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import um2.m2ips.projet.entities.AssocieA;
import um2.m2ips.projet.entities.Celebrite;
import um2.m2ips.projet.entities.Monument;

public class CelebriteDAO implements ICelebriteDAO {
	@PersistenceContext
	private EntityManager em;
	
	//Recuperer Toutes les Celebrites
	@Override
	public List<Celebrite> recupererToutesLesCelebrites() {
		Query req=em.createQuery("select c from Celebrite c ");
		return req.getResultList();
	}
	
	
	//Recherches par Nom et/ou Prenom 
	@Override
	public List<Celebrite> rechercherCelebritesParNoms(String nom, String prenom) {
		Query req=em.createQuery("select c from Celebrite c where c.nom like :n and c.prenom like :p");
		req.setParameter("n", "%"+nom+"%");
		req.setParameter("p", "%"+prenom+"%");
		return req.getResultList();
	}
	
	
	@Override
	public List<Celebrite> rechercherCelebritesParPrenom(String prenom) {
		Query req=em.createQuery("select c from Celebrite c where c.prenom like :p");
		req.setParameter("p", "%"+prenom+"%");
		return req.getResultList();
	}

	@Override
	public List<Celebrite> rechercherCelebritesParNom(String nom) {
		Query req=em.createQuery("select c from Celebrite c where c.nom like :n ");
		req.setParameter("n", "%"+nom+"%");
		return req.getResultList();
	}

	
	//ajout
	@Override
	public void ajouterCelebrite(Celebrite c) {
		em.persist(c);
		
	}

	//supprime
	@Override
	public void supprimerCelebrite(int numC) {
		Query req2 = em.createQuery("delete from AssocieA where numCelebrite = :x ");
		req2.setParameter("x", numC).executeUpdate();
		Query req = em.createQuery("delete from Celebrite where numCelebrite = :x ");
		req.setParameter("x", numC).executeUpdate();
		
	}

	//Recupere 
	@Override
	public Celebrite recupererCelebrite(int numC) {
		Celebrite c= em.find(Celebrite.class, numC);
		return c;
	}

	//MAJ
	@Override
	public void miseAJourCelebrite(Celebrite c) {
		em.merge(c);
		
	}

	
	
	/*
	@Override
	public List<Celebrite> rechercheCelebritesParLieu(String nomL) {
		Query req=em.createQuery("select c from Celebrites c where c.Lieu.nomC like x");
		req.setParameter("x", "%"+nomL+"%");
		return req.getResultList();
	}
	*/

	

	

}
