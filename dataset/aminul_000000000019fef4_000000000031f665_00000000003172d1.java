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
            int n = in.nextInt(), d = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            int res = 0;
            if (d == 2) res = solveTestFor2(n, d, arr);
            else if (d == 3) res = solveTestFor3(n, d, arr);
            pw.println("Case #" + t + ": " + res);
        }

        pw.close();
    }

    static int solveTestFor3(int n, int d, long arr[]) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        boolean isOnePossible = false;
        for (long i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxFreq = 0;
        for (long key : map.keySet()) {
            int freq = map.get(key);
            maxFreq = max(maxFreq, freq);
            if (freq + (map.getOrDefault(key * 2, 0) * 2) >= 3) {
                isOnePossible = true;
            }
            if(freq >= 2 && map.higherKey(key) != null) {
                isOnePossible = true;
            }
        }
        if (maxFreq >= 3) return 0;
        else if (isOnePossible) return 1;
        else return 2;
    }

    static int solveTestFor2(int n, int d, long arr[]) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (long i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxFreq = 0;
        for (long key : map.keySet()) {
            int freq = map.get(key);
            maxFreq = max(maxFreq, freq);
        }
        if (maxFreq >= 2) return 0;
        else return 1;
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