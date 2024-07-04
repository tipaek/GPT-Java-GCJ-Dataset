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
        TaskNestingDepth solver = new TaskNestingDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskNestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            int num = 0;
            while (t > 0) {
                t--;
                num++;
                String s = in.next();
                out.print("Case #" + num + ": ");
                int opened = 0;
                for (int i = 0, l = s.length(); i < l; i++) {
                    int c = s.charAt(i) - '0';
                    if (c == 0) {
                        for (int j = 0; j < opened; j++)
                            out.print(")");
                        opened = 0;
                    } else {
                        if (opened <= c) {
                            int dif = c - opened;
                            for (int j = 0; j < dif; j++)
                                out.print("(");
                        } else {
                            int dif = opened - c;
                            for (int j = 0; j < dif; j++)
                                out.print(")");
                        }
                        opened = c;
                    }
                    out.print((char) (c + '0'));
                }
                for (int j = 0; j < opened; j++)
                    out.print(")");
                out.println();
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

