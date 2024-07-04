import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            results[i] = computeResult(matrix, n, i);
        }

        for (String result : results) {
            System.out.println(result);
        }

        sc.close();
    }

    private static String computeResult(int[][] matrix, int n, int caseIndex) {
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

        return "Case #" + (caseIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats;
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