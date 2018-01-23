package um2.m2ips.projet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import um2.m2ips.projet.entities.AssocieA;
import um2.m2ips.projet.entities.Celebrite;
import um2.m2ips.projet.entities.Monument;
import um2.m2ips.projet.metier.IAssociationMetier;
import um2.m2ips.projet.metier.ICelebriteMetier;
import um2.m2ips.projet.metier.IMonumentMetier;
import um2.m2ips.projet.models.AssociationForm;


@Controller
public class RelationController {
	@Autowired
	IMonumentMetier monumentMetier;
	@Autowired
	ICelebriteMetier celebriteMetier;
	@Autowired
	IAssociationMetier associationMetier;
	
	//Page  Gestion des Relations Célébrites -> Monuments
	@RequestMapping(value="/GestionAssociations")
	public String GestionAssociations (Model modele)
	{
		System.out.println("etape 1");
		List<AssocieA> associations= associationMetier.recupererToutesLesAssociations();
		for (AssocieA a: associations)
		{
			System.out.println(a.getCelebrite());
		}
		List<AssociationForm> result=new ArrayList<>();
		Monument m;
		Celebrite c;
		long numM;
		String nomM;
		int numC;
		String nomC;
		
		//Recuperer le nom du monument et de la celebrite pour chaque association
		for (AssocieA association: associations)
		{
			m=association.getMonument();
			c=association.getCelebrite();
			numM=m.getCodeM();
			nomM=m.getNomM();
			numC=c.getNumCelebrite();
			nomC=c.getNom()+" "+c.getPrenom();
			AssociationForm a= new AssociationForm(numM, nomM, numC, nomC);
			result.add(a);
		}
		modele.addAttribute("AssociationForm", new AssociationForm());
		modele.addAttribute("associations", result);
		modele.addAttribute("celebrites", celebriteMetier.recupererToutesLesCelebrites());
		modele.addAttribute("monuments", monumentMetier.recupererTousLesMonuments());
		return "relationsCelebritesMonuments";
	}
	
	//Ajouter une Relation 
			@RequestMapping(value={ "**/enregistrerAssociation/**"}, method = RequestMethod.POST)
			public String enregistrerAssociation (AssociationForm aform, BindingResult bindingResult, Model modele)
			{
				
				
				
				if (bindingResult.hasErrors()){return "relationsCelebritesMonuments"; }
				
				
				//récupere les info saisies
				long numM=aform.getNumM();
				int numC=aform.getNumC();
				
				//Recupere les objets Monuments et Celebrite
				Celebrite c= celebriteMetier.recupererCelebrite(numC);
				Monument m= monumentMetier.recupererMonument(numM);
				
				AssocieA a = new AssocieA(c, m);
				associationMetier.ajouterRelation(a);
				
				List<AssocieA> associations= associationMetier.recupererToutesLesAssociations();
				List<AssociationForm> result=new ArrayList<>();
				String nomM;
				String nomC;
				//Recuperer le nom du monument et de la celebrite pour chaque association
				for (AssocieA association: associations)
				{
					m=association.getMonument();
					c=association.getCelebrite();
					numM=m.getCodeM();
					nomM=m.getNomM();
					numC=c.getNumCelebrite();
					nomC=c.getNom()+" "+c.getPrenom();
					AssociationForm af= new AssociationForm(numM, nomM, numC, nomC);
					result.add(af);
				}
				modele.addAttribute("AssociationForm", new AssociationForm());
				modele.addAttribute("associations", result);
				modele.addAttribute("celebrites", celebriteMetier.recupererToutesLesCelebrites());
				modele.addAttribute("monuments", monumentMetier.recupererTousLesMonuments());
				return "relationsCelebritesMonuments";
				
				
			}
			
			
			//Supprimer 
			@RequestMapping(value={"/supprimerAssociation/{numM}/{numC}"})
			public String supprimerMonument (@PathVariable(value="numC") int numC, @PathVariable(value="numM") long numM, Model modele)
				{
					
					associationMetier.supprimerRelation(numC, numM);
					
					List<AssocieA> associations= associationMetier.recupererToutesLesAssociations();
					List<AssociationForm> result=new ArrayList<>();
					String nomM;
					String nomC;
					Monument m;
					Celebrite c;
					long codeM;
					int codeC;
					//Recuperer le nom du monument et de la celebrite pour chaque association
					for (AssocieA association: associations)
					{
						m=association.getMonument();
						c=association.getCelebrite();
						codeM=m.getCodeM();
						nomM=m.getNomM();
						codeC=c.getNumCelebrite();
						nomC=c.getNom()+" "+c.getPrenom();
						AssociationForm af= new AssociationForm(codeM, nomM, codeC, nomC);
						result.add(af);
					}
					modele.addAttribute("AssociationForm", new AssociationForm());
					modele.addAttribute("associations", result);
					modele.addAttribute("celebrites", celebriteMetier.recupererToutesLesCelebrites());
					modele.addAttribute("monuments", monumentMetier.recupererTousLesMonuments());
					return "relationsCelebritesMonuments";
				}
		

}
