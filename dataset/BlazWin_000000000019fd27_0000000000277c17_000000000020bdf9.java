import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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

            List<Pair<Integer, Integer>> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(Pair.of(in.nextInt(), in.nextInt()));
            }

            a.sort(Comparator.comparing(x -> x.fs));
            int last1 = 0;
            int last2 = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.size(); i++) {
                int st = a.get(i).fs;
                int end = a.get(i).sc;
                if (last1 > st) {
                    if (last2 > st) {
                        out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                        return;
                    }
                    sb.append('J');
                    last2 = end;
                    continue;
                }
                sb.append('C');
                last1 = end;
            }
            out.println(String.format("Case #%d: %s", testNumber, sb));
        }
    }

    static class Pair<T, K> {

        T fs;
        K sc;

        public Pair(T fs, K sc) {
            this.fs = fs;
            this.sc = sc;
        }

        public static <T, K> Pair<T, K> of(T fs, K sc) {
            return new Pair<>(fs, sc);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(fs, pair.fs) && Objects.equals(sc, pair.sc);
        }

        public int hashCode() {
            return Objects.hash(fs, sc);
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

