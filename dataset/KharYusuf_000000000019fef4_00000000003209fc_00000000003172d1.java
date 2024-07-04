import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author KharYusuf
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakeChoppers {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt(), d = s.nextInt();
            MultiSet<Integer> m = new MultiSet<>();
            for (int i = 0; i < n; i++) m.add(s.nextInt());
            if (d == 2) {
                int ans = 1;
                for (Map.Entry<Integer, Integer> e : m.t.entrySet())
                    if (e.getValue() > 1) {
                        ans--;
                        break;
                    }
                w.println("Case #" + testNumber + ": " + ans);
            } else {
                int ans = 2;
                for (Map.Entry<Integer, Integer> e : m.t.entrySet()) {
                    if (e.getValue() > 2) {
                        ans = 0;
                        break;
                    } else {
                        if (m.contains(e.getKey() * 2)) {
                            ans = 1;
                        }
                    }
                }
                w.println("Case #" + testNumber + ": " + ans);
            }
        }

    }

    static class MultiSet<U extends Comparable<U>> {
        public int sz = 0;
        public TreeMap<U, Integer> t;

        public MultiSet() {
            t = new TreeMap<>();
        }

        public void add(U x) {
            t.put(x, t.getOrDefault(x, 0) + 1);
            sz++;
        }

        public boolean contains(U x) {
            return t.containsKey(x);
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {

            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {

                curChar = 0;

                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }

            return buf[curChar++];
        }

        public int nextInt() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();

                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public String next() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {

            if (filter != null)
                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

