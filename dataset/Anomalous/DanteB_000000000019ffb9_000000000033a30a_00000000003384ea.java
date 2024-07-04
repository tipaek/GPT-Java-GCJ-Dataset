import java.util.*;
import java.io.*;

public class Solution {

    private static final InputReader in = new InputReader(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            long l = in.nextLong();
            long r = in.nextLong();
            long i = 1;
            while (true) {
                if (l >= r && l >= i) {
                    l -= i;
                } else if (r >= i) {
                    r -= i;
                } else {
                    break;
                }
                i++;
            }
            out.printf("Case #%d: %d %d %d\n", tc, i - 1, l, r);
        }
        finish();
    }

    private static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    private static class InputReader implements Iterator<String>, Closeable {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;
        private String nextToken;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        @Override
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

        @Override
        public String next() {
            String result = peekToken();
            nextToken = null;
            return result;
        }

        public String nextLine() {
            peekToken();
            String result = tokenizer == null ? null : tokenizer.nextToken("\n");
            nextToken = null;
            tokenizer = null;
            return result;
        }

        @Override
        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                // Ignored
            }
        }

        private String peekToken() {
            if (nextToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    nextToken = tokenizer.nextToken();
                } catch (IOException e) {
                    // Ignored
                }
            }
            return nextToken;
        }
    }
}