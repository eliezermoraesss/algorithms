package algorithms;

import java.util.*;

// Kadane's Algorithm

public class FindMaxSum {
	public static int findMaxSum(int[] array) {
		int sum = 0;
		List<Integer> numerosPositivos = new ArrayList<>();
		List<Integer> numerosNegativos =  new ArrayList<>();
		
		for (int item : array) { // Tempo: O(n) Espaço // O(n)
			if (item >= 0) {
		    	numerosPositivos.add(item); 
		    } else {
		    	numerosNegativos.add(item);
		    }
		}
	    
		if (numerosPositivos.size() > 0) {
		    for (int item : numerosPositivos) { // O(n) 
		      sum += item;
		    }
		} else if (numerosNegativos.size() > 0) {
			int maiorElemento = numerosNegativos.get(0);
			for (int item : numerosNegativos) { // O(n)
			  	if (item > maiorElemento) {
			    	maiorElemento = item;
			    }
			}
			sum = maiorElemento;
	    } 
	  return sum;
	}
	// Complexidade: Tempo O(n), Espaço O(n)
	
	public static int findMaxSum2(int[] array) {
		int sum = 0;
		int maximoNegativo = Integer.MIN_VALUE;
		boolean temPositivo = false;
		
		for (int item : array) {
			if (item >= 0) {
				sum += item;
				temPositivo = true;
			} else {
				if (item > maximoNegativo) {
					maximoNegativo = item;
				}
			}
		}
		return temPositivo ? sum : maximoNegativo;
	}
	// Complexidade: Tempo O(n), Espaço O(1)

	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4};
		int[] array2 = {-5, -2, -3, -8};
		System.out.println(findMaxSum(array1));
		System.out.println(findMaxSum(array2));
		System.out.println(findMaxSum2(array1));
		System.out.println(findMaxSum2(array2));
	}
}
