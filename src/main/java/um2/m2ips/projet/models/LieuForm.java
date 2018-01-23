package um2.m2ips.projet.models;

import java.util.List;

import um2.m2ips.projet.entities.Lieu;

public class LieuForm {
	private String nomDep;
	private List<Lieu> lieux;
	
	
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	public List<Lieu> getLieux() {
		return lieux;
	}
	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
	
	

}
