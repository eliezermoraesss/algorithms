package algorithms;

public class ReverseString {
	// ===========================================
	// 12. REVERSE STRING
	// ===========================================

	/**
	 * ENUNCIADO: Inverter uma string
	 * ENTRADA: "hello"
	 * SAÍDA: "olleh"
	 * MÉTODO 1: Usando StringBuilder
	 */
	public static String reverseString(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("String não pode ser nula ou vazia");
		}
		return new StringBuilder(str).reverse().toString();
	}
	// Complexidade: Tempo O(n), Espaço O(n)
	
	/**
	 * MÉTODO 2: Usando array de caracteres (in-place)
	 */
	public static String reverseStringManual(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("String não pode ser nula ou vazia");
		}
		
		char[] chars = str.toCharArray();
		int left = 0;
		int right = chars.length - 1;
		
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			
			left++;
			right--;
		}
		return new String(chars);
	}
	// Complexidade: Tempo O(n), Espaço O(n)
	
	public static void main(String[] args) {
		System.out.println("Reverse String (StringBuilder): " + reverseString("hello"));
		System.out.println("Reverse String (Manual): " + reverseString("hello"));
	}
}
