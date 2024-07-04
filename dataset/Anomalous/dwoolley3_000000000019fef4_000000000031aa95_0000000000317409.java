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
        int T = in.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();

            int n = s.length();
            int mh = Math.abs(x) + Math.abs(y);
            int closest = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                mh = Math.abs(x) + Math.abs(y);
                if (mh <= (i + 1)) {
                    closest = Math.min(closest, i + 1);
                }
            }

            String ans = (closest < Integer.MAX_VALUE) ? String.valueOf(closest) : "IMPOSSIBLE";
            out.println("Case #" + tc + ": " + ans);
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