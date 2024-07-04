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
            long m[] = new long[n];
            String r[] = new String[n];
            for (int i = 0; i < n; i++) {
                m[i] = in.nextLong();
                r[i] = in.next();
            }
            if (u == 2) pw.println("Case #" + t + ": " + solveTest1(m, r));
            else pw.println("Case #" + t + ": " + solveTest2And3(m, r));
            //debug(solveTest2And3(m, r));
        }

        pw.close();
    }

    static String solveTest1(long[] m, String r[]) {
        int n = (int) 1e4;
        TreeSet<String> set[] = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            set[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            set[(int) m[i]].add(r[i]);
        }

        char map[] = new char[10];
        for (int i = 99; i >= 0; i--) {
            set[i + 1].removeAll(set[i]);
            if (set[i + 1].isEmpty()) continue;
            String num = String.valueOf(i + 1);
            String dig = set[i + 1].first();
            if (num.length() != dig.length()) continue;
            for (int j = 0; j < num.length(); j++) {
                map[num.charAt(j) - '0'] = dig.charAt(j);
            }
        }

        return new String(map);
    }

    static String solveTest2And3(long m[], String r[]) {
        int n = (int) 1e4;
        HashSet<Character> set = new HashSet<>();
        int lim[] = new int[250];
        for (int i = 0; i < n; i++) {
            String dig = r[i];
            if (m[i] == -1) {
                for (char c : dig.toCharArray()) {
                    if (lim[c - 'A'] == 0) lim[c - 'A'] = 9;
                }
            } else {
                String num = String.valueOf(m[i]);
                if (num.length() > dig.length()) {
                    for (char c : dig.toCharArray()) {
                        if (lim[c - 'A'] == 0) lim[c - 'A'] = 9;
                    }
                } else {
                    int d = dig.charAt(0) - 'A', v = num.charAt(0) - '0';
                    if (lim[d] == 0) lim[d] = v;
                    else lim[d] = min(lim[d], v);
                    boolean b = true;
                    for(int j = 1; j < dig.length(); j++) {
                        if(b) {
                            d = dig.charAt(i) - 'A'; v = num.charAt(i) - '0';
                            if (lim[d] == 0) lim[d] = v;
                            else lim[d] = min(lim[d], v);
                            b |= num == 0;
                        }
                        
                    }
                }
            }
        }

        List<Pair> g = new ArrayList<>();
        for (int i = 0; i < lim.length; i++) {
            if (lim[i] != 0) g.add(new Pair(lim[i], i));
        }

        Collections.sort(g);
        String res = "";
        for (Pair p : g) {
            res += (char) (p.s + 'A');
            set.add((char) (p.s + 'A'));
        }

        //debug(g);

        /*for (char c = 'A'; c <= 'Z'; c++) {
            if (!set.contains(c) && res.length() < 10) {
                set.add(c);
                res = res + c;
            }
        }*/

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!set.contains(c) && res.length() < 10) {
                set.add(c);
                res += c;
            }
        }

        return res;
    }

    static class Pair implements Comparable<Pair> {
        int f, s;

        Pair(int F, int S) {
            f = F;
            s = S;
        }

        public int compareTo(Pair p) {
            if (f == p.f) return s - p.s;
            return f - p.f;
        }

        public String toString() {
            return f + " " + s;
        }
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