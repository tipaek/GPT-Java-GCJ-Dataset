import java.io.*;
import java.util.*;

class Pair {
    int num;
    String res;

    Pair(int a, String b) {
        this.num = a;
        this.res = b;
    }
}

class FFT {

    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int mod = 998244353;

    int[] getCharArray() {
        String s = ns();
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[n - 1 - i] = s.charAt(i) - '0';
        }
        return a;
    }

    int[] addZero(int[] a, int max) {
        int[] max_a = new int[max];
        for (int i = 0; i < max; i++) {
            max_a[i] = (i >= a.length) ? 0 : a[i];
        }
        return max_a;
    }

    void solve() {
        int t = ni();
        for (int loop = 1; loop <= t; loop++) {
            int u = ni();
            Pair[] b = new Pair[10000];
            for (int i = 0; i < 10000; i++) {
                int inp = ni();
                String x = ns();
                b[i] = new Pair(inp, x);
            }
            Arrays.sort(b, Comparator.comparingInt(x -> x.num));
            HashSet<Character> hs = new HashSet<>();
            char[] ct = new char[10];
            for (Pair i : b) {
                if (i.num < 10 && !hs.contains(i.res.charAt(0))) {
                    ct[i.num] = i.res.charAt(0);
                    hs.add(i.res.charAt(0));
                } else {
                    for (char j : i.res.toCharArray()) {
                        if (!hs.contains(j)) {
                            ct[0] = j;
                            hs.add(j);
                        }
                    }
                }
            }
            out.print("Case #" + loop + ": ");
            for (char i : ct) out.print(i);
            out.println();
        }
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
        new FFT().run();
    }

    private void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int[] help = new int[end - start + 1];
        int c = 0;
        while (i <= mid && j <= end) {
            help[c++] = arr[j] < arr[i] ? arr[j++] : arr[i++];
        }
        while (i <= mid) {
            help[c++] = arr[i++];
        }
        while (j <= end) {
            help[c++] = arr[j++];
        }
        System.arraycopy(help, 0, arr, start, help.length);
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

    private int[][] na(int n, int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) a[i][j] = ni();
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

    void display2D(int[][] a) {
        for (int[] row : a) {
            for (int j : row) {
                out.print(j + " ");
            }
            out.println();
        }
    }

    int[][] creategraph(int n, int m) {
        int[][] g = new int[n + 1][];
        int[] from = new int[m];
        int[] to = new int[m];
        int[] ct = new int[n + 1];
        for (int i = 0; i < m; i++) {
            from[i] = ni();
            to[i] = ni();
            ct[from[i]]++;
            ct[to[i]]++;
        }
        for (int i = 0; i < n + 1; i++) g[i] = new int[ct[i]];
        for (int i = 0; i < m; i++) {
            g[from[i]][--ct[from[i]]] = to[i];
            g[to[i]][--ct[to[i]]] = from[i];
        }
        return g;
    }

    static long __gcd(long a, long b) {
        return (b == 0) ? a : __gcd(b, a % b);
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long modInverse(long a, int m) {
        return (__gcd(a, m) != 1) ? -1 : power(a, m - 2, m);
    }

    static long nCrModPFermat(int n, int r, int p, long[] fac) {
        if (r == 0) return 1;
        long t = (fac[n] * modInverse(fac[r], p)) % p;
        return (t * modInverse(fac[n - r], p)) % p;
    }

    private static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}