import java.util.*;
import java.io.*;

class ForegonSolution {
    int c;
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    long mod = 1000000007L;
    BinaryTree[] ba;
    BinaryTree[] ba1;
    BinaryTree[] ba2;
    int[] array;

    void solve() throws Exception {
        int t = ni();
        for (int ca = 1; ca <= t; ca++) {
            int n = ni();
            int trace = 0;
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = ni();
                    if (i == j) trace += a[i][j];
                }
            }
            int[][] col = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    col[i][j] = a[j][i];
                }
            }

            int countRow = 0;
            int countCol = 0;
            for (int i = 0; i < n; i++) {
                if (!vestigium(a[i], n)) countRow++;
                if (!vestigium(col[i], n)) countCol++;
            }
            out.println("Case #" + ca + ": " + trace + " " + countRow + " " + countCol);
        }
    }

    boolean vestigium(int[] a, int n) {
        int[] b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[a[i]]++;
            if (b[a[i]] > 1) return false;
        }
        return true;
    }

    long power(long a, int x) {
        String s = Integer.toBinaryString(x);
        long temp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                temp = (temp * a) % mod;
                a = (a * a) % mod;
            }
        }
        return temp;
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
        new ForegonSolution().run();
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

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
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

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }
}

class BinaryTree {
    int key;
    BinaryTree right;
    BinaryTree left;
}

class A {
    int a;
    int b;
}