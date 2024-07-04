import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int rowCount = countRepeatedRows(matrix, n);
            int columnCount = countRepeatedColumns(matrix, n);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + columnCount);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int rowCount = 0;
        for (int row = 0; row < n; row++) {
            if (hasRepeatedElements(matrix[row])) {
                rowCount++;
            }
        }
        return rowCount;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int columnCount = 0;
        for (int col = 0; col < n; col++) {
            if (hasRepeatedElements(getColumn(matrix, col))) {
                columnCount++;
            }
        }
        return columnCount;
    }

    private static boolean hasRepeatedElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
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