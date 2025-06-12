package algorithms;

/**
 * BUBBLE SORT
 * ENUNCIADO: Ordenar array usando bubble sort
 * ENTRADA: [64, 34, 25, 12, 22, 11, 90]
 * SAÍDA: [11, 12, 22, 25, 34, 64, 90]
 */
import java.util.*;

public class BubbleSort2 {
	public static void bubbleSort(int[] arr) {
	    int arrayLength = arr.length;
	    
	    for(int i = 0; i < arrayLength; i++) {
	    	boolean hasChange = false;
	    	for (int j = 0; j < arrayLength - i - 1; j++) {
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

	public static void main(String[] args) {
	    int[] bubbleArray = {64, 34, 25, 12, 22, 11, 90};
	    bubbleSort(bubbleArray);
		System.out.println(Arrays.toString(bubbleArray));
	}
	// Complexidade: Tempo: O(n²), Espaço: O(1)
}
