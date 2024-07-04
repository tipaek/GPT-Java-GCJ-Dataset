import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        testCaseLoop: for (int testCase = 1; testCase <= tnum; testCase++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);

            long ans = d-1;
            for (int i = 0; i < a.length; i++) {
                for (int j = 1; j <= d; j++) {
                    if(a[i] % j != 0) continue;
                    long can = a[i] / j;
                    int md = d - j;
                    long mans = j-1;
                    long coef = 1;
                    long rem = 0;
                    for (int k = 0; k < a.length; k++) {
                        if(k == i) continue;
                        boolean use = false;
                        if(md >= coef){
                            if(can * coef == a[k]){
                                md -= coef;
                                mans += coef -1;
                                use = true;
                            }else if(can * coef < a[k]){
                                coef = a[k] / can + 1;
                            }
                        }
                        if(!use){
                            rem += a[k] / can;
                        }
                    }

                    if(md > 0){
                        if(md > rem){
                            continue;
                        }else{
                            mans += md;
                        }
                    }
                    ans = Math.min(ans, mans);
                }
            }

            printAns(testCase,  ans + " ");
        }
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