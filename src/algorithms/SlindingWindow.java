package algorithms;

import java.util.*;

public class SlindingWindow {
	// ===========================================
    // 5. SLIDING WINDOW
    // ===========================================

    /**
     * ENUNCIADO: Encontrar substring mais longa sem caracteres repetidos
     * ENTRADA: "abcabcbb"
     * SAÍDA: 3 (substring "abc")
     */
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> window = new HashSet<>();
		int left = 0;
		int maxLength = 0;
		
		for (int right = 0; right < s.length(); right++) {
			char rightChar = s.charAt(right);
			
			// Remove caracteres do início até não haver duplicata
			while (window.contains(rightChar)) {
				window.remove(s.charAt(left));
				left++;
			}
			
			// Adiciona o caractere atual à janela (conjunto de caracteres únicos)
			window.add(rightChar);
			// Atualiza o comprimento máximo se a janela atual for maior
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}
	// Complexidade: Tempo O(n), Espaço O(min(m,n)) onde m é o tamanho do charset
	
	public static void main(String[] args) {
		String text = "abcabcbb";
		System.out.println("Longest Substring: " + lengthOfLongestSubstring(text));
	}
}
