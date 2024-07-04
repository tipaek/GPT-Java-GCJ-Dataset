
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author sguar <shugangcao@gmail.com>
 * strive for greatness
 * Created on 2020-04-04
 */
public class Solution {
    InputStream is;
    PrintWriter out;

    /**
     * *A
     * A*
     * *B*C*D
     * *A*
     */
    void solve() {
        int t = ni();
        for (int test = 1; test <= t; test++) {
            int n = ni();
            System.out.println(n);
            List<String> start = new ArrayList<>();
            List<String> last = new ArrayList<>();

            List<String> other = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = ns();
                //System.out.println(s);
                boolean prefix = true;
                boolean suffix = true;
                if (!s.startsWith("*")) {
                    prefix = false;
                }
                if (!s.endsWith("*")) {
                    suffix = false;
                }

                String[] p = s.split("\\*");
                for (int j = 0; j < p.length; j++) {
                    if (j == 0 && !prefix) {
                        start.add(p[j]);
                    } else if (j == p.length - 1 && !suffix) {
                        last.add(p[j]);
                    } else {
                        other.add(p[j]);
                    }
                    //System.out.println(j + "--"  + p[j]);
                }
            }

            boolean flag = true;
            String maxPrefix = "";
            for (String it : start) {
                //System.out.println("perfix - " + it);
                if (it.startsWith(maxPrefix)) {
                    maxPrefix = it;
                } else if (maxPrefix.startsWith(it)) {
                    //
                } else {
                    flag = false;
                    break;
                }
            }

            String maxSuffix = "";
            for (String it : last) {
                //System.out.println("suffix - " + it + ": " + maxSuffix);
                //System.out.println(it.endsWith(maxSuffix));

                if (it.length() >= maxSuffix.length() && it.endsWith(maxSuffix)) {
                    maxSuffix = it;
                } else if (it.length() < maxSuffix.length() && maxSuffix.endsWith(it)) {
                    //
                } else {
                    flag = false;
                    break;
                }
            }

            StringBuilder ans = new StringBuilder();
            if (!flag) {
                ans.append("*");
            } else {
                ans.append(maxPrefix);
                for (String it : other) {
                    //System.out.println("other - " + it);
                    ans.append(it);
                }
                ans.append(maxSuffix);
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