import java.util.Scanner;

public class Solution {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = sc.nextInt();
            solve(matrixSize, i + 1);
        }
    }

    public static void solve(int matrixSize, int testCase) {
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        // Reading the matrix and calculating the trace
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = sc.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        // Counting rows with duplicate values
        for (int i = 0; i < matrixSize; i++) {
            if (hasDuplicates(matrix[i])) {
                rowCount++;
            }
        }

        // Counting columns with duplicate values
        for (int i = 0; i < matrixSize; i++) {
            if (hasColumnDuplicates(matrix, i)) {
                colCount++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
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

    private static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        boolean[] seen = new boolean[matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[i][colIndex];
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}