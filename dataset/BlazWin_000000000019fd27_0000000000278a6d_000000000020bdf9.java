import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();

            List<ParentingPartneringReturns.Item> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(new ParentingPartneringReturns.Item(in.nextInt(), in.nextInt(), i));
            }

            a.sort(Comparator.comparing(x -> x.from));
            int last1 = 0;
            int last2 = 0;
            char[] ans = new char[n];
            for (int i = 0; i < a.size(); i++) {
                int st = a.get(i).from;
                int end = a.get(i).to;
                if (last1 > st) {
                    if (last2 > st) {
                        out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                        return;
                    }
                    ans[a.get(i).idx] = 'J';
                    last2 = end;
                    continue;
                }
                ans[a.get(i).idx] = 'C';
                last1 = end;
            }
            out.println(String.format("Case #%d: %s", testNumber, new String(ans)));
        }

        public static class Item {

            int from;
            int to;
            int idx;

            public Item(int from, int to, int idx) {
                this.from = from;
                this.to = to;
                this.idx = idx;
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

