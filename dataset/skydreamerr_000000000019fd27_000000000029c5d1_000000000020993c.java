import java.util.*;
import java.io.*;

public class Vestigium {
    static int k = 0;
    static int r = 0;
    static int c = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }
            solve(m);
            System.out.printf("Case #%d: %d %d %d%n", x, k, r, c);
        }
    }

    static private void solve(int[][] m) {
        k = 0;
        r = 0;
        c = 0;
        Set<Integer>[] col = new HashSet[m.length];
        for (int j = 0; j < m.length; j++) {
            col[j] = new HashSet<>();
        }
        boolean[] cvisited = new boolean[m.length];
        for (int i = 0; i < m.length; i++) {
            Set<Integer> row = new HashSet<>();
            boolean visited = false;
            for (int j = 0; j < m.length; j++) {
                if (i == j) k += m[i][i];
                if (!visited && row.contains(m[i][j])) {
                    r++;
                    visited = true;
                } else {
                    row.add(m[i][j]);
                }
                if (!cvisited[j] && col[j].contains(m[i][j])) {
                    c++;
                    cvisited[j] = true;
                } else {
                    col[j].add(m[i][j]);
                }

            }
        }

    }
}