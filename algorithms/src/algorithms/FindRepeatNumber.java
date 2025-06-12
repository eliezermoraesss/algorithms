package algorithms;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
	public static Set<Integer> findRepeatNumber(int[] arr) {
		Set<Integer> seen = new HashSet<>();
		Set<Integer> repeated = new HashSet<>();
		
		for (int num : arr) { // O(n)
			if (seen.contains(num)) {
				repeated.add(num);
			} else {
				seen.add(num);
			}	
		}
		return repeated;
	}
	// Complexidade: Tempo O(n), Espaço O(n)
	
	public static void main(String[] args) {
		int[] numberArray = {1, 2, 5, 2, 1, 8, 6, 7, 5, 8, 9, 10, 45, 67};
		System.out.println(findRepeatNumber(numberArray));
	}
}
