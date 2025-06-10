package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {
	// ===========================================
    // 11. ANAGRAM CHECK
    // ===========================================

    /**
     * ENUNCIADO: Verificar se duas strings são anagramas
     * ENTRADA: s1 = "listen", s2 = "silent"
     * SAÍDA: true
     */
	
	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		// Método 1: Usando Sorting
		char[] chars1 = s1.toLowerCase().toCharArray();
		char[] chars2 = s1.toLowerCase().toCharArray();
		
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		
		return Arrays.equals(chars1, chars2);
	}
	// Complexidade: Tempo O(n log n), Espaço O(n)
	
	/**
     * ANAGRAM CHECK - Versão otimizada com HashMap
     */
	public static boolean isAnagramOptimized(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		Map<Character, Integer> charCount = new HashMap<>();
		
		// Conta caracteres da primeira string
		for  (char c : s1.toLowerCase().toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}
		
		// Decrementa com caracteres da segunda string
		for (char c : s2.toLowerCase().toCharArray()) {
			if (!charCount.containsKey(c)) {
				return false;
			}
			
			int count = charCount.get(c) - 1;
			if (count == 0 ) {
				charCount.remove(c);
			} else {
				charCount.put(c, count);
			}
		}
		return charCount.isEmpty();
	}
	// Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos
	
	public static void main(String[] args) {
		System.out.println(isAnagram("listen", "silent"));
		System.out.println(isAnagramOptimized("listen", "silent"));
	}
}
