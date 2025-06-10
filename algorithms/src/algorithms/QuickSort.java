package algorithms;

import java.util.Arrays;

public class QuickSort {
	/**
     * QUICK SORT
     * ENUNCIADO: Ordenar array usando quicksort
     * ENTRADA: [10, 7, 8, 9, 1, 5]
     * SAÍDA: [1, 5, 7, 8, 9, 10]
     */
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			
			quickSort(arr, low, pi - 1); // Antes do pivot
			quickSort(arr, pi + 1, high); // Depois do pivot
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // Último elemento como pivot
		int i = (low - 1);
		
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		// Coloca o pivot na possição correta
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	// Complexidade: Tempo O(n log n) avg, O(n²) worst, Espaço O(log n)
	
	public static void main(String[] args) {
		int[] quickArray = {10, 7, 8, 9, 1, 5};
		quickSort(quickArray, 0, quickArray.length - 1);
		System.out.println("Quick Sort: " + Arrays.toString(quickArray));
	}
}
