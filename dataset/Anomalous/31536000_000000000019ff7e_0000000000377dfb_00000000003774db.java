import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        FastScanner scanner = new FastScanner();
        java.io.PrintWriter out = new java.io.PrintWriter(System.out);
        solve(scanner, out);
        out.flush();
    }

    private static int calculateDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            Arrays.fill(dp[i], 0);
            dp[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), 
                                    dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1));
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public void solve(FastScanner scanner, java.io.PrintWriter out) {
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String C = scanner.next();
            String J = scanner.next();
            TreeMap<Distance, String> solutions = new TreeMap<>();
            for (int k = 1; k <= 6; k++) {
                for (int i = 0; i < pow(3, k); i++) {
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 0, t = i; j < k; j++, t /= 3) {
                        tmp.append((char) ('X' + t % 3));
                    }
                    solutions.put(new Distance(calculateDistance(tmp.toString(), C), calculateDistance(tmp.toString(), J)), tmp.toString());
                }
            }
            out.println(String.format("Case #%d: %s", caseNum, solutions.firstEntry().getValue()));
        }
    }

    public static class Distance implements Comparable<Distance> {
        final int a, b;

        Distance(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Distance other) {
            int comparison = Integer.compare(a + b, other.a + other.b);
            if (comparison != 0) return comparison;
            return Integer.compare(Math.abs(a - b), Math.abs(other.a - other.b));
        }
    }

    private int pow(int base, int exponent) {
        return exponent == 0 ? 1 : base * pow(base, exponent - 1);
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
            return 32 <= c && c <= 126;
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

        public long nextLong() {
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

        public int nextInt() {
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