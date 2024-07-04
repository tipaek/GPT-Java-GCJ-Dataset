//package codejam.y2020.q.d;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Set;

/**
 * @author tainic on May 4, 2019
 */
public class Solution {

    private static boolean LOCAL;
    static {
        try { LOCAL = "aurel".equalsIgnoreCase(System.getenv().get("USER")); } catch (Exception e){}
    }

    private void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        int b = in.nextInt();

        for (int ti = 1; ti <= t; ti++) {
            AwesomeMachine awesomeMachine = LOCAL ? new LocalAwesomeMachine(b) : new RemoteAwesomeMachine(in, out);

            if (!solve(awesomeMachine, b)) {
                throw new RuntimeException();
            }
            //System.err.println("Queries: " + awesomeMachine.queries());
        }
    }

    private boolean solve(AwesomeMachine awesomeMachine, int b) {
        assert b % 10 == 0;

        Set<Integer> same = new HashSet<>();
        Set<Integer> diff = new HashSet<>();

        char[] a = new char[b];
        for (int i = 1; i <= b / 2; i++) {
            if (awesomeMachine.queries() > 0 && awesomeMachine.queries() % 10 == 0) {
                if (!same.isEmpty()) {
                    queryAndFlip(awesomeMachine, a, same);
                }

                if (!diff.isEmpty()) {
                    queryAndFlip(awesomeMachine, a, diff);
                }

                if (same.isEmpty() || diff.isEmpty()) {
                    awesomeMachine.query(1);
                }
            }

            char x = awesomeMachine.query(i);
            char y = awesomeMachine.query(b - i + 1);
            a[i - 1] = x;
            a[b - i] = y;
            if (x == y) {
                same.add(i);
            } else {
                diff.add(i);
            }
        }
        return awesomeMachine.answer(String.valueOf(a));
    }

    private void queryAndFlip(AwesomeMachine awesomeMachine, char[] a, Set<Integer> indices) {
        int j = indices.iterator().next();

        char aj = awesomeMachine.query(j);

        if (aj != a[j - 1]) {
            flip(a, indices);
        }
    }

    private void flip(char[] a, Set<Integer> indices) {
        for (int i : indices) {
            a[i - 1] = flip(a[i - 1]);
            a[a.length - i] = flip(a[a.length - i]);
        }
    }

    private char flip(char bit) {
        return bit == '0' ? '1' : '0';
    }

    interface AwesomeMachine {
        char query(int bitIndex);
        boolean answer(String s);
        int queries();
    }

    static class LocalAwesomeMachine implements AwesomeMachine {

        private final Random R = new Random();
        private final char[] a;
        private int queries = 0;

        public LocalAwesomeMachine(int b) {
            a = new char[b];
            for (int i = 0; i < a.length; i++) {
                a[i] = R.nextInt(2) == 0 ? '0' : '1';
            }
        }

        @Override
        public char query(int bitIndex) {
            queries++;
            if (queries % 10 == 1) {
                applyRandomOperation(a);
            }
            return a[bitIndex - 1];
        }

        private void applyRandomOperation(char[] a) {
            int op = R.nextInt(4); // 0 nothing, 1 flip, 2 reverse, 3 flip + reverse

            // flip
            if (op == 1 || op == 3) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = flip(a[i]);
                }
            }
            // reverse
            if (op == 2 || op == 3) {
                for (int i = 0, j = a.length - 1; i < j; i++, j--) {
                    char ai = a[i];
                    a[i] = a[j];
                    a[j] = ai;
                }
            }
        }

        @Override
        public boolean answer(String s) {
            return String.valueOf(a).equals(s);
        }

        @Override
        public int queries() {
            return queries;
        }

        private char flip(char bit) {
            return bit == '0' ? '1' : '0';
        }
    }

    static class RemoteAwesomeMachine implements AwesomeMachine {

        private final InputReader in;
        private final PrintWriter out;
        private int queries = 0;

        public RemoteAwesomeMachine(InputReader in, PrintWriter out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public char query(int bitIndex) {
            queries++;
            out.println(bitIndex);
            out.flush();
            return in.next().charAt(0);
        }

        @Override
        public boolean answer(String s) {
            out.println(s);
            out.flush();
            return in.next().equals("Y");
        }

        @Override
        public int queries() {
            return queries;
        }

    }

    //region main
    public static void main(String[] args) throws Exception {
        long t = System.currentTimeMillis();

        try (
            InputReader in = new StreamInputReader(System.in);
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