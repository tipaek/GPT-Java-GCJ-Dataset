// package Algorithms.src.google.kickstart;

import java.util.*;
import java.io.*;

public class Solution {
    public static class Task {

        static long[] pow2 = new long[40];
        static {
           pow2[1] = 1;
           for(int i = 2; i < 40; i++) pow2[i] = pow2[i-1] << 1;
        }

        int abs(int a) { return Math.abs(a);}

        private String recurP(int x, int y, int i, String tmp) {
            if(x < 0 || y < 0) return null;
            else if(x == 0 && y == 0) return tmp;
            String ret = recurP(x - (int) pow2[i], y, i + 1, tmp + "E");
            return ret == null ? recurP(x, y- (int) pow2[i], i + 1, tmp + "N") : ret;
        }

        private String recurN(int x, int y, int i, String tmp) {
            if(x > 0 || y > 0) return null;
            else if(x == 0 && y == 0) return tmp;
            String ret = recurN(x + (int) pow2[i], y, i + 1, tmp + "W");
            return ret == null ? recurN(x, y + (int) pow2[i], i + 1, tmp + "S") : ret;
        }

        private String recurXP(int x, int y, int i, String tmp) {
            if(x < 0 || y > 0) return null;
            else if(x == 0 && y == 0) return tmp;
            String ret = recurXP(x - (int) pow2[i], y, i + 1, tmp + "E");
            return ret == null ? recurXP(x, y + (int) pow2[i], i + 1, tmp + "S") : ret;
        }

        private String recurYP(int x, int y, int i, String tmp) {
            if(x > 0 || y < 0) return null;
            else if(x == 0 && y == 0) return tmp;
            String ret = recurYP(x + (int) pow2[i], y, i + 1, tmp + "W");
            return ret == null ? recurYP(x, y - (int) pow2[i], i + 1, tmp + "N") : ret;
        }

        private String recur(int x, int y, int i, String tmp) {
            if(x == 0 && y == 0) return "";
            else if(x >= 0 && y >= 0) return recurP(x, y, i, tmp);
            else if( x <= 0 && y <= 0) return recurN(x, y, i, tmp);
            else if(x>=0 && y <=0) return recurXP(x, y, i, tmp);
            return recurYP(x, y, i, tmp);
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int t = 0;
            while (T-- > 0) {
                t++;
                int x = sc.nextInt();
                int y = sc.nextInt();
                StringBuilder stringBuilder = new StringBuilder("IMPOSSIBLE");
                if(abs(x) % 2 != abs(y) % 2) {
                    stringBuilder = new StringBuilder();
                    long ts = abs(x) + abs(y);
                    long sum = 0l;
                    boolean f = false;
                    for(int i = 0; i < pow2.length; i++) {
                        sum += pow2[i];
                        if(sum == ts) {
                            f = true; break;
                        }
                    }
                    if(f) {
                        if(abs(x) % 2 > 0) {
                            stringBuilder.append(x > 0 ? 'E': 'W');
                            x = x > 0 ? x - 1: x + 1;
                        } else {
                            stringBuilder.append(y > 0 ? 'N': 'S');
                            y = y > 0 ? y -1: y + 1;
                        }
                    } else {
                        if(abs(x) % 2 > 0) {
                            stringBuilder.append(x > 0 ? 'W': 'E');
                            x = x < 0 ? x - 1: x + 1;
                        } else {
                            stringBuilder.append(y > 0 ? 'S': 'N');
                            y = y < 0 ? y -1: y + 1;
                        }
                    }
                    stringBuilder.append(recur(x, y, 2, ""));
                }
                pw.println("Case #" + t + ": " + stringBuilder.toString());
            }

        }



    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("nondec.in"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("nondec.out"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}