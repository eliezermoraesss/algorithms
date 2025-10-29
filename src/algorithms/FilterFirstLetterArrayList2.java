package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FilterFirstLetterArrayList2 {
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		nomes.add("Eliezer");
		nomes.add("Nádia");
		nomes.add("Snoopy");
		nomes.add("Edmar");
		nomes.add("Eidy");
		nomes.add("Nathália");
		
		for (int i = 0; i < nomes.size(); i++) {
			if (nomes.get(i).charAt(0) != 'E') {
				nomes.remove(i);
				i--;
			}
		}
				
		System.out.print(nomes);
	}
}
