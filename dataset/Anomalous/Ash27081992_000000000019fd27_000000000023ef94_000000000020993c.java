import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            solve(matrixSize, i);
        }
    }

    public static void solve(int matrixSize, int testCase) {
        int[][] matrix = new int[matrixSize][matrixSize];
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Read matrix and calculate diagonal sum
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        // Check for duplicate rows
        for (int i = 0; i < matrixSize; i++) {
            if (hasDuplicate(matrix[i])) {
                duplicateRows++;
            }
        }

        // Check for duplicate columns
        for (int j = 0; j < matrixSize; j++) {
            int[] column = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicate(column)) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }

    private static boolean hasDuplicate(int[] array) {
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