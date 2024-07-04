import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        testCaseLoop: for (int testCase = 1; testCase <= tnum; testCase++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            long[][] f = new long[r+2][c+2];
            long[] level = new long[100002];
            int tid = 1;
            ArrayDeque<Integer> next = new ArrayDeque<Integer>();
            long msum = 0;
            long ans = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    f[i+1][j+1] = sc.nextLong();
                    level[tid] = f[i+1][j+1];
                    msum += f[i+1][j+1];
                    next.add(tid);
                    tid++;
                }
            }
            ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < r; i++) {
                ArrayList<Integer> mrow = new ArrayList<Integer>();
                mrow.add(0);
                for (int j = 0; j < c; j++) {
                    mrow.add(i*c + j + 1);
                }
                mrow.add(100001);
                row.add(mrow);
            }
            ArrayList<ArrayList<Integer>> col = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < c; i++) {
                ArrayList<Integer> mcol = new ArrayList<Integer>();
                mcol.add(0);
                for (int j = 0; j < r; j++) {
                    mcol.add(j*c + i + 1);
                }
                mcol.add(100001);
                col.add(mcol);
            }

            while(!next.isEmpty()){
                ans += msum;
                ArrayDeque<Integer> mnext =new ArrayDeque<Integer>();
                ArrayDeque<Integer[]> remr = new ArrayDeque<>();
                ArrayDeque<Integer[]> remc = new ArrayDeque<>();
                while(!next.isEmpty()){
                    int mid = next.poll();
                    int mr = getR(mid, c);
                    int mc = getC(mid, c);
                    int mrp = Collections.binarySearch(row.get(mr), mid);
                    int mcp = Collections.binarySearch(col.get(mc), mid);
                    int nearsum = 0;
                    int nearnum = 0;
                    int r1 = row.get(mr).get(mrp-1);
                    int r2 = row.get(mr).get(mrp+1);
                    int c1 = col.get(mc).get(mcp-1);
                    int c2 = col.get(mc).get(mcp+1);
                    nearsum += level[r1];
                    nearsum += level[r2];
                    nearsum += level[c1];
                    nearsum += level[c2];
                    if(r1 != 0 && r1 != 100001) nearnum++;
                    if(r2 != 0 && r2 != 100001) nearnum++;
                    if(c1 != 0 && c1 != 100001) nearnum++;
                    if(c2 != 0 && c2 != 100001) nearnum++;
                    if(nearsum > level[mid] * nearnum){
                        msum -= level[mid];
                        if(r1 != 0 && r1 != 100001) mnext.add(r1);
                        if(r2 != 0 && r2 != 100001) mnext.add(r2);
                        if(c1 != 0 && c1 != 100001) mnext.add(c1);
                        if(c2 != 0 && c2 != 100001) mnext.add(c2);
                        remr.add(new Integer[]{mr, mrp});
                        remc.add(new Integer[]{mc, mcp});
                    }
                }
                while(!remr.isEmpty()){
                    Integer[] trem = remr.poll();
                    row.get(trem[0]).remove((int)trem[1]);
                }
                while(!remc.isEmpty()){
                    Integer[] trem = remc.poll();
                    col.get(trem[0]).remove((int)trem[1]);
                }   
                next = mnext;
                
            }

            printAns(testCase, ans + "");   
        }
    }

    private static int getR(int id, int c){
        return (id-1) / c;
    }

    private static int getC(int id, int c){
        return (id - 1) % c;
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