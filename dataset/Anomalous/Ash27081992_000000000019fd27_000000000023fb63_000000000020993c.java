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
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        for (int i = 0; i < matrixSize; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }

        for (int j = 0; j < matrixSize; j++) {
            int[] column = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + (testCase + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
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
}