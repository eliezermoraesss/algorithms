package algorithms;

public class FibonacciIterative {
	/**
     * FIBONACCI ITERATIVO
     * ENUNCIADO: Calcular n-ésimo número de Fibonacci iterativamente
     * ENTRADA: n = 10
     * SAÍDA: 55
     */
	
	public static int fibonacchiIterative(int n) {
		if (n <= 1 ) {
			return n;
		}
		
		int prev2 = 0;
		int prev1 = 1;
		int current = 0;
		
		for (int i = 2; i <= n; i++) {
			current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}
		
		return current;
	}
	// Comprexidade: Tempo O(n), Espaço O(1) - muito mais eficiente!
	
	public static void main(String[] args) {
		System.out.println("Fibonacchi Iterative: " + fibonacchiIterative(46));
	}
}
