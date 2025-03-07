import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        tc: for (int testCase = 1; testCase <= tnum; testCase++) {
            int u = sc.nextInt();
            int[] num = new int[26];
            Arrays.fill(num, -1);
            for (int i = 0; i < 10000; i++) {
                long q = sc.nextLong();
                String s = sc.next();
                num[s.charAt(0) - 'A']++;
                // for (int j = 0; j < s.length(); j++) {
                //     num[s.charAt(j) - 'A']++;
                // }
                if(s.length() > 1 && num[s.charAt(1) - 'A'] == -1) num[s.charAt(1) - 'A'] = 0;
            }


            char[] ans = new char[10];
            for (int i = 0; i < ans.length; i++) {
                int mmax = -1;
                int maxpos = 0;
                for (int j = 0; j < num.length; j++) {
                    if(num[j] > mmax){
                        mmax = num[j];
                        maxpos = j;
                    }
                }
                ans[i] = (char)(maxpos + 'A');
                num[maxpos] = -1;
            }

            String sans = "" + ans[9];
            for (int i = 0; i < 9; i++) {
                sans += ans[i];
            }

            printAns(testCase, sans);
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