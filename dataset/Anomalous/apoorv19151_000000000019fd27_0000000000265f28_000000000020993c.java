package Package_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJam1 {

    static int countOccurrences(int[] array, int number) {
        int count = 0;
        for (int value : array) {
            if (value == number) {
                count++;
            }
        }
        return count;
    }

    static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (countOccurrences(row, j + 1) > 1) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    static int[][] transposeMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] transposed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }

    static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int[][] transposed = transposeMatrix(matrix);
        for (int[] col : transposed) {
            for (int j = 0; j < transposed.length; j++) {
                if (countOccurrences(col, j + 1) > 1) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(rowValues[k]);
                }
            }

            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}