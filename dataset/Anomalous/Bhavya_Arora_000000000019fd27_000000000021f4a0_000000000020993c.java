import java.io.*;
import java.util.*;

public class Solution {

    private InputStream is;
    private PrintWriter out;

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        is = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    private void solve() {
        int t = ni();
        for (int q = 1; q <= t; q++) {
            int n = ni();
            int[][] arr = new int[n][n];
            long sum = 0;
            long rowCount = 0;
            long colCount = 0;

            int[] chk = new int[n + 1];
            for (int i = 0; i < n; i++) {
                boolean rowDuplicate = false;
                Arrays.fill(chk, 0);

                for (int j = 0; j < n; j++) {
                    arr[i][j] = ni();

                    if (!rowDuplicate && chk[arr[i][j]] != 0) {
                        rowDuplicate = true;
                        rowCount++;
                    }
                    chk[arr[i][j]]++;
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                boolean colDuplicate = false;
                Arrays.fill(chk, 0);

                for (int i = 0; i < n; i++) {
                    if (!colDuplicate && chk[arr[i][j]] != 0) {
                        colDuplicate = true;
                        colCount++;
                    }
                    chk[arr[i][j]]++;
                }
            }

            out.println("Case #" + q + ": " + sum + " " + rowCount + " " + colCount);
        }
    }

    private byte[] input = new byte[1024];
    private int len = 0, ptr = 0;

    private int readByte() {
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

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b = readByte();
        while (b != -1 && isSpaceChar(b)) {
            b = readByte();
        }
        return b;
    }

    private int ni() {
        int n = 0;
        int b = readByte();
        boolean minus = false;
        while (b != -1 && !(b >= '0' && b <= '9') && b != '-') {
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

    private long nl() {
        long n = 0;
        int b = readByte();
        boolean minus = false;
        while (b != -1 && !(b >= '0' && b <= '9') && b != '-') {
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

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private String nLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b) && b != ' ')) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private int[] nia(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    private long[] nla(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
        return a;
    }

    private int[][] nim(int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ni();
            }
        }
        return mat;
    }

    private long[][] nlm(int n) {
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = nl();
            }
        }
        return mat;
    }

    private char[] ns(int n) {
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

    private void piarr(int[] arr) {
        for (int i : arr) {
            out.print(i + " ");
        }
        out.println();
    }

    private void plarr(long[] arr) {
        for (long l : arr) {
            out.print(l + " ");
        }
        out.println();
    }

    private void pimat(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                out.print(val);
            }
            out.println();
        }
    }

    private void plmat(long[][] mat) {
        for (long[] row : mat) {
            for (long val : row) {
                out.print(val);
            }
            out.println();
        }
    }
}