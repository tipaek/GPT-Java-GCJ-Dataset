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
 * @author htvu
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            for (int test = 1; test <= T; ++test) {

                String s = in.next();
                StringBuilder ans = new StringBuilder();
                int cnt = 0;
                for (int i = 0; i < s.length(); ++i) {
                    int d = s.charAt(i) - '0';
                    while (d > cnt) {
                        ans.append('(');
                        cnt++;
                    }
                    while (d < cnt) {
                        ans.append(')');
                        cnt--;
                    }
                    ans.append(d);
                }
                while (cnt-- > 0) ans.append(')');

                out.printf("Case #%d: %s\n", test, ans.toString());
            }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

