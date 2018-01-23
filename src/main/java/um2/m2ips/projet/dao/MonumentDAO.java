package um2.m2ips.projet.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import um2.m2ips.projet.entities.AssocieA;
import um2.m2ips.projet.entities.Monument;

public class MonumentDAO implements IMonumentDAO {
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void ajouterMonument(Monument m) {
		em.persist(m);
	}

	@Override
	public List<Monument> recupererTousLesMonuments() {
		Query req=em.createQuery("select m from Monument m");
		return req.getResultList();
	}

	@Override
	public List<Monument> recupererTousLesMonumentsParNom(String nom) {
		Query req=em.createQuery("select m from Monument m where m.nomM like:x");
		req.setParameter("x", "%"+nom+"%");
		return req.getResultList();
	}

	@Override
	public void supprimerMonument(long codeM) {
		Query req2 = em.createQuery("delete from AssocieA where codeM = :x ");
		req2.setParameter("x", codeM).executeUpdate();
		Query req = em.createQuery("delete from Monument where codeM = :x ");
		req.setParameter("x", codeM).executeUpdate();
	}


	@Override
	public Monument recupererMonument(long codeM) {
		Monument m= em.find(Monument.class, codeM);
		System.out.println ("monument trouvé : " + m.getNomM());
		return m;
		
	}

	
	@Override
	public List<Monument> rechercherMonumentsParLieu(String nomCom) {
		Query req = em.createQuery("select m from Monument m where m.localite.nomCom =:x");
		req.setParameter("x", nomCom);
		List <Monument> result =req.getResultList();
		return result;
	}

	

	@Override
	public List<Monument> rechercherMonumentsParDep(String nomDep) {
		Query req = em.createQuery("select m from Monument m where m.localite.departements.nomDep like:x");
		
		req.setParameter("x", "%"+nomDep+"%");
		
		return req.getResultList();
	}

	@Override
	public List<Monument> rechercherMonumentsParProp(String nomP) {
		Query req=em.createQuery("select m from Monument m where m.proprietaire like:x");
		req.setParameter("x", "%"+nomP+"%");
		return req.getResultList();
	}

	@Override
	public List<Monument> rechercherMonumentsParType(String nomT) {
		Query req=em.createQuery("select m from Monument m where m.typeMonument like:x");
		req.setParameter("x", "%"+nomT+"%");
		return req.getResultList();
	}

	@Override
	public void miseAJourMonument(Monument m) {
		em.merge(m);
		
	}

	

	
	
	
	

}
