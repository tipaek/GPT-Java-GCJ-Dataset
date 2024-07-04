import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = solve(matrix);
            System.out.printf("Case #%d: %d %d %d%n", testCase, result[0], result[1], result[2]);
        }
    }

    static int[] solve(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for repeated elements in columns
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