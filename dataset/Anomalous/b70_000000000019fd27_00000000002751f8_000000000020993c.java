import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int repeatedRows = countRepeatedRows(matrix, size);
            int repeatedCols = countRepeatedColumns(matrix, size);

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row, size)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedCols = 0;
        for (int col = 0; col < size; col++) {
            int[] columnArray = new int[size];
            for (int row = 0; row < size; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray, size)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }

    private static boolean hasDuplicates(int[] array, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}