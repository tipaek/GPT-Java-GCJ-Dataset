//package com.company;


import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {
        Scanner sc;
        int ask(int i) {

            System.out.println(i);
            System.out.flush();;
            return sc.nextInt();

        }
//        Random rnd = new Random();
//        int cs;
        boolean test;
//        int[] secret;

        public void solve(Scanner sc) throws IOException {
            this.sc = sc;
            int T = sc.nextInt();
            int B = sc.nextInt();
            outer:
            for (int tt = 1; tt <= T; tt++) {
                int[] loc = new int[B + 1];
                int ques = 1;
                for (int i = 1; i + i <= B + 1; i++) {
                    if (ques > 1 && ques % 10 == 1) {
                        int vj = -1, tj = -1;
                        int wj = -1, sj = -1;
                        for (int j = 1; j < i; j++) {
                            if (tj == -1 && (loc[j] != loc[B + 1 - j])) {
                                tj = 1;
                                vj = j;
                            }
                            if (sj == -1 && (loc[j] == loc[B + 1 - j])) {
                                sj = 1;
                                wj = j;
                            }
                        }
                        if (vj == -1 && wj == -1) throw new RuntimeException();
                        int l1 = vj == -1 ? ask(wj) : ask(vj);
                        int l3 = wj == -1 ? ask(vj) : ask(wj);
                        if (vj == -1) {
                            if (l3 != loc[wj]) {
                                for (int j = 1; j < i; j++) {
                                    loc[j] ^= 1;
                                    loc[B + 1 - j] ^= 1;
                                }
                            }
                        } else if (wj == -1) {
                            if (l1 != loc[vj]) {
                                for (int j = 1; j < i; j++) {
                                    loc[j] ^= 1;
                                    loc[B + 1 - j] ^= 1;
                                }
                            }
                        } else {
                            boolean comp = false, flip = false;
                            if (l3 != loc[wj]) comp = true;
                            flip = ((l1 == loc[vj]) == comp);
                            if (flip) {
                                for (int j = 1; j < i; j++) {
                                    int t = loc[B + 1 - j];
                                    loc[B + 1 - j] = loc[j];
                                    loc[j] = t;
                                }
                            }
                            if (comp) {
                                for (int j = 1; j < i; j++) {
                                    loc[j] ^= 1;
                                    loc[B + 1 - j] ^= 1;
                                }
                            }
                        }
                        ques += 2;
                    }
                    {
                        loc[i] = ask(i);
                        loc[B - i + 1] = ask(B - i + 1);
                        ques += 2;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= B; i++) {
                    sb.append(loc[i]);
                }
                System.out.println(sb.toString());
                System.out.flush();
                String s = sc.next();
                if (s.charAt(0) == 'N') throw new RuntimeException();
//                pw.println("Case #" + tt + ": " + sb.toString());
            }
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
//        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("output"));
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