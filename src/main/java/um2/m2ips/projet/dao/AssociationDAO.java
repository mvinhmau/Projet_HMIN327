package um2.m2ips.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import um2.m2ips.projet.entities.AssocieA;
import um2.m2ips.projet.entities.Monument;


public class AssociationDAO implements IAssociationDAO {
	@PersistenceContext
		EntityManager em;
		
		@Override
		public List<AssocieA> recupererToutesLesAssociations() {
			Query req=em.createQuery("select a from AssocieA a");
			System.out.println("dao 1");
			return req.getResultList();
		}

		@Override
		public void ajouterRelation(AssocieA a) {
			em.persist(a);
			
		}

		@Override
		public void supprimerRelation(int numC, long numM) {
			Query req2 = em.createQuery("delete from AssocieA where numCelebrite = :x and codeM =:y ");
			req2.setParameter("x", numC);
			req2.setParameter("y", numM).executeUpdate();
		}

		@Override
		public AssocieA recupererRelation(int numC, long numM) {
			Query req=em.createQuery("select a from AssocieA a where a.numCelebrite =: x and a.codeM =:y ");
			req.setParameter("x", numC);
			req.setParameter("y", numM);
			return (AssocieA) req.getSingleResult();
			
		}

		@Override
		public List<AssocieA> recupererCelebritesParMonument(long numM) {
			Query req=em.createQuery("select a from AssocieA a where a.monument.codeM =:y ");
			req.setParameter("y", numM);
			return req.getResultList();
		}

		



}
