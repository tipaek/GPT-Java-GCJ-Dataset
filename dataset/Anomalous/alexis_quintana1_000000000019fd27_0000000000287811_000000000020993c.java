import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        int[] trace = new int[testCases];
        int[] repeatedRows = new int[testCases];
        int[] repeatedCols = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace[t] += matrix[i][j];
                    }
                }
            }

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        repeatedRows[t]++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for repeated elements in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        repeatedCols[t]++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
        }

        for (int t = 0; t < testCases; t++) {
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace[t], repeatedRows[t], repeatedCols[t]);
        }

        scanner.close();
    }
}