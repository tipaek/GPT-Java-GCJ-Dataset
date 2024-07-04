import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean isFileIO, String suffix) throws IOException {
            if (isFileIO) {
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

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

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
        int t = ni();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = ni(), k = ni();
            int[][] mat = new int[n][n];
            for (int[] row : mat) Arrays.fill(row, -1);

            int some = k % n;
            int rest = n - some;
            for (int i = 0; i < n; i++) {
                if (i < rest) {
                    mat[i][i] = k / n;
                    if (i == rest - 1) {
                        mat[i][0] = k / n + 1;
                    } else {
                        mat[i][i + 1] = k / n + 1;
                    }
                } else {
                    mat[i][i] = k / n + 1;
                    if (i == n - 1) {
                        mat[i][rest] = k / n;
                    } else {
                        mat[i][i + 1] = k / n;
                    }
                }
            }

            int[] arr = new int[n - 2];
            int ptr = 0;
            for (int i = 1; i <= n; i++) {
                if (i == k / n || i == k / n + 1) continue;
                arr[ptr++] = i;
            }

            for (int i = 0; i < n; i++) {
                ptr = 0;
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == -1 && ptr < arr.length) {
                        mat[i][j] = arr[ptr++];
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
        pw.flush();
        pw.close();
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
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < 1 || mat[i][j] > n || !rowSet.add(mat[i][j])) return false;
            }
        }

        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (mat[i][j] < 1 || mat[i][j] > n || !colSet.add(mat[i][j])) return false;
            }
        }
        return true;
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

    static void pa(String arrayName, Object[] arr) {
        pl(arrayName + " : ");
        for (Object o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, int[] arr) {
        pl(arrayName + " : ");
        for (int o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, long[] arr) {
        pl(arrayName + " : ");
        for (long o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, double[] arr) {
        pl(arrayName + " : ");
        for (double o : arr) p(o);
        pl();
    }

    static void pa(String arrayName, char[] arr) {
        pl(arrayName + " : ");
        for (char o : arr) p(o);
        pl();
    }

    static void pa(String listName, List<?> list) {
        pl(listName + " : ");
        for (Object o : list) p(o);
        pl();
    }

    static void pa(String arrayName, Object[][] arr) {
        pl(arrayName + " : ");
        for (Object[] row : arr) {
            for (Object o : row) p(o);
            pl();
        }
    }

    static void pa(String arrayName, int[][] arr) {
        pl(arrayName + " : ");
        for (int[] row : arr) {
            for (int o : row) p(o);
            pl();
        }
    }

    static void pa(String arrayName, long[][] arr) {
        pl(arrayName + " : ");
        for (long[] row : arr) {
            for (long o : row) p(o);
            pl();
        }
    }

    static void pa(String arrayName, char[][] arr) {
        pl(arrayName + " : ");
        for (char[] row : arr) {
            for (char o : row) p(o);
            pl();
        }
    }

    static void pa(String arrayName, double[][] arr) {
        pl(arrayName + " : ");
        for (double[] row : arr) {
            for (double o : row) p(o);
            pl();
        }
    }

    static void pa(String arrayName, boolean[][] arr) {
        pl(arrayName + " : ");
        for (boolean[] row : arr) {
            for (boolean o : row) p(o);
            pl();
        }
    }
}