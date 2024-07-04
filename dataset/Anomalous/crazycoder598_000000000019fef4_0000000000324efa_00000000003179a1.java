import java.util.*;
import java.io.*;

class Solution {
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
            int u = ni();
            long[] a1 = new long[10000];
            String[] s = new String[10000];
            for (int i = 0; i < 10000; i++) {
                a1[i] = nl();
                s[i] = ns();
            }
            char[] a = new char[10];
            int start = 0;
            MergeSort ob = new MergeSort();
            n = 10000;
            ob.sort(a1, s, 0, n - 1);
            Boolean[] b = new Boolean[1000];
            Arrays.fill(b, false);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (!b[s[i].charAt(j)]) {
                        a[start] = s[i].charAt(j);
                        start++;
                        b[s[i].charAt(j)] = true;
                    }
                }
            }
            out.print(Case(i1));
            for (int i = 0; i < 10; i++) out.print(a[i]);
            out.println();
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
        adj[b].add(a);
        adj[a].add(b);
    }

    void dfs(int cur, int prev, int _depth) {
        depth[cur] = _depth;
        par[0][cur] = prev;
        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if (next != prev) {
                dfs(next, cur, _depth + 1);
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
        for (int i = 0; i < MAXLN; i++) {
            if (((diff >> i) & 1) == 1) u = par[i][u];
        }
        if (u == v) return u;
        for (int i = MAXLN - 1; i >= 0; i--) {
            if (par[i][u] != par[i][v]) {
                u = par[i][u];
                v = par[i][v];
            }
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
        return a < 0 ? n - a : a;
    }

    int plus(int a, int n) {
        return a > n - 1 ? a - n : a;
    }

    long gcd(long a, long b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    long term(long a, long b, int k) {
        return (b - a) / k + 1;
    }

    String CAse(int i) {
        return "Case #" + i + ":";
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
                P[i] /= degree(P);
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
        new Solution().run();
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
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
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
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

class MergeSort {
    void merge(long arr[], String[] s, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long[] L = new long[n1];
        long[] R = new long[n2];
        String[] L1 = new String[n1];
        String[] R1 = new String[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            L1[i] = s[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            R1[j] = s[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                s[k] = L1[i];
                i++;
            } else {
                arr[k] = R[j];
                s[k] = R1[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            s[k] = L1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            s[k] = R1[j];
            j++;
            k++;
        }
    }

    void sort(long arr[], String[] s, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, s, l, m);
            sort(arr, s, m + 1, r);
            merge(arr, s, l, m, r);
        }
    }
}