import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Checking for repeated values in rows
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != matrixSize) {
                    rowRepeats++;
                }
            }

            // Checking for repeated values in columns
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != matrixSize) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}