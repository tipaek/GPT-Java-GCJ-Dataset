import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    class InputReader {
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

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Float.parseFloat(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    private InputReader sc = new InputReader(System.in);
    // private InputReader sc = new InputReader(new File("input.txt"));
    private PrintWriter pw = new PrintWriter(System.out);

    private void solveTest(int test) {
        String s = sc.next();
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int nOpen = 0;
        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - '0';
            if (nOpen < val) {
                for (int j = 0; j < val - nOpen; j++) {
                    sb.append("(");
                }
            } else if (nOpen > val) {
                for (int j = 0; j < nOpen - val; j++) {
                    sb.append(")");
                }
            }
            nOpen = val;
            sb.append(val);
        }

        for (int i = 0; i < nOpen; i++) {
            sb.append(")");
        }

        pw.println(String.format("Case #%d: %s", test, sb.toString()));
    }

    private void run()  {
        int nTests = sc.nextInt();

        for (int test = 1; test <= nTests; test++) {
            solveTest(test);
        }

        pw.close();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.run();
    }
}
