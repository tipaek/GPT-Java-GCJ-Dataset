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
            int d = in.nextInt();

            HashMap<Long, Integer> map = new HashMap<>();
            long[] a = new long[n];
            long maxa = 0;
            final int MAX = 1000;
            int cuts = MAX;
            boolean oneLess = false;

            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
                int cnt = map.get(a[i]);

                if (cnt == d) cuts = 0;
                if (cnt == d - 1) oneLess = true;
                if (a[i] > maxa) maxa = a[i];
            }

            if (cuts == MAX) {
                if (d == 2) {
                    cuts = 1;
                } else if (d == 3) {
                    cuts = 2;
                    for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == d - 1 && maxa > entry.getKey()) {
                            cuts = 1;
                            break;
                        }
                    }
                    if (cuts == 2) {
                        for (long value : a) {
                            if (value % 2 == 0 && map.getOrDefault(value / 2, 0) == 1) {
                                cuts = 1;
                            }
                        }
                    }
                }
            }

            out.println("Case #" + tc + ": " + cuts);
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