import java.io.*;
import java.util.*;

public class Solution {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }

        public int compareTo(Pair p) {
            if (this.x != p.x) {
                return this.x - p.x;
            } else {
                return this.y - p.y;
            }
        }

        public int hashCode() {
            return (x + " " + y).hashCode();
        }

        public String toString() {
            return x + " " + y;
        }

        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return p.x == this.x && p.y == this.y;
            }
            return false;
        }
    }

    void solve() throws Exception {
        int t = ni();
        for (int z = 1; z <= t; ++z) {
            int x = ni();
            int y = ni();
            boolean xneg = x < 0;
            boolean yneg = y < 0;
            if (xneg) x = -x;
            if (yneg) y = -y;

            StringBuilder result = new StringBuilder("IMPOSSIBLE");
            for (int i = 1; i <= 390624; ++i) {
                String num = Integer.toString(i, 5);
                if (num.contains("0")) continue;

                char[] str = num.toCharArray();
                StringBuilder sb = new StringBuilder();
                int gx = 0, gy = 0;
                for (int j = 0; j < str.length; ++j) {
                    switch (str[j]) {
                        case '1':
                            gx += (1 << j);
                            sb.append("E");
                            break;
                        case '2':
                            gx -= (1 << j);
                            sb.append("W");
                            break;
                        case '3':
                            gy += (1 << j);
                            sb.append("N");
                            break;
                        case '4':
                            gy -= (1 << j);
                            sb.append("S");
                            break;
                    }
                }

                if (x == gx && y == gy) {
                    if (result.toString().equals("IMPOSSIBLE") || result.length() > sb.length()) {
                        result = sb;
                    }
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                char[] str = result.toString().toCharArray();
                if (xneg) {
                    for (int i = 0; i < str.length; ++i) {
                        if (str[i] == 'E') str[i] = 'W';
                        else if (str[i] == 'W') str[i] = 'E';
                    }
                }
                if (yneg) {
                    for (int i = 0; i < str.length; ++i) {
                        if (str[i] == 'N') str[i] = 'S';
                        else if (str[i] == 'S') str[i] = 'N';
                    }
                }
                result = new StringBuilder(new String(str));
            }

            pn("Case #" + z + ": " + result);
        }
    }

    void print(Object o) {
        System.out.println(o);
        System.out.flush();
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void pn(Object o) {
        out.println(o);
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
}