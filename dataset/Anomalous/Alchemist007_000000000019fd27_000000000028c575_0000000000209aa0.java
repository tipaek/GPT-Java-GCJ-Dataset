import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static int targetTrace;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            targetTrace = scanner.nextInt();
            int[][] matrix = new int[size][size];
            if (solveSudoku(matrix, 0, 0)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean solveSudoku(int[][] matrix, int row, int col) {
        if (col == matrix[row].length) {
            row++;
            col = 0;
        }

        if (row == matrix.length) {
            return isTraceValid(matrix);
        }

        if (matrix[row][col] == 0) {
            for (int num = 1; num <= matrix.length; num++) {
                if (isSafe(matrix, row, col, num)) {
                    matrix[row][col] = num;
                    if (solveSudoku(matrix, row, col + 1)) {
                        return true;
                    }
                    matrix[row][col] = 0;
                }
            }
            return false;
        } else {
            return solveSudoku(matrix, row, col + 1);
        }
    }

    private static boolean isSafe(int[][] matrix, int row, int col, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == num || matrix[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static boolean isTraceValid(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum == targetTrace;
    }
}