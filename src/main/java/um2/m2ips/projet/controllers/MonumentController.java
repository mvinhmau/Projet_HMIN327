package um2.m2ips.projet.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import um2.m2ips.projet.entities.Lieu;
import um2.m2ips.projet.entities.ListeTypes;
import um2.m2ips.projet.entities.Monument;
import um2.m2ips.projet.metier.ILieuMetier;
import um2.m2ips.projet.metier.IMonumentMetier;
import um2.m2ips.projet.models.CalculDistanceForm;
import um2.m2ips.projet.models.MonumentForm;

@Controller
public class MonumentController {
	
	@Autowired 
	private IMonumentMetier metier;
	@Autowired
	private ILieuMetier lieuMetier;
	
	
	//Partie Gestion des Monuments 
	
	//Liste des types pour les monuments
	
	//Liste 
	@RequestMapping(value="/GestionMonuments")
	public String gestionMonuments (Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		modele.addAttribute("monumentForm", new MonumentForm()); //exemple de valeur par défaut
		modele.addAttribute("monuments", metier.recupererTousLesMonuments());
		modele.addAttribute("lieux", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("types", listeTypes.getListType());
		return "monuments";
	}
	
	//Ajouter un monument 
	@RequestMapping(value={ "**/enregistrerMonument/**"}, method = RequestMethod.POST)
	public String enregistrerMonument (MonumentForm mform, BindingResult bindingResult, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		if (bindingResult.hasErrors()){return "monuments"; }
		List <Monument> monuments = metier.recupererTousLesMonuments();
		
		//récupère l'objet Lieu 
		String codeInsee=mform.getCodeInsee();
		Lieu lieu = lieuMetier.recupererUnLieu(codeInsee);
		
		//récupere les info saisies
		String nomM=mform.getNomM();
		String type=mform.getType();
		String prop=mform.getNomProp();
		float longi= mform.getLongitude();
		float lat=mform.getLatitude();
		long codeM=mform.getCodeM();
		
		
		//test si le monument existe déjà 
		long code= mform.getCodeM();
		if (code!=0)
		{
			Monument m = new Monument (code, nomM, prop, type, lat, longi, lieu);
			metier.miseAJourMonument(m);
		}
		else 
		{
			Monument m = new Monument (nomM, prop, type, lat, longi, lieu);	
			metier.ajouterMonument(m);
		}	
		
		modele.addAttribute("monumentForm", new MonumentForm());
		modele.addAttribute("monuments", metier.recupererTousLesMonuments());
		modele.addAttribute("lieux", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("types", listeTypes.getListType());
		return "monuments";
		
		
	}
	
	//Supprimer un monument
	@RequestMapping(value={"/supprimerMonument/{codeM}", "**/supprimerMonument/{codeM}/**"})
	public String supprimerMonument (@PathVariable(value="codeM") long codeM,  Model modele)
		{
			ListeTypes listeTypes= new ListeTypes();
			metier.supprimerMonument(codeM);
			modele.addAttribute("monumentForm", new MonumentForm());
			modele.addAttribute("monuments", metier.recupererTousLesMonuments());
			modele.addAttribute("lieux", lieuMetier.recupererTousLesLieux());
			modele.addAttribute("types", listeTypes.getListType());
			return "monuments";
		}
	
	//Modifier un monument
	@RequestMapping(value="**/miseAJourMonument/{codeM}/**")
	public String miseAJourMonument (@PathVariable(value="codeM") long codeM, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		Monument m=metier.recupererMonument(codeM);
		
		//Creation du formulaire
		String nom=m.getNomM();
		String type=m.getTypeMonument();
		String prop=m.getProprietaire();
		Lieu lieu=m.getLocalite();
		String nomlieu=lieu.getNomCom();
		float longi=m.getLongitude();
		float lat=m.getLatitude();
		MonumentForm mForm= new MonumentForm(codeM, nom, type, prop, nomlieu, longi, lat);
		
		modele.addAttribute("monumentForm", mForm);
		modele.addAttribute("monuments", metier.recupererTousLesMonuments());
		modele.addAttribute("lieu", lieu);
		modele.addAttribute("lieux", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("types", listeTypes.getListType());
		return "monuments";
	}
	
	
	
	//Partie Recherche Monuments

	
	@RequestMapping(value="/rechercherMonumentsParNom")
	public String rechercherMonumentsParNom ( MonumentForm mform, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		
		//recupere la liste des monuments (couche métier)
		List<Monument> monuments = metier.recupererTousLesMonumentsParNom(mform.getNomM());
		
		//stoke le resultat dans le modele MonumentForm
		mform.setMonuments(monuments);
		
		//stocke les différentes données dans le modèle qui sera fournit à la vue 
		modele.addAttribute("monumentForm", mform);
		modele.addAttribute("types", listeTypes.getListType());
		modele.addAttribute("rechercheform", new MonumentForm());
		modele.addAttribute("communes", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
		
		//envoie a la vue RechercheMonument
		return "RechercheMonument";
	}
	
	
	
	@RequestMapping(value="/rechercherMonumentsParLieu")
	public String rechercherMonumentsParLieu ( MonumentForm mform, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		List<Monument> monuments= metier.rechercherMonumentsParLieu(mform.getNomLieu());
		mform.setMonuments(monuments);
		modele.addAttribute("monumentForm", mform);
		modele.addAttribute("types", listeTypes.getListType());
		modele.addAttribute("rechercheform", new MonumentForm());
		modele.addAttribute("communes", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
		return "RechercheMonument";
	}
	
	
	@RequestMapping(value="/rechercherMonumentsParDep")
	public String rechercherMonumentsParDep ( MonumentForm mform, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		List<Monument> monuments= metier.rechercherMonumentsParDep(mform.getNomDep());
		mform.setMonuments(monuments);
		modele.addAttribute("monumentForm", mform);
		modele.addAttribute("types", listeTypes.getListType());
		modele.addAttribute("rechercheform", new MonumentForm());
		modele.addAttribute("communes", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
		return "RechercheMonument";
	}
	
	@RequestMapping(value="/rechercherMonumentsParProp")
	public String rechercherMonumentsParProp ( MonumentForm mform, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		List<Monument> monuments= metier.rechercherMonumentsParProp(mform.getNomProp());
		mform.setMonuments(monuments);
		modele.addAttribute("monumentForm", mform);
		modele.addAttribute("types", listeTypes.getListType());
		modele.addAttribute("rechercheform", new MonumentForm());
		modele.addAttribute("communes", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
		return "RechercheMonument";
	}
	
	@RequestMapping(value="/rechercherMonumentsParType")
	public String rechercherMonumentsParType (MonumentForm mform, Model modele)
	{
		ListeTypes listeTypes= new ListeTypes();
		List<Monument> monuments= metier.rechercherMonumentsParType(mform.getType());
		mform.setMonuments(monuments);
		modele.addAttribute("monumentForm", mform);
		modele.addAttribute("types", listeTypes.getListType());
		modele.addAttribute("rechercheform", new MonumentForm());
		modele.addAttribute("communes", lieuMetier.recupererTousLesLieux());
		modele.addAttribute("departements", lieuMetier.recupererTousLesDepartements());
		return "RechercheMonument";
	}
	
	//Partie Calcul de Distance 
	@RequestMapping(value="/CalculerDistanceEntreDeuxPoints")
	public String CalculerDistanceEntreDeuxPoints(CalculDistanceForm cform, Model modele)
	{
		List<Monument> monuments= metier.recupererTousLesMonuments();
		
		long codeM1= cform.getCodeM1();
		Monument m1= metier.recupererMonument(codeM1);
		String nom1=m1.getNomM();
		float lat1= m1.getLatitude();
		float long1=m1.getlongitude();
		
		long codeM2=cform.getCodeM2();
		Monument m2= metier.recupererMonument(codeM2);
		String nom2=m2.getNomM();
		float lat2=m2.getLatitude();
		float long2=m2.getlongitude();
		
		String distance = metier.calculerLaDistanceEntreDeuxPoints(lat1, long1, lat2, long2);
		System.out.println("distance trouvee: "+ distance);
		System.out.println("monuments "+ nom1 +" - " +nom2);
		modele.addAttribute("m1", m1);
		modele.addAttribute("m2", m2);
		modele.addAttribute("nom1", nom1);
		modele.addAttribute("nom2", nom2);
		modele.addAttribute("distance", distance);
		modele.addAttribute("calculDistanceForm", new CalculDistanceForm());
		modele.addAttribute("monuments", monuments);
		
		return "calculeDeDistance";
	}

	
}
