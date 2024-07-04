//package CodeJam2020;

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
            int n = ni();
            Pair [] activities = new Pair[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Pair(ni(), ni(), i);
            }

            Arrays.sort(activities, (a1, a2) -> {
                if (a1.x == a2.x) {
                    return a1.y - a2.y;
                }
                return a1.x - a2.x;
            });

            boolean[] isJ = new boolean[n];
            int lastTimeOfJ = 0;
            for (Pair ac : activities) {
                if (ac.x >= lastTimeOfJ) {
                    isJ[ac.index] = true;
                    lastTimeOfJ = ac.y;
                }
            }

            int lastTimeOfC = 0;
            boolean ok = true;
            for (Pair ac : activities) {
                if (!isJ[ac.index]) {
                    if (ac.x < lastTimeOfC) {
                        ok = false;
                        break;
                    } else {
                        lastTimeOfC = ac.y;
                    }
                }

            }
            StringBuilder ans = new StringBuilder();
            if (ok) {

                for (int i = 0; i < n; i++) {
                    if (isJ[i]) {
                        ans.append('J');
                    } else {
                        ans.append('C');
                    }
                }
            } else {
                ans.append("IMPOSSIBLE");
            }
            out.println("Case #" + test + ": " + ans.toString());
        }
    }


    class Pair {
        int x;
        int y;
        int index;

        Pair(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public String toString() {
            return "x: " + x + ", y: " + y;
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