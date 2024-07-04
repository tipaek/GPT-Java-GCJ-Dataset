//package codejam.y2020.q.b;

import java.io.*;
import java.util.*;

/**
 * @author tainic on May 4, 2019
 */
public class Solution {

    private static boolean LOCAL;
    static {
        try { LOCAL = "aurel".equalsIgnoreCase(System.getenv().get("USER")); } catch (Exception e){}
    }

    private static final String TEST =
        "7\n" +
        "0000\n" +
        "101\n" +
        "111000\n" +
        "1\n" +
        "312\n" +
        "222\n" +
        "132\n";

    private void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            char[] a = in.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (char c : a) {
                int d = (c - '0');
                for (int i = 0; i < Math.abs(d - open); i++) {
                    sb.append(d > open ? '(' : ')');
                }
                open = d;
                sb.append(d);
            }
            while (open > 0) {
                sb.append(')');
                open--;
            }

            out.println(String.format("Case #%d: %s", ti, sb.toString()));
        }
    }

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

}