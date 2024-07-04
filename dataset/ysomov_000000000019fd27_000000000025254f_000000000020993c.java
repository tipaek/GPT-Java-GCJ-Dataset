//package codejam.y2020.q.a;

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
        "3\n" +
        "4\n" +
        "1 2 3 4\n" +
        "2 1 4 3\n" +
        "3 4 1 2\n" +
        "4 3 2 1\n" +
        "4\n" +
        "2 2 2 2\n" +
        "2 3 2 3\n" +
        "2 2 2 3\n" +
        "2 2 2 2\n" +
        "3\n" +
        "2 1 3\n" +
        "1 3 2\n" +
        "1 2 3";

    private void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            int n = in.nextInt();
            Set<Integer>[] cols = new Set[n];
            for (int c = 0; c < n; c++) {
                cols[c] = new HashSet<>();
            }
            int trace = 0, badRows = 0, badCols = 0;
            for (int r = 0; r < n; r++) {
                Set<Integer> row = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    int x = in.nextInt();
                    row.add(x);
                    cols[c].add(x);
                    if (r == c) trace += x;
                }
                if (row.size() < n) badRows++;
            }
            for (int c = 0; c < n; c++) {
                if (cols[c].size() < n) badCols++;
            }
            out.println(String.format("Case #%d: %d %d %d", ti, trace, badRows, badCols));
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