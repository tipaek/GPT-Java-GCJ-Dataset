public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        FastScanner scanner = new FastScanner();
        java.io.PrintWriter writer = new java.io.PrintWriter(System.out);
        solve(scanner, writer);
        writer.flush();
    }

    class Rational {
        long numerator, denominator;

        public Rational(long numerator, long denominator) {
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
            if (this.denominator < 0) {
                this.denominator = -this.denominator;
                this.numerator = -this.numerator;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Rational) {
                Rational other = (Rational) obj;
                return this.numerator == other.numerator && this.denominator == other.denominator;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(denominator * 1000000001L + numerator);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public void solve(FastScanner scanner, java.io.PrintWriter writer) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int numPoints = scanner.nextInt();
            java.awt.Point[] points = new java.awt.Point[numPoints];
            for (int i = 0; i < numPoints; i++) {
                points[i] = new java.awt.Point(scanner.nextInt(), scanner.nextInt());
            }

            java.util.Map<Rational, java.util.Map<Rational, Integer>> lineMap = new java.util.HashMap<>();
            for (int i = 0; i < numPoints; i++) {
                for (int j = 0; j < i; j++) {
                    int dx = points[i].x - points[j].x;
                    int dy = points[i].y - points[j].y;
                    if (dy < 0) {
                        dx = -dx;
                        dy = -dy;
                    } else if (dy == 0 && dx < 0) {
                        dx = -dx;
                    }
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    Rational slope = new Rational(dy, dx);
                    Rational intercept = new Rational((long) (points[j].x - points[i].x) * points[i].y - (long) points[i].x * (points[j].y - points[i].y), points[j].x - points[i].x);
                    lineMap.compute(slope, (key, value) -> {
                        if (value == null) {
                            value = new java.util.HashMap<>();
                        }
                        value.compute(intercept, (k, v) -> v == null ? 1 : v + 1);
                        return value;
                    });
                }
            }

            int maxPoints = 1;
            for (java.util.Map.Entry<Rational, java.util.Map<Rational, Integer>> entry : lineMap.entrySet()) {
                entry.getValue().replaceAll((k, v) -> (int) Math.sqrt(2 * v) + 1);
                int currentMax = 0;
                int oddCount = 0;
                for (int count : entry.getValue().values()) {
                    currentMax += count;
                    if ((count & 1) != 0) {
                        oddCount++;
                    }
                }
                currentMax += oddCount % 2 == 0 ? 2 : 1;
                maxPoints = Math.max(maxPoints, currentMax);
            }
            maxPoints = Math.min(maxPoints, numPoints);
            writer.println(String.format("Case #%d: %d", t, maxPoints));
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class FastScanner {
        private final java.io.InputStream in = System.in;
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
            if (!hasNext()) throw new java.util.NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            byte b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public final long nextLong() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            long n = 0;
            try {
                byte b = readByte();
                if (b == '-') {
                    while (isNumber(b = readByte())) n = n * 10 + '0' - b;
                    return n;
                } else if (!isNumber(b)) throw new NumberFormatException();
                do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
                return n;
            } catch (java.util.NoSuchElementException e) {
                return n;
            }
        }

        public final int nextInt() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            int n = 0;
            try {
                byte b = readByte();
                if (b == '-') {
                    while (isNumber(b = readByte())) n = n * 10 + '0' - b;
                    return n;
                } else if (!isNumber(b)) throw new NumberFormatException();
                do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
                return n;
            } catch (java.util.NoSuchElementException e) {
                return n;
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}