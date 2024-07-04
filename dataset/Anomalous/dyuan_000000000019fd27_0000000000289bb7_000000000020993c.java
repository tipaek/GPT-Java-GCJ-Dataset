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
            System.out.printf("Case #%d: %d %d %d%n", i + 1, result[0], result[1], result[2]);
        }

        scanner.close();
    }

    private static int[] processTestCase(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for row repeats
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for column repeats
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }
}