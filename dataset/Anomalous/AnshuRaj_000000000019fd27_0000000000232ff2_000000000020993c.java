import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int ROWS, COLS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            processTestCase(matrix, i + 1);
        }
    }

    private static void processTestCase(int[][] matrix, int testCaseNumber) {
        int trace = calculateTrace(matrix);
        ROWS = countDuplicateRows(matrix);
        COLS = countDuplicateColumns(matrix);

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + ROWS + " " + COLS);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }

            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }

        return false;
    }
}