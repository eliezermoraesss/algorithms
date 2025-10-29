package algorithms;

public class OddSum {
	public static void main(String[] args) {
		int[] numeros = {5, 8, 2, 3, 10, 15, 20, 1, 0, 6};
		int sum = 0;
		
		for (int num : numeros) {
			if (num % 2 != 0) sum += num;
		}
		System.out.println(sum);
	}
}
