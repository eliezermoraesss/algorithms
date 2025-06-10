package algorithms;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {
	// ===========================================
    // 10. CARACTERES REPETIDOS
    // ===========================================

    /**
     * ENUNCIADO: Encontrar o primeiro caractere repetido em uma string
     * ENTRADA: "programming"
     * SAÍDA: 'r' (primeiro caractere que aparece mais de uma vez)
     */
	
	public static String findFirstRepeatedChar(String str) {
		Set<Character> seen = new HashSet<>();
		
		for (char c : str.toCharArray()) {
			if (seen.contains(c)) return "Primeiro caractere repetido: " + c;
			seen.add(c);
		}
		return "Nenhum caractere repetido";
	}
	
	public static void main(String[] args) {
		System.out.println(findFirstRepeatedChar("programming"));
	}
}
