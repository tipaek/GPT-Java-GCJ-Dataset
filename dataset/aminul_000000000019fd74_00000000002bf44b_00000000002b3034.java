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
            int n = in.nextInt();
            char[][] s = new char[n][];
            for (int i = 0; i < n; i++) {
                s[i] = in.next().toCharArray();
            }

            pw.println("Case #" + t + ": " + solve(n, s));
        }

        pw.close();
    }

    static String solve(int n, char[][] s) {
        int pref[] = new int[n], suf[] = new int[n];
        int prefId = -1, sufId = -1;
        int maxPref = 0, maxSuf = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (char c : s[i]) {
                if (c == '*') break;
                pref[i]++;
                cnt++;
            }
            if (cnt > maxPref) {
                maxPref = cnt;
                prefId = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            suf[i] = s[i].length - 1;
            for (int j = s[i].length - 1; j >= 0; j--) {
                char c = s[i][j];
                if (c == '*') break;
                suf[i]--;
                cnt++;
            }
            //debug(s[i], cnt);
            if (cnt > maxSuf) {
                maxSuf = cnt;
                sufId = i;
            }
        }

        /*debug(pref);
        debug(suf);
        debug(prefId, sufId);
        debug(maxPref, maxSuf);*/

        if (prefId != -1) {
            for (char[] b : s) {
                if (!prefixCheck(maxPref, s[prefId], b)) return "*";
            }
        }

        if (sufId != -1) {
            for (char[] b : s) {
                if (!suffixCheck(maxSuf, s[sufId], b)) return "*";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxPref; i++) {
            sb.append(s[prefId][i]);
        }
        for (int i = 0; i < n; i++) {
            for (int k = pref[i] + 1; k < suf[i]; k++) {
                if (s[i][k] != '*') sb.append(s[i][k]);
            }
        }
        if (sufId != -1) {
            for (int i = suf[sufId] + 1; i < s[sufId].length; i++) {
                sb.append(s[sufId][i]);
            }
        }

        return sb.toString();
    }

    static boolean prefixCheck(int maxPref, char[] a, char[] b) {
        for (int i = 0; i < a.length && i < b.length && i < maxPref; i++) {
            if (b[i] == '*') break;
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static boolean suffixCheck(int maxSuf, char[] a, char[] b) {
        for (int i = 0, j = a.length - 1, k = b.length - 1; j >= 0 && k >= 0 && i < maxSuf; i++, j--, k--) {
            if (b[k] == '*') break;
            if (a[j] != b[k]) return false;
        }
        return true;
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