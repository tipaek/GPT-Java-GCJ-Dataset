import java.util.*;

public class Solution {

    public static int[] computeTrace(int[][] matrix) {
        int[] result = new int[3];
        int k = 0, r = 0, c = 0;
        int n = matrix.length;

        // Initialize row and column checkers
        boolean[] repeatedRows = new boolean[n];
        boolean[] repeatedCols = new boolean[n];
        Map<Integer, Set<Integer>> colChecker = new HashMap<>();

        for (int i = 0; i < n; i++) {
            colChecker.put(i, new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowRecords = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int currentValue = matrix[i][j];
                
                // Calculate trace
                if (i == j) {
                    k += currentValue;
                }

                // Check for repeated values in row
                if (!repeatedRows[i] && !rowRecords.add(currentValue)) {
                    r++;
                    repeatedRows[i] = true;
                }

                // Check for repeated values in column
                if (!repeatedCols[j] && !colChecker.get(j).add(currentValue)) {
                    c++;
                    repeatedCols[j] = true;
                }
            }
        }

        result[0] = k;
        result[1] = r;
        result[2] = c;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = computeTrace(matrix);
            System.out.printf("#%d: %d %d %d%n", testCase + 1, result[0], result[1], result[2]);
        }

        scanner.close();
    }
}