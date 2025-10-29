package algorithms;

import java.util.Arrays;

public class BubbleSort {
	// 2. ALGORITMOS DE ORDENAÇÃO
    // ===========================================

    /**
     * BUBBLE SORT
     * ENUNCIADO: Ordenar array usando bubble sort
     * ENTRADA: [64, 34, 25, 12, 22, 11, 90]
     * SAÍDA: [11, 12, 22, 25, 34, 64, 90]
     */
	
	public static void bubbleSort(int[] arr) {
		int arrayLength = arr.length;
		
		for (int i = 0; i < arrayLength - 1; i++) {
			boolean hasChange = false;
			
			for (int  j = 0; j < arrayLength - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					hasChange = true;
				}
			}
			if (!hasChange) break;
		}
	}
	// Complexidade: Tempo O(n²) worst/avg, O(n) best, Espaço O(1)
	
	public static void main(String[] args) {
		int[] bubbleArray = {64, 34, 25, 12, 22, 11, 90};
		bubbleSort(bubbleArray);
		System.out.println("Bubble Sort: " + Arrays.toString(bubbleArray));
	}
}
