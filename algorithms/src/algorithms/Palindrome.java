package algorithms;

public class Palindrome {
	// ===========================================
    // 3. PALINDROME
    // ===========================================

    /**
     * ENUNCIADO: Verificar se uma string é palíndromo
     * ENTRADA: "A man a plan a canal Panama"
     * SAÍDA: true (ignorando espaços e maiúsculas)
     */
	
	public static boolean isPalidrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++; // Desconsiderar os espaços
			while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--; // Desconsiderar os espaços
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;
			left++;
			right--;
		}
		return true;
	}
	// Complexidade: Tempo O(n), Espaço O(1)
	
	public static void main(String[] args) {
		System.out.println("Palindrome: " + isPalidrome("A man a plan a canal Panama"));
        System.out.println("Palindrome: " + isPalidrome("race a car"));
	}
}
