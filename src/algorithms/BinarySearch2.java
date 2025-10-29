package algorithms;

public class BinarySearch2 {
	
	// ===========================================
    // 1. BINARY SEARCH
    // ===========================================

    /**
     * ENUNCIADO: Implementar busca binária em array ordenado
     * ENTRADA: Array ordenado [1, 3, 5, 7, 9, 11, 13, 15] e target = 7
     * SAÍDA: Índice do elemento (3) ou -1 se não encontrado
     */
	
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] main) {
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
		int target = 15;
		System.out.println("O valor " + target + " está no índice " + binarySearch(array, target) + " do array");
	}
}
