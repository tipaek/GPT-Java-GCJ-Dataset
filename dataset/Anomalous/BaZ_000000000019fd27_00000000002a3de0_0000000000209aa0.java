/**
 * BaZ :D
 */

import java.util.*;
import java.io.*;

public class Solution {
    static MyScanner scan;
    static PrintWriter pw;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static int n, k;
    static int[][] ans;
    static boolean found;

    static void solve() throws IOException {
        initIo(false, "");
        int t = ni();
        for (int case_ = 1; case_ <= t; ++case_) {
            n = ni();
            k = ni();
            ans = new int[n][n];
            found = false;
            check(new int[n][n], 0, new int[n], 0);
            if (found) {
                pl("Case #" + case_ + ": POSSIBLE");
                for (int[] row : ans) {
                    for (int value : row) {
                        p(value);
                    }
                    pl();
                }
            } else {
                pl("Case #" + case_ + ": IMPOSSIBLE");
            }
        }
        pw.flush();
        pw.close();
    }

    static void check(int[][] mat, int idx, int[] col_mask, int row_mask) {
        if (idx == n * n) {
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += mat[i][i];
            }
            if (sum == k) {
                found = true;
                for (int i = 0; i < n; ++i) {
                    ans[i] = Arrays.copyOf(mat[i], n);
                }
            }
            return;
        }
        int row = idx / n, col = idx % n;
        if (col == 0) {
            row_mask = 0;
        }
        for (int i = 1; i <= n; ++i) {
            if ((col_mask[col] & (1 << (i - 1))) == 0 && (row_mask & (1 << (i - 1))) == 0) {
                mat[row][col] = i;
                col_mask[col] |= (1 << (i - 1));
                check(mat, idx + 1, col_mask, row_mask | (1 << (i - 1)));
                col_mask[col] ^= (1 << (i - 1));
            }
        }
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            pw = new PrintWriter(System.out, true);
        }
    }

    static int ni() throws IOException {
        return scan.nextInt();
    }

    static void pl() {
        pw.println();
    }

    static void p(Object o) {
        pw.print(o + " ");
    }

    static void pl(Object o) {
        pw.println(o);
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}