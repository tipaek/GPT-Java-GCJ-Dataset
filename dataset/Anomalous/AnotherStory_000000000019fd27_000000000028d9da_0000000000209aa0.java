import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int requiredSum = scanner.nextInt();

            int[] initialArray = new int[n];
            for (int i = 0; i < n; i++) {
                initialArray[i] = i + 1;
            }

            int[][][] matrix = new int[n][n][n * 2];

            fillMatrix(matrix, initialArray, n, 0, n);

            for (int i = 0; i < n; i++) {
                initialArray[i] = n - i;
            }

            fillMatrix(matrix, initialArray, n, n, n * 2);

            boolean isPossible = false;
            for (int k = 0; k < n * 2; k++) {
                int diagonalSum = 0;
                for (int i = 0; i < n; i++) {
                    diagonalSum += matrix[i][i][k];
                }

                if (diagonalSum == requiredSum) {
                    System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                    printMatrix(matrix, n, k);
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void fillMatrix(int[][][] matrix, int[] array, int n, int start, int end) {
        for (int k = start; k < end; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j][k] = array[(i + j + k) % n];
                }
            }
        }
    }

    private static void printMatrix(int[][][] matrix, int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j][k] + " ");
            }
            System.out.println();
        }
    }
}