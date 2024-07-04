import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Counting rows with duplicate values
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    if (seen[value]) {
                        duplicateRows++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Counting columns with duplicate values
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (seen[value]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Output the results for the current test case
            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateColumns);
        }
    }
}