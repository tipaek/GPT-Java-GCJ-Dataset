import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] b = new int[n][n];
            int[][] a = new int[n][n];
            generateMatrix(b, n, 0, 0, k, a);
            if (trace(a) == 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                printMatrix(a);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void generateMatrix(int[][] a, int n, int row, int col, int k, int[][] ans) {
        if (trace(ans) == 0) {
            for (int i = 1; i <= n; i++) {
                if (isSafe(a, n, row, col, i)) {
                    a[row][col] = i;
                    if (row == n - 1 && col == n - 1) {
                        if (trace(a) == k) {
                            copyMatrix(a, ans);
                            return;
                        }
                    } else if (trace(a) < k) {
                        if (row < n - 1) {
                            generateMatrix(copyMatrix(a, n), n, row + 1, col, k, ans);
                        } else {
                            generateMatrix(copyMatrix(a, n), n, 0, col + 1, k, ans);
                        }
                    }
                }
            }
        }
    }

    public static boolean isSafe(int[][] a, int n, int row, int col, int num) {
        for (int i = 0; i < row; i++) {
            if (a[i][col] == num) {
                return false;
            }
        }
        for (int j = 0; j < col; j++) {
            if (a[row][j] == num) {
                return false;
            }
        }
        return true;
    }

    public static int[][] copyMatrix(int[][] a, int n) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, copy[i], 0, n);
        }
        return copy;
    }

    public static void copyMatrix(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
    }

    public static int trace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}