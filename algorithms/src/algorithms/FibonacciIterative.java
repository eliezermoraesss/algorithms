package algorithms;

public class FibonacciIterative {
	/**
     * FIBONACCI ITERATIVO
     * ENUNCIADO: Calcular n-ésimo número de Fibonacci iterativamente
     * ENTRADA: n = 10
     * SAÍDA: 55 (sequência: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
     */
	
	public static int fibonacchiIterative(int n) {
		if (n <= 1 ) {
			return n;
		}
		
		int numeroAnterior = 0;
		int numeroAtual = 1;
		int proximoNumero = 0;
		
		for (int i = 2; i <= n; i++) {
			proximoNumero = numeroAtual + numeroAnterior;
			numeroAnterior = numeroAtual;
			numeroAtual = proximoNumero;
		}
		
		return proximoNumero;
	}
	// Comprexidade: Tempo O(n), Espaço O(1) - muito mais eficiente!
	
	public static void main(String[] args) {
		System.out.println("Fibonacchi Iterative: " + fibonacchiIterative(40));
	}
}
