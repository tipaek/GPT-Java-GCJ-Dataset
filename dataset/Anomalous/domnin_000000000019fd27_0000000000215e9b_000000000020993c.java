import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = scanner.nextInt();
            int rowRepeats = 0, columnRepeats = 0, trace = 0;

            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix and calculate the trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < matrixSize) {
                    rowRepeats++;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    columnSet.add(matrix[row][col]);
                }
                if (columnSet.size() < matrixSize) {
                    columnRepeats++;
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }

        scanner.close();
    }
}