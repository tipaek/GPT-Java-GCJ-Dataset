import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    private FastReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private void solve() {
        int testCases = in.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int n = in.nextInt();
            String[] leftParts = new String[n];
            String[] rightParts = new String[n];

            for (int i = 0; i < n; i++) {
                String pattern = in.next();
                int starIndex = pattern.indexOf('*');
                leftParts[i] = pattern.substring(0, starIndex);
                rightParts[i] = pattern.substring(starIndex + 1);
            }

            String left = leftParts[0];
            String right = rightParts[0];
            boolean isValid = true;

            for (int i = 1; i < n && isValid; i++) {
                if (leftParts[i].length() <= left.length()) {
                    isValid = left.startsWith(leftParts[i]);
                } else {
                    isValid = leftParts[i].startsWith(left);
                    left = leftParts[i];
                }
            }

            for (int i = 1; i < n && isValid; i++) {
                if (rightParts[i].length() <= right.length()) {
                    isValid = right.endsWith(rightParts[i]);
                } else {
                    isValid = rightParts[i].endsWith(right);
                    right = rightParts[i];
                }
            }

            String result = isValid ? (left + right) : "*";
            out.println("Case #" + tc + ": " + result);
        }
    }

    private void runWithFiles() {
        in = new FastReader(new File("input.txt"));
        try {
            out = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        solve();
        out.close();
    }

    private static class FastReader {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public FastReader(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }
    }
}