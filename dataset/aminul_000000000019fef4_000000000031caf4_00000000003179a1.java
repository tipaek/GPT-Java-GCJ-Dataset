/**
 * Created by Aminul on 5/2/2020.
 */

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int u = in.nextInt();
            int n = (int) 1e4;
            int m[] = new int[n];
            String r[] = new String[n];
            for (int i = 0; i < n; i++) {
                m[i] = in.nextInt();
                r[i] = in.next();
            }
            pw.println("Case #" + t + ": " + solveTest1(m, r));
        }

        pw.close();
    }

    static String solveTest1(int m[], String r[]) {
        int n = (int) 1e4;
        TreeSet<String> set[] = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            set[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            set[m[i]].add(r[i]);
        }

        char map[] = new char[10];
        for (int i = n - 2; i >= 0; i--) {
            set[i + 1].removeAll(set[i]);
            if(set[i + 1].isEmpty()) continue;
            String num = String.valueOf(i + 1);
            String dig = set[i + 1].first();
            if(num.length() != dig.length()) continue;
            for (int j = 0; j < num.length(); j++) {
                map[num.charAt(j) - '0'] = dig.charAt(j);
            }
        }

        return new String(map);
    }

    static String solveTest1(int u, int m[], String r[]) {
        int n = (int) 1e4;
        String res = "";
        String map[] = new String[10];
        Arrays.fill(map, "");
        for (int i = 0; i < n; i++) {
            if (m[i] == 1) debug(r[i]);
            if (m[i] == 1) {
                debug(m[i], r[i]);
                res += r[i];
                map[1] = r[i];
                break;
            }
        }

        for (int digit = 2; digit <= 9; digit++) {
            for (int i = 0; i < n; i++) {
                if (m[i] == digit) {
                    boolean ok = true;
                    for (int j = 1; j <= digit - 1; j++) {
                        if (map[j].equals(r[i])) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    res += r[i];
                    map[1] = r[i];
                    break;
                }
            }
        }


        return res;
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
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

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }


        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
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
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}