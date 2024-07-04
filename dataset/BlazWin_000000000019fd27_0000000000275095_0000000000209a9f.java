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
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class NestingDepth {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int val = s.charAt(i) - '0';
                while (count > val) {
                    count--;
                    sb.append(')');
                }
                while (count < val) {
                    count++;
                    sb.append('(');
                }
                sb.append(s.charAt(i));
            }
            for (int i = 0; i < count; i++) {
                sb.append(')');
            }
            out.println(String.format("Case #%d: %s", testNumber, sb));
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

