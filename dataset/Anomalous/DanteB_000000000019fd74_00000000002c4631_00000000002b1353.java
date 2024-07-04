import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();

        for (int tc = 1; tc <= t; ++tc) {
            long n = in.nextInt();
            out.printf("Case #%d:\n", tc);
            if (n <= 500) {
                printSequence(n, n);
                continue;
            }
            if (n <= 998) {
                printSequence(n - 499, n - 499);
                out.printf("%d %d\n", n - 498, n - 499);
                printSequence(n - 498, 499);
                continue;
            }
            if (n <= 1000) {
                printSequence(n - 995, n - 995);
                out.printf("%d %d\n", n - 994, n - 995);
                printSequence(n - 994, 498);
                out.println("498 497");
                continue;
            }
        }
        finish();
    }

    private static void printSequence(long start, long end) {
        for (long i = start; i <= end; i++) {
            out.printf("%d %d\n", i, i);
        }
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader r;
        private StringTokenizer st;
        private String token;

        public InputReader(InputStream i) {
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasNext() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            String ans = peekToken();
            token = null;
            return ans;
        }

        public String nextLine() {
            peekToken();
            String ans = token == null ? "" : token;
            token = null;
            st = null;
            return ans;
        }

        public void close() {
            try {
                r.close();
            } catch (IOException e) {
                // Ignored
            }
        }

        private String peekToken() {
            if (token == null) {
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        String line = r.readLine();
                        if (line == null) {
                            return null;
                        }
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                    // Ignored
                }
            }
            return token;
        }
    }
}