package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlgorithmsOtimizationExercises {
	// Desafio 1: Verificar duplicatas em um array
	// Descrição: Dado um array de inteiros, retorne true se houver pelo menos um elemento repetido.
	
	// [1, 2, 3, 4] → Deve retornar false
	// [1, 2, 2, 4] → Deve retornar true
	// [] → Deve retornar false
	
	public static boolean hasDuplicate(int[] array) {
		for(int i = 0; i < array.length; i++) { // O(n)
			for (int j = i + 1; j < array.length; j++) { // O(n)
				if (array[i] == array[j]) return true;
			}
		}
		return false;
	}
	// Complexidade: Tempo O(n²), Espaço O(1)
	
	public static boolean hasDuplicateSet(int[] array) {
		Set<Integer> seen = new HashSet<>();
		
		for (int item : array) {
			if (!seen.add(item)) return true;
		}
		return false;
	}
	// Complexidade: Tempo O(n), Espaço O(1)
	
	// Desafio 3: Contar frequências de elementos
	// Descrição: Conte a frequência de cada elemento em um array.
	
	// [1, 2, 2, 3, 3, 3] → 1:1, 2:2, 3:3
	// [7, 7, 7, 7] → 7:4
	// [] → vazio
	
	public static Map<Integer, Integer> elementFrequency(int[] array) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;	
				}
				frequency.put(array[i], count);
			}
		}
		return frequency;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4};
		int[] array2 = {1, 2, 2, 4};
		System.out.println("Sem Set: " + hasDuplicate(array1));
		System.out.println("Com Set: " + hasDuplicateSet(array1));
		System.out.println("Sem Set: " + hasDuplicate(array2));
		System.out.println("Com Set: " + hasDuplicateSet(array2));
		
		int[] array3 = {1, 2, 2, 3, 3, 3};
		System.out.println(elementFrequency(array3));
	}
}
