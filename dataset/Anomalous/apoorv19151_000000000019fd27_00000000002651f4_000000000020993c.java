package Package_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJam1 {

    static int count(int[] array, int number) {
        int count = 0;
        for (int value : array) {
            if (value == number) {
                count++;
            }
        }
        return count;
    }

    static int trace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    static int noOfRowsWithDuplicates(int[][] matrix) {
        int rowsWithDuplicates = 0;
        for (int[] row : matrix) {
            for (int j = 1; j <= matrix.length; j++) {
                if (count(row, j) > 1) {
                    rowsWithDuplicates++;
                    break;
                }
            }
        }
        return rowsWithDuplicates;
    }

    static int[][] transpose(int[][] matrix) {
        int size = matrix.length;
        int[][] transposedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    static int noOfColumnsWithDuplicates(int[][] matrix) {
        int columnsWithDuplicates = 0;
        int[][] transposedMatrix = transpose(matrix);
        for (int[] column : transposedMatrix) {
            for (int j = 1; j <= transposedMatrix.length; j++) {
                if (count(column, j) > 1) {
                    columnsWithDuplicates++;
                    break;
                }
            }
        }
        return columnsWithDuplicates;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                String[] rowElements = reader.readLine().split(" ");
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(rowElements[k]);
                }
            }
            int trace = trace(matrix);
            int rowsWithDuplicates = noOfRowsWithDuplicates(matrix);
            int columnsWithDuplicates = noOfColumnsWithDuplicates(matrix);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowsWithDuplicates, columnsWithDuplicates);
        }
    }
}