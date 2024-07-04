import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        WormholeInOne solver = new WormholeInOne();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class WormholeInOne {
        int n;
        int[] par;
        int[] size;

        int findSet(int i) {
            if (par[i] == i)
                return i;
            par[i] = findSet(par[i]);
            return par[i];
        }

        void union(int i, int j) {
            i = findSet(i);
            j = findSet(j);

            if (i != j) {
                par[j] = i;
                size[i] += size[j];
            }
        }

        int getAns(ArrayList<Edge> edgeList) {
            par = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                par[i] = i;
                size[i] = 1;
            }

            for (Edge curE : edgeList) {
                union(curE.u, curE.v);
            }

            int ans = 0;
            int oddCnt = 0;
            int oneCnt = 0;
            for (int i = 0; i < n; ++i) {
                if (findSet(i) == i) {
                    if (size[i] == 1)
                        oneCnt++;
                    ans += (size[i] / 2) * 2;
                    oddCnt += size[i] % 2;
                }
            }

            int highOdds = oddCnt - oneCnt;
            int poss = (highOdds / 2) * 2;
            ans += poss;
            oddCnt -= poss;
            ans += Math.min(oddCnt, 2);

            return ans;
        }

        int getSign(long val) {
            return val > 0 ? 1 : -1;
        }

        long gcd(long a, long b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }

        boolean areEqual(Edge e1, Edge e2) {
            if (e1.flag == 1 && e2.flag == 1)
                return true;
            if (e1.flag == 2 && e2.flag == 2)
                return true;
            if (e1.delx == e2.delx && e1.dely == e2.dely && e1.sign == e2.sign)
                return true;
            return false;
        }

        Edge getEdge(Point a, Point b) {
            long delx = a.x - b.x;
            long dely = a.y - b.y;
            int sign = getSign(delx) * getSign(dely);
            Edge e = new Edge(a.ind, b.ind, Math.abs(delx), Math.abs(dely), sign);
            if (delx == 0)
                e.flag = 1;
            else if (dely == 0)
                e.flag = 2;
            else {
                long gcd = gcd(e.delx, e.dely);
                e.delx /= gcd;
                e.dely /= gcd;
            }
            return e;
        }

        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            n = sc.nextInt();

            Point p[] = new Point[n];
            for (int i = 0; i < n; ++i)
                p[i] = new Point(i, sc.nextLong(), sc.nextLong());

            Edge e[] = new Edge[n * (n - 1) / 2];
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    e[ptr++] = getEdge(p[i], p[j]);
                }
            }

            Arrays.sort(e, new Comparator<Edge>() {

                public int compare(Edge o1, Edge o2) {
                    if (o1.flag > o2.flag)
                        return -1;
                    if (o1.flag < o2.flag)
                        return 1;
                    if (o1.delx < o2.delx)
                        return -1;
                    if (o1.delx > o2.delx)
                        return 1;
                    if (o1.dely < o2.dely)
                        return -1;
                    if (o1.dely > o2.dely)
                        return 1;
                    if (o1.sign < o2.sign)
                        return -1;
                    if (o1.sign > o2.sign)
                        return 1;
                    return 0;
                }
            });

            ArrayList<Edge> curList = new ArrayList<>();
            ptr = 0;
            int ans = Math.min(n, 2);
            while (ptr < e.length) {
                curList.clear();
                Edge firstE = e[ptr];
                curList.add(firstE);
                ptr++;
                while (ptr < e.length && areEqual(firstE, e[ptr])) {
                    curList.add(e[ptr]);
                    ptr++;
                }
                ans = Math.max(ans, getAns(curList));
            }
            out.println("Case #" + testNumber + ": " + ans);
        }

        class Edge {
            int u;
            int v;
            int flag;
            int sign;
            long delx;
            long dely;

            Edge(int a, int b, long c, long d, int e) {
                u = a;
                v = b;
                delx = c;
                dely = d;
                sign = e;
            }

        }

        class Point {
            int ind;
            long x;
            long y;

            Point(int ind, long a, long b) {
                this.ind = ind;
                x = a;
                y = b;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
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

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

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

        public String readString() {
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

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

