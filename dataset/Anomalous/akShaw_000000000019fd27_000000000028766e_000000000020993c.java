import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            results[i] = calculateResult(matrix, n, i);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String calculateResult(int[][] matrix, int n, int caseNumber) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];

            rowRepeats += hasDuplicates(matrix[i]);

            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }

            colRepeats += hasDuplicates(column);
        }

        return "Case #" + (caseNumber + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats;
    }

    private static int hasDuplicates(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int count : frequencyMap.values()) {
            if (count > 1) {
                return 1;
            }
        }

        return 0;
    }
}