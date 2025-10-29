package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllRepeatedChars {
    /**
     * ENUNCIADO: Encontrar todos os caracteres repetidos
     * ENTRADA: "programming"
     * SAÍDA: ['r', 'g', 'm'] (todos os caracteres que aparecem mais de uma vez)
     */
	
	public static List<Character> findAllRepeatedChars(String str) {
		Map<Character, Integer> frequency = new HashMap<>();
		List<Character> repeated = new ArrayList<>();
		
		// Primeira passada: conta as frequências
		for (char c : str.toCharArray()) {
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);
		}
		
		// Segunda passada: encontra repetidos em ordem de aparição
		Set<Character> addedToResult = new HashSet<>();
		for (char c : str.toCharArray()) {
			if (frequency.get(c) > 1 && !addedToResult.contains(c)) {
				repeated.add(c);
				addedToResult.add(c);
			}
		}
		return repeated;
	}
	// Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos
	
	public static void main(String[] args) {
		System.out.println(findAllRepeatedChars("programming"));
	}
}
