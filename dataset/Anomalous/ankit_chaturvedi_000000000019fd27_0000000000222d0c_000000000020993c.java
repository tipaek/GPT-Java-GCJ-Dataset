import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] values = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[101];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            result.append("Case #").append(caseNumber).append(": ").append(trace).append(" ").append(rowRepeats).append(" ").append(colRepeats).append("\n");
            caseNumber++;
        }

        System.out.print(result);
    }
}