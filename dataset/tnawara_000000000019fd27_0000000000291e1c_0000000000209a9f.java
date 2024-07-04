import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
8
0000
101
111000
1
021
312
4
221
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            Task solver = new Task();
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    private static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int prev = 0;
            String s = in.next();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                int cur = s.charAt(i) - '0';
                if (cur == prev) {
                    res.append(cur);
                } else if (cur > prev) {
                    int d = cur - prev;
                    while (d > 0) {
                        --d;
                        res.append('(');
                    }
                    res.append(cur);
                } else {
                    int d = prev - cur;
                    while (d > 0) {
                        --d;
                        res.append(')');
                    }
                    res.append(cur);
                }
                prev = cur;
            }
            while (prev > 0) {
                --prev;
                res.append(')');
            }
            out.printf("Case #%d: %s\n", testNumber, res.toString());
        }
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 343499);
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
