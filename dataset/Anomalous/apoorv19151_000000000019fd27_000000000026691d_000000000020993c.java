package Package_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static int countOccurrences(int[] array, int number) {
        int count = 0;
        for (int value : array) {
            if (value == number) {
                count++;
            }
        }
        return count;
    }

    private static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int rowCount = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (countOccurrences(row, j + 1) > 1) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    private static int[][] getTranspose(int[][] matrix) {
        int size = matrix.length;
        int[][] transposedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int colCount = 0;
        int[][] transposedMatrix = getTranspose(matrix);
        for (int[] row : transposedMatrix) {
            for (int j = 0; j < transposedMatrix.length; j++) {
                if (countOccurrences(row, j + 1) > 1) {
                    colCount++;
                    break;
                }
            }
        }
        return colCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] rowElements = reader.readLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowElements[j]);
                }
            }

            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}