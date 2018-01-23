package um2.m2ips.projet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import um2.m2ips.projet.entities.Departement;
import um2.m2ips.projet.entities.Lieu;
import um2.m2ips.projet.metier.ILieuMetier;
import um2.m2ips.projet.models.LieuForm;

@Controller
public class LieuController {
	
	@Autowired
	private ILieuMetier metier;
	
	@RequestMapping (value="/rechercherLieuxParDep")
	public String rechercherLieuxParDep (Model modele, LieuForm lform)
	{
		
		List<Lieu> lieux= metier.rechercherLieuxParDep(lform.getNomDep());
		List <Departement> departements= metier.recupererTousLesDepartements();
		System.out.println(lieux.size());
		lform.setLieux(lieux);
		modele.addAttribute("lieuForm", lform);
		modele.addAttribute("rechercheform", new LieuForm());
		modele.addAttribute("departements", departements);
		return "RechercheLieu";
	}
	

}