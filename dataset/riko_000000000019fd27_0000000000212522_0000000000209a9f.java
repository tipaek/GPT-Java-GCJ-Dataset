import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Eric
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task2020QB solver = new Task2020QB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task2020QB {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            String s = in.next();
            String t = solveMe(s);
            out.print("Case #" + testNumber + ": ");
            out.println(t);
        }

        private String solveMe(String s) {
            StringBuilder t = new StringBuilder();
            int curDepth = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                if (curDepth < c) {
                    t.append(repeat("(", c - curDepth));
                } else if (curDepth > c) {
                    t.append(repeat(")", curDepth - c));
                }
                curDepth = c;
                t.append(c);
            }
            t.append(repeat(")", curDepth));
            return t.toString();
        }

        public static String repeat(String pattern, int n) {
            StringBuilder sb = new StringBuilder(pattern.length() * n);
            return repeatSb(sb, pattern, n).toString();
        }

        public static StringBuilder repeatSb(StringBuilder sb, String pattern, int n) {
            for (int i = 0; i < n; i++) {
                sb.append(pattern);
            }
            return sb;
        }

    }

    static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;
        String context = null;

        public FastReader(InputStream in) {
            this(new InputStreamReader(in));
        }

        public FastReader(InputStreamReader input) {
            br = new BufferedReader(input);
        }

        public String next() {
            if (context != null) {
                System.err.print("[" + context + "] Wait for input ...");
            }
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null)
                        return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
            }
            String res = st.nextToken();
            if (context != null) {
                System.err.println("[" + context + "] ... received : " + res);
            }
            return res;
        }

    }
}

