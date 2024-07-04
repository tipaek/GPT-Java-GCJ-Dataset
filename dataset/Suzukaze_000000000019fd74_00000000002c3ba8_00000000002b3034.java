//package com.company;


import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {
        String next = null;
        public boolean recur(char[] s1, char[] s2, int n1, int n2, StringBuilder bt, boolean[][] visit) {
            if (n1 == -1 && n2 == -1) {
                next = bt.reverse().toString();
                return true;
            }
            if (visit[n1 + 1][n2 + 1]) return false;
            visit[n1 + 1][n2 + 1] = true;
            if (n1 == -1 && s2[n2] == '*') return recur(s1, s2, n1, n2 - 1, bt, visit);
            if (n2 == -1 && s1[n1] == '*') return recur(s1, s2, n1 - 1, n2, bt, visit);
            if (n1 == -1 || n2 == -1) return false;
            if (s1[n1] == '*' && s2[n2] == '*') {
                if (recur(s1, s2, n1 - 1, n2, bt, visit)) return true;
                return recur(s1, s2, n1, n2 - 1, bt, visit);
            } else {
                if (s1[n1] == '*') {
                    if (recur(s1, s2, n1 - 1, n2, bt, visit)) return true;
                    bt.append(s2[n2]);
                    if (recur(s1, s2, n1, n2 - 1, bt, visit)) return true;
                    bt.deleteCharAt(bt.length() - 1);
                }
                if (s2[n2] == '*') {
                    if (recur(s1, s2, n1, n2 - 1, bt, visit)) return true;
                    bt.append(s1[n1]);
                    if (recur(s1, s2, n1 - 1, n2, bt, visit)) return true;
                    bt.deleteCharAt(bt.length() - 1);
                }
                if (s1[n1] == s2[n2]) {
                    bt.append(s1[n1]);
                    if (recur(s1, s2, n1 - 1, n2 - 1, bt, visit)) return true;
                    bt.deleteCharAt(bt.length() - 1);
                }
            }

            return false;
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int ks = 0;
            outer:
            while (T-- > 0) {
                ks++;
                int n = sc.nextInt();
                String[] ss = new String[n];
                for (int i = 0; i < n; i++) {
                    ss[i] = sc.next();
                }
                for (int i = 1; i < n; i++) {
                    next = null;
                    recur(ss[i - 1].toCharArray(), ss[i].toCharArray(), ss[i - 1].length() - 1, ss[i].length() - 1, new StringBuilder(), new boolean[ss[i - 1].length() + 1][ss[i].length() + 1]);
                    if (next != null) {
                        ss[i] = next;
                    } else {
                        pw.println("Case #" + ks + ": " + "*");
                        continue outer;
                    }
                }
                pw.println("Case #" + ks + ": " + ss[n - 1]);
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
        //System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        //System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
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