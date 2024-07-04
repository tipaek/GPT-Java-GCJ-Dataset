//package com.company;


import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            for (int tt = 1; tt <= T; tt++) {
                String s = sc.next();
                pw.println("Case #" + tt + ": " + rec(s.toCharArray(), 0, s.length(), '0').toString());
            }
        }
        public StringBuilder rec(char[] str, int start, int end, int d) {
            if (end == start) return new StringBuilder();
            StringBuilder sb = new StringBuilder();
            int mini = start;
            for (int i = start; i < end; i++) {
                if (str[i] < str[mini]) mini = i;
            }
            StringBuilder left = rec(str, start, mini, str[mini]);
            StringBuilder right = rec(str, mini + 1, end, str[mini]);
            for (int i = d; i < str[mini]; i++) {
                sb.append("(");
            }
            sb.append(left);
            sb.append(str[mini]);
            sb.append(right);
            for (int i = d; i < str[mini]; i++) {
                sb.append(")");
            }
            return sb;
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("output"));
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