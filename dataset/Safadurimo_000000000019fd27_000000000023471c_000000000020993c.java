import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
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
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task_A solver = new Task_A();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task_A {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                int[][] M = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        M[j][k] = in.nextInt();
                    }
                }
                int k = calcTrace(n, M);
                int r = calcRepeatRows(n, M);
                int c = calcRepeatColumns(n, M);
                out.printf("Case #%d: %d %d %d\n", i, k, r, c);
            }

        }

        private int calcRepeatColumns(int n, int[][] m) {
            int ret = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    set.add(m[j][i]);
                }
                ret += set.size() == n ? 0 : 1;
            }
            return ret;
        }

        private int calcRepeatRows(int n, int[][] m) {
            int ret = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    set.add(m[i][j]);
                }
                ret += set.size() == n ? 0 : 1;
            }
            return ret;

        }

        private int calcTrace(int n, int[][] m) {
            int ret = 0;
            for (int i = 0; i < n; i++) {
                ret += m[i][i];
            }
            return ret;
        }

    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

