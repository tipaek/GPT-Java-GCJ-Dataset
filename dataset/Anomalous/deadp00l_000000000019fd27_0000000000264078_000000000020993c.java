import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixProcessor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int q = 1; q <= t; q++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            int primaryDiagonalSum = 0;
            int maxRowDuplicates = 0;
            int maxColumnDuplicates = 0;

            // Calculate primary diagonal sum
            for (int i = 0; i < n; i++) {
                primaryDiagonalSum += matrix[i][i];
            }

            // Calculate max duplicates in rows
            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    rowCount[matrix[i][j]]++;
                }
                for (int count : rowCount) {
                    if (count > 1) {
                        maxRowDuplicates = Math.max(maxRowDuplicates, count);
                    }
                }
            }

            // Calculate max duplicates in columns
            for (int j = 0; j < n; j++) {
                int[] colCount = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    colCount[matrix[i][j]]++;
                }
                for (int count : colCount) {
                    if (count > 1) {
                        maxColumnDuplicates = Math.max(maxColumnDuplicates, count);
                    }
                }
            }

            System.out.println("Case #" + q + ": " + primaryDiagonalSum + " " + maxRowDuplicates + " " + maxColumnDuplicates);
        }
    }
}