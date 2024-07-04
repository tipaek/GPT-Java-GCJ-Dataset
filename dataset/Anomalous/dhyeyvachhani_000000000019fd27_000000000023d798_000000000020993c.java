import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();

        for (int i = 0; i < total; i++) {
            int matrixSize = in.nextInt();
            in.nextLine();
            int[][] matrix = new int[matrixSize][matrixSize];
            String[] lines = new String[matrixSize];

            // Reading matrix data as strings
            for (int j = 0; j < matrixSize; j++) {
                lines[j] = in.nextLine();
            }

            // Converting string data to matrix
            for (int j = 0; j < matrixSize; j++) {
                String[] temp = lines[j].split(" ");
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(temp[k]);
                }
            }

            // Calculating the trace of the matrix
            int trace = 0;
            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];
            }

            // Finding rows with repeated elements
            int rowCount = 0;
            for (int j = 0; j < matrixSize; j++) {
                if (hasRepeatedElements(matrix[j])) {
                    rowCount++;
                }
            }

            // Finding columns with repeated elements
            int colCount = 0;
            for (int j = 0; j < matrixSize; j++) {
                if (hasRepeatedElements(getColumn(matrix, j))) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    // Helper method to check if an array has repeated elements
    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to get a column from a matrix
    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}