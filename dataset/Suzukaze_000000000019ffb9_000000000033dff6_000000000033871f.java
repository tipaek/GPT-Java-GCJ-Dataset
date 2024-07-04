//package com.company;

import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            outer:
            for (int ks = 1; ks <= T; ks++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[] vals = new int[n];
                for (int i = 1; i < n; i++) {
                    vals[i] = sc.nextInt();
                }
                List<Integer>[] edges = new List[n];
                int[][] ed = new int[m][3];
                for (int i = 0; i < n; i++) {
                    edges[i] = new ArrayList<>();
                }
                for (int i = 0; i < m; i++) {
                    int a = sc.nextInt() - 1;
                    int b = sc.nextInt() - 1;
                    ed[i][0] = a; ed[i][1] = b; ed[i][2] = 1000000;
                    edges[a].add(b);
                    edges[b].add(a);
                }
                List<Integer> orderPos = new ArrayList<>();
                List<Integer> orderNeg = new ArrayList<>();
                for (int i = 1; i < n; i++) {
                    if (vals[i] > 0) orderPos.add(i);
                    else orderNeg.add(i);
                }
                orderPos.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return vals[o1] - vals[o2];
                    }
                });
                orderNeg.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return vals[o2] - vals[o1];
                    }
                });
                boolean[] visit = new boolean[n]; visit[0] = true;
                int[] d = new int[n];
                int op = 0, on = 0;
                int placed = 1;
                int pts = 0;
                while (op < orderPos.size() || on < orderNeg.size()) {
                    if (on < orderNeg.size() && -vals[orderNeg.get(on)] == placed) {
                        List<Integer> tmp = new ArrayList<>();
                        while (on < orderNeg.size() && -vals[orderNeg.get(on)] == placed) {
                            int v = orderNeg.get(on);
                            for (int i = 0; i < m; i++) {
                                if (ed[i][0] == v && visit[ed[i][1]]) {
                                    d[v] = pts + 1;
                                    ed[i][2] = d[v] - d[ed[i][1]]; break;
                                }
                                if (ed[i][1] == v && visit[ed[i][0]]) {
                                    d[v] = pts + 1;
                                    ed[i][2] = d[v] - d[ed[i][0]]; break;
                                }
                            }
                            tmp.add(v);
                            on++;
                        }
                        for (int v: tmp) {
                            visit[v] = true;
                        }
                        placed += tmp.size();
                        pts++;
                        // place several negative vertices;
                    } else {
                        // place one positive vertex;
                        if (op == orderPos.size()) throw new RuntimeException();
                        int v = orderPos.get(op);
                        for (int i = 0; i < m; i++) {
                            if (ed[i][0] == v && visit[ed[i][1]]) {
                                d[v] = vals[v];
                                ed[i][2] = d[v] - d[ed[i][1]]; break;
                            }
                            if (ed[i][1] == v && visit[ed[i][0]]) {
                                d[v] = vals[v];
                                ed[i][2] = d[v] - d[ed[i][0]]; break;
                            }
                        }
                        op++;
                        visit[v] = true;
                        placed++;
                        pts = d[v];
                    }
                }
                pw.print("Case #" + ks + ":");
                for (int[] x: ed) pw.print(" " + x[2]);
                pw.println();
            }
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("input"));

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