package um2.m2ips.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Monument")
public class Monument implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeM;
	
	private String nomM;
	private String proprietaire;
	private String typeMonument;
	private float latitude;
	private float longitude;
	 @ManyToOne
	 @JoinColumn(name="codeInsee")
	private Lieu localite;
	


	public Monument() {
		super();
	}
	public Monument( long codeM,String nomM, String propritaire, String typeMonument, float latitude, float longitude,
			Lieu localite) {
		super();
		this.codeM=codeM;
		this.nomM = nomM;
		this.proprietaire = propritaire;
		this.typeMonument = typeMonument;
		this.latitude = latitude;
		this.longitude = longitude;
		this.localite = localite;
	}

	public Monument( String nomM, String propritaire, String typeMonument, float latitude, float longitude,
			Lieu localite) {
		super();
		
		this.nomM = nomM;
		this.proprietaire = propritaire;
		this.typeMonument = typeMonument;
		this.latitude = latitude;
		this.longitude = longitude;
		this.localite = localite;
	}
	

	public long getCodeM() {
		return codeM;
	}

	public void setCodeM(long codeM) {
		this.codeM = codeM;
	}

	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	
	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getlongitude() {
		return longitude;
	}
	public void setlongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getTypeMonument() {
		return typeMonument;
	}

	public void setTypeMonument(String typeMonument) {
		this.typeMonument = typeMonument;
	}
	
	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Lieu getLocalite() {
		return localite;
	}

	public void setLocalite(Lieu localite) {
		this.localite = localite;
	}
	
}
