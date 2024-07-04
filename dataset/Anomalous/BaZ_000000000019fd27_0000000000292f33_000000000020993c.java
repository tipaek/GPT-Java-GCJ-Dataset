import java.io.*;
import java.util.*;

public class Solution {

    static MyScanner scan;
    static PrintWriter pw;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }, "BaZ", 1 << 27).start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        int t = ni();
        for (int cs = 1; cs <= t; ++cs) {
            int n = ni();
            int[][] mat = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = ni();
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
            }
            int row = 0, col = 0;
            for (int i = 0; i < n; ++i) {
                if (hasDuplicate(mat[i])) {
                    ++row;
                }
            }
            for (int j = 0; j < n; ++j) {
                if (hasDuplicate(getColumn(mat, j))) {
                    ++col;
                }
            }
            pw.printf("Case #%d: %d %d %d%n", cs, trace, row, col);
        }
        pw.flush();
        pw.close();
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

    static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
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