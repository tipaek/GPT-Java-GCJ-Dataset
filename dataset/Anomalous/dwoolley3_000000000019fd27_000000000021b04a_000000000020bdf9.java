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

            int[] s = new int[n];
            int[] e = new int[n];
            int[] ind = new int[n];
            for (int i = 0; i < n; i++) {
                ind[i] = i;
                s[i] = in.nextInt();
                e[i] = in.nextInt();
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (s[i] > s[j] || (s[i] == s[j] && e[i] > e[j])) {
                        swap(s, i, j);
                        swap(e, i, j);
                        swap(ind, i, j);
                    }
                }
            }

            char[] c = new char[n];
            int cur = 0;
            char curc = 'C';
            c[ind[cur]] = curc;
            String ans = "";

            for (int i = 1; i < n; i++) {
                if (e[cur] > s[i] && s[cur] < e[i]) {
                    if (i + 1 < n && e[i] > s[i + 1] && s[i] < e[i + 1] &&
                        e[cur] > s[i + 1] && s[cur] < e[i + 1]) {
                        ans = "IMPOSSIBLE";
                        break;
                    }
                    c[ind[i]] = (curc == 'C') ? 'J' : 'C';
                    if (e[cur] < e[i]) {
                        cur = i;
                        curc = c[ind[i]];
                    }
                } else {
                    c[ind[i]] = curc;
                    cur = i;
                }
            }

            if (!ans.equals("IMPOSSIBLE")) {
                ans = new String(c);
            }

            out.println("Case #" + tc + ": " + ans);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    private class FastReader {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public FastReader(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
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