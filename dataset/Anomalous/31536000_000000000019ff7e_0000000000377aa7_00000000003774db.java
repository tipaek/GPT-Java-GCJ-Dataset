import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        FastScanner fs = new FastScanner();
        java.io.PrintWriter out = new java.io.PrintWriter(System.out);
        solve(fs, out);
        out.flush();
    }

    private static int calculateDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            Arrays.fill(dp[i], 0);
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = Math.min(
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                    dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1)
                );
            }
        }

        return dp[len1][len2];
    }

    private void solve(FastScanner fs, java.io.PrintWriter out) {
        int testCases = fs.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String C = fs.next();
            String J = fs.next();
            TreeMap<Integer, String> results = new TreeMap<>();

            for (int k = 1; k <= 6; k++) {
                for (int i = 0; i < pow(3, k); i++) {
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 0, t = i; j < k; j++, t /= 3) {
                        tmp.append((char) ('X' + t % 3));
                    }
                    int maxDist = Math.max(calculateDistance(tmp.toString(), C), calculateDistance(tmp.toString(), J));
                    results.put(maxDist, tmp.toString());
                }
            }

            out.println(String.format("Case #%d: %s", caseNum, results.firstEntry().getValue()));
        }
    }

    private int pow(int base, int exp) {
        return exp == 0 ? 1 : base * pow(base, exp - 1);
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
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
                ptr++;
            }
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
            int num = 0;
            boolean negative = false;
            byte b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                num = num * 10 + b - '0';
            } while (isNumber(b = readByte()));
            return negative ? -num : num;
        }

        public long nextLong() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            long num = 0;
            boolean negative = false;
            byte b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                num = num * 10 + b - '0';
            } while (isNumber(b = readByte()));
            return negative ? -num : num;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}