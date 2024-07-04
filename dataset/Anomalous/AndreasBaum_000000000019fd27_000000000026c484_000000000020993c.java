import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix);
            int rowsWithRepeatedElements = countRowsWithRepeatedElements(matrix);
            int colsWithRepeatedElements = countColsWithRepeatedElements(matrix);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowsWithRepeatedElements + " " + colsWithRepeatedElements);
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

    private static int countRowsWithRepeatedElements(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasRepeatedElements(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countColsWithRepeatedElements(int[][] matrix) {
        int count = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasRepeatedElements(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasRepeatedElements(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}