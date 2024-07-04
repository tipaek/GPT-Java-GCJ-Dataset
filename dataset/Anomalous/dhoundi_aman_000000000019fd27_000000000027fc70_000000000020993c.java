import java.io.*;

public class MatrixAnalyzer {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(input.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, columnRepeats = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                String[] rowValues = input.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Checking for row repetitions
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Checking for column repetitions
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        columnRepeats++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}