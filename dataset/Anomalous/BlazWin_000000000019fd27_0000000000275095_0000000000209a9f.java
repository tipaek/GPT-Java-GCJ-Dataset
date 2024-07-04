import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class NestingDepth {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int currentDepth = 0;
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                while (currentDepth > digit) {
                    sb.append(')');
                    currentDepth--;
                }
                while (currentDepth < digit) {
                    sb.append('(');
                    currentDepth++;
                }
                sb.append(c);
            }
            while (currentDepth > 0) {
                sb.append(')');
                currentDepth--;
            }
            out.printf("Case #%d: %s%n", testNumber, sb);
        }
    }

    static class InputReader {

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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