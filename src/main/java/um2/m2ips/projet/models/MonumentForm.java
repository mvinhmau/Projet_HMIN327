package um2.m2ips.projet.models;

import java.util.List;

import um2.m2ips.projet.entities.Monument;

public class MonumentForm {
	private String nomM;
	private String codeInsee;
	private String nomLieu;
	private String nomDep;
	private String nomProp;
	private String type;
	private float longitude;
	private float latitude;
	private long codeM;
	private List<Monument> monuments;
	
	//Getters et Setters
	
	
	public String getNomProp() {
		return nomProp;
	}


	public MonumentForm() {
		super();
	}


	public MonumentForm(long codeM, String nomM,  String type, String nomProp, String nomLieu, float longitude, float latitude) {
		super();
		this.codeM=codeM;
		this.nomM = nomM;
		this.nomLieu = nomLieu;
		this.nomProp = nomProp;
		this.type = type;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public long getCodeM() {
		return codeM;
	}


	public void setCodeM(long codeM) {
		this.codeM = codeM;
	}


	public String getCodeInsee() {
		return codeInsee;
	}

	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	public void setNomProp(String nomProp) {
		this.nomProp = nomProp;
	}
	
	
	public String getNomLieu() {
		return nomLieu;
	}
	public void setNomLieu(String nomL) {
		this.nomLieu = nomL;
	}
	
	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	
	public List<Monument> getMonuments() {
		return monuments;
	}
	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}
	
	

}
