package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BruteForceSearch {
	// ===========================================
    // 7. BRUTE FORCE - SUBSTRING SEARCH
    // ===========================================

    /**
     * ENUNCIADO: Encontrar todas ocorrências de um padrão em texto
     * ENTRADA: texto = "AABAACAADAABAAABAA", padrão = "AABA"
     * SAÍDA: [0, 9, 13] (índices onde padrão começa)
     */
	public static List<Integer> bruteForceSearch(String text, String pattern) {
		List<Integer> occurrences = new ArrayList<>();
		int textLength = text.length();
		int patternLength = pattern.length();
		
		for (int i= 0; i <= textLength - patternLength; i++) {
			int j;
			for (j = 0; j < patternLength; j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			
			if (j == patternLength) { // Padrão encontrado
				occurrences.add(i);
			}
		}
		return occurrences;
	}
	// Complexidade: Tempo O(n*m), Espaço O(1) para busca + O(k) para resultado
	
	public static void main(String[] args) {
		System.out.println("Brute Force Search: " + bruteForceSearch("AABAACAADAABAAABAA", "AABA"));
	}
}
