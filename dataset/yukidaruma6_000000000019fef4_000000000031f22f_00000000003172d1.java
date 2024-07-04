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

            int[] same = new int[n];
            int[] dbl = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < dbl.length; j++) {
                    if(a[i] == a[j]){
                        same[i]++;
                    }
                    if(a[i] * 2 == a[j]){
                        dbl[j]++;
                    }
                }
            }

            int maxSame = 0;
            int maxSamePos = 0;
            int maxDbl = 0;
            for (int i = 0; i < n; i++) {
                if(maxSame < same[i]){
                    maxSame = same[i];
                    maxSamePos = i;
                }
                maxDbl = Math.max(dbl[i], maxDbl);
            }

            boolean hasLarger = false;
            for (int i = 0; i < n; i++) {
                if(a[i] > a[maxSamePos]) hasLarger = true;
            }

            if(d == 2){
                if(maxSame >= 2){
                    printAns(testCase, "0");
                }else{
                    printAns(testCase, "1");
                }
            }else{
                if(maxSame >= 3){
                    printAns(testCase, "0");
                }else if(maxSame >= 2 && hasLarger){
                    printAns(testCase, "1");
                }else if(maxDbl >= 1){
                    printAns(testCase, "1");
                }else{
                    printAns(testCase, "2");
                }
            }
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