import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int k = sc.nextInt();
            int[][] a = new int[n][n];
            int[][] b = new int[n][n];
            boolean possible = false;

            for (int j = 0; j < n; j++) {
                if (k == (j + 1) * n) {
                    possible = true;
                    System.out.println("Case #" + i + ": POSSIBLE");
                    break;
                }

                for (int m = 0; m < n; m++) {
                    int value = (j + m) % n + 1;
                    a[j][m] = value;
                    b[m][j] = value;
                }
            }

            if (!possible) {
                if (arrange(a, k) || arrange(b, k)) {
                    System.out.println("Case #" + i + ": POSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
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

                if (check(matrix, k) || check2(matrix, k)) {
                    return true;
                }

                if (j != i) {
                    swapRows(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                interchangeColumns(matrix, i, j);

                if (check(matrix, k) || check2(matrix, k)) {
                    return true;
                }

                interchangeColumns(matrix, i, j); // revert back
            }
        }

        return false;
    }

    static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    static void interchangeColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    static boolean check2(int[][] matrix, int k) {
        for (int i = 2; i < n - 1; i++) {
            int bSum = 0, cSum = 0;
            int j = 0;

            for (j = 0; j < n - i; j++) {
                bSum += matrix[i][j] + matrix[j][i];
                cSum += matrix[n - 1 - i][j] + matrix[j][n - 1 - i];
            }

            cSum += matrix[n - j][j];
            bSum += matrix[j][j];

            if ((bSum == k || cSum == k) && k < n * n - 1) {
                return true;
            }

            bSum = 0;
            cSum = 0;
        }

        return false;
    }
}