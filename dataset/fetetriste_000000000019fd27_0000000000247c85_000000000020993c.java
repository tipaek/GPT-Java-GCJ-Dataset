import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A_Vestigium solver = new A_Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class A_Vestigium {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int n = in.nextInt();
                int[][] a = new int[n][n];
                int[][] b = new int[n][n];
                int[][] c = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int x = in.nextInt();
                        a[i][j] = x;
                        b[i][j] = x;
                        c[j][i] = x;
                    }
                }
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += a[i][i];
                }
                int rs = rep(b);
                int cs = rep(c);
                out.printf("Case #%d: %d %d %d\n", test, trace, rs, cs);
            }
        }

        private int rep(int[][] b) {
            int res = 0;
            for (int[] row : b) {
                Arrays.sort(row);
                for (int i = 0; i + 1 < row.length; i++) {
                    if (row[i] == row[i + 1]) {
                        ++res;
                        break;
                    }
                }
            }
            return res;
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

