//package codejam.y2020.r1c.c;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

/**
 * @author tainic on May 2, 2020
 */
public class Solution {

    private static boolean LOCAL;
    static {
        try { LOCAL = "aurel".equalsIgnoreCase(System.getenv().get("USER")); } catch (Exception e){}
    }

    private static final String TEST =
        "5\n" +
        "2 12\n" +
        "4 8\n" +
        "1 3\n" +
        "1\n" +
        "5 2\n" +
        "10 5 359999999999 123456789 10\n" +
        "2 3\n" +
        "8 4\n" +
        "3 2\n" +
        "1 2 3";

    void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            Arrays.sort(a);
            long min = Long.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                long[] sameCuts = f(a, i, d);
                if (sameCuts[0] == d) {
                    min = Math.min(sameCuts[1], min);
                    if (min == 0) {
                        break;
                    }
                }
            }
            if (min == Long.MAX_VALUE) {
                min = 0;
                long same = 0;
                for (long l : a) {
                    if (same == d) break;
                    if (same + l <= d) {
                        min += l - 1;
                        same += l;
                    } else {
                        min += d - same;
                        same = d;
                    }
                }
                if (same == d) {
                    min = Math.min(min, d - 1);
                } else {
                    min = d - 1;
                }
            }

            out.println(String.format("Case #%d: %d", ti, min));
        }
    }

    private long[] f(long[] a, int i, long d) {
        long same = 0;
        long cuts = 0;
        for (int j = i; j < a.length; j++) {
            if (a[j] % a[i] == 0) {
                long k = a[j] / a[i];
                if (same + k <= d) {
                    cuts += k - 1;
                    same += k;
                } else {
                    cuts += d - same;
                    same = d;
                }
                if (same == d) return new long[]{d, cuts};
            }
        }

        for (int j = i; j < a.length; j++) {
            if (a[j] % a[i] != 0) {
                long k = a[j] / a[i];
                if (same + k <= d) {
                    cuts += k;
                    same += k;
                } else {
                    cuts += d - same;
                    same = d;
                }
                if (same == d) return new long[]{d, cuts};
            }
        }

        return new long[]{same, cuts};
    }
   /* private static final double eps = 0.000001;
    private long search(int d, long[] a) {
        double min = 0;
        double max = a[0];

        while (max - min >= eps) {
            double m = (max - min) / 2 + min;
            long[] sameCuts = f(a, 0, m, d);
            if (sameCuts[0] == d) {
                min = m;
            } else {
                max = m;
            }
        }
        return f(a, 0, min, d)[1];
    }
*/

    //region main
    public static void main(String[] args) throws Exception {
        long t = System.currentTimeMillis();

        try (
            InputReader in = new StreamInputReader(!LOCAL ? System.in : new ByteArrayInputStream(TEST.getBytes()));
            PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out, 2048), false)
        ) {
            new Solution().solve(in, out);
        }

        System.err.println("time: " + (System.currentTimeMillis() - t) + "ms");
    }
    //endregion

    //region fast io
    abstract static class InputReader implements AutoCloseable {

        public abstract int read();

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class StreamInputReader extends InputReader {

        private InputStream stream;
        private byte[] buf;
        private int curChar, numChars;

        public StreamInputReader(InputStream stream) {
            this(stream, 2048);
        }

        public StreamInputReader(InputStream stream, int bufSize) {
            this.stream = stream;
            this.buf = new byte[bufSize];
        }

        @Override
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        @Override
        public void close() throws Exception {
            stream.close();
        }

    }
    //endregion

    //region imports
    //endregion

}