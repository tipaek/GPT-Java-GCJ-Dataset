import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author lewin
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        WormholeInOne solver = new WormholeInOne();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class WormholeInOne {
        long[] x;
        long[] y;
        int n;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            x = new long[n];
            y = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }

            int ans = 1;
            HashSet<Fraction> ts = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    long dx = x[i] - x[j];
                    long dy = y[i] - y[j];
                    ts.add(new Fraction(dx, dy));
                }
            }

            for (Fraction g : ts) {
                HashMap<Long, Integer> cs = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    long t = -g.x * y[i] + g.y * x[i];
                    Integer m = cs.get(t);
                    if (m == null) m = 0;
                    cs.put(t, m + 1);
                }
                List<Integer> tt = new ArrayList<>(cs.values());
                int count = 0;
                int max = 0;
                for (int x : tt) {
                    if (x % 2 == 0) {
                        count += x;
                    } else {
                        if (x > 1) {
                            max = Math.max(max, x);
                        }
                    }
                }
                if (max > 0) {
                    tt.sort(Collections.reverseOrder());
                    int have = max + 1;
                    for (int x : tt) {
                        if (x % 2 == 1 && x > 1 && have > 0) {
                            have--;
                            count += x;
                        }
                    }
                    count = Math.min(count + 1, n);
                } else {
                    count = Math.min(count + 2, n);
                }
                ans = Math.max(ans, count);
            }

            out.printf("Case #%d: %d\n", testNumber, ans);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }

    static class Fraction {
        public long x;
        public long y;

        public Fraction(long x, long y) {
            if (x < 0) {
                x = -x;
                y = -y;
            } else if (x == 0) {
                y = Math.abs(y);
            }

            long g = Utils.gcd(Math.abs(x), Math.abs(y));
            if (g != 0) {
                x /= g;
                y /= g;
            } else {
                if (x != 0) x = 1;
                if (y != 0) y = 1;
            }
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "Fraction{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public int hashCode() {
            return new Long(x * 12091379 + y).hashCode();
        }

        public boolean equals(Object other) {
            if (!(other instanceof Fraction)) return false;
            return ((Fraction) other).x == x && ((Fraction) other).y == y;
        }

    }

    static class Utils {
        public static long gcd(long x, long y) {
            for (; x != 0; x ^= y, y ^= x, x ^= y, x %= y) ;
            return y;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }
}

