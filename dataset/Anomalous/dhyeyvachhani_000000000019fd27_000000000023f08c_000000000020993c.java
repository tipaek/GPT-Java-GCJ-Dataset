import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseNum = 0; caseNum < totalCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix data
            for (int row = 0; row < matrixSize; row++) {
                String[] rowData = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate row count with repeated elements
            int rowCount = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (hasRepeatedElements(matrix[row])) {
                    rowCount++;
                }
            }

            // Calculate column count with repeated elements
            int colCount = 0;
            for (int col = 0; col < matrixSize; col++) {
                if (hasRepeatedElements(getColumn(matrix, col))) {
                    colCount++;
                }
            }

            // Print the result for the current case
            System.out.println("Case #" + (caseNum + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> elementSet = new HashSet<>();
        for (int element : array) {
            if (!elementSet.add(element)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}