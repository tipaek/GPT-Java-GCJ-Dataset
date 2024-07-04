import java.util.*;

public class Solution {

    public static int[] computeTrace(int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[3];
        int trace = 0, repeatedRows = 0, repeatedCols = 0;

        // Initialize sets to track unique elements in rows and columns
        Set<Integer>[] rowSets = new HashSet[n];
        Set<Integer>[] colSets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        boolean[] isRowRepeated = new boolean[n];
        boolean[] isColRepeated = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];

                // Calculate trace
                if (i == j) {
                    trace += value;
                }

                // Check for repeated elements in rows
                if (!isRowRepeated[i] && !rowSets[i].add(value)) {
                    repeatedRows++;
                    isRowRepeated[i] = true;
                }

                // Check for repeated elements in columns
                if (!isColRepeated[j] && !colSets[j].add(value)) {
                    repeatedCols++;
                    isColRepeated[j] = true;
                }
            }
        }

        result[0] = trace;
        result[1] = repeatedRows;
        result[2] = repeatedCols;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int[] result = computeTrace(matrix);
            System.out.printf("#%d: %d %d %d%n", testCase, result[0], result[1], result[2]);
        }
        scanner.close();
    }
}