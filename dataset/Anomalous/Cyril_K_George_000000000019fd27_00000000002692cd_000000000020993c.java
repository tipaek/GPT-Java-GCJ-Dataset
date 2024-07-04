import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        int[][] results = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Input matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                }
            }

            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Calculate row duplicates
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    colDuplicates++;
                }
            }

            // Store results
            results[i][0] = trace;
            results[i][1] = rowDuplicates;
            results[i][2] = colDuplicates;
        }

        // Print results
        for (int i = 0; i < t; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, results[i][0], results[i][1], results[i][2]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}