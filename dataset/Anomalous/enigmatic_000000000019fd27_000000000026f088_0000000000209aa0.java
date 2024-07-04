import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int t = fr.nextInt();
        for (int cs = 1; cs <= t; ++cs) {
            int n = fr.nextInt();
            int K = fr.nextInt();
            int[][] mt = new int[n][n];
            int md = K % n;
            int q = K / n;

            for (int i = 0; i < md; ++i) {
                for (int j = 0; j < n; ++j) {
                    mt[i][(i + j) % n] = (q + j) % n;
                }
            }

            for (int i = md; i + 1 < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    mt[i][(i + j) % n] = (q - 1 + j) % n;
                }
            }
            mt[n - 1][n - 1] = q - 1;

            boolean isPossible = true;
            for (int i = 0; i < n; ++i) {
                boolean[] mrk = new boolean[n];
                for (int j = 0; j < n; ++j) {
                    if (mrk[mt[j][i]]) {
                        isPossible = false;
                        break;
                    }
                    mrk[mt[j][i]] = true;
                }
                if (!isPossible) break;
            }

            op.print("Case #" + cs + ": ");
            if (isPossible) {
                op.println("POSSIBLE");
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        op.print((mt[i][j] + 1) + " ");
                    }
                    op.println();
                }
            } else {
                op.println("IMPOSSIBLE");
            }
        }
        op.flush();
        op.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}