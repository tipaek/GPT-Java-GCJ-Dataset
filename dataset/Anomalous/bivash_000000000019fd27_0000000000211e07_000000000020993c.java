import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateColumns(matrix);

            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColCount = 0;
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            int[] columnArray = new int[n];
            for (int row = 0; row < n; row++) {
                columnArray[row] = matrix[row][col];
            }

            if (hasDuplicates(columnArray)) {
                duplicateColCount++;
            }
        }

        return duplicateColCount;
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