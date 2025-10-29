package algorithms;

public class MinMaxNumber {
	
	/**
     * ENUNCIADO: Encontrar o maior E o menor número simultaneamente
     * ENTRADA: [3, 7, 2, 9, 1, 8, 4]
     * SAÍDA: {min: 1, max: 9}
     */
	
	public static class MinMax {
		int min;
		int max;
		
		public MinMax(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "min: " + min + ", max: " + max;
		}
	}
	
	public static MinMax findMinMax(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
		}
		
		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return new MinMax(min, max);
	}
	// Complexidade: Tempo O(n), Espaço O(1)
	
	public static void main(String[] args) {
		int[] array = {3, 7, 2, 9, 1, 8, 4};
		System.out.println(findMinMax(array));
	}
}
