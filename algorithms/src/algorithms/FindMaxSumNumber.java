package algorithms;

public class FindMaxSumNumber {
	
	public static void main(String[] args) {
		int[] arr = {-9, -3, -4, -6, -3, -2, 1};
		System.out.println("A maior soma possível é: " + findMaxSum(arr));
		System.out.println("A maior soma possível é: " + findMaxSum2(arr));
	}

	private static int findMaxSum(int[] arr) {
		int sum = 0;
		int minValue = Integer.MIN_VALUE;
		
		for (int item : arr) { // O(n)
			if (item >= 0) {
				sum += item;
			} else if (item > minValue) {
				minValue = item;
			}
		}
		return sum == 0 ? minValue : sum;
	}
	// Complexidade: Tempo O(n), Espaço O(1)
	
	private static int findMaxSum2(int[] arr) {
		int sum = 0;
		int minValue = Integer.MIN_VALUE;
		boolean hasPositive = false;
		
		for (int item : arr) { // O(n)
			if (item >= 0) {
				sum += item;
				hasPositive = true;
			} else {
				if (item > minValue) {
					minValue = item;
				}
			}
		}
		return hasPositive ? sum : minValue;
	}
}
