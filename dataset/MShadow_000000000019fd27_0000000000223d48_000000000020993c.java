import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static int[] solve(int[][] a, int n) {
        Set<Integer>[] rowSet = new Set[n];
        Set<Integer>[] colSet = new Set[n];
        for (int i = 0; i < n; i++) {
            rowSet[i] = new HashSet();
            colSet[i] = new HashSet();
        }
        boolean[] rowDupe = new boolean[n];
        boolean[] colDupe = new boolean[n];

        int sumDia = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) sumDia += a[i][j];
                if (!rowSet[i].add(a[i][j])) rowDupe[i] = true;
                if (!colSet[j].add(a[i][j])) colDupe[j] = true;
            }
        }
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (rowDupe[i]) r++;
            if (colDupe[i]) c++;
        }

        return new int[]{sumDia, r, c};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = in.nextInt();
                }
            }
            int[] res = solve(a, n);
            System.out.println("Case #" + i + ": " + (res[0]) + " " + (res[1]) + " " + res[2]);
        }
    }
}