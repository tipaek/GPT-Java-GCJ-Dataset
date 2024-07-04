import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Eric
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task2020QAA solver = new Task2020QAA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task2020QAA {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] a = in.nextMatInt(n, n);

            out.print("Case #" + testNumber + ": ");
            int nbRows = 0;
            for (int i = 0; i < n; i++) {
                int[] val = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    val[a[i][j]]++;
                    if (val[a[i][j]] == 2) {
                        nbRows++;
                        break;
                    }
                }
            }
            int nbCols = 0;
            for (int i = 0; i < n; i++) {
                int[] val = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    val[a[j][i]]++;
                    if (val[a[j][i]] == 2) {
                        nbCols++;
                        break;
                    }
                }
            }
            int trace = 0;
            for (int i = 0; i < n; i++)
                trace += a[i][i];

            out.println(trace + " " + nbRows + " " + nbCols);
        }

    }

    static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;
        String context = null;

        public FastReader(InputStream in) {
            this(new InputStreamReader(in));
        }

        public FastReader(InputStreamReader input) {
            br = new BufferedReader(input);
        }

        public String next() {
            if (context != null) {
                System.err.print("[" + context + "] Wait for input ...");
            }
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null)
                        return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
            }
            String res = st.nextToken();
            if (context != null) {
                System.err.println("[" + context + "] ... received : " + res);
            }
            return res;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[][] nextMatInt(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = nextInt();
            return a;
        }

    }
}

