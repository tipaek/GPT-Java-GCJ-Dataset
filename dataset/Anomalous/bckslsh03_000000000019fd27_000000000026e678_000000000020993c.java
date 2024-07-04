import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[] rowMarker = new int[matrixSize + 1];
            int[] columnMarker = new int[matrixSize + 1];
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Processing the matrix
            for (int i = 0; i < matrixSize; i++) {
                boolean hasRowDuplicates = false;
                boolean hasColumnDuplicates = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for duplicates in the row
                    if (rowMarker[matrix[i][j]] != i + 1) {
                        rowMarker[matrix[i][j]] = i + 1;
                    } else {
                        hasRowDuplicates = true;
                    }

                    // Check for duplicates in the column
                    if (columnMarker[matrix[j][i]] != i + 1) {
                        columnMarker[matrix[j][i]] = i + 1;
                    } else {
                        hasColumnDuplicates = true;
                    }
                }

                if (hasRowDuplicates) {
                    rowDuplicates++;
                }
                if (hasColumnDuplicates) {
                    columnDuplicates++;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}