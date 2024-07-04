import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        private String pass(String s) {
            StringBuilder sb = new StringBuilder();
            int curStack = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    curStack++;
                    sb.append(c);
                } else if (c == ')') {
                    curStack--;
                    sb.append(c);
                } else {
                    int p = Integer.parseInt(c + "");

                    while (curStack < p) {
                        curStack++;
                        sb.append('(');
                    }
                    while (curStack > p) {
                        curStack--;
                        sb.append(')');
                    }

                    sb.append(c);
                }
            }
            return sb.toString();
        }

        private String reverse(String s) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    sb.append(')');
                } else if (c == ')') {
                    sb.append('(');
                } else {
                    sb.append(c);
                }
            }
            return sb.reverse().toString();
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            String s = in.readToken();

            out.println("Case #" + testNumber + ": " + reverse(pass(reverse(pass(s)))));
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public String next() {
            return readToken();
        }

    }
}

