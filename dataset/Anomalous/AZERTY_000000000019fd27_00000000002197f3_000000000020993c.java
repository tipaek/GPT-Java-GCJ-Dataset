import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check rows and columns for duplicates and compute trace
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize];
                boolean[] colCheck = new boolean[matrixSize];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    int rowValue = matrix[i][j] - 1;
                    int colValue = matrix[j][i] - 1;

                    // Check row for duplicates
                    if (rowCheck[rowValue]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[rowValue] = true;
                    }

                    // Check column for duplicates
                    if (colCheck[colValue]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[colValue] = true;
                    }

                    // Compute trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }

                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (testIndex + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}