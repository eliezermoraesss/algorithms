//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class AlgorithmExercises {

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
            int mid = left + (right - left) / 2; // Evita overflow

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Não encontrado
    }
    // Complexidade: Tempo O(log n), Espaço O(1)

    // ===========================================
    // 2. ALGORITMOS DE ORDENAÇÃO
    // ===========================================

    /**
     * BUBBLE SORT
     * ENUNCIADO: Ordenar array usando bubble sort
     * ENTRADA: [64, 34, 25, 12, 22, 11, 90]
     * SAÍDA: [11, 12, 22, 25, 34, 64, 90]
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Últimos i elementos já estão ordenados
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Se não houve troca, array já está ordenado
            if (!swapped) break;
        }
    }
    // Complexidade: Tempo O(n²) worst/avg, O(n) best, Espaço O(1)

    /**
     * QUICK SORT
     * ENUNCIADO: Ordenar array usando quicksort
     * ENTRADA: [10, 7, 8, 9, 1, 5]
     * SAÍDA: [1, 5, 7, 8, 9, 10]
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Antes do pivot
            quickSort(arr, pi + 1, high); // Depois do pivot
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Último elemento como pivot
        int i = (low - 1);     // Índice do menor elemento

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Coloca pivot na posição correta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    // Complexidade: Tempo O(n log n) avg, O(n²) worst, Espaço O(log n)

    /**
     * MERGE SORT
     * ENUNCIADO: Ordenar array usando merge sort
     * ENTRADA: [38, 27, 43, 3, 9, 82, 10]
     * SAÍDA: [3, 9, 10, 27, 38, 43, 82]
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);      // Primeira metade
            mergeSort(arr, mid + 1, right); // Segunda metade

            merge(arr, left, mid, right);   // Combina as duas metades
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copia dados para arrays temporários
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Combina os arrays temporários
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copia elementos restantes
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    // Complexidade: Tempo O(n log n), Espaço O(n)

    // ===========================================
    // 3. PALINDROME
    // ===========================================

    /**
     * ENUNCIADO: Verificar se uma string é palíndromo
     * ENTRADA: "A man a plan a canal Panama"
     * SAÍDA: true (ignorando espaços e maiúsculas)
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++; right--;
        }
        return true;
    }
    // Complexidade: Tempo O(n), Espaço O(n) devido ao replaceAll

    // ===========================================
    // 4. TWO POINTER - TWO SUM
    // ===========================================

    /**
     * ENUNCIADO: Encontrar dois números que somam um target
     * ENTRADA: Array ordenado [2, 7, 11, 15] e target = 9
     * SAÍDA: Índices [0, 1] pois arr[0] + arr[1] = 2 + 7 = 9
     */
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{}; // Não encontrado
    }
    // Complexidade: Tempo O(n), Espaço O(1)

    // ===========================================
    // 5. SLIDING WINDOW
    // ===========================================

    /**
     * ENUNCIADO: Encontrar substring mais longa sem caracteres repetidos
     * ENTRADA: "abcabcbb"
     * SAÍDA: 3 (substring "abc")
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Remove caracteres do início até não haver duplicata
            while (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(rightChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    // Complexidade: Tempo O(n), Espaço O(min(m,n)) onde m é tamanho do charset

    /**
     * ENUNCIADO: Temperaturas diárias - encontrar próximo dia mais quente
     * ENTRADA: [73, 74, 75, 71, 69, 72, 76, 73]
     * SAÍDA: [1, 1, 4, 2, 1, 1, 0, 0] (dias até temperatura maior)
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Armazena índices

        for (int i = 0; i < n; i++) {
            // Enquanto stack não vazio e temperatura atual > temperatura do topo
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
    // Complexidade: Tempo O(n), Espaço O(n)

    // ===========================================
    // 6. FIBONACCI SEQUENCE
    // ===========================================

    /**
     * FIBONACCI RECURSIVO
     * ENUNCIADO: Calcular n-ésimo número de Fibonacci
     * ENTRADA: n = 10
     * SAÍDA: 55 (sequência: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
     */
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Complexidade: Tempo O(2^n), Espaço O(n) - muito ineficiente!

    /**
     * FIBONACCI ITERATIVO
     * ENUNCIADO: Calcular n-ésimo número de Fibonacci iterativamente
     * ENTRADA: n = 10
     * SAÍDA: 55
     */
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
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
    // Complexidade: Tempo O(n), Espaço O(1) - muito mais eficiente!

    // ===========================================
    // 7. BRUTE FORCE - SUBSTRING SEARCH
    // ===========================================

    /**
     * ENUNCIADO: Encontrar todas ocorrências de um padrão em texto
     * ENTRADA: texto = "AABAACAADAABAAABAA", padrão = "AABA"
     * SAÍDA: [0, 9, 13] (índices onde padrão começa)
     */
    public static List<Integer> bruteForceSearch(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) { // Padrão encontrado
                occurrences.add(i);
            }
        }

        return occurrences;
    }
    // Complexidade: Tempo O(n*m), Espaço O(1) para busca + O(k) para resultado

    // ===========================================
    // 8. PERMUTATIONS
    // ===========================================

    /**
     * ENUNCIADO: Gerar todas as permutações de um array
     * ENTRADA: [1, 2, 3]
     * SAÍDA: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue; // Pula se já usado

            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
    // Complexidade: Tempo O(n! * n), Espaço O(n! * n)

    // ===========================================
    // 9. ENCONTRAR MAIOR NÚMERO DO ARRAY
    // ===========================================

    /**
     * ENUNCIADO: Encontrar o maior número em um array
     * ENTRADA: [3, 7, 2, 9, 1, 8, 4]
     * SAÍDA: 9
     */
    public static int findMaxNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
        }

        int max = arr[0]; // Assume primeiro elemento como maior

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
    // Complexidade: Tempo O(n), Espaço O(1)

    /**
     * ENUNCIADO: Encontrar maior número usando streams (Java 8+)
     * ENTRADA: [3, 7, 2, 9, 1, 8, 4]
     * SAÍDA: 9
     */
    public static int findMaxNumberStream(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
        }

        return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
    }
    // Complexidade: Tempo O(n), Espaço O(1)

    /**
     * ENUNCIADO: Encontrar o maior E o menor número simultaneamente
     * ENTRADA: [3, 7, 2, 9, 1, 8, 4]
     * SAÍDA: {min: 1, max: 9}
     */
    public static class MinMax {
        int min;
        int max;

        MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Min: " + min + ", Max: " + max;
        }
    }

    public static MinMax findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array não pode ser nulo ou vazio");
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new MinMax(min, max);
    }
    // Complexidade: Tempo O(n), Espaço O(1)

    // ===========================================
    // 10. CARACTERES REPETIDOS
    // ===========================================

    /**
     * ENUNCIADO: Encontrar o primeiro caractere repetido em uma string
     * ENTRADA: "programming"
     * SAÍDA: 'r' (primeiro caractere que aparece mais de uma vez)
     */
    public static char findFirstRepeatedChar(String str) {
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return c; // Primeiro repetido encontrado
            }
            seen.add(c);
        }

        return '\0'; // Nenhum caractere repetido (null character)
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    /**
     * ENUNCIADO: Contar frequência de todos os caracteres
     * ENTRADA: "hello world"
     * SAÍDA: {h=1, e=1, l=3, o=2, space=1, w=1, r=1, d=1}
     */
    public static Map<Character, Integer> countCharacterFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        return frequency;
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    /**
     * ENUNCIADO: Encontrar todos os caracteres repetidos
     * ENTRADA: "programming"
     * SAÍDA: ['r', 'g', 'm'] (todos os caracteres que aparecem mais de uma vez)
     */
    public static List<Character> findAllRepeatedChars(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        List<Character> repeated = new ArrayList<>();

        // Primeira passada: conta frequências
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Segunda passada: encontra repetidos em ordem de aparição
        Set<Character> addedToResult = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (frequency.get(c) > 1 && !addedToResult.contains(c)) {
                repeated.add(c);
                addedToResult.add(c);
            }
        }

        return repeated;
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    /**
     * ENUNCIADO: Verificar se string tem caracteres duplicados
     * ENTRADA: "abcdef" -> false, "hello" -> true
     * SAÍDA: boolean indicando se há duplicatas
     */
    public static boolean hasDuplicateChars(String str) {
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.add(c)) { // add() retorna false se elemento já existe
                return true;
            }
        }

        return false;
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    /**
     * ENUNCIADO: Encontrar caractere mais frequente
     * ENTRADA: "programming"
     * SAÍDA: 'r' ou 'g' ou 'm' (qualquer um dos mais frequentes)
     */
    public static char findMostFrequentChar(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String não pode ser nula ou vazia");
        }

        Map<Character, Integer> frequency = new HashMap<>();

        // Conta frequências
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Encontra o mais frequente
        char mostFrequent = str.charAt(0);
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    /**
     * ENUNCIADO: Remover caracteres duplicados mantendo primeira ocorrência
     * ENTRADA: "programming"
     * SAÍDA: "progamin" (remove duplicatas, mantém ordem)
     */
    public static String removeDuplicateChars(String str) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (seen.add(c)) { // add() retorna true se não existia
                result.append(c);
            }
        }

        return result.toString();
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    // ===========================================
    // 11. ANAGRAM CHECK
    // ===========================================

    /**
     * ENUNCIADO: Verificar se duas strings são anagramas
     * ENTRADA: s1 = "listen", s2 = "silent"
     * SAÍDA: true
     */
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Método 1: Usando sorting
        char[] chars1 = s1.toLowerCase().toCharArray();
        char[] chars2 = s2.toLowerCase().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    /**
     * ANAGRAM CHECK - Versão otimizada com HashMap
     */
    public static boolean isAnagramOptimized(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Conta caracteres da primeira string
        for (char c : s1.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrementa com caracteres da segunda string
        for (char c : s2.toLowerCase().toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }
            int count = charCount.get(c) - 1;
            if (count == 0) {
                charCount.remove(c);
            } else {
                charCount.put(c, count);
            }
        }

        return charCount.isEmpty();
    }
    // Complexidade: Tempo O(n), Espaço O(k) onde k é número de caracteres únicos

    // ===========================================
    // MÉTODO MAIN PARA TESTES
    // ===========================================

    public static void main(String[] args) {
        // Teste Binary Search
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("Binary Search (7): " + binarySearch(sortedArray, 7));

        // Teste Bubble Sort
        int[] bubbleArray = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(bubbleArray);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleArray));

        // Teste Quick Sort
        int[] quickArray = {10, 7, 8, 9, 1, 5};
        quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickArray));

        // Teste Merge Sort
        int[] mergeArray = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArray));

        // Teste Palindrome
        System.out.println("Palindrome: " + isPalindrome("A man a plan a canal Panama"));

        // Teste Two Sum
        int[] twoSumArray = {2, 7, 11, 15};
        System.out.println("Two Sum: " + Arrays.toString(twoSum(twoSumArray, 9)));

        // Teste Longest Substring
        System.out.println("Longest Substring: " + lengthOfLongestSubstring("abcabcbb"));

        // Teste Daily Temperatures
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Daily Temperatures: " + Arrays.toString(dailyTemperatures(temps)));

        // Teste Fibonacci
        System.out.println("Fibonacci (10) Recursive: " + fibonacciRecursive(10));
        System.out.println("Fibonacci (10) Iterative: " + fibonacciIterative(10));

        // Teste Brute Force Search
        System.out.println("Brute Force Search: " + bruteForceSearch("AABAACAADAABAAABAA", "AABA"));

        // Teste Permutations
        int[] permArray = {1, 2, 3};
        System.out.println("Permutations: " + permute(permArray));

        // Teste Maior Número
        int[] maxArray = {3, 7, 2, 9, 1, 8, 4};
        System.out.println("Maior número: " + findMaxNumber(maxArray));
        System.out.println("Min/Max: " + findMinMax(maxArray));

        // Teste Caracteres Repetidos
        String testString = "programming";
        System.out.println("Primeiro repetido: " + findFirstRepeatedChar(testString));
        System.out.println("Frequência: " + countCharacterFrequency("hello world"));
        System.out.println("Todos repetidos: " + findAllRepeatedChars(testString));
        System.out.println("Tem duplicatas: " + hasDuplicateChars("hello"));
        System.out.println("Mais frequente: " + findMostFrequentChar(testString));
        System.out.println("Remove duplicatas: " + removeDuplicateChars(testString));

        // Teste Anagram
        System.out.println("Anagram: " + isAnagramOptimized("listen", "silent"));
    }
}