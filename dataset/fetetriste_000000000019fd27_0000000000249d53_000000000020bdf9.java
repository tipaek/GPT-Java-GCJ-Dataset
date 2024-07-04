import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        C_ParentingPartneringReturns solver = new C_ParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class C_ParentingPartneringReturns {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int n = in.nextInt();
                int[] l = new int[n];
                int[] r = new int[n];
                for (int i = 0; i < n; i++) {
                    l[i] = in.nextInt();
                    r[i] = in.nextInt();
                }
                int freeC = 0;
                int freeJ = 0;
                boolean[] used = new boolean[n];
                char[] ans = new char[n];
                for (int step = 0; step < n; step++) {
                    int i = -1;
                    for (int j = 0; j < n; j++) {
                        if (used[j]) {
                            continue;
                        }
                        if (i < 0 || l[i] > l[j]) {
                            i = j;
                        }
                    }
                    if (freeC <= l[i]) {
                        ans[i] = 'C';
                        freeC = r[i];
                    } else if (freeJ <= l[i]) {
                        ans[i] = 'J';
                        freeJ = r[i];
                    } else {
                        ans = null;
                        break;
                    }
                    used[i] = true;
                }
                out.printf("Case #%d: %s\n", test, ans == null ? "IMPOSSIBLE" : new String(ans));
            }
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

