import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        tc: for (int testCase = 1; testCase <= tnum; testCase++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long m1, m2, m3;

            if(l > r){
                long x = l - r;
                m1 = calcm(1, 1, 0, 2*x);
                l -= m1 * (m1 + 1) / 2;
                m2 = calcm(1, m1, 0, r);
                m3 = calcm(1, m1+1, 0, l);
                if(m3 > m2) m3 = m2;
                if(l == r){
                    l -= m2 * (m1+1) + m2 * (m2-1);
                    r -= m3 * (m1+2) + m3 * (m3-1); 
                }else{
                    r -= m2 * (m1+1) + m2 * (m2-1);
                    l -= m3 * (m1+2) + m3 * (m3-1);
                }

            }else{
                long x = r - l;
                m1 = calcm(1, 1, 0, 2*x);
                r -= m1 * (m1 + 1) / 2;
                m2 = calcm(1, m1, 0, l);
                m3 = calcm(1, m1+1, 0, r);
                if(m3 > m2) m3 = m2;
                l -= m2 * (m1+1) + m2 * (m2-1);
                r -= m3 * (m1+2) + m3 * (m3-1);
            }
            printAns(testCase, (m1+m2+m3) + " " + l + " " + r);
        }
    }

    public static long calcm(long a, long b, long c, long x){
        long mans = (-b + (long)Math.sqrt(b * b - 4 * a * (c-x))) / (2 * a) - 1;
        if(mans < 0) mans = 0;
        while(a * (mans+1) * (mans+1) + b * (mans + 1) + c <= x){
            mans++;
        }
        return mans;
    }

    private static void printAns(int testCase, String ans){
        System.out.println("Case #" + testCase + ": " + ans);
    }

    private static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte())
                return buffer[ptr++];
            else
                return -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr]))
                ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext())
                throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
                throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}