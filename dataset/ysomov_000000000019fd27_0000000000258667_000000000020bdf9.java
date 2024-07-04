//package codejam.y2020.q.c;

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
        "4\n" +
        "3\n" +
        "360 480\n" +
        "420 540\n" +
        "600 660\n" +
        "3\n" +
        "0 1440\n" +
        "1 3\n" +
        "2 4\n" +
        "5\n" +
        "99 150\n" +
        "1 100\n" +
        "100 301\n" +
        "2 5\n" +
        "150 250\n" +
        "2\n" +
        "0 720\n" +
        "720 1440";

    static class Activity implements Comparable<Activity> {
        int index;
        int start;
        int end;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity that) {
            int cmp = Integer.compare(end, that.end);
            if (cmp == 0) {
                cmp = Integer.compare(start, that.end);
            }
            if (cmp == 0) {
                cmp = Integer.compare(index, that.index);
            }
            return cmp;
        }
    }

    private void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(i, in.nextInt(), in.nextInt());
            }

            Arrays.sort(activities);
            int jamie = 0, cameron = 0;
            char[] assignment = new char[n];
            for (Activity a : activities) {
                boolean canGiveToJamie = (a.start >= jamie);
                boolean canGiveToCameron = (a.start >= cameron);

                if (!canGiveToJamie && !canGiveToCameron) {
                    assignment = "IMPOSSIBLE".toCharArray();
                    break;
                } else if (canGiveToCameron && (!canGiveToJamie || jamie < cameron)) {
                    cameron = a.end;
                    assignment[a.index] = 'C';
                } else {
                    jamie = a.end;
                    assignment[a.index] = 'J';
                }
            }

            out.println(String.format("Case #%d: %s", ti, String.valueOf(assignment)));
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