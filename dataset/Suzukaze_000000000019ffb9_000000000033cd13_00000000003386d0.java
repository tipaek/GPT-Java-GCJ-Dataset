//package com.company;

import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {

        int[] diff(int[][] points, int i, int j) {
            int x = points[i][0] - points[j][0];
            int y = points[i][1] - points[j][1];
            return normalize(new int[]{x, y});
        }

        int gcd(int x, int y) {
            return y == 0 ? x: gcd(y, x % y);
        }

        int[] normalize(int[] d) {
            boolean neg = (d[0] < 0) != (d[1] < 0);
            if (d[0] == 0 || d[1] == 0) neg = false;
            int x = Math.abs(d[0]), y = Math.abs(d[1]);
            int g = gcd(x, y);
            x /= g; y /= g;
            if (neg) y = -y;
            return new int[]{x, y};
        }

        public class DJS {
            int[] a;
            public DJS(int n) {
                a = new int[n];
                Arrays.fill(a, -1);
            }
            int find(int x) {
                if (a[x] < 0) return x;
                return a[x] = find(a[x]);
            }
            void uni(int x, int y) {
                int rx = find(x), ry = find(y);
                if (rx == ry) throw new RuntimeException();
                a[ry] += a[rx];
                a[rx] = ry;
            }
        }

        boolean between(int[][] points, int i, int j, int k) {
            if (points[i][0] < points[k][0] && points[k][0] < points[j][0]) return true;
            if (points[i][0] == points[k][0] && points[k][0] == points[j][0]) {
                return points[i][1] < points[k][1] && points[k][1] < points[j][1];
            }
            return false;
        }


        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            outer:
            for (int ks = 1; ks <= T; ks++) {
                int n = sc.nextInt();
                int[][] points = new int[n][2];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        points[i][j] = sc.nextInt();
                    }
                }
                int[][][] dir = new int[n][n][2];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        int[] d = diff(points, i, j);
                        boolean good = true;
                        for (int k = 0; k < n; k++) {
                            if (k == i || k == j) continue;
                            if (between(points, i, j, k) || between(points, j, i, k)) {
                                int[] di = diff(points, i, k);
                                int[] dj = diff(points, k, j);
                                if ((long) di[0] * dj[1] == (long) dj[0] * di[1]) good = false;
                            }
                        }
                        if (!good) {
                            d[0] = 0;
                            d[1] = 0;
                        }
                        dir[i][j] = Arrays.copyOf(d, 2);
                    }
                }
                Map<Long, List<int[]>> pair = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (dir[i][j][0] != 0 || dir[i][j][1] != 0) {
                            long hash = (long) dir[i][j][0] * Integer.MAX_VALUE + dir[i][j][1];
//                            System.err.println(i + " " + j + " " + hash);
                            if (!pair.containsKey(hash)) {
                                pair.put(hash, new ArrayList<>());
                            }
                            pair.get(hash).add(new int[]{i, j});
                        }
                    }
                }
                int mx = 0;
                for (List<int[]> g: pair.values()) {
//                    System.err.println();
                    DJS djs = new DJS(n);
                    for (int[] e: g) if (e[0] < e[1]) {
//                        System.err.println(e[0] + " " + e[1]);
                        djs.uni(e[0], e[1]);
                    }
                    List<Integer> lines = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if (djs.find(i) == i && djs.a[i] < -1) {
                            lines.add(-djs.a[i]);
                        }
                    }
                    int sum = 0;
                    for (int x: lines) sum += x;
                    int odd = 0;
                    for (int x: lines) if (x % 2 == 1) odd++;
                    if (odd % 2 == 1) sum--;
                    mx = Math.max(mx, sum);
                }
                pw.println("Case #" + ks + ": " + Math.min(n, mx + 2));
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