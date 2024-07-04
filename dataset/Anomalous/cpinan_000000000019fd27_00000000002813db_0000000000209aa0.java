import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private void solve() {
        InputReader in = new InputReader(System.in);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();

            int traceValue = -1;
            for (int i = 1; i <= N; i++) {
                if (i * N == K) {
                    traceValue = i;
                    break;
                }
            }

            out.print("Case #" + t + ": ");
            if (traceValue != -1) {
                out.println("POSSIBLE");

                int value = traceValue;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        out.print(value + " ");
                        value++;
                        if (j == N - 1) {
                            value--;
                        } else {
                            if (value > N) {
                                value = 1;
                            }
                        }
                    }
                    out.println();
                }
            } else {
                out.println("IMPOSSIBLE");
            }
        }
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}