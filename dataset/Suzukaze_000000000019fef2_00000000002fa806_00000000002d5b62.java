//package com.company;

import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {

        boolean on(int a, int i) {
            return (a & (1 << i)) != 0;
        }

        String revA(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c: s.toCharArray()) {
                if (c == 'E') sb.append('W');
                else if (c == 'W') sb.append('E');
                else sb.append(c);
            }
            return sb.toString();
        }
        String revB(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c: s.toCharArray()) {
                if (c == 'S') sb.append('N');
                else if (c == 'N') sb.append('S');
                else sb.append(c);
            }
            return sb.toString();
        }

        boolean check(String s, int a, int b) {
            int v = 1;
            for (char c : s.toCharArray()) {
                if (c == 'E') a -= v;
                if (c == 'W') a += v;
                if (c == 'S') b += v;
                if (c == 'N') b -= v;
                v *= 2;
            }
            return (a == 0 && b == 0);
        }

        String brute(int a, int b) {
            for (int i = 1; i <= 8; i++) {
                for (int j = 0; j < 1 << (2 * i); j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < i; k++) {
                        boolean v = (((1 << (2 * k)) & j) != 0);
                        boolean u = (((1 << (2 * k + 1)) & j) != 0);
                        if (v && u) sb.append('W');
                        if (v && !u) sb.append('E');
                        if (!v && u) sb.append('N');
                        if (!v && !u) sb.append('S');
                    }
                    if (check(sb.toString(), a, b)) return sb.toString();
                }
            }
            return "IMPOSSIBLE";
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            for (int ks = 1; ks <= T; ks++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int oa = a, ob = b;
                boolean revA = a < 0;
                boolean revB = b < 0;
                a = Math.abs(a);
                b = Math.abs(b);
                StringBuilder sb = new StringBuilder();
                boolean canA = false, canB = false;
                boolean mustA = false, mustB = false;
                boolean bad = false;
                for (int i = 0; i <= 30; i++) {
                    if (!mustA && !mustB && 1 << i > a && 1 << i > b) break;
                    if (canA && mustA) throw new RuntimeException();
                    if (canB && mustB) throw new RuntimeException();
                    if (canA && canB) throw new RuntimeException();
                    int va = on(a, i) ? 1: 0;
                    int vb = on(b, i) ? 1: 0;
                    if (mustA) {
                        va++;
                        mustA = false;
                        if (va == 2) {
                            va = 0;
                            mustA = true;
                        }
                    }
                    if (mustB) {
                        vb++;
                        mustB = false;
                        if (vb == 2) {
                            vb = 0;
                            mustB = true;
                        }
                    }
                    if (va == 0 && vb == 0) {
                        if (!canA && !canB) {
                            bad = true; break;
                        }
                        if (canA) {
                            sb.setCharAt(i - 1, 'W');
                            sb.append('E');
                            canA = true;
                        }
                        if (canB) {
                            sb.setCharAt(i - 1, 'S');
                            sb.append( 'N');
                            canB = true;
                        }
                    }
                    if (va == 1 && vb == 0) {
                        canA = true; canB = false;
                        sb.append('E');
                    }
                    if (va == 0 && vb == 1) {
                        canA = false; canB = true;
                        sb.append('N');
                    }
                    if (va == 1 && vb == 1) {
                        if (!canA && !canB) {
                            bad = true; break;
                        }
                        if (canA) {
                            sb.setCharAt(i - 1, 'W');
                            sb.append('N');
                            mustA = true; canA = false; canB = true;
                        } else if (canB) {
                            sb.setCharAt(i - 1, 'S');
                            sb.append( 'E');
                            mustB = true; canB = false; canA = true;
                        }
                    }
                }
//                String bf = brute(oa, ob);
//                if (bf.equals("IMPOSSIBLE") != bad) {
//                    throw new RuntimeException();
//                }
                if (bad) {
                    pw.println("Case #" + ks + ": " + "IMPOSSIBLE");
                } else {
                    String s = sb.toString();
                    if (revA) s = revA(s);
                    if (revB) s = revB(s);
//                    if (!check(s, oa, ob)) {
//                        throw new RuntimeException();
//                    }
                    pw.println("Case #" + ks + ": " + s);
                }
            }
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("input"));
//        pw.println(10000);
//        for (int i = 1; i <= 100; i++) {
//            for (int j = 1; j <= 100; j++) {
//                pw.println(i + " " + j);
//            }
//        }
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