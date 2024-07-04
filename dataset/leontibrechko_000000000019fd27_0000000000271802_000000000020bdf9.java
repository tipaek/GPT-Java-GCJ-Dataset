import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.in = in;

            int n = in.nextInt();
            ParentingPartneringReturns.Seg[] segs = new ParentingPartneringReturns.Seg[n];
            for (int i = 0; i < n; i++) {
                segs[i] = new ParentingPartneringReturns.Seg(in.nextInt(), in.nextInt(), i);
            }

            Arrays.sort(segs);

            int c = 0;
            int j = 0;
            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                if (segs[i].l >= c) {
                    res[segs[i].index] = 'C';
                    c = segs[i].r;
                } else if (segs[i].l >= j) {
                    res[segs[i].index] = 'J';
                    j = segs[i].r;
                } else {
                    res = null;
                    break;
                }
            }

            StringBuilder resS;
            if (res == null) {
                resS = new StringBuilder("IMPOSSIBLE");
            } else {
                resS = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    resS.append(res[i]);
                }
            }

            out.printf("Case #%d: %s\n", testNumber, resS.toString());
        }

        private static class Seg implements Comparable<ParentingPartneringReturns.Seg> {
            int l;
            int r;
            int index;

            public Seg(int l, int r, int index) {
                this.l = l;
                this.r = r;
                this.index = index;
            }

            public int compareTo(ParentingPartneringReturns.Seg o) {
                return Integer.compare(l, o.l);
            }

        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
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

