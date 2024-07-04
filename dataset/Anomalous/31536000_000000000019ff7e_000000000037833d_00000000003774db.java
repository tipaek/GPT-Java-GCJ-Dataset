import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
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

    private void solve(FastScanner scanner, java.io.PrintWriter out) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            TreeMap<Distance, String> resultMap = new TreeMap<>();
            for (int length = 1; length <= 6; length++) {
                for (int i = 0; i < pow(3, length); i++) {
                    StringBuilder temp = new StringBuilder();
                    for (int j = 0, val = i; j < length; j++, val /= 3) {
                        temp.append((char) ('X' + val % 3));
                    }
                    resultMap.put(new Distance(calculateDistance(temp.toString(), str1), 
                                               calculateDistance(temp.toString(), str2)), 
                                  temp.toString());
                }
            }
            out.printf("Case #%d: %s%n", t, resultMap.firstEntry().getValue());
        }
    }

    private static class Distance implements Comparable<Distance> {
        final int dist1, dist2;

        Distance(int dist1, int dist2) {
            this.dist1 = dist1;
            this.dist2 = dist2;
        }

        @Override
        public int compareTo(Distance other) {
            int comparison = Integer.compare(dist1 + dist2, other.dist1 + other.dist2);
            if (comparison != 0) return comparison;
            return Integer.compare(Math.abs(dist1 - dist2), Math.abs(other.dist1 - other.dist2));
        }
    }

    private int pow(int base, int exponent) {
        if (exponent == 0) return 1;
        return base * pow(base, exponent - 1);
    }

    private static class FastScanner {
        private final java.io.InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int pointer = 0;
        private int bufferLength = 0;

        private boolean hasNextByte() {
            if (pointer < bufferLength) return true;
            pointer = 0;
            try {
                bufferLength = in.read(buffer);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return bufferLength > 0;
        }

        private byte readByte() {
            if (hasNextByte()) return buffer[pointer++];
            return -1;
        }

        private static boolean isPrintableChar(byte c) {
            return 32 < c || c < 0;
        }

        private static boolean isNumber(int c) {
            return '0' <= c && c <= '9';
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[pointer])) pointer++;
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

        public int nextInt() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            int number = 0;
            byte b = readByte();
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                number = number * 10 + b - '0';
                b = readByte();
            } while (isNumber(b));
            return negative ? -number : number;
        }

        public long nextLong() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            long number = 0;
            byte b = readByte();
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                number = number * 10 + b - '0';
                b = readByte();
            } while (isNumber(b));
            return negative ? -number : number;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}