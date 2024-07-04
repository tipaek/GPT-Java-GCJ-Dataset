import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate rows and columns
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicateFound = false;
                boolean colDuplicateFound = false;

                for (int j = 0; j < matrixSize; j++) {
                    // Check row for duplicates
                    if (!rowDuplicateFound && !rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        rowDuplicateFound = true;
                    }

                    // Check column for duplicates
                    if (!colDuplicateFound && !colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        colDuplicateFound = true;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}