import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt();
            pair<pair<Integer, Integer>, Integer>[] p = new pair[n];
            for (int i = 0; i < n; i++) p[i] = new pair<>(new pair<>(s.nextInt(), s.nextInt() - 1), i);
            Arrays.sort(p);
            char[] ans = new char[n];
            int[] prev = {p[0].x.y, -1};
            ans[p[0].y] = 'J';
            w.print("Case #" + testNumber + ": ");
            for (int i = 1; i < n; i++) {
                if (prev[0] < p[i].x.x) {
                    prev[0] = Math.max(prev[0], p[i].x.y);
                    ans[p[i].y] = 'J';
                } else if (prev[1] < p[i].x.x) {
                    ans[p[i].y] = 'C';
                    prev[1] = Math.max(prev[1], p[i].x.y);
                } else {
                    w.println("IMPOSSIBLE");
                    return;
                }
            }
            w.println(ans);
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

    static class pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<pair<U, V>> {
        public U x;
        public V y;

        public pair(U x, V y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(pair<U, V> other) {
            int i = x.compareTo(other.x);
            if (i != 0) return i;
            return y.compareTo(other.y);
        }

        public String toString() {
            return x.toString() + " " + y.toString();
        }

        public boolean equals(Object obj) {
            if (this.getClass() != obj.getClass()) return false;
            pair<U, V> other = (pair<U, V>) obj;
            return x.equals(other.x) && y.equals(other.y);
        }

        public int hashCode() {
            return 31 * x.hashCode() + y.hashCode();
        }

    }
}

