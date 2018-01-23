package um2.m2ips.projet.models;

public class AssociationForm {
	private long numM;
	private String nomM;
	private int numC;
	private String nomC;
	
	
	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public long getNumM() {
		return numM;
	}
	public void setNumM(long numM) {
		this.numM = numM;
	}
	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public AssociationForm(long numM, String nomM, int numC, String nomC) {
		super();
		this.numM = numM;
		this.nomM = nomM;
		this.numC = numC;
		this.nomC = nomC;
	}
	public AssociationForm() {
		super();
	}
	public AssociationForm(long numM, int numC) {
		super();
		this.numM = numM;
		this.numC = numC;
	}
	
	
	

}
