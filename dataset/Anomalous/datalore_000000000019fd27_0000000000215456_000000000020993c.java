import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Read the matrix and calculate the trace and duplicate rows
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
            }

            // Calculate duplicate columns
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != matrixSize) {
                    duplicateColumns++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}