import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int[][][] testCases = new int[t][][];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            testCases[i] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    testCases[i][j][k] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int[] result = processTestCase(testCases[i]);
            System.out.println("Case #" + (i + 1) + ": " + result[0] + " " + result[1] + " " + result[2]);
        }

        scanner.close();
    }

    private static int[] processTestCase(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }

        // Check for duplicate values in columns
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }

        return new int[]{trace, rowCount, colCount};
    }
}