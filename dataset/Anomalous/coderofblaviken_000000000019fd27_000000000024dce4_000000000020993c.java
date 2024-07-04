import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < matrixSize; i++) {
                int[] row = Arrays.copyOf(matrix[i], matrixSize);
                Arrays.sort(row);
                for (int j = 1; j < matrixSize; j++) {
                    if (row[j] == row[j - 1]) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < matrixSize; j++) {
                int[] col = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    col[i] = matrix[i][j];
                }
                Arrays.sort(col);
                for (int i = 1; i < matrixSize; i++) {
                    if (col[i] == col[i - 1]) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}