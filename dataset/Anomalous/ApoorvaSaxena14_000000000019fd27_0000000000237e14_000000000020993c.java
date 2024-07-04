import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int sumDiagonal = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read matrix and calculate the sum of the diagonal
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        sumDiagonal += matrix[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> columnSet = new HashSet<>();
                boolean rowDuplicateFound = false;
                boolean columnDuplicateFound = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowDuplicateFound && rowSet.contains(matrix[i][j])) {
                        duplicateRows++;
                        rowDuplicateFound = true;
                    }
                    if (!columnDuplicateFound && columnSet.contains(matrix[j][i])) {
                        duplicateColumns++;
                        columnDuplicateFound = true;
                    }

                    rowSet.add(matrix[i][j]);
                    columnSet.add(matrix[j][i]);

                    if (rowDuplicateFound && columnDuplicateFound) {
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d\n", test, sumDiagonal, duplicateRows, duplicateColumns);
        }
    }
}