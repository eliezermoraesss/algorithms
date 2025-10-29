package algorithms;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicateChars {
	/**
     * ENUNCIADO: Verificar se string tem caracteres duplicados
     * ENTRADA: "abcdef" -> false, "hello" -> true
     * SAÍDA: boolean indicando se há duplicatas
     */
	public static boolean hasDuplicatedChars(String str) {
		Set<Character> seen = new HashSet<>();
		
		for (char c : str.toCharArray()) {
			if (seen.contains(c)) return true;
			seen.add(c);
		}
		return false;
	}
	// Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos
	
	public static void main(String[] args) {
		System.out.println(hasDuplicatedChars("abcdef"));
	}
}
