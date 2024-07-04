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

        long abs(long a) { return a >= 0 ? a : -a;}

        private String minL(String a, String b, String c, String d) {
            int l = (int) 1e9; String ret = null;
            if(a != null && a.length() < l) {
                l = a.length(); ret = a;
            }
            if(b != null && b.length() < l) {
                l = b.length(); ret = b;
            }
            if(c != null && c.length() < l) {
                l = c.length(); ret = c;
            }
            if(d != null && d.length() < l) {
                l = d.length(); ret = d;
            }
            return ret;
        }

        private long X, Y;
        private String recur(long x, long y, int i, String tmp) {
            String key = x + ":" + y;
            if(x == X && y == Y) return tmp;
            else if(abs(x) > abs(X) || abs(y) > abs(Y)) return null;

            String ans = recur(x - pow2[i], y, i+1, tmp + 'W');

            String ans1 = recur(x + pow2[i], y, i+1, tmp + 'E');

            String ans2 = recur(x, y- pow2[i], i+1, tmp + 'S');

            String ans3 = recur(x, y + pow2[i], i+1, tmp + 'N');

            return minL(ans, ans1, ans2, ans3);
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int t = 0;
            while (T-- > 0) {
                t++;
                X= sc.nextInt();
                Y = sc.nextInt();
                StringBuilder stringBuilder;
                if(abs(X) % 2 != abs(Y) % 2) {
                    stringBuilder = new StringBuilder();
                    String ans = recur(0, 0, 1, "");
                    if(ans == null) stringBuilder = new StringBuilder("IMPOSSIBLE");
                    else stringBuilder.append(ans);
                } else stringBuilder = new StringBuilder("IMPOSSIBLE");
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