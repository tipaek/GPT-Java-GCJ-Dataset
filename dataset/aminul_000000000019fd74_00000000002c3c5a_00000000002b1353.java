/**
 * Created by Aminul on 4/11/2020.
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
            long n = in.nextInt();
            List<int[]> res = solve2(n);
            /*if(res.size() > 500) {
                debug(n);
            }*/
            pw.println("Case #" + t + ":");
            for (int a[] : res) pw.println(a[0] + " " + a[1]);
        }

        pw.close();
    }

    static List<int[]> solve(long n) {
        List<int[]> res = new ArrayList<>();
        long sum = 1;
        int len = 1;
        int r = 1, c = 1, dir = 1;
        while (n > 0) {
            //debug(n, sum);
            if (n >= sum) {
                for (int i = 1; i <= len; i++) {
                    res.add(new int[]{r, c});
                    c += dir;
                }
                if (c <= 0) c = 1;
                r++;
                n -= sum;
                dir *= -1;
                sum *= 2;
                len++;
            } else {
                while (n > 0) {
                    res.add(new int[]{r++, c});
                    n--;
                    if (dir == -1) c++;
                }
            }
        }
        return res;
    }

    static List<int[]> solve2(long n) {
        int row = 1;
        long sum = 1;
        int dir = 0;
        List<int[]> res = new ArrayList<>();
        while (n > 0) {
            if (n > sum) {
                if (dir == 0) {
                    for (int i = 1; i <= row; i++) {
                        res.add(new int[]{row, i});
                    }
                } else {
                    for (int i = row; i >= 1; i--) {
                        res.add(new int[]{row, i});
                    }
                }
                n -= sum;
                dir ^= 1;
            } else {
                if (dir == 0)
                    res.add(new int[]{row, row});
                else
                    res.add(new int[]{row, 1});
                n--;
            }
            row++;
            sum *= 2;
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