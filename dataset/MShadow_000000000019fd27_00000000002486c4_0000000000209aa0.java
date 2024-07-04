import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static int[][] matrix;
    private static int trace;
    private static Set<Integer>[] row;
    private static Set<Integer>[] col;

    private static boolean solve(int n, int k) {
        matrix = new int[n][n];
        trace = 0;
        row = new Set[n];
        col = new Set[n];
        for (int i = 0; i < n; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }
        return backtrack(0, 0, k, n);
    }

    private static boolean backtrack(int i, int j, int K, int n) {
        if (i == n) return trace == K;
        for (int k = 1; k <= n; k++) {
            if (row[i].contains(k) || col[j].contains(k)) continue;

            matrix[i][j] = k;
            row[i].add(k);
            col[j].add(k);
            if (i == j) trace += k;

            int ii = i, jj = j;
            if (j == n - 1) {
                ii++;
                jj = 0;
            } else {
                jj++;
            }
            if (backtrack(ii, jj, K, n)) return true;

            matrix[i][j] = -1;
            row[i].remove(k);
            col[j].remove(k);
            if (i == j) trace -= k;
        }
        return false;
    }

    private static void print(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int n = in.nextInt();
            int k = in.nextInt();
            boolean res = solve(n, k);
            System.out.println("Case #" + ks + ": " + (res ? "POSSIBLE" : "IMPOSSIBLE"));
            if (res) print(matrix, n);
        }
    }
}