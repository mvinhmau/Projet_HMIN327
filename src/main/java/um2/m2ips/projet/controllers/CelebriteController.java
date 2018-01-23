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
import um2.m2ips.projet.entities.Epoques;
import um2.m2ips.projet.entities.Lieu;
import um2.m2ips.projet.entities.ListeTypes;
import um2.m2ips.projet.entities.Monument;
import um2.m2ips.projet.entities.Nationalites;
import um2.m2ips.projet.metier.IAssociationMetier;
import um2.m2ips.projet.metier.ICelebriteMetier;
import um2.m2ips.projet.metier.IMonumentMetier;
import um2.m2ips.projet.models.CelebriteForm;
import um2.m2ips.projet.models.MonumentForm;

@Controller
public class CelebriteController {
	
	@Autowired
	private ICelebriteMetier metier;
	@Autowired
	private IMonumentMetier monumentMetier;
	@Autowired
	private IAssociationMetier associationMetier;
	
	//Partie Gestion
	
	//Accueil
	@RequestMapping(value="/GestionCelebrites")
	public String gestionCelebrites (Model modele)
	{
		Nationalites nationalites= new Nationalites();
		Epoques epoques=new Epoques();
		modele.addAttribute("celebriteForm", new CelebriteForm()); //exemple de valeur par défaut
		modele.addAttribute("celebrites", metier.recupererToutesLesCelebrites());
		modele.addAttribute("nationalites", nationalites.getListNationalities());
		modele.addAttribute("epoques", epoques.getEpoques());
		

		return "celebrites";
	}
	
	//Ajouter une Celebrite
	
		@RequestMapping(value={ "**/enregistrerCelebrite/**"}, method = RequestMethod.POST)
		public String enregistrerCelebrite (CelebriteForm cform, BindingResult bindingResult, Model modele)
		{
			Nationalites nationalites= new Nationalites();
			Epoques epoques=new Epoques();
			
			if (bindingResult.hasErrors()){return "celebrites"; }
			
			
			//récupere les info saisies
			String nom=cform.getNom();
			String prenom=cform.getPrenom();
			String nationalite=cform.getNationalite();
			String epoque= cform.getEpoque();
			
			
			int numCelebrite= cform.getNumCelebrite();
			if (numCelebrite!=0)
			{
				Celebrite c = new Celebrite(numCelebrite, nom, prenom,nationalite,epoque);
				metier.miseAJourCelebrite(c);
			}
			else 
			{
				Celebrite c = new Celebrite (nom, prenom,nationalite,epoque);	
				metier.ajouterCelebrite(c);
			}	
			
			modele.addAttribute("celebriteForm", new CelebriteForm());
			modele.addAttribute("celebrites", metier.recupererToutesLesCelebrites());
			modele.addAttribute("nationalites", nationalites.getListNationalities());
			modele.addAttribute("epoques", epoques.getEpoques());
			
			return "celebrites";
			
			
		}
		
		//Modifier 
		@RequestMapping(value="**/miseAJourCelebrite/{numCelebrite}/**")
		public String miseAJourCelebrite (@PathVariable(value="numCelebrite") int num, Model modele)
		{
			Nationalites nationalites= new Nationalites();
			Epoques epoques=new Epoques();
			Celebrite c= metier.recupererCelebrite(num);
			
			//Creation du formulaire
			String nom=c.getNom();
			String prenom=c.getPrenom();
			String nationalite=c.getNationalite();
			String epoque=c.getEpoque();
			
			CelebriteForm cForm= new CelebriteForm(num, nom, prenom, nationalite, epoque);
			
			modele.addAttribute("celebriteForm", cForm);
			modele.addAttribute("celebrites", metier.recupererToutesLesCelebrites());
			modele.addAttribute("nationalites", nationalites.getListNationalities());
			modele.addAttribute("epoques", epoques.getEpoques());
			return "celebrites";
		}
		
		//Supprimer 
		@RequestMapping(value={"/supprimerCelebrite/{numCelebrite}", "**/supprimerCelebrite/{numCelebrite}/**"})
		public String supprimerCelebrite (@PathVariable(value="numCelebrite") int numC,  Model modele)
			{
				Nationalites nationalites= new Nationalites();
				Epoques epoques=new Epoques();
				
				metier.supprimerCelebrite(numC);
				
				modele.addAttribute("celebriteForm", new CelebriteForm());
				modele.addAttribute("celebrites", metier.recupererToutesLesCelebrites());
				modele.addAttribute("nationalites", nationalites.getListNationalities());
				modele.addAttribute("epoques", epoques.getEpoques());
				return "celebrites";
			}
	
	
	
	//Partie Recherche
	
	@RequestMapping (value="/rechercherCelebritesParNoms")
	public String rechercherCelebritesParNoms(Model modele, CelebriteForm cform)
	{
		List<Monument> monuments= monumentMetier.recupererTousLesMonuments() ; 
		
		
		List<Celebrite> celebrites ; 
		
		if (cform.getNom().isEmpty())
		{
			celebrites= metier.rechercherCelebritesParPrenom(cform.getPrenom());
		}
		else
		{
			if (cform.getPrenom().isEmpty())
			{
				celebrites= metier.rechercherCelebritesParNom(cform.getNom());
			}
			else 
			{
				celebrites= metier.rechercherCelebritesParNoms(cform.getNom(), cform.getPrenom());
			}
		}
		cform.setCelebrites(celebrites);
		
		modele.addAttribute("celebriteForm", cform);
		modele.addAttribute("rechercheform", new CelebriteForm());
		modele.addAttribute("rechercheform2", new MonumentForm());
		modele.addAttribute("monuments", monuments);
		return "RechercheCelebrite";
	}
	
	//Rechercher les celebrites affectees à un monument
	@RequestMapping (value="/rechercherCelebritesParMonument")
	public String rechercherCelebritesParMonument(Model modele, MonumentForm mform)
	{
		
		List<Monument> monuments= monumentMetier.recupererTousLesMonuments() ; 
		long numM= mform.getCodeM();
		
		//Recupere les association des celebrites avec ce monument
		List<AssocieA> list = associationMetier.recupererCelebritesParMonument(numM);
		List<Celebrite> celebrites= new ArrayList <>();
		Celebrite celebrite;
		for (AssocieA a : list)
		{
			celebrite= a.getCelebrite();
			celebrites.add(celebrite);
		}
		// Ajoute la liste des resultats au form
		CelebriteForm cform = new CelebriteForm();
		cform.setCelebrites(celebrites);
		
		
		
		
		modele.addAttribute("celebriteForm", cform);
		modele.addAttribute("rechercheform", new CelebriteForm());
		modele.addAttribute("rechercheform2", new MonumentForm());
		modele.addAttribute("monuments", monuments);
		return "RechercheCelebrite";
	}
	

}
