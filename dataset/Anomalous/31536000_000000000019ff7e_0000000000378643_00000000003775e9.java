import java.util.NoSuchElementException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        solve(fs, out);
        out.flush();
    }

    public void solve(FastScanner fs, PrintWriter out) {
        int T = fs.nextInt();
        for (int c = 1; c <= T; c++) {
            long N = fs.nextInt(), D = fs.nextInt();
            long X1 = fs.nextInt(), Y1 = fs.nextInt(), X2 = fs.nextInt(), Y2 = fs.nextInt();
            if (X1 > X2) {
                long temp = X1;
                X1 = X2;
                X2 = temp;
            }
            if (Y1 > Y2) {
                long temp = Y1;
                Y1 = Y2;
                Y2 = temp;
            }
            D *= 2;
            X1 *= 2;
            X2 *= 2;
            Y1 *= 2;
            Y2 *= 2;
            long len1 = -2, len2 = -2;
            for (long y = Y1 + D; y >= Y1; y--) {
                long x = X1 + (Y1 + D - y);
                if (dist(X2, Y2, x, y) <= D * D) len1++;
            }
            for (long y = Y1; y >= Y1 - D; y--) {
                long x = X1 + D + (y - Y1);
                if (dist(X2, Y2, x, y) <= D * D) len2++;
            }
            len1 = Math.max(0, len1);
            len2 = Math.max(0, len2);
            len1 *= len2;
            len2 = 2 * D * D - len1;
            len1 *= 3;
            long gcdValue = gcd(len1, len2);
            if (len1 == 0) len2 = 1;
            out.printf("Case #%d: %d %d%n", c, len1 / gcdValue, len2 / gcdValue);
        }
    }

    long dist(long x1, long y1, long x2, long y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class FastScanner {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

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
            boolean negative = false;
            byte b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                n = n * 10 + b - '0';
                b = readByte();
            } while (isNumber(b));
            return negative ? -n : n;
        }

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
            boolean negative = false;
            byte b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                n = n * 10 + b - '0';
                b = readByte();
            } while (isNumber(b));
            return negative ? -n : n;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}