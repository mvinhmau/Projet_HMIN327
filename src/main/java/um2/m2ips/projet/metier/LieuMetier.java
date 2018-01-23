package um2.m2ips.projet.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import um2.m2ips.projet.dao.ICelebriteDAO;
import um2.m2ips.projet.dao.ILieuDAO;
import um2.m2ips.projet.dao.LieuDAO;
import um2.m2ips.projet.entities.Departement;
import um2.m2ips.projet.entities.Lieu;

public class LieuMetier implements ILieuMetier {
	LieuDAO dao;
	
	
	public void setDao(LieuDAO dao)
	{
		this.dao=dao;
	}

	@Override
	@Transactional
	public List<Lieu> rechercherLieuxParDep(String nomDep) {
		return dao.rechercherLieuxParDep(nomDep);
	}

	@Override
	@Transactional
	public List<Lieu> recupererTousLesLieux() {
		return dao.recupererTousLesLieux();
	}

	@Override
	@Transactional
	public Lieu recupererUnLieu(String codeInsee) {
		return dao.recupererUnLieu(codeInsee);
	}

	@Override
	@Transactional
	public List<Departement> recupererTousLesDepartements() {
		return dao.recupererTousLesDepartements();
	}

}
