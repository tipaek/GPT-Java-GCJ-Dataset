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

    static void solve() throws IOException {
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int[] N = new int[44];
        int[] K = new int[44];
        int ptr = 0;

        for (int i = 2; i <= 5; ++i) {
            for (int j = i; j <= i * i; ++j) {
                N[ptr] = i;
                K[ptr++] = j;
            }
        }

        int t = ni();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = ni(), k = ni();
            int[][] mat = new int[n][n];
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }

            int some = k % n;
            int rest = n - some;

            if (some == 0) {
                int[] arr = new int[n];
                int val = k / n;
                for (int i = 0; i < n; i++) {
                    arr[i] = val++;
                    if (val > n) {
                        val = 1;
                    }
                }
                pl("Case #" + caseNum + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int e : arr) {
                        p(e);
                    }
                    pl();
                    arr = shift(arr);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (i < rest) {
                        mat[i][i] = k / n;
                        if ((k / n) + 1 <= n) {
                            mat[i][i == rest - 1 ? 0 : i + 1] = (k / n) + 1;
                        }
                    } else {
                        mat[i][i] = (k / n) + 1;
                        mat[i][i == n - 1 ? rest : i + 1] = k / n;
                    }
                }

                int size = (k / n) + 1 <= n ? n - 1 : n;
                int[] arr = new int[size];
                int ptrArr = 0;
                for (int i = (k / n) + 1 <= n ? (k / n) + 1 : 1; i != (k / n); i = (i + 1 <= n ? i + 1 : 1)) {
                    if (i == (k / n) || i == (k / n) + 1) continue;
                    arr[ptrArr++] = i;
                }

                for (int i = 0; i < n; i++) {
                    ptrArr = 0;
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] == -1 && ptrArr < arr.length) {
                            mat[i][j] = arr[ptrArr++];
                        }
                    }
                    arr = rotate(arr);
                }

                if (check(mat, n)) {
                    pl("Case #" + caseNum + ": POSSIBLE");
                    for (int[] row : mat) {
                        for (int val : row) {
                            p(val);
                        }
                        pl();
                    }
                } else {
                    pl("Case #" + caseNum + ": IMPOSSIBLE");
                }
            }
        }
        pw.flush();
        pw.close();
    }

    static int[] shift(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = arr[n - 1];
        System.arraycopy(arr, 0, res, 1, n - 1);
        return res;
    }

    static int[] rotate(int[] arr) {
        if (arr.length == 0) return arr;
        int n = arr.length;
        int[] res = new int[n];
        System.arraycopy(arr, 1, res, 0, n - 1);
        res[n - 1] = arr[0];
        return res;
    }

    static boolean check(int[][] mat, int n) {
        for (int[] row : mat) {
            Set<Integer> set = new HashSet<>();
            for (int val : row) {
                if (val < 1 || val > n) return false;
                set.add(val);
            }
            if (set.size() != n) return false;
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (mat[j][i] < 1 || mat[j][i] > n) return false;
                set.add(mat[j][i]);
            }
            if (set.size() != n) return false;
        }
        return true;
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        pw = isFileIO ? new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt") : new PrintWriter(System.out, true);
    }

    static int ni() throws IOException {
        return scan.nextInt();
    }

    static long nl() throws IOException {
        return scan.nextLong();
    }

    static double nd() throws IOException {
        return scan.nextDouble();
    }

    static String ne() throws IOException {
        return scan.next();
    }

    static String nel() throws IOException {
        return scan.nextLine();
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

    static void psb(StringBuilder sb) {
        pw.print(sb);
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            br = readingFromFile ? new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt")) : new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}