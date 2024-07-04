import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[][] arr = getMatrix(n, k);
            if (arr == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (int j = 0; j < n; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int l = 0; l < n; l++) {
                        sb.append(arr[j][l]);
                        sb.append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    System.out.println(sb.toString());
                }
            }
        }
    }

    private static int[][] getMatrix(int n, int k) {
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];

        int[][] arr = new int[n][n];

        if (backtracking(0, 0, arr, rows, cols, n, k, 0)) {
            return arr;
        } else {
            return null;
        }
    }

    private static boolean backtracking(int i, int j, int[][] arr, boolean[][] rows, boolean[][] cols, int n, int k, int sum) {
        if (i == n) {
            return sum == k;
        }
        if (j == n) {
            return backtracking(i+1, 0, arr, rows, cols, n, k, sum);
        }

        for (int l = 1; l <= n; l++) {
            if (!rows[i][l-1] && !cols[j][l-1]) {
                arr[i][j] = l;

                rows[i][l-1] = true;
                cols[j][l-1] = true;

                if (backtracking(i, j + 1, arr, rows, cols, n, k, (i == j) ? sum + l : sum)) {
                    return true;
                }

                rows[i][l-1] = false;
                cols[j][l-1] = false;
            }
        }

        return false;
    }

}
