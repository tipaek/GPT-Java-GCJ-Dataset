import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            Answer solution = new Answer();
            solution.solve(in, out);
        }
    }
}

class Answer {
    public void solve(Scanner in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = matrix[i][j];
                }
                if (hasDuplicates(col)) {
                    duplicateCols++;
                }
            }

            out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}