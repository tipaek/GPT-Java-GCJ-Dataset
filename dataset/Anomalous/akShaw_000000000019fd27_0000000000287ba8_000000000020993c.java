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

            results[i] = evaluateMatrix(matrix, n, i);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String evaluateMatrix(int[][] matrix, int size, int caseIndex) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            duplicateRows += hasDuplicates(matrix[i]);

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            duplicateColumns += hasDuplicates(column);
        }

        return "Case #" + (caseIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns;
    }

    private static int hasDuplicates(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int value : array) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        for (int count : frequencyMap.values()) {
            if (count > 1) {
                return 1;
            }
        }
        return 0;
    }
}