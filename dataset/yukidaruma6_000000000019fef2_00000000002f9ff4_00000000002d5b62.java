import java.util.*;
import java.io.*;

public class Solution {

    static ArrayList<Integer> gans;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        tc: for (int testCase = 1; testCase <= tnum; testCase++) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            gans = new ArrayList<Integer>();
            for (int i = 0; i < 40; i++) {
                gans.add(1);
            }

            System.out.print("Case #" + testCase + ": ");
            dfs(x, y, new ArrayList<Integer>());
            if(gans.size() < 38){
                for(int mmove : gans){
                    switch(mmove){
                        case 0:
                        System.out.print("N");
                        break;
                        case 1:
                        System.out.print("E");
                        break;
                        case 2:
                        System.out.print("S");
                        break;
                        case 3:
                        System.out.print("W");
                        break;
                    }
                }
                System.out.println("");
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static boolean dfs(long mx, long my, ArrayList<Integer> move){
        if(move.size() > 35) return false;
        if(mx == 0 && my== 0){
            if(move.size() < gans.size()) gans = move;
        }
        boolean ret = false;
        long jumpl = 1L << move.size();
        long mmx = Math.abs(mx);
        long mmy = Math.abs(my);
        ArrayList<Integer> next1 = (ArrayList<Integer>)move.clone();
        ArrayList<Integer> next2 = (ArrayList<Integer>)move.clone();
        if(mmy % (jumpl * 2) == jumpl && mmx % (jumpl * 2) == 0){
            next1.add(0);
            next2.add(2);
            ret = dfs(mx, my-jumpl, next1) || dfs(mx, my+jumpl, next2);
        }else if(mmx % (jumpl * 2) == jumpl && mmy % (jumpl * 2) == 0){
            next1.add(1);
            next2.add(3);
            ret = dfs(mx-jumpl, my, next1) || dfs(mx+jumpl, my, next2);
        }else{
            ret = false;
        }
        return ret;
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