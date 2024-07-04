import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            // Print the results for the current test case
            System.out.printf("Case #%d: %d %d %d\n", t, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}