import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private StringBuilder buffer = new StringBuilder(16384);

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();

        for (int t = 0; t < T; ++t) {
            buffer.append("Case #").append(t).append(":\n");
            int N = reader.nextInt();

            if (N <= 501) {
                generatePath(N);
            }
        }
        System.out.print(buffer);
    }

    private void generatePath(int N) {
        if (N == 501) {
            buffer.append("1 1\n");
            buffer.append("2 1\n");
            N -= 2;
        } else {
            buffer.append("1 1\n");
            N -= 1;
        }

        int n = 2;
        while (N > 0) {
            buffer.append(n).append(' ').append(n).append('\n');
            --N;
            ++n;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public double nextDouble() {
            String next = next();
            return next == null ? -1 : Double.parseDouble(next);
        }

        public long nextLong() {
            String next = next();
            return next == null ? -1 : Long.parseLong(next);
        }

        public int nextInt() {
            String next = next();
            return next == null ? -1 : Integer.parseInt(next);
        }
    }
}