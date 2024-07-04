import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] a = in.nextArrString(n);
            String res = solveMe(n, a);
            out.print("Case #" + testNumber + ": ");
            out.println(res == null || res.length() > 1000 ? "*" : res);
        }

        private String solveMe(int n, String[] a) {
            StringBuilder part1 = new StringBuilder();
            int[] cur1 = new int[n];
            while (true) {
                char c = '\0';
                for (int i = 0; i < n; i++) {
                    if (cur1[i] < a[i].length() && a[i].charAt(cur1[i]) != '*') {
                        if (c == '\0') {
                            c = a[i].charAt(cur1[i]);
                            part1.append(c);
                        } else if (c != a[i].charAt(cur1[i])) {
                            return null;
                        }
                        cur1[i]++;
                    }
                }
                if (c == '\0')
                    break;
            }

            StringBuilder part2 = new StringBuilder();
            int[] cur2 = new int[n];
            for (int i = 0; i < n; i++)
                cur2[i] = a[i].length() - 1;
            while (true) {
                char c = '\0';
                for (int i = 0; i < n; i++) {
                    if (cur2[i] >= 0 && a[i].charAt(cur2[i]) != '*') {
                        if (c == '\0') {
                            c = a[i].charAt(cur2[i]);
                            part2.append(c);
                        } else if (c != a[i].charAt(cur2[i])) {
                            return null;
                        }
                        cur2[i]--;
                    }
                }
                if (c == '\0')
                    break;
            }
            part2.reverse();

        /*StringBuilder res = new StringBuilder(part1);
        int i1 = part1.length()-1;
        int i2= 0;
        while (i1>=0 && i2<part2.length()) {
            String possible = part1 + part2.substring(i2);
            for (int i=0; i<n; i++) {
                if (!match(a[i], possible)) {
                    break;
                }
            }
            i2++;
            i1--;
        }

        if (i2<part2.length())
            res.append(part2.substring(i2, part2.length()));*/

            part1.append(part2);

            return part1.toString();
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String[] nextArrString(int n) {
            String[] a = new String[n];
            for (int i = 0; i < a.length; i++)
                a[i] = next();
            return a;
        }

    }
}

