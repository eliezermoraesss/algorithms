package algorithms;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterFrequency {
	/**
     * ENUNCIADO: Contar frequência de todos os caracteres
     * ENTRADA: "hello world"
     * SAÍDA: {h=1, e=1, l=3, o=2, space=1, w=1, r=1, d=1}
     */
	
	public static Map<Character, Integer> countCharacterFrequency(String str) {
		Map<Character, Integer> frequency = new HashMap<>();
		
		for (char c : str.toCharArray()) {
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);
		}
		
		return frequency;
	}
	// Complexidade: Tempo O(n), Espaço O(k) onde k é o número de caracteres únicos
	
	public static void main(String[] args) {
		System.out.println(countCharacterFrequency("hello world"));
	}
}
