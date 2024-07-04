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
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    static int countRowsWithDuplicates(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (countOccurrences(row, j + 1) > 1) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    static int[][] transposeMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] transposedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    static int countColumnsWithDuplicates(int[][] matrix) {
        int duplicateColumnCount = 0;
        int[][] transposedMatrix = transposeMatrix(matrix);
        for (int[] column : transposedMatrix) {
            for (int j = 0; j < transposedMatrix.length; j++) {
                if (countOccurrences(column, j + 1) > 1) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
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
            int duplicateRows = countRowsWithDuplicates(matrix);
            int duplicateColumns = countColumnsWithDuplicates(matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}