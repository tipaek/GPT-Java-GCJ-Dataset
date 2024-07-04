import java.awt.Point;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

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

    public void solve(FastScanner fs, PrintWriter out) {
        int T = fs.nextInt();
        for (int i = 1; i <= T; ++i) {
            int N = fs.nextInt();
            Point[] points = new Point[N];
            for (int j = 0; j < N; ++j) {
                points[j] = new Point(fs.nextInt(), fs.nextInt());
            }
            Map<Long, Set<Point>> hash = new HashMap<>();
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    int x = points[j].x - points[k].x;
                    int y = points[j].y - points[k].y;
                    if (y < 0 || (y == 0 && x <= 0)) continue;
                    int gcd = gcd(x, y);
                    x /= gcd;
                    y /= gcd;
                    long key = y * 1000000001L + x;
                    final Point p1 = points[j], p2 = points[k];
                    hash.compute(key, (u, v) -> {
                        if (v == null) {
                            v = new HashSet<>();
                        }
                        v.add(p1);
                        v.add(p2);
                        return v;
                    });
                }
            }
            int ans = 1;
            for (Set<Point> set : hash.values()) {
                ans = Math.max(ans, set.size() + 2);
            }
            ans = Math.min(ans, N);
            out.printf("Case #%d: %d%n", i, ans);
        }
    }

    private int gcd(int a, int b) {
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
            } catch (IOException e) {
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