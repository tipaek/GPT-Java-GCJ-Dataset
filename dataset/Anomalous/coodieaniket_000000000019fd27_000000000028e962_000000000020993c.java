import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != matrixSize) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() != matrixSize) {
                    colDuplicates++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}