import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Sparsh Sanchorawala
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakeChoppers {
        public void solve(int testNumber, InputReader s, PrintWriter w) {
            int n = s.nextInt(), d = s.nextInt();
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = s.nextLong();
            HashMap<Long, Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!hm.containsKey(a[i]))
                    hm.put(a[i], 0);
                hm.put(a[i], hm.get(a[i]) + 1);
            }
            w.print("Case #" + testNumber + ": ");
            if (d == 2) {
                int res = 1;
                for (Map.Entry<Long, Integer> e : hm.entrySet()) {
                    if (e.getValue() >= 2)
                        res = 0;
                }
                w.println(res);
            } else if (d == 3) {
                int res = 2;
                for (int i = 0; i < n; i++) {
                    hm.put(a[i], hm.get(a[i]) - 1);
                    for (Map.Entry<Long, Integer> e : hm.entrySet()) {
                        if (e.getValue() >= 2 && a[i] > e.getKey()) {
                            res = 1;
                        }
                    }
                    if (a[i] % 2 == 0) {
                        long val = a[i] / 2;
                        if (hm.containsKey(val) && hm.get(val) >= 1)
                            res = 1;
                    }

                    hm.put(a[i], hm.get(a[i]) + 1);
                }
                for (Map.Entry<Long, Integer> e : hm.entrySet()) {
                    if (e.getValue() >= 3)
                        res = 0;
                }
                w.println(res);
            } else {
                w.println("NA");
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

