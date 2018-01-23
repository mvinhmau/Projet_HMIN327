package um2.m2ips.projet.metier;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import um2.m2ips.projet.dao.IMonumentDAO;
import um2.m2ips.projet.entities.Monument;

public class MonumentMetier implements IMonumentMetier {
	private IMonumentDAO dao;
	
	public void setDao(IMonumentDAO dao)
	{
		this.dao=dao;
	}

	@Override
	@Transactional
	public void ajouterMonument(Monument m) {
		dao.ajouterMonument(m);

	}

	@Override
	@Transactional
	public List<Monument> recupererTousLesMonuments() {
		return dao.recupererTousLesMonuments();
	}

	@Override
	@Transactional
	public void supprimerMonument(long codeM) {
		dao.supprimerMonument(codeM);
		
	}

	@Override
	@Transactional
	public Monument recupererMonument(long codeM) {
		return dao.recupererMonument(codeM);
	}


	@Override
	@Transactional
	public List<Monument> recupererTousLesMonumentsParNom(String nomM) {
		return dao.recupererTousLesMonumentsParNom(nomM);
	}

	@Override
	@Transactional
	public List<Monument> rechercherMonumentsParLieu(String nomCom) {
		return dao.rechercherMonumentsParLieu(nomCom);
	}

	
	@Override
	@Transactional
	public List<Monument> rechercherMonumentsParDep(String nomDep) {
		return dao.rechercherMonumentsParDep(nomDep);
	}

	@Override
	@Transactional
	public List<Monument> rechercherMonumentsParProp(String nomP) {
		return dao.rechercherMonumentsParProp(nomP);
	}

	@Override
	@Transactional
	public List<Monument> rechercherMonumentsParType(String nomT) {
		return dao.rechercherMonumentsParType(nomT);
	}

	@Override
	@Transactional
	public void miseAJourMonument(Monument m) {
		dao.miseAJourMonument(m);
		
	}

	@Override
	@Transactional
	public String calculerLaDistanceEntreDeuxPoints(float lat1, float long1, float lat2, float long2) {
		
	    double distance=6366*Math.acos(Math.cos(radians(lat1))*Math.cos(radians(lat2))*Math.cos(radians(long1)-radians(long2))+Math.sin(radians(lat1))*Math.sin(radians(lat2)));
	    NumberFormat nf = new DecimalFormat("0.##");
	    return nf.format(distance);
	}
	
	public double radians (float x)
	{
		return  ((double) x/57.295779513082);
	}

}
