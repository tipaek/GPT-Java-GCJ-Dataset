import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix elements
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Count rows with duplicate elements
            int duplicateRowCount = 0;
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowElements = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowElements.add(matrix[i][j])) {
                        duplicateRowCount++;
                        break;
                    }
                }
            }

            // Count columns with duplicate elements
            int duplicateColumnCount = 0;
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> columnElements = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnElements.add(matrix[i][j])) {
                        duplicateColumnCount++;
                        break;
                    }
                }
            }

            // Output the results for the current test case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRowCount, duplicateColumnCount);
        }

        scanner.close();
    }
}