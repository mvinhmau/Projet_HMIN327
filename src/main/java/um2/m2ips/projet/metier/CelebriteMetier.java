package um2.m2ips.projet.metier;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import um2.m2ips.projet.dao.ICelebriteDAO;
import um2.m2ips.projet.entities.Celebrite;

public class CelebriteMetier implements ICelebriteMetier {
	ICelebriteDAO dao;
	
	public void setDao(ICelebriteDAO dao)
	{
		this.dao=dao;
	}

	//Recuperer Toutes les Celebrites
	@Override
	@Transactional
	public List<Celebrite> recupererToutesLesCelebrites() {
		return dao.recupererToutesLesCelebrites();
	}
	
	//Recherche par nom et/ou prenom
	@Override
	@Transactional
	public List<Celebrite> rechercherCelebritesParNoms(String nom, String prenom) {
		return dao.rechercherCelebritesParNoms(nom, prenom);
	}
	
	@Override
	@Transactional
	public List<Celebrite> rechercherCelebritesParNom(String nom) {
		return dao.rechercherCelebritesParNom(nom);
	}


	@Override
	@Transactional
	public List<Celebrite> rechercherCelebritesParPrenom(String prenom) {
		List<Celebrite> celebrites= dao.rechercherCelebritesParPrenom(prenom);
		return celebrites;
	}

	@Override
	@Transactional
	public void ajouterCelebrite(Celebrite c) {
		dao.ajouterCelebrite(c);
		
	}

	@Override
	@Transactional
	public void supprimerCelebrite(int numC) {
		dao.supprimerCelebrite(numC);
		
	}

	@Override
	@Transactional
	public Celebrite recupererCelebrite(int numC) {
		// TODO Auto-generated method stub
		return dao.recupererCelebrite(numC);
	}

	@Override
	@Transactional
	public void miseAJourCelebrite(Celebrite c) {
		dao.miseAJourCelebrite(c);
		
	}

	
	

	/*
	@Override
	@Transactional
	public List<Celebrite> rechercherCelebritesParLieu(String nomL) {
		return dao.rechercherCelebritesParLieu(nomL);
	}
	*/
	




	
}
