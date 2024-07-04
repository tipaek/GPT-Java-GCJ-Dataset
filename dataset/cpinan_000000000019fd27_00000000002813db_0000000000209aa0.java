import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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

    private void resolve() {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);

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
                out.print("POSSIBLE");
                out.println();

                int value = traceValue;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        out.print(value);
                        out.print(" ");
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
                out.print("IMPOSSIBLE");
                out.println();
            }
        }
        out.close();
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        p.resolve();
    }

}
