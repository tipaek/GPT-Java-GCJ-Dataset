import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();
        int B = reader.nextInt();

        for (int t = 0; t < T; t++) {
            char[] bs = new char[B];

            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                System.out.flush();

                bs[i] = reader.nextInt() == 0 ? '0' : '1';
            }

            System.out.println(new String(bs));
            reader.next();
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            String next = next();
            return next == null ? -1 : Integer.parseInt(next);
        }
    }
}