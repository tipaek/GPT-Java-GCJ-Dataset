import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    private FastReader in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        process();
        out.close();
    }

    private void process() {
        int T = in.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String s = in.next();
            int n = s.length();
            StringBuilder ans = new StringBuilder();
            int lparen = 0, rparen = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                StringBuilder cs = new StringBuilder().append(c);
                while (i + 1 < n && c == s.charAt(i + 1)) {
                    i++;
                    cs.append(c);
                }
                int dig = c - '0';
                int x = lparen - rparen;
                while (lparen - rparen < dig) {
                    lparen++;
                    ans.append("(");
                }
                while (lparen - rparen > dig) {
                    rparen++;
                    ans.append(")");
                }
                ans.append(cs);
            }
            while (lparen > rparen) {
                rparen++;
                ans.append(")");
            }

            out.println("Case #" + tc + ": " + ans);
        }
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