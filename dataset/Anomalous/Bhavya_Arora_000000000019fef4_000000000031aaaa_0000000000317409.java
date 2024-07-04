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
            int m = ni();
            char[] s = ns().toCharArray();
            int len = s.length;
            long sec = 0;
            long tot = Math.abs(n) + Math.abs(m);
            boolean found = false;

            if (sec >= tot) {
                out.println("Case #" + q + ": " + sec);
                found = true;
            } else {
                for (int i = 0; i < len; i++) {
                    sec++;
                    switch (s[i]) {
                        case 'N':
                            m++;
                            break;
                        case 'S':
                            m--;
                            break;
                        case 'E':
                            n++;
                            break;
                        case 'W':
                            n--;
                            break;
                    }
                    if (sec >= Math.abs(n) + Math.abs(m)) {
                        out.println("Case #" + q + ": " + sec);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                out.println("Case #" + q + ": IMPOSSIBLE");
            }
        }
    }

    private byte[] inputBuffer = new byte[1024];
    private int bufferLength = 0, bufferPointer = 0;

    private int readByte() {
        if (bufferPointer >= bufferLength) {
            bufferPointer = 0;
            try {
                bufferLength = is.read(inputBuffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (bufferLength <= 0) return -1;
        }
        return inputBuffer[bufferPointer++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
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

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -num : num;
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
        while (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -num : num;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private float nf() {
        return Float.parseFloat(ns());
    }

    private int[] nia(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ni();
        }
        return arr;
    }

    private long[] nla(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nl();
        }
        return arr;
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
            if (isSpaceChar(b)) break;
            c[i] = (char) b;
            b = readByte();
        }
        return i == n ? c : Arrays.copyOf(c, i);
    }

    private void printIntArray(int[] arr) {
        for (int value : arr) {
            out.print(value + " ");
        }
        out.println();
    }

    private void printLongArray(long[] arr) {
        for (long value : arr) {
            out.print(value + " ");
        }
        out.println();
    }

    private void printIntMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int value : row) {
                out.print(value);
            }
            out.println();
        }
    }

    private void printLongMatrix(long[][] mat) {
        for (long[] row : mat) {
            for (long value : row) {
                out.print(value);
            }
            out.println();
        }
    }
}