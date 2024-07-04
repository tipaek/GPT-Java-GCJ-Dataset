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

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    private InputReader sc = new InputReader(System.in);
    private PrintWriter pw = new PrintWriter(System.out);

    private void solveTest(int test) {
        String s = sc.next();
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int openBrackets = 0;
        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - '0';
            if (openBrackets < val) {
                sb.append("(".repeat(val - openBrackets));
            } else if (openBrackets > val) {
                sb.append(")".repeat(openBrackets - val));
            }
            openBrackets = val;
            sb.append(val);
        }

        sb.append(")".repeat(openBrackets));

        pw.printf("Case #%d: %s%n", test, sb.toString());
    }

    private void run() {
        int nTests = sc.nextInt();

        for (int test = 1; test <= nTests; test++) {
            solveTest(test);
        }

        pw.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}