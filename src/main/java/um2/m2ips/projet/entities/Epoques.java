package um2.m2ips.projet.entities;
import java.util.ArrayList;
import java.util.List;

public class Epoques {
	public List<String> getEpoques() {

		List<String> list = new ArrayList<String>();
		list.add("prehistoire");
		list.add("antiquite");
		list.add("moyen age");
		list.add("renaissance");
		list.add("epoque moderne");
		list.add("contemporaine");
		list.add("XXIe siecles");

		

		return list;

	}

}
