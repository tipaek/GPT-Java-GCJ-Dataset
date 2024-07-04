import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();
        tc: for (int testCase = 1; testCase <= tnum; testCase++) {

            if(a == 999999995){
                System.out.println("0 0");

            int mx = -7;
            int my = -6;
            while(true){
                String rep = sc.next();
                if(rep.equals("CENTER")){
                    continue tc;
                }else if(rep.equals("HIT")){

                }else{

                }
                mx++;
                if(mx > 6){
                    mx = -7;
                    my++;
                }
                if(my > 6) break;
                System.out.println(mx + " " + my);
            }
            }else{


            System.out.println((-51) + " " + (-50+a));

            int mx = -51;
            int my = -50;
            int phase = 0;
            int edge1 = 0;
            int edge2 = 0;
            while(true){
                String rep = sc.next();
                boolean hit = false;
                if(rep.equals("CENTER")){
                    continue tc;
                }else if(rep.equals("HIT")){
                    hit = true;
                }else{

                }

                if(phase == 0){
                    if(hit){
                        phase = 1;
                        edge1 = mx;
                        mx++;
                    }else{
                        mx++;
                    }
                    System.out.println((mx) + " " + (my + a));
                }else if(phase == 1){
                    if(hit){
                        mx++;
                    }else{
                        phase = 2;
                        edge2 = mx - 1;
                        mx = (edge1+edge2) / 2;
                    }
                    System.out.println((mx) + " " + (my + a));
                }else if(phase == 2){
                    System.out.println((mx) + " " + (my));
                    my++;
                }
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