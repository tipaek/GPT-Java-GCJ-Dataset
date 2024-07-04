import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate the number of rows with duplicate values
            int duplicateRows = countDuplicateRowsOrColumns(matrix, matrixSize);

            // Transpose the matrix
            int[][] transposedMatrix = transposeMatrix(matrix, matrixSize);

            // Calculate the number of columns with duplicate values
            int duplicateColumns = countDuplicateRowsOrColumns(transposedMatrix, matrixSize);

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int countDuplicateRowsOrColumns(int[][] matrix, int size) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueValues.add(matrix[i][j]);
            }
            if (uniqueValues.size() != size) {
                count++;
            }
        }

        return count;
    }

    private static int[][] transposeMatrix(int[][] matrix, int size) {
        int[][] transposedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}