package algorithms;

public class FibonacciRecursive {
	// ===========================================
    // 6. FIBONACCI SEQUENCE
    // ===========================================

    /**
     * FIBONACCI RECURSIVO
     * ENUNCIADO: Calcular n-ésimo número de Fibonacci recursivamente
     * ENTRADA: n = 10
     * SAÍDA: 55 (sequência: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
     */
	
	public static int fibonacchiRecursive(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacchiRecursive(n - 1) + fibonacchiRecursive(n - 2);
	}
	// Complexidade: Tempo O(2^n), Espaço O(n) - muito ineficiente!
	
	public static void main(String[] args) {
		System.out.println("Fibonacchi Recursive: " + fibonacchiRecursive(45));
	}
}
