import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix input
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Check rows and columns for duplicates and calculate diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> columnSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                boolean columnHasDuplicates = false;

                for (int j = 0; j < matrixSize; j++) {
                    // Check for duplicates in rows
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }

                    // Check for duplicates in columns
                    if (!columnSet.add(matrix[j][i])) {
                        columnHasDuplicates = true;
                    }

                    // Calculate diagonal sum
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }

                if (rowHasDuplicates) {
                    duplicateRows++;
                }
                if (columnHasDuplicates) {
                    duplicateColumns++;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d\n", testCase, diagonalSum, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}