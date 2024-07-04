import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        int[][][] cases = new int[t][][];

        // Read input for each test case
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            cases[i] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cases[i][j][k] = in.nextInt();
                }
            }
        }

        // Process each test case and print the results
        for (int i = 0; i < t; i++) {
            int[] result = processCase(cases[i]);
            System.out.println("Case #" + (i + 1) + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        in.close();
    }

    static int[] processCase(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate rows
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }

        // Check for duplicate columns
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        return new int[]{trace, duplicateRows, duplicateColumns};
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}