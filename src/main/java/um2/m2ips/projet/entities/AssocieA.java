package um2.m2ips.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AssocieA")
public class AssocieA  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @ManyToOne //possibilte de plusieurs associations de monuments vers une celebrite
	 @JoinColumn(name="numCelebrite")
	private Celebrite celebrite;
	 @Id
	 @ManyToOne //possibilte de plusieurs associations de celebrites vers un monument
	 @JoinColumn(name="codeM")
	private Monument monument;

	public AssocieA() {
	}

	public AssocieA(Celebrite celebrite, Monument monument) {
		super();
		this.celebrite = celebrite;
		this.monument = monument;
	}

	public Celebrite getCelebrite() {
		return celebrite;
	}

	public void setCelebrite(Celebrite celebrite) {
		this.celebrite = celebrite;
	}

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}
	 
	
}
