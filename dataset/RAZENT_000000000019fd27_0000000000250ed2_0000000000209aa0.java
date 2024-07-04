import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static boolean check = false;

    public static void genMatrix(int i, int j, int s1, boolean[][] cols, boolean[][] rows, int[][] matrix, int n, int s0) {
        for (int k = 1; k <= n; k++) {
            if (check || s1 + k > s0) {
                return;
            }
            if (!rows[i][k - 1] && !cols[j][k - 1]) {
                rows[i][k-1] = true;
                cols[j][k-1] = true;
                matrix[i][j] = k;
                if (i == j) {
                    s1 += k;
                }
                if (i == n - 1 && j == n - 1) {
                    if (s1 == s0) check = true;
                } else {
                    int tmpJ, tmpI;
                    if (j == n - 1) {
                        tmpI = i + 1;
                        tmpJ = 0;
                    } else {
                        tmpI = i;
                        tmpJ = j + 1;
                    }
                    genMatrix(tmpI, tmpJ, s1, cols, rows, matrix, n, s0);
                }
                if (check) return;
                rows[i][k - 1] = false;
                cols[j][k - 1] = false;
                matrix[i][j] = 0;
                if (i == j) s1 -= k;
            }
        }
    }

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int o = 1; o <= T; o++) {
            check = false;
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            boolean[][] cols = new boolean[n][n];
            boolean[][] rows = new boolean[n][n];
            int[][] matrix = new int[n][n];

            genMatrix(0, 0, 0, cols, rows, matrix, n, s);
            if (check) {
                System.out.println("Case #" + o + ": " + "POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + o + ": " + "IMPOSSIBLE");
            }
        }
    }
}