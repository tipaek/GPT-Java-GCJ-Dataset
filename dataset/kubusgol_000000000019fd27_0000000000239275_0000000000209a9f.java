import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String S = in.next();
            StringBuilder sb = new StringBuilder();

            int bal = 0;

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);

                while (bal < c - '0') {
                    bal++;
                    sb.append('(');
                }

                while (bal > c - '0') {
                    bal--;
                    sb.append(')');
                }

                sb.append(c);
            }

            while (bal > 0) {
                bal--;
                sb.append(')');
            }
            out.println("Case #" + testNumber + ": " + sb.toString());
        }

    }

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

    }
}

