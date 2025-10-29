package algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class FilterFirstLetterArrayList {
	public static List<String> mode1(List<String> nomes) {
		List<String> nomesFiltrados = nomes.stream()
				.filter(nome -> nome.startsWith("E"))
				.collect(Collectors.toList());
				
		return nomesFiltrados;
	}
	
	public static List<String> mode2() {
		List<String> nomes = new ArrayList<>();
		nomes.add("Eliezer");
		nomes.add("Nádia");
		nomes.add("Snoopy");
		nomes.add("Edmar");
		nomes.add("Eidy");
		nomes.add("Nathália");
		
		for (int i = 0; i < nomes.size(); i++) {
			if (nomes.get(i).charAt(0) != 'N') {
				nomes.remove(i);
				i--;
			}
		}
				
		return nomes;
	}
	
	public static List<String> mode3(List<String> nomes) {
		nomes.removeIf(nome -> nome.startsWith("S"));
		return nomes;
	}
	
	public static void main(String[] args) {
		List<String> originalList = Arrays.asList("Eliezer", "Nádia", "Snoopy", "Edmar", "Eidy", "Nathália");
		List<String> copyList = new ArrayList<>(originalList);
		
		System.out.println(mode1(originalList) + " size: " + originalList.size());
		
		List<String> nomes = mode2();
		System.out.println(nomes + " size: " + nomes.size());
		
		System.out.println(mode3(copyList) + " size: " + copyList.size());
	}
}
