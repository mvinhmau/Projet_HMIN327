package um2.m2ips.projet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecuriteController {
	
	//Page de Connexion
		@RequestMapping(value = "/connexion",  method = RequestMethod.GET)
	    public String connexion() {
	        return "connexion";
	    }
		
		//Deconnexion
		@RequestMapping("/deconnexion")
		public String deconnexion(){
		    return "logout";
		}
		
		//Erreur de Connexion
		@RequestMapping(value = "/erreurConnexion")
	    public String erreurConnexion() {
	        return "erreurConnexion";
	    }
		
		//Acces Refuse
		@RequestMapping(value = "/accesRefuse")
		public String accesRefuse() {
		    return "accesRefuse";
		}
}
