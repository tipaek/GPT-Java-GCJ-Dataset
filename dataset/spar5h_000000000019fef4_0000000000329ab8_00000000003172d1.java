import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
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
            HashMap<Double, int[]> hm = new HashMap<>();
            HashMap<Double, int[]> used = new HashMap<>();
            int res = d - 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= d; j++) {
                    double x = (double) a[i] / j;
                    if (!hm.containsKey(x))
                        hm.put(x, new int[d]);
                    hm.get(x)[j - 1]++;
                    if (!used.containsKey(x))
                        used.put(x, new int[n]);
                    used.get(x)[i] = 1;
                }
            }

            for (Map.Entry<Double, int[]> e : hm.entrySet()) {
                long ex = 0;
                int[] z = used.get(e.getKey());
                for (int i = 0; i < n; i++) {
                    if (z[i] == 1)
                        continue;
                    if (ex >= d)
                        break;
                    if (a[i] % e.getKey() != 0)
                        ex += (long) (a[i] / e.getKey());
                }
                int can = 0;
                int req = d;
                int[] b = e.getValue();
                for (int i = 0; req > 0 && i < d; i++) {
                    for (int j = 0; req > 0 && j < b[i]; j++) {
                        int lk = 0;
                        for (int k = 0; req > 0 && k < i; k++) {
                            can++;
                            req--;
                            lk++;
                        }
                        if (lk == i && req > 0) {
                            req--;
                        }
                    }
                }
                if (req > 0 && ex >= req) {
                    can += req;
                    req = 0;
                }
                if (req == 0) {
                    res = Math.min(can, res);
                }
            }
            w.println("Case #" + testNumber + ": " + res);

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

