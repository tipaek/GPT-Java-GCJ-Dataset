import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        tc: for (int testCase = 1; testCase <= tnum; testCase++) {
            int n = sc.nextInt();
            String[] p = new String[n];
            String pexact = "0";
            for (int i = 0; i < p.length; i++) {
                p[i] = sc.next();
                if(!p[i].contains("*")){
                    if(pexact.equals("0")){
                        pexact = p[i];
                    }else{
                        if(!pexact.equals(p[i])){
                            printAns(testCase, "*");
                            continue tc;
                        }
                    }
                }
            }

            char[] ans = new char[10000];
            int ansp = 0;
            Arrays.fill(ans, '0');

            if(pexact.equals("0")){
                for (int i = 0; i < p.length; i++) {
                    int hp = 0, tp = p[i].length()-1;
                    if(p[i].charAt(0) != '*'){
                        for ( ; hp < p[i].length(); hp++) {
                            char mpi = p[i].charAt(hp);
                            if(mpi == '*') break;
                            if(ans[hp] == '0'){
                                ans[hp] = mpi;
                            }else if(ans[hp] != mpi){
                                printAns(testCase, "*");
                                continue tc;
                            }
                        }
                    }

                    if(p[i].charAt(p[i].length()-1) != '*'){
                        for ( ; tp >= hp; tp--){
                            char mpi = p[i].charAt(tp);
                            int mansp = ans.length-1-(p[i].length()-1-tp);
                            if(mpi == '*') break;
                            if(ans[mansp] == '0'){
                                ans[mansp] = mpi;
                            }else if(ans[mansp] != mpi){
                                printAns(testCase, "*");
                                continue tc;
                            }
                        }
                    }

                    ansp = Math.max(ansp, hp);
                    for (; hp < tp; hp++){
                        char mpi = p[i].charAt(hp);
                        if(mpi != '*'){
                            ans[ansp] = mpi;
                            ansp++;
                        }
                    }
                }
                    
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.length; i++) {
                    if(ans[i] != '0') sb.append(ans[i]);
                }

                printAns(testCase, sb.toString());
            }else{
                for (int i = 0; i < p.length; i++) {
                    int mp = 0;
                    boolean asta = false;
                    int conts = -1;
                    int contanss = -1;
                    int mansp = 0;
                    while(mp < p[i].length()){
                        char mpi = p[i].charAt(mp);
                        if(mpi == '*'){
                            asta = true;
                            conts = -1;
                        }else{
                            if(conts == -1){
                                conts = mp;
                                contanss = mansp;
                            }
                            if(mpi != pexact.charAt(mansp)){
                                if(!asta){
                                    printAns(testCase, "*");
                                    continue tc;
                                }else{
                                    mp = conts-1;
                                    contanss++;
                                    mansp = contanss-1;
                                }
                            }
                        }
                        mp++;
                        if(mpi != '*') mansp++;
                        if(mp != p[i].length() && mansp == pexact.length()){
                            printAns(testCase, "*");
                            continue tc;
                        }
                    }
                    char mpif = p[i].charAt(p[i].length()-1);
                    if(mpif != '*'){
                        if(mpif != pexact.charAt(pexact.length()-1)){
                            printAns(testCase, "*");
                            continue tc;
                        }
                    }
                }
                
                printAns(testCase, pexact);
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