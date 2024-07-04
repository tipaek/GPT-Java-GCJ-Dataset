import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.readInt();
            int matrix[][] = new int[n][n];

            int badColumns = 0;
            int badLines = 0;
            int diag = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                int diversity = 0;

                for (int j = 0; j < n; j++) {
                    int val = matrix[i][j] = in.readInt();
                    if (!set.contains(val)) {
                        set.add(val);
                        diversity++;
                    }
                }

                if (diversity < n) {
                    badLines++;
                }
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                int diversity = 0;

                for (int j = 0; j < n; j++) {
                    int val = matrix[j][i];
                    if (!set.contains(val)) {
                        set.add(val);
                        diversity++;
                    }
                }

                if (diversity < n) {
                    badColumns++;
                }
            }

            for (int i = 0; i < n; i++) {
                diag += matrix[i][i];
            }

            out.println("Case #" + testNumber + ": " + diag + " " + badLines + " " + badColumns);
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public String next() {
            return readToken();
        }

    }
}

