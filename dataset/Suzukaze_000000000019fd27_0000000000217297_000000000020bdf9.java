//package com.company;


import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            outer:
            for (int tt = 1; tt <= T; tt++) {
                int n = sc.nextInt();
                int[][] pairs = new int[n][3];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        pairs[i][j] = sc.nextInt();
                    }
                    pairs[i][2] = i;
                }
                Arrays.sort(pairs, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });
                char[] ans = new char[n];
                int l1 = -1, l2 = -1;
                for (int i = 0; i < n; i++) {
                    int s = pairs[i][0], e = pairs[i][1];
                    if (s >= l1) {
                        l1 = e;
                        ans[pairs[i][2]] = 'C';
                    } else if (s >= l2) {
                        l2 = e;
                        ans[pairs[i][2]] = 'J';
                    } else {
                        pw.println("Case #" + tt + ": " + "IMPOSSIBLE");
                        continue outer;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(ans[i]);
                }

                pw.println("Case #" + tt + ": " + sb.toString());
            }
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