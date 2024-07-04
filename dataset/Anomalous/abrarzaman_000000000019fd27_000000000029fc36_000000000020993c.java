import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            boolean[] rowHasDuplicate = new boolean[n];
            boolean[] colHasDuplicate = new boolean[n];

            for (int i = 0; i < n; i++) {
                boolean[] rowSeen = new boolean[n + 1];
                boolean[] colSeen = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    // Check for duplicate in row
                    if (rowSeen[matrix[i][j]]) {
                        rowHasDuplicate[i] = true;
                    } else {
                        rowSeen[matrix[i][j]] = true;
                    }

                    // Check for duplicate in column
                    if (colSeen[matrix[j][i]]) {
                        colHasDuplicate[i] = true;
                    } else {
                        colSeen[matrix[j][i]] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowHasDuplicate[i]) {
                    duplicateRows++;
                }
                if (colHasDuplicate[i]) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}