package um2.m2ips.projet.entities;

import java.util.ArrayList;
import java.util.List;

public class ListeTypes {
	public List<String> getListType() {

		List<String> list = new ArrayList<String>();
		list.add("autre");
		list.add("cinema");
		list.add("musee");
		list.add("opera");
		list.add("parc");
		list.add("place");
		list.add("piscine");
		list.add("theatre");
		

		return list;

	}

}
