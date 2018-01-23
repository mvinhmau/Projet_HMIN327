package um2.m2ips.projet.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Departement")
public class Departement implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numDep;
	private String nomDep;
	
	
	@OneToMany(mappedBy="departements",fetch=FetchType.LAZY)
	private Collection<Lieu> lieux;
	
	public Departement() {
		super();
	}
	
	public Departement(String numDep, String nomDep) {
		super();
		this.numDep = numDep;
		this.nomDep = nomDep;
	}
	
//	public Collection<Lieu> getLieux() {
//		return lieux;
//	}
//
//	public void setLieux(Collection<Lieu> lieux) {
//		this.lieux = lieux;
//	}

	public String getNumDep() {
		return numDep;
	}
	public void setNumDep(String numDep) {
		this.numDep = numDep;
	}
	
	
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	

	
	
}
