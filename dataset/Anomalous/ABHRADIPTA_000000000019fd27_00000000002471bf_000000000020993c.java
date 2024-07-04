import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(in.readLine());
        String[] results = new String[testCases];

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(in.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] elements = in.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }

            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Calculate trace of the matrix
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        duplicateCols++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            results[t - 1] = String.format("Case #%d: %d %d %d", t, trace, duplicateRows, duplicateCols);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}