//package com.company;

import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {

        Scanner sc;

        int sA, sB, sR;
        boolean test = false;
        int q = 300;

        String ask(int a, int b) {
//            System.err.println(a + " " + b);
            if (test) {
                q--;
                if (q < 0) throw new RuntimeException();
                long da = a - sA, db = b - sB;
                if (da == 0 && db == 0) return "CENTER";
                if (da * da + db * db <= (long) sR * sR) return "HIT";
                return "MISS";
            } else {
                System.out.println(a + " " + b);
                System.out.flush();
                String s = sc.next();
                return s;
            }
        }

        int gLo(int a, int b) {
            int c = a + b;
            if (c < 0) c--;
            return c / 2;
        }
        int gHi(int a, int b) {
            int c = a + b;
            if (c > 0) c++;
            return c / 2;
        }

        public void solve(Scanner sc) throws IOException {
            this.sc = sc;
            Random rnd = new Random();
            int T;
//            test = true;
            if (!test) {
                T = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
            } else {
                T = 1;
                sA = sc.nextInt();
                sB = sc.nextInt();
                sR = sc.nextInt();
            }
            outer:
            for (int ks = 1; ks <= T; ks++) {
                int va = 0, vb = 0;
                while (true) {
                    va = rnd.nextInt(2000000000) - 1000000000;
                    vb = rnd.nextInt(2000000000) - 1000000000;
                    String s = ask(va, vb);
                    if (s.equals("CENTER")) continue outer;
                    if (s.equals("HIT")) break;
                }
                int lo, hi;
                lo = va; hi = 1000000000;
                while (lo < hi) {
                    int mid = gHi(lo, hi);
                    String s = ask(mid, vb);
                    if (s.equals("CENTER")) continue outer;
                    if (s.equals("HIT")) {
                        lo = mid;
                    } else {
                        hi = mid - 1;
                    }
                }
                int aHi = lo;
                lo = -1000000000; hi = va;
                while (lo < hi) {
                    int mid = gLo(lo, hi);
                    String s = ask(mid, vb);
                    if (s.equals("CENTER")) continue outer;
                    if (s.equals("HIT")) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                int aLo = lo;
                va = (aLo + aHi) / 2;

                lo = vb; hi = 1000000000;
                while (lo < hi) {
                    int mid = gHi(lo, hi);
                    String s = ask(va, mid);
                    if (s.equals("CENTER")) continue outer;
                    if (s.equals("HIT")) {
                        lo = mid;
                    } else {
                        hi = mid - 1;
                    }
                }
                int bHi = lo;
                lo = -1000000000; hi = vb;
                while (lo < hi) {
                    int mid = gLo(lo, hi);
                    String s = ask(va, mid);
                    if (s.equals("CENTER")) continue outer;
                    if (s.equals("HIT")) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                int bLo = lo;
                vb = (bLo + bHi) / 2;
                String s = ask(va, vb);
                if (!s.equals("CENTER")) throw new RuntimeException();
            }
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
//        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("input"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
//        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

//    static class Scanner {
//        StringTokenizer st;
//        BufferedReader br;
//
//        public Scanner(InputStream s) {
//            br = new BufferedReader(new InputStreamReader(s));
//        }
//
//        public Scanner(FileReader s) throws FileNotFoundException {
//            br = new BufferedReader(s);
//        }
//
//        public String next() throws IOException {
//            while (st == null || !st.hasMoreTokens())
//                st = new StringTokenizer(br.readLine());
//            return st.nextToken();
//        }
//
//        public int nextInt() throws IOException {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() throws IOException {
//            return Long.parseLong(next());
//        }
//
//        public String nextLine() throws IOException {
//            return br.readLine();
//        }
//
//        public double nextDouble() throws IOException {
//            return Double.parseDouble(next());
//        }
//
//        public boolean ready() throws IOException {
//            return br.ready();
//        }
//    }
}