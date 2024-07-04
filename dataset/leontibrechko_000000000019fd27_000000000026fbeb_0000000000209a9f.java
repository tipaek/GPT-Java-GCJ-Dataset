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
 *
 * @author Liavontsi Brechka
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
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.in = in;

            String s = in.next();
            int n = s.length();

            int[] a = new int[n + 2];
            for (int i = 0; i < n; i++) {
                a[i + 1] = s.charAt(i) - '0';
            }

            int[] diff = new int[n + 2];
            for (int i = 1; i < n + 2; i++) {
                diff[i] = a[i] - a[i - 1];
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n + 2; i++) {
                char next = diff[i] < 0 ? ')' : '(';

                for (int j = 0; j < Math.abs(diff[i]); j++) {
                    res.append(next);
                }

                if (i > 0 && i < n + 1) res.append(a[i]);
            }

            out.printf("Case #%d: %s\n", testNumber, res.toString());
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

