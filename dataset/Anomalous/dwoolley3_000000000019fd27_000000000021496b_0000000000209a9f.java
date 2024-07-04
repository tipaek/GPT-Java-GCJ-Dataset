import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    private FastReader in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    private void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private void solve() {
        int T = in.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String s = in.next();
            int n = s.length();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                StringBuilder cs = new StringBuilder().append(c);
                while (i + 1 < n && c == s.charAt(i + 1)) {
                    i++;
                    cs.append(c);
                }
                if (c == '0') {
                    ans.append(cs);
                } else if (c == '1') {
                    ans.append("(").append(cs).append(")");
                }
            }
            out.println("Case #" + tc + ": " + ans);
        }
    }

    private static class FastReader {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public FastReader(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
                tokenizer = null;
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