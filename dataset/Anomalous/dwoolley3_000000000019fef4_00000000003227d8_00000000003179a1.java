import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private FastReader in;
    private PrintWriter out;

    private void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private void solve() {
        int T = in.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int u = in.nextInt();
            int n = 10_000;

            char[] let = new char[10];
            Set<Character> hs = new HashSet<>();
            Set<Character> used = new HashSet<>();
            long[] r = new long[n];
            String[] s = new String[n];

            for (int i = 0; i < n; i++) {
                r[i] = in.nextLong();
                s[i] = in.next();
                for (char c : s[i].toCharArray()) {
                    hs.add(c);
                }
            }

            for (int num = 1; num < 10; num++) {
                for (int i = 0; i < n; i++) {
                    long pow10 = 1;
                    for (int j = 1; j <= u; j++) {
                        if (r[i] >= num * pow10 && r[i] <= (num + 1) * pow10 - 1 && s[i].length() == j) {
                            char c = s[i].charAt(0);
                            if (!used.contains(c)) {
                                let[num] = c;
                            }
                        }
                        pow10 *= 10L;
                    }
                }
                used.add(let[num]);
            }

            for (char c : hs) {
                if (!used.contains(c)) {
                    let[0] = c;
                    break;
                }
            }

            String ans = new String(let);
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