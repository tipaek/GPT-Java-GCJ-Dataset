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
            int n = in.nextInt();
            out.println("Case #" + tc + ": ");

            int sum = 0;
            if (n >= 1) {
                out.println("1 1");
                sum += 1;
            }
            if (n >= 2) {
                out.println("2 1");
                sum += 1;
            }
            if (n == 3) {
                out.println("2 2");
                sum += 1;
            }
            if (n >= 4) {
                int row = 3;
                while (row - 1 <= n - sum) {
                    out.println(row + " 2");
                    sum += (row - 1);
                    row++;
                }
                for (int i = 0; i < n - sum; i++) {
                    out.println((row - 1 + i) + " 1");
                }
            }
        }
    }

    private void runWithFiles() {
        try {
            in = new FastReader(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        solve();
        out.close();
    }

    private class FastReader {
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