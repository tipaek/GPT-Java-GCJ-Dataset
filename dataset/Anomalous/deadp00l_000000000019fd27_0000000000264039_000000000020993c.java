import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixAnalysis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            // Calculate the primary diagonal sum
            int primaryDiagonalSum = 0;
            for (int i = 0; i < n; i++) {
                primaryDiagonalSum += matrix[i][i];
            }

            // Calculate the maximum row duplicates
            int maxRowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    rowCount[matrix[i][j]]++;
                }
                for (int count : rowCount) {
                    if (count > 1 && count > maxRowDuplicates) {
                        maxRowDuplicates = count;
                    }
                }
            }

            // Calculate the maximum column duplicates
            int maxColDuplicates = 0;
            for (int j = 0; j < n; j++) {
                int[] colCount = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    colCount[matrix[i][j]]++;
                }
                for (int count : colCount) {
                    if (count > 1 && count > maxColDuplicates) {
                        maxColDuplicates = count;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + primaryDiagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }
    }
}