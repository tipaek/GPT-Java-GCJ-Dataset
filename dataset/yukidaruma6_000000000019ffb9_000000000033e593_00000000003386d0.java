import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        testCaseLoop: for (int testCase = 1; testCase <= tnum; testCase++) {
            int n = sc.nextInt();
            long[][] hole = new long[n][2];
            for (int i = 0; i < hole.length; i++) {
                hole[i][0] = sc.nextLong();
                hole[i][1] = sc.nextLong();
            }

            if(n <= 3){
                printAns(testCase, n + "");
                continue testCaseLoop;
            }else{
                int maxComb = 0;
                for (int h1 = 0; h1 < n; h1++) {
                    for (int h2 = 0; h2 < n; h2++) {
                        if(h1 == h2) continue;
                        long[] dir1 = makedir(hole[h1], hole[h2]);
                        for (int h3 = 0; h3 < n; h3++) {
                            if(h3 == h1 || h3 == h2) continue;
                            for (int h4 = 0; h4 < n; h4++) {
                                if(h4 == h1 || h4 == h2 || h4 == h3) continue;
                                long[] dir2 = makedir(hole[h3], hole[h4]);
                                if(sameDir(dir1, dir2)) maxComb = Math.max(maxComb, 1);
                                for (int h5 = 0; h5 < n; h5++) {
                                    if(h5 == h1 || h5 == h2 || h5 == h3 || h5 == h4) continue;
                                    for (int h6 = 0; h6 < n; h6++) {
                                        if(h6 == h1 || h6 == h2 || h6 == h3 || h6 == h4 || h6 == h5) continue;
                                        long[] dir3 = makedir(hole[h5], hole[h6]);
                                        if(sameDir(dir2, dir3)) maxComb = Math.max(maxComb, 1);
                                        if(sameDir(dir1, dir3)) maxComb = Math.max(maxComb, 1);
                                        if(sameDir(dir1, dir2) || sameDir(dir2, dir3)) maxComb = Math.max(maxComb, 2);
                                    }
                                }
                            }
                        }
                    }
                }
                printAns(testCase, Math.min(n, maxComb * 2 + 4) + "");
            }
        }
    }

    public static long[] makedir(long[] a, long[] b){
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];

        long mdx = Math.abs(dx);
        long mdy = Math.abs(dy);

        if(dx == 0){
            return new long[]{0, 1};
        }
        if(dy == 0){
            return new long[]{1, 0};
        }


        long tmp;
        if(mdy > mdx){
            tmp = mdx;
            mdx = mdy;
            mdy = tmp;
        }

        while((tmp = mdx % mdy) != 0){
            mdx = mdy;
            mdy = tmp;
        }

        dx /= mdy;
        dy /= mdy;

        if(dx < 0 && dy < 0){
            dx = -dx;
            dy = -dy;
        }else if(dx < 0){
            dx = -dx;
            dy = -dy;
        }

        return new long[]{dx, dy};
    }

    public static boolean sameDir(long[] a, long[] b){
        return (a[0] == b[0] && a[1] == b[1]);
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