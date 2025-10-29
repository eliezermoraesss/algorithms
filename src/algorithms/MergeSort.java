package algorithms;

import java.util.Arrays;

public class MergeSort {
	/**
    * MERGE SORT
    * ENUNCIADO: Ordenar array usando merge sort
    * ENTRADA: [38, 27, 43, 3, 9, 82, 10]
    * SAÍDA: [3, 9, 10, 27, 38, 43, 82]
    */
	public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);      // Primeira metade
            mergeSort(arr, mid + 1, right); // Segunda metade

            merge(arr, left, mid, right);   // Combina as duas metades
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copia dados para arrays temporários
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Combina os arrays temporários
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copia elementos restantes
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
	// Complexidade: Tempo O(n log n), Espaço O(n)
	
	public static void main(String[] args) {
		int[] mergeArray = {38, 27, 43, 3, 9, 82, 10};
		mergeSort(mergeArray, 0, mergeArray.length - 1);
		System.out.println("Merge Soft: " + Arrays.toString(mergeArray));
	}
}
