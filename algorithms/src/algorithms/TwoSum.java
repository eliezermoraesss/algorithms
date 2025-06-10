package algorithms;

import java.util.Arrays;

public class TwoSum {
	// ===========================================
    // 4. TWO POINTER - TWO SUM
    // ===========================================

    /**
     * ENUNCIADO: Encontrar dois números que somam um target
     * ENTRADA: Array ordenado [2, 7, 11, 15] e target = 9
     * SAÍDA: Índices [0, 1] pois arr[0] + arr[1] = 2 + 7 = 9
     */
	public static int[] twoSum(int[] arr, int target) {
		int left = 0; // O(1)
		int right = arr.length - 1; // O(1)
		
		while (left < right) { // O(n)
			int sum = arr[left] + arr[right];
			
			if (sum == target) {
				return new int[]{left, right};
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[]{};
	}
	// Complexidade: Tempo O(n), Espaço O(1)
	
	public static void main(String[] args) {
		int[] array = {2, 7, 11, 15};
		int target = 18;
		System.out.println("" + Arrays.toString(twoSum(array, target)));
	}
}
