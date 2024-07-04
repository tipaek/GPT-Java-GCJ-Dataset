import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
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
            System.out.println(calculateVestigium(testCase, matrix, size));
        }
        scanner.close();
    }

    private static String calculateVestigium(int testCase, int[][] matrix, int size) {
        int diagonalSum = 0, duplicateRows = 0, duplicateColumns = 0;

        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                duplicateColumns++;
            }
        }

        return "Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}