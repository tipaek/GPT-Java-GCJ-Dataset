import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            Arrays.sort(a);
            if (d == 2) {
                if (hasDuplicate(a)) {
                    out.printf("Case #%d: %d\n", tc, 0);
                } else {
                    out.printf("Case #%d: %d\n", tc, 1);
                }
            } else {
                if (hasDuplicate(a) || hasDouble(a)) {
                    out.printf("Case #%d: %d\n", tc, 1);
                } else {
                    out.printf("Case #%d: %d\n", tc, 2);
                }
            }
        }
        finish();
    }

    private static boolean hasDuplicate(long[] a) {
        long last = -1;
        for (long value : a) {
            if (value == last) {
                return true;
            }
            last = value;
        }
        return false;
    }

    private static boolean hasDouble(long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (Arrays.binarySearch(a, 2 * a[i]) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String currentToken;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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
            String result = peekToken();
            currentToken = null;
            return result;
        }

        public String nextLine() {
            peekToken();
            String result = tokenizer.nextToken("\n");
            currentToken = null;
            tokenizer = null;
            return result;
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                // Ignore
            }
        }

        private String peekToken() {
            if (currentToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    currentToken = tokenizer.nextToken();
                } catch (IOException e) {
                    // Ignore
                }
            }
            return currentToken;
        }
    }
}