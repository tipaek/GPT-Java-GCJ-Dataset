import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = in.nextInt();

        for (int caseNum = 0; caseNum < totalCases; caseNum++) {
            int matrixSize = in.nextInt();
            in.nextLine(); // Consume the newline character
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix data
            for (int row = 0; row < matrixSize; row++) {
                String[] line = in.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Count rows with repeated elements
            int rowCount = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (hasDuplicates(matrix[row])) {
                    rowCount++;
                }
            }

            // Count columns with repeated elements
            int colCount = 0;
            for (int col = 0; col < matrixSize; col++) {
                if (hasDuplicates(getColumn(matrix, col))) {
                    colCount++;
                }
            }

            // Print the results
            System.out.println("Case #" + (caseNum + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    // Helper method to check if an array has duplicate elements
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true; // Duplicate found
            }
        }
        return false;
    }

    // Helper method to get a column from a 2D array
    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}