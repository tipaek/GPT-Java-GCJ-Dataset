import java.awt.Point;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        solve(fs, out);
        out.flush();
    }

    class Rational {
        long d, m;

        public Rational(long D, long M) {
            d = D;
            m = M;
            long gcd = gcd(d, m);
            d /= gcd;
            m /= gcd;
            if (m < 0) {
                m = -m;
                d = -d;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Rational) {
                Rational other = (Rational) o;
                return this.d == other.d && this.m == other.m;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(m * 1000000001L + d);
        }

        @Override
        public String toString() {
            return d + "/" + m;
        }
    }

    public void solve(FastScanner fs, PrintWriter out) {
        int T = fs.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = fs.nextInt();
            Point[] points = new Point[N];
            for (int j = 0; j < N; ++j) {
                points[j] = new Point(fs.nextInt(), fs.nextInt());
            }

            Map<Rational, Map<Rational, Integer>> hash = new HashMap<>();
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < j; ++k) {
                    int x = points[j].x - points[k].x;
                    int y = points[j].y - points[k].y;
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    } else if (y == 0 && x < 0) {
                        x = -x;
                    }
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    Rational r = new Rational(y, x);
                    long numerator = (long) (points[k].x - points[j].x) * points[j].y - (long) points[j].x * (points[k].y - points[j].y);
                    Rational angle = new Rational(numerator, points[k].x - points[j].x);

                    hash.computeIfAbsent(r, k1 -> new HashMap<>()).merge(angle, 1, Integer::sum);
                }
            }

            int ans = 1;
            for (Map.Entry<Rational, Map<Rational, Integer>> entry : hash.entrySet()) {
                entry.getValue().replaceAll((k, v) -> (int) Math.sqrt(2 * v) + 1);

                int tmp = 0;
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                for (int value : entry.getValue().values()) {
                    if ((value & 1) == 0) {
                        tmp += value;
                    } else {
                        pq.add(value);
                    }
                }

                if (!pq.isEmpty()) tmp += pq.poll() - 1;
                if (!pq.isEmpty()) tmp += pq.poll() - 1;
                tmp += 2;
                ans = Math.max(ans, tmp);
            }
            ans = Math.min(ans, N);
            out.printf("Case #%d: %d%n", i, ans);
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private byte readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        private static boolean isPrintableChar(byte c) {
            return 32 < c || c < 0;
        }

        private static boolean isNumber(int c) {
            return '0' <= c && c <= '9';
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            byte b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            byte b = readByte();
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                n = n * 10 + b - '0';
            } while (isNumber(b = readByte()));
            return negative ? -n : n;
        }

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
            byte b = readByte();
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                n = n * 10 + b - '0';
            } while (isNumber(b = readByte()));
            return negative ? -n : n;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}