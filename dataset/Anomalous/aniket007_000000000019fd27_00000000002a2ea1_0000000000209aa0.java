import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int k = sc.nextInt();
            int[][] matrixA = new int[n][n];
            int[][] matrixB = new int[n][n];
            boolean possible = false;

            for (int j = 0; j < n; j++) {
                if (k == (j + 1) * n) {
                    possible = true;
                    System.out.println("Case #" + i + ": POSSIBLE");
                    break;
                }
                for (int m = 0; m < n; m++) {
                    matrixA[j][m] = matrixB[m][j] = (j * n + m) % n + 1;
                }
            }

            if (!possible) {
                if (arrange(matrixA, k) || arrange(matrixB, k)) {
                    System.out.println("Case #" + i + ": POSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
        sc.close();
    }

    static boolean check(int[][] matrix, int k) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][n - i - 1];
        }

        return primaryDiagonalSum == k || secondaryDiagonalSum == k;
    }

    static boolean arrange(int[][] matrix, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j != i) {
                    swapRows(matrix, i, j);
                }
                if (check(matrix, k) || checkAlternative(matrix, k)) {
                    return true;
                }
                if (j != i) {
                    swapRows(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                swapColumns(matrix, i, j);
                if (check(matrix, k) || checkAlternative(matrix, k)) {
                    return true;
                }
                swapColumns(matrix, i, j);
            }
        }

        return false;
    }

    static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    static boolean checkAlternative(int[][] matrix, int k) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += matrix[n / 2][i] + matrix[i][n / 2];
            sum2 += matrix[n - n / 2 - 1][i] + matrix[i][n - n / 2 - 1];
        }

        sum1 -= matrix[n / 2][n / 2]; // Remove the middle element added twice
        sum2 -= matrix[n - n / 2 - 1][n - n / 2 - 1]; // Remove the middle element added twice

        return sum1 == k || sum2 == k;
    }
}