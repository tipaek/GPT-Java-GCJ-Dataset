import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.AbstractCollection;
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
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        ArrayList<pair<Integer, Integer>>[] a;

        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int c = s.nextInt(), d = s.nextInt();
            int[] p = new int[c];
            for (int i = 1; i < c; i++) p[i] = -s.nextInt();
            a = new ArrayList[c];
            for (int i = 0; i < c; i++) a[i] = new ArrayList<>();
            int[] ans = new int[d];
            Arrays.fill(ans, -1);
            for (int i = 0; i < d; i++) {
                int u = s.nextInt() - 1, v = s.nextInt() - 1;
                a[u].add(new pair<>(v, i));
                a[v].add(new pair<>(u, i));
            }
            PriorityQueue<pair<Integer, Integer>> l = new PriorityQueue<>();
            boolean[] vis = new boolean[c];
            vis[0] = true;
            l.add(new pair<>(0, 0));
            while (!l.isEmpty()) {
                pair<Integer, Integer> cur = l.poll();
                for (pair<Integer, Integer> pi : a[cur.y]) {
                    if (!vis[pi.x]) {
                        vis[pi.x] = true;
                        ans[pi.y] = p[pi.x] - p[cur.y];
                        l.add(new pair<>(cur.x + ans[pi.y], pi.x));
                    /*if(p[pi.x] > p[cur.x]) {
                        ans[pi.y] = 1;
                        l.add(new pair<>(cur.y + 1, pi.x));
                    }
                    else {
                        ans[pi.y] = 0;
                        l.add(new pair<>(cur.y, pi.x));
                    }*/
                    }
                }
            }
            w.print("Case #" + testNumber + ": ");
            for (int i : ans) w.print((i == -1 ? (int) 1e6 : i) + " ");
            w.println();
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

