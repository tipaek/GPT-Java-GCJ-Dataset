import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            Scanner sc = new Scanner(in);

            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int n = sc.nextInt();
                int k = sc.nextInt();

                int[][] m = new int[n][n];

                int[][] ret = fillTrace(0, m, 0, n, k);
                if (ret != null) {
                    out.println(String.format("Case #%s: POSSIBLE", t + 1));
                    for (int i = 0; i < ret.length; i++) {
                        for (int j = 0; j < ret[0].length; j++) {
                            out.print(ret[i][j] + " ");
                        }
                        out.println();
                    }

                } else {
                    out.println(String.format("Case #%s: IMPOSSIBLE", t + 1));
                }
            }
        }
    }

    private static int[][] fillTrace(int i, int[][] m, int trace, int n, int k) {
        if (i == n) {
            if (trace == k) {
                HashSet[] rows = new HashSet[n];
                for (int j = 0; j < rows.length; j++) rows[j] = new HashSet();
                HashSet[] cols = new HashSet[n];
                for (int j = 0; j < cols.length; j++) cols[j] = new HashSet();

                for (int j = 0; j < n; j++) {
                    rows[j].add(m[j][j]);
                    cols[j].add(m[j][j]);
                }

                return fillRest(0, m, n, rows, cols);
            }
            return null;
        }

        for (int j = 1; j <= n; j++) {
            m[i][i] = j;

            if (trace + j + (n - i - 1) > k) {
                return null;
            } else if (trace + j + (n - i - 1) * n < k) {
                // skip value
            } else {
                int[][] cand = fillTrace(i + 1, m, trace + j, n, k);
                if (cand != null) {
                    return cand;
                }
            }
        }
        return null;
    }

    private static int[][] fillRest(int z, int[][] m, int n, HashSet[] rows, HashSet[] cols) {
        if (z == n * n) {
            return m;
        }

        int i = z / n;
        int j = z % n;

        if (m[i][j] != 0) {
            return fillRest(z + 1, m, n, rows, cols);
        }

        for (int k = 1; k <= n; k++) {
            if (rows[i].contains(k)) continue;
            if (cols[j].contains(k)) continue;

            rows[i].add(k);
            cols[j].add(k);
            m[i][j] = k;

            int[][] cand = fillRest(z + 1, m, n, rows, cols);
            if (cand != null) {
                return cand;
            }

            m[i][j] = 0;
            rows[i].remove(k);
            cols[j].remove(k);
        }

        return null;
    }

}
