

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * @author sguar <shugangcao@gmail.com>
 * strive for greatness
 * Created on 2020-04-04
 */
public class Solution {
    InputStream is;
    PrintWriter out;

    void solve() {
        int t = ni();
        for (int test = 1; test <= t; test++) {
            long l = nl();
            long r = nl();

            long i;
            if (l < r) {
                i = getFastI(r - l);
                r -= count(i);
            } else {
                i = getFastI(l - r);
                l -= count(i);
            }
            //System.out.println("debug i: " + i + ", l : " + l +  " r: " + r);

            i ++ ;
            long ans = 0;
            if (l < r) {
                long a1 = cntLast(l, i);
                //System.out.println(a1);
                l = l - a1 * a1 - a1 * i;
                long a2 = cntFirst(r, i);
                //System.out.println(a2);
                r = r - a2 * (a2 - 1) - a2 * i;

                ans = i + a1 + a2 - 1;

            } else {

                long a1 = cntFirst(l, i);
                l = l - a1 * (a1 - 1) - a1 * i;
                //System.out.println(a1);
                long a2 = cntLast(r, i);
                //System.out.println(a2);
                r = r - a2 * a2 - a2 * i;

                ans = i + a1 + a2 - 1;
            }

            System.out.println("Case #" + test + ": " + ans + " " + l + " " + r);
        }
    }

    private long cntLast(long small, long i) {
        long l = 0;
        long r = 2_000_000_000;

        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (mid * i + mid * mid <= small) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long cntFirst(long big, long i) {
        long l = 0;
        long r = 2_000_000_000;

        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (mid * i + mid * (mid - 1) <= big) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long getFastI(long gap) {
        long l = 0;
        long r = 2_000_000_000;

        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (count(mid) <= gap) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long count(long i) {
        return i * (i + 1) / 2;
    }

    class Pair {
        int x;
        int y;
        int value;

        Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return this.x * 1000 + this.y;
        }

        @Override
        public String toString() {
            return "x: " + x + ", y: " + y + ", value: " + value;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return this.x == p.x && this.y == p.y;
        }
    }

    public static long invl(long a, long mod) {
        long b = mod;
        long p = 1, q = 0;
        while (b > 0) {
            long c = a / b;
            long d;
            d = a;
            a = b;
            b = d % b;
            d = p;
            p = q;
            q = d - c * q;
        }
        return p < 0 ? p + mod : p;
    }


    void run() throws Exception {

        is = System.in;
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private byte[] inbuf = new byte[1024];
    int lenbuf = 0;
    int ptrbuf = 0;

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
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
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
}