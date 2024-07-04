import java.util.*;
import java.io.*;

class PolyNo {
    int c;
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    long mod = 1000000007L;
    long mod1 = 163577857L;
    long[] fact;
    int[] array;
    long[] infact;
    int[][] index;
    HashMap[] hm;
    HashMap[] mul;
    HashMap[] div;
    int[] arr;
    int[] value;
    int MAXN = 100007;
    int MAXLN = 17;
    int[] depth;
    int[][] par;
    Vector<Integer>[] adj;
    int n, q, u, v, sz;

    void solve() throws Exception {
        int t = ni();
        for (int i1 = 1; i1 <= t; i1++) {
            int x = ni();
            int y = ni();
            String s = ns();
            int count = 0;
            boolean found = false;
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'E': x++; break;
                    case 'N': y++; break;
                    case 'W': x--; break;
                    case 'S': y--; break;
                }
                count++;
                if (count >= distance(x, y)) {
                    found = true;
                    out.println(Case(i1) + count);
                    break;
                }
            }
            if (!found) out.println(Case(i1) + "IMPOSSIBLE");
        }
    }

    int distance(int a, int b) {
        return Math.abs(a) + Math.abs(b);
    }

    long ncr(int a, int b) {
        long temp = fact[a];
        temp = (temp * infact[b]) % mod1;
        temp = (temp * infact[a - b]) % mod1;
        return temp;
    }

    long power1(long a, int x) {
        String s = Integer.toBinaryString(x);
        long temp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                temp = (temp * a) % mod1;
            }
            a = (a * a) % mod1;
        }
        return temp;
    }

    void initialize(int n) {
        depth = new int[MAXN];
        par = new int[MAXLN][MAXN];
        adj = new Vector[n];
        for (int i = 0; i < n; i++) adj[i] = new Vector<>();
    }

    void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    void dfs(int cur, int prev, int _depth) {
        depth[cur] = _depth;
        par[0][cur] = prev;
        for (int neighbor : adj[cur]) {
            if (neighbor != prev) {
                dfs(neighbor, cur, _depth + 1);
            }
        }
    }

    void LCAPreprocess() {
        for (int i = 1; i < MAXLN; i++) {
            for (int j = 0; j < n; j++) {
                if (par[i - 1][j] != -1) {
                    par[i][j] = par[i - 1][par[i - 1][j]];
                }
            }
        }
    }

    int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int i = 0; i < MAXLN; i++)
            if (((diff >> i) & 1) == 1) u = par[i][u];

        if (u == v) return u;

        for (int i = MAXLN - 1; i >= 0; i--)
            if (par[i][u] != par[i][v]) {
                u = par[i][u];
                v = par[i][v];
            }

        return par[0][u];
    }

    String Case(int test) {
        return "Case #" + test + ": ";
    }

    long power(long a, int x) {
        String s = Integer.toBinaryString(x);
        long temp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                temp = (temp * a) % mod;
            }
            a = (a * a) % mod;
        }
        return temp;
    }

    int min(int a, int b) {
        return Math.min(a, b);
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    int mi(int a, int n) {
        return (a < 0) ? n - a : a;
    }

    int plus(int a, int n) {
        return (a >= n) ? a - n : a;
    }

    long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        return (b == 0) ? a : gcd(b, a % b);
    }

    long term(long a, long b, int k) {
        return (b - a) / k + 1;
    }

    boolean check1(int k, int rate) {
        return k >= rate;
    }

    int[] polyFWHT(int[] P, boolean inverse) {
        for (int len = 1; 2 * len <= degree(P); len <<= 1) {
            for (int i = 0; i < degree(P); i += 2 * len) {
                for (int j = 0; j < len; j++) {
                    int u = P[i + j];
                    int v = P[i + len + j];
                    P[i + j] = u + v;
                    P[i + len + j] = u - v;
                }
            }
        }

        if (inverse) {
            for (int i = 0; i < degree(P); i++) {
                P[i] = P[i] / degree(P);
            }
        }

        return P;
    }

    int degree(int[] p) {
        return p.length - 1;
    }

    public String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    long max(long a, long b) {
        return Math.max(a, b);
    }

    long min(long a, long b) {
        return Math.min(a, b);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new PolyNo().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
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

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !isSpaceChar(b)) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }
}

class Complex {
    int real;
    int image;
}