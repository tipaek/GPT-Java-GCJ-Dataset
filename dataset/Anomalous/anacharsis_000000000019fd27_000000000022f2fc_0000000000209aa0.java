import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    private static final Map<AnswerKey, String> ANSWERS = new HashMap<>();

    static {
        ANSWERS.put(new AnswerKey(2, 2), "1 2\n2 1\n");
        ANSWERS.put(new AnswerKey(2, 2), "2 1\n1 2\n");

        ANSWERS.put(new AnswerKey(3, 3), "1 2 3\n3 1 2\n2 3 1\n");
        ANSWERS.put(new AnswerKey(3, 6), "3 2 1\n2 1 3\n1 3 2\n");
        ANSWERS.put(new AnswerKey(3, 9), "3 1 2\n2 3 1\n1 2 3\n");

        ANSWERS.put(new AnswerKey(4, 4), "1 2 3 4\n2 1 4 3\n3 4 1 2\n4 3 2 1\n");
        ANSWERS.put(new AnswerKey(4, 6), "2 3 4 1\n3 1 2 4\n4 2 1 3\n1 4 3 2\n");
        ANSWERS.put(new AnswerKey(4, 7), "3 2 4 1\n4 1 2 3\n2 3 1 4\n1 4 3 2\n");
        ANSWERS.put(new AnswerKey(4, 8), "4 2 3 1\n3 1 2 4\n2 4 1 3\n1 3 4 2\n");
        ANSWERS.put(new AnswerKey(4, 9), "4 1 2 3\n3 2 4 1\n2 3 1 4\n1 4 3 2\n");
        ANSWERS.put(new AnswerKey(4, 10), "4 1 2 3\n2 3 4 1\n3 2 1 4\n1 4 3 2\n");
        ANSWERS.put(new AnswerKey(4, 11), "4 1 2 3\n2 4 3 1\n3 2 1 4\n1 3 4 2\n");
        ANSWERS.put(new AnswerKey(4, 12), "4 2 1 3\n2 4 3 1\n1 3 2 4\n3 1 4 2\n");
        ANSWERS.put(new AnswerKey(4, 13), "4 2 1 3\n3 4 2 1\n2 1 3 4\n1 3 4 2\n");
        ANSWERS.put(new AnswerKey(4, 16), "4 1 2 3\n1 4 3 2\n2 3 4 1\n3 2 1 4\n");

        ANSWERS.put(new AnswerKey(5, 5), "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n");
        ANSWERS.put(new AnswerKey(5, 7), "2 3 4 5 1\n3 1 2 4 5\n4 5 1 2 3\n5 2 3 1 4\n1 4 5 3 2\n");
        ANSWERS.put(new AnswerKey(5, 8), "3 2 4 5 1\n2 1 3 4 5\n4 5 1 2 3\n5 3 2 1 4\n1 4 5 3 2\n");
        ANSWERS.put(new AnswerKey(5, 9), "4 2 3 5 1\n2 1 4 3 5\n3 5 1 2 4\n5 4 2 1 3\n1 3 5 4 2\n");
        ANSWERS.put(new AnswerKey(5, 10), "5 2 3 4 1\n2 1 4 5 3\n3 5 1 2 4\n4 3 2 1 5\n1 4 5 3 2\n");
        ANSWERS.put(new AnswerKey(5, 11), "5 1 2 3 4\n3 2 4 5 1\n4 3 1 2 5\n2 4 5 1 3\n1 5 3 4 2\n");
        ANSWERS.put(new AnswerKey(5, 12), "5 1 2 3 4\n2 3 4 5 1\n3 4 1 2 5\n4 2 5 1 3\n1 5 3 4 2\n");
        ANSWERS.put(new AnswerKey(5, 13), "5 1 2 3 4\n2 4 3 5 1\n4 5 1 2 3\n3 2 4 1 5\n1 3 5 4 2\n");
        ANSWERS.put(new AnswerKey(5, 14), "5 1 2 3 4\n2 5 3 4 1\n3 4 1 2 5\n4 2 5 1 3\n1 3 4 5 2\n");
        ANSWERS.put(new AnswerKey(5, 15), "5 1 3 2 4\n2 5 1 4 3\n4 3 2 5 1\n3 2 4 1 5\n1 4 5 3 2\n");
        ANSWERS.put(new AnswerKey(5, 16), "5 1 2 3 4\r\n3 5 4 2 1\r\n1 2 3 4 5\r\n2 4 5 1 3\r\n4 3 1 5 2\n");
        ANSWERS.put(new AnswerKey(5, 17), "5 1 2 3 4\r\n2 5 3 4 1\r\n1 3 4 2 5\r\n4 2 5 1 3\r\n3 4 1 5 2\n");
        ANSWERS.put(new AnswerKey(5, 18), "5 1 2 3 4\r\n1 5 4 2 3\r\n2 3 5 4 1\r\n4 2 3 1 5\r\n3 4 1 5 2\n");
        ANSWERS.put(new AnswerKey(5, 19), "5 1 2 3 4\r\n2 5 3 4 1\r\n4 2 5 1 3\r\n1 3 4 2 5\r\n3 4 1 5 2\n");
        ANSWERS.put(new AnswerKey(5, 20), "5 1 2 4 3\r\n2 5 3 1 4\r\n3 4 5 2 1\r\n1 2 4 3 5\r\n4 3 1 5 2\n");
        ANSWERS.put(new AnswerKey(5, 21), "5 1 2 3 4\r\n2 5 4 1 3\r\n3 4 5 2 1\r\n1 2 3 4 5\r\n4 3 1 5 2\n");
        ANSWERS.put(new AnswerKey(5, 25), "5 1 2 3 4\r\n1 5 3 4 2\r\n2 4 5 1 3\r\n3 2 4 5 1\r\n4 3 1 2 5\n");
    }

    public void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();

        for (int t = 0; t < T; ++t) {
            int N = reader.nextInt();
            int trace = reader.nextInt();

            AnswerKey key = new AnswerKey(N, trace);
            String solution = ANSWERS.get(key);

            if (solution == null) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t + 1));
            } else {
                System.out.println(String.format("Case #%d: POSSIBLE", t + 1));
                System.out.print(solution);
            }
        }
    }

    static class AnswerKey {
        private final int N;
        private final int K;

        public AnswerKey(int n, int k) {
            N = n;
            K = k;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + K;
            result = prime * result + N;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            AnswerKey other = (AnswerKey) obj;
            if (K != other.K)
                return false;
            return N == other.N;
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
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
    }
}