/**
 * Created by Aminul on 4/4/2020.
 */

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(in.nextInt(), in.nextInt());
            }
            pw.println("Case #" + t + ": " + solve(n, pairs));
        }

        pw.close();
    }

    static boolean isIntersection(Pair a, Pair b) {
        int maxStart = max(a.f, b.f), minEnd = min(a.s, b.s);
        return maxStart < minEnd;
    }

    static String solve(int n, Pair[] pairs) {
        TwoSat twoSat = new TwoSat(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isIntersection(pairs[i], pairs[j])) {
                    twoSat.addNand(true, i, true, j);
                    twoSat.addNand(false, i, false, j);
                }
            }
        }
        boolean ok = twoSat.solve();
        if (!ok) return "IMPOSSIBLE";
        else {
            char s[] = new char[n];
            for (int i = 0; i < n; i++) {
                s[i] = twoSat.getVal(i) ? 'J' : 'C';
            }
            return String.valueOf(s);
        }
    }

    static class TwoSat {
        int n, s[], c;
        boolean mark[];
        ArrayDeque<Integer> g[];
        Stack<Integer> stack;

        TwoSat(int N) {
            this.n = N;
            s = new int[n * 2];
            mark = new boolean[n * 2];
            stack = new Stack<>();
            g = new ArrayDeque[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                g[i] = new ArrayDeque<>();
            }
        }

        void addImpl(boolean xflag, int x, boolean yflag, int y) {
            x = x * 2 + (xflag ? 1 : 0);
            y = y * 2 + (yflag ? 1 : 0);
            addEdge(x, y);
            addEdge(y ^ 1, x ^ 1);
        }

        void addEdge(int from, int to) {
            g[from].addLast(to);
            stack.add(from);
        }

        void removeLastImpl() {
            g[stack.pop()].removeLast();
            g[stack.pop()].removeLast();
        }

        //# Add (a NAND b)
        public void addNand(boolean va, int a, boolean vb, int b) {
            addImpl(va, a, !vb, b);
        }

        //# Add (a OR b)
        public void addOr(boolean va, int a, boolean vb, int b) {
            addImpl(!va, a, vb, b); // ~a -> b
        }

        //# Add (a XOR b)
        public void addXor(boolean va, int a, boolean vb, int b) {
            addImpl(!va, a, vb, b); // ~a -> b
            addImpl(va, a, !vb, b); // a -> ~b
        }

        //# Forces a to have whatever value va is
        public void addForce(int a, boolean va) {
            addImpl(!va, a, va, a);
        }//$

        // Returns the value of the variable v
        public boolean getVal(int v) {
            return mark[v << 1];
        }

        boolean dfs(int u) {
            if (mark[u ^ 1]) return false;
            if (mark[u]) return true;
            mark[u] = true;
            s[c++] = u;
            for (int i : g[u])
                if (!dfs(i)) return false;
            return true;
        }

        boolean solve() {
            Arrays.fill(mark, false);
            for (int i = 0; i < 2 * n; i += 2) {
                if (!mark[i] && !mark[i + 1]) {
                    c = 0;
                    if (!dfs(i)) {
                        while (c != 0) mark[s[--c]] = false;
                        if (!dfs(i + 1)) return false;
                    }
                }
            }
            return true;
        }
    }

    static class Pair implements Comparable<Pair> {
        int f, s;

        Pair(int F, int S) {
            f = F;
            s = S;
        }

        public int compareTo(Pair p) {
            if (f == p.f) return s - p.s;
            return f - p.f;
        }

        public String toString() {
            return f + " " + s;
        }
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }


        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}