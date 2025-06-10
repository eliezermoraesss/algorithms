package algorithms;

public class FindMaxNumber {
	// ===========================================
    // 9. ENCONTRAR MAIOR NÚMERO DO ARRAY
    // ===========================================

    /**
     * ENUNCIADO: Encontrar o maior número em um array
     * ENTRADA: [3, 7, 2, 9, 1, 8, 4]
     * SAÍDA: 9
     */
	
	public static int findMaxNumber(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
		}
			int max = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	// Complexidade: Tempo O(n), Espaço O(1)
	
	public static void main(String[] args) {
		int[] array = {3, 7, 3, 9, 10, 8, 4};
		System.out.println("Maior número: " + findMaxNumber(array));
	}
}
