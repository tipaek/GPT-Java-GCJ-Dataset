import java.io.*;
import java.util.*;

public class Solution {

    InputStream is;
    PrintWriter o;

    static boolean isPowerOfTwo(long x) {
        return x != 0 && ((x & (x - 1)) == 0L);
    }

    void solve() {
        int t = ni();
        for (int q = 1; q <= t; q++) {
            long x = nl();
            long y = nl();
            String res = "";

            if (isPowerOfTwo(Math.abs(x) + 1)) {
                res = handleXCase(x, y, res);
            } else if (isPowerOfTwo(Math.abs(y) + 1)) {
                res = handleYCase(x, y, res);
            }

            o.println("Case #" + q + ": " + (res.isEmpty() ? "IMPOSSIBLE" : res));
        }
    }

    private String handleXCase(long x, long y, String res) {
        if (y == 0) {
            res = processX(x, res);
        } else if (isPowerOfTwo(Math.abs(y)) && (long) (Math.pow(2, (Math.log(Math.abs(y)) / Math.log(2))) - 1) == Math.abs(x)) {
            res = processXY(x, y, res);
        } else {
            res = processXSum(x, y, res);
        }
        return res;
    }

    private String processX(long x, String res) {
        long num = 1;
        while (x != 0) {
            res += (x > 0) ? "E" : "W";
            x += (x > 0) ? -num : num;
            num *= 2;
        }
        return res;
    }

    private String processXY(long x, long y, String res) {
        long num = 1;
        while (x != 0) {
            res += (x > 0) ? "E" : "W";
            x += (x > 0) ? -num : num;
            num *= 2;
        }
        res += (y > 0) ? "N" : "S";
        return res;
    }

    private String processXSum(long x, long y, String res) {
        long pow = (long) (Math.log(Math.abs(x) + 1) / Math.log(2));
        long sum = 0;
        for (int i = 1; i <= pow - 1; i++) {
            sum += (long) Math.pow(2, i);
        }
        if (sum == y || sum == -y) {
            res = handleSumCase(x, y, res, pow);
        }
        return res;
    }

    private String handleSumCase(long x, long y, String res, long pow) {
        int f1 = 0;
        if (x < 0) {
            f1 = 1;
            res += "E";
        } else {
            res += "W";
        }

        int f2 = 0;
        if (y < 0) {
            f2 = 1;
        }

        for (int i = 1; i < pow; i++) {
            res += (f2 == 1) ? "S" : "N";
        }

        res += (f1 == 0) ? "E" : "W";
        return res;
    }

    private String handleYCase(long x, long y, String res) {
        if (x == 0) {
            res = processY(y, res);
        } else if (isPowerOfTwo(Math.abs(x)) && (long) (Math.pow(2, (Math.log(Math.abs(x)) / Math.log(2))) - 1) == Math.abs(y)) {
            res = processYX(x, y, res);
        } else {
            res = processYSum(x, y, res);
        }
        return res;
    }

    private String processY(long y, String res) {
        long num = 1;
        while (y != 0) {
            res += (y > 0) ? "N" : "S";
            y += (y > 0) ? -num : num;
            num *= 2;
        }
        return res;
    }

    private String processYX(long x, long y, String res) {
        long num = 1;
        while (y != 0) {
            res += (y > 0) ? "N" : "S";
            y += (y > 0) ? -num : num;
            num *= 2;
        }
        res += (x > 0) ? "E" : "W";
        return res;
    }

    private String processYSum(long x, long y, String res) {
        long pow = (long) (Math.log(Math.abs(y) + 1) / Math.log(2));
        long sum = 0;
        for (int i = 1; i <= pow - 1; i++) {
            sum += (long) Math.pow(2, i);
        }
        if (sum == x || sum == -x) {
            res = handleSumCaseY(x, y, res, pow);
        }
        return res;
    }

    private String handleSumCaseY(long x, long y, String res, long pow) {
        int f1 = 0;
        if (y < 0) {
            f1 = 1;
            res += "N";
        } else {
            res += "S";
        }

        int f2 = 0;
        if (x < 0) {
            f2 = 1;
        }

        for (int i = 1; i < pow; i++) {
            res += (f2 == 1) ? "W" : "E";
        }

        res += (f1 == 0) ? "N" : "S";
        return res;
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        is = System.in;
        o = new PrintWriter(System.out);
        solve();
        o.flush();
    }

    byte[] input = new byte[1024];
    int len = 0, ptr = 0;

    int readByte() {
        if (ptr >= len) {
            ptr = 0;
            try {
                len = is.read(input);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (len <= 0) {
                return -1;
            }
        }
        return input[ptr++];
    }

    boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    int skip() {
        int b = readByte();
        while (b != -1 && isSpaceChar(b)) {
            b = readByte();
        }
        return b;
    }

    char nc() {
        return (char) skip();
    }

    String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    String nLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b) && b != ' ')) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    int ni() {
        int n = 0;
        int b = readByte();
        boolean minus = false;
        while (b != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            b = readByte();
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b == -1) {
            return -1;
        }
        while (b >= '0' && b <= '9') {
            n = n * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -n : n;
    }

    long nl() {
        long n = 0L;
        int b = readByte();
        boolean minus = false;
        while (b != -1 && !((b >= '0' && b <= '9') || b == '-')) {
            b = readByte();
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (b >= '0' && b <= '9') {
            n = n * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -n : n;
    }

    double nd() {
        return Double.parseDouble(ns());
    }

    float nf() {
        return Float.parseFloat(ns());
    }

    int[] nia(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    long[] nla(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
        return a;
    }

    int[][] nim(int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ni();
            }
        }
        return mat;
    }

    long[][] nlm(int n) {
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = nl();
            }
        }
        return mat;
    }

    char[] ns(int n) {
        char[] c = new char[n];
        int i, b = skip();
        for (i = 0; i < n; i++) {
            if (isSpaceChar(b)) {
                break;
            }
            c[i] = (char) b;
            b = readByte();
        }
        return i == n ? c : Arrays.copyOf(c, i);
    }

    void piarr(int[] arr) {
        for (int value : arr) {
            o.print(value + " ");
        }
        o.println();
    }

    void plarr(long[] arr) {
        for (long value : arr) {
            o.print(value + " ");
        }
        o.println();
    }

    void pimat(int[][] mat) {
        for (int[] row : mat) {
            for (int elem : row) {
                o.print(elem);
            }
            o.println();
        }
    }

    void plmat(long[][] mat) {
        for (long[] row : mat) {
            for (long elem : row) {
                o.print(elem);
            }
            o.println();
        }
    }
}