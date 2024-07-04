import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private StringBuilder buffer = new StringBuilder(16384);

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();

        for (int t = 0; t < T; ++t) {
            buffer.append("Case #").append(t + 1).append(":\n");
            int N = reader.nextInt();

            if (N <= 501) {
                generatePath(N);
            }
        }
        System.out.print(buffer);
    }

    private void generatePath(int N) {
        if (N == 1) {
            buffer.append("1 1\n");
            N = 0;
        } else if (N == 501) {
            buffer.append("1 1\n2 2\n3 2\n");
            N -= 4;
        } else {
            buffer.append("1 1\n2 2\n");
            N -= 2;
        }

        int n = 2;
        while (N > 0) {
            buffer.append(n).append(' ').append(n).append('\n');
            --N;
            ++n;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
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
    }
}