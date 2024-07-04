import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            PrintWriter out = new PrintWriter(System.out);
            InputReader in = new InputReader(inputStream);

            int testCount = in.nextInt();
            for (int test = 1; test <= testCount; test++) {
                out.print("Case #" + test + ": ");
                solve(in, out);
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void solve(InputReader in, PrintWriter out) {
        try {
            long l = Long.parseLong(in.next());
            long r = Long.parseLong(in.next());

            long diff = Math.abs(l - r);
            long i = (long) (Math.sqrt(2.0 * diff) + 0.00000000001);

            if (r >= l) {
                r -= i * (i + 1) / 2;
            } else {
                l -= i * (i + 1) / 2;
            }

            long target = Math.max(l, r);
            long n = (-i + (long) (Math.sqrt(i * i + 4 * target) + 0.00000000001)) / 2;
            long total = i + 2 * n;

            if (l >= r) {
                l -= (n + i) * n;
                r -= (n + i + 1) * n;
                if (r < 0) {
                    r += i + 2 * n;
                    total--;
                }
            } else {
                r -= (n + i) * n;
                l -= (n + i + 1) * n;
                if (l < 0) {
                    l += i + 2 * n;
                    total--;
                }
            }

            out.println(total + " " + l + " " + r);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return "";
                    } else {
                        tokenizer = new StringTokenizer(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}