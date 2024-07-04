import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix data
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = Integer.parseInt(rowValues[colIndex]);
                }
            }

            // Calculate trace
            int trace = 0;
            for (int index = 0; index < matrixSize; index++) {
                trace += matrix[index][index];
            }

            // Count rows with repeated elements
            int rowCount = 0;
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                if (hasDuplicates(matrix[rowIndex])) {
                    rowCount++;
                }
            }

            // Count columns with repeated elements
            int colCount = 0;
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                if (hasColumnDuplicates(matrix, colIndex)) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        Set<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            if (!seen.add(row[colIndex])) {
                return true;
            }
        }
        return false;
    }
}