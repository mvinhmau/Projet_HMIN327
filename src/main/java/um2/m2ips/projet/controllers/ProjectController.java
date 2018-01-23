package um2.m2ips.projet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import um2.m2ips.projet.entities.Departement;
import um2.m2ips.projet.entities.ListeTypes;
import um2.m2ips.projet.entities.Monument;
import um2.m2ips.projet.entities.Nationalites;
import um2.m2ips.projet.metier.ILieuMetier;
import um2.m2ips.projet.metier.IMonumentMetier;
import um2.m2ips.projet.models.CalculDistanceForm;
import um2.m2ips.projet.models.CelebriteForm;
import um2.m2ips.projet.models.LieuForm;
import um2.m2ips.projet.models.MonumentForm;


@Controller
public class ProjectController {
	
	@Autowired
	private ILieuMetier lieuMetier;
	@Autowired
	private IMonumentMetier monumentMetier;
	
	
	//Page d'Acceuil 
	
	@RequestMapping(value={"/", "/accueil", })
	public String indexDefault(){
		return "accueil";
	}
	
	
	//Pages Recherches Informations 
	
		//Page  Acceuil RechercheInformation
		@RequestMapping(value="/RechercheInformation")
		public String RechercheInformation ()
		{
			
			return "accueilRechercheInformation";
		}
		
		//Page RechercheCelebrite
		@RequestMapping(value="/RechercheCelebrite")
		public String RechercheCelebrite (Model modele)
		{
			modele.addAttribute("rechercheform", new CelebriteForm());
			modele.addAttribute("rechercheform2", new MonumentForm());
			modele.addAttribute("monuments", monumentMetier.recupererTousLesMonuments());
			return "RechercheCelebrite";
		}
				
		//Page RechercheMonument
		@RequestMapping(value="/RechercheMonument")
		public String RechercheMonument (Model modele)
		{
			ListeTypes listeTypes= new ListeTypes();
			modele.addAttribute("rechercheform", new MonumentForm());
			modele.addAttribute("types", listeTypes.getListType());
			modele.addAttribute("communes", lieuMetier.recupererTousLesLieux());
			modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
			return "RechercheMonument";
		}
			
		//Page RechercheLieu
		@RequestMapping(value="/RechercheLieu")
		public String RechercheLieu (Model modele)
		{
			modele.addAttribute("rechercheform", new LieuForm());
			modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
			return "RechercheLieu";
		}
				
	
	//Page CalculDeDistance
	@RequestMapping(value="/CalculeDeDistance")
	public String CalculeDeDistance (Model modele)
	{
		List<Monument> monuments= monumentMetier.recupererTousLesMonuments();
		modele.addAttribute("calculDistanceForm", new CalculDistanceForm());
		modele.addAttribute("monuments", monuments);
		return "calculeDeDistance";
	}
	
	//Pages Gestion
	
		//Page  Accueil Gestion des donnees
			@RequestMapping(value="/GestionDesDonnees")
			public String GestionDesDonnees ()
			{
				
				return "accueilGestion";
			}
		
		
		
		
	
		
	
	
	
}

