import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int q = 1; q <= t; q++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int[] reference = new int[n];
            for (int i = 0; i < n; i++) {
                reference[i] = i + 1;
            }

            // Check for repeated elements in rows and columns
            for (int i = 0; i < n; i++) {
                int[] row = Arrays.copyOf(matrix[i], n);
                int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    col[j] = matrix[j][i];
                }

                Arrays.sort(row);
                Arrays.sort(col);

                if (!Arrays.equals(row, reference)) {
                    rowRepeats++;
                }
                if (!Arrays.equals(col, reference)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + q + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}