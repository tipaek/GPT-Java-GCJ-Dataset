import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = 0;
            // Check for duplicate values in each row
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!rowValues.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            int duplicateColumns = 0;
            // Check for duplicate values in each column
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colValues = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!colValues.add(matrix[row][col])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}