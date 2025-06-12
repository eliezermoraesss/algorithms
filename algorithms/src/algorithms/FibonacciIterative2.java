package algorithms;

public class FibonacciIterative2 {
	/**
     * FIBONACCI ITERATIVO
     * ENUNCIADO: Calcular n-ésimo número de Fibonacci iterativamente
     * ENTRADA: n = 10
     * SAÍDA: 55 (sequência: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
     */
	
	public static void fibonacciIterative(int n) {
		if (n <= 1) {
			System.out.println(n);
		}
		
		int anterior = 0;
		int atual = 1;
		int proximo = 0;
		System.out.println(atual);
		for (int i = 2; i <= n; i ++) {
			proximo = atual + anterior;
			anterior = atual;
			atual = proximo;
			System.out.println(atual);
		}
	}
	
	public static void main(String[] args) {
		fibonacciIterative(10);
	}
}
