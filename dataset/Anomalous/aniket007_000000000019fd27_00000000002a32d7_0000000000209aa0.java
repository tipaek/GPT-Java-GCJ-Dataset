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

            // Initializing matrices a and b
            initializeMatrices(a, b);

            // Check if the sum of diagonals equals k
            if (isDiagonalSumEqual(a, k) || isDiagonalSumEqual(b, k)) {
                possible = true;
            }

            // Print the result
            System.out.println("Case #" + i + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
        }
    }

    private static void initializeMatrices(int[][] a, int[][] b) {
        int c = 1;
        for (int j = 0; j < n; j++) {
            for (int m = 0; m < n; m++) {
                if (c > n) c = 1;
                a[j][m] = b[m][j] = c++;
            }
            c--;
        }
    }

    private static boolean isDiagonalSumEqual(int[][] matrix, int targetSum) {
        return check(matrix, targetSum) || arrange(matrix, targetSum);
    }

    private static boolean check(int[][] matrix, int targetSum) {
        int primaryDiagonalSum = 0, secondaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][n - i - 1];
        }
        return primaryDiagonalSum == targetSum || secondaryDiagonalSum == targetSum;
    }

    private static boolean arrange(int[][] matrix, int targetSum) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j != i) {
                    swapRows(matrix, i, j);
                    if (check(matrix, targetSum)) return true;
                }
                if (check(matrix, targetSum) || check2(matrix, targetSum)) return true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                interchange(matrix, i, j);
                if (check(matrix, targetSum) || check2(matrix, targetSum)) return true;
            }
        }
        return false;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void interchange(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static boolean check2(int[][] matrix, int targetSum) {
        int primaryDiagonalSum = 0, secondaryDiagonalSum = 0;
        for (int i = 2; i < n - n / 2; i++) {
            for (int j = 0; j < n - i; j++) {
                primaryDiagonalSum += matrix[i][j] + matrix[j][i];
                secondaryDiagonalSum += matrix[n - 1 - i][j] + matrix[j][n - 1 - i];
            }
            secondaryDiagonalSum += matrix[n - (n - i)][n - i];
            primaryDiagonalSum += matrix[n - i][n - i];
            if (primaryDiagonalSum == targetSum || secondaryDiagonalSum == targetSum) return true;
            primaryDiagonalSum = 0;
            secondaryDiagonalSum = 0;
        }
        return false;
    }
}