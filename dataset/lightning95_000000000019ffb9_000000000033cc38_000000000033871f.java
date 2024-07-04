import java.io.*;
import java.util.*;

/**
 * @author Aydar Gizatullin a.k.a. lightning95, aydar.gizatullin@gmail.com
 */
public class Solution {
    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    class Event {
        int id, time, type;

        Event(int cId, int cTime, int cType) {
            id = cId;
            time = cTime;
            type = cType;
        }
    }

    private void solveOne() {
        int n = rw.nextInt();
        int m = rw.nextInt();
        int[] t = new int[n];
        for (int i = 1; i < n; ++i) {
            t[i] = rw.nextInt();
        }
        int[][] a = new int[n][n];
        int maxW = 1000000;
        List<Pair> edges = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            Arrays.fill(a[i], maxW);
        for (int i = 0; i < m; ++i) {
            int x = rw.nextInt() - 1;
            int y = rw.nextInt() - 1;
            edges.add(new Pair(x, y));
            a[x][y] = 0;
            a[y][x] = 0;
        }
        boolean[] us = new boolean[n];
        int[] d = new int[n];
        int maxWWW = maxW * 100;
        Arrays.fill(d, maxWWW);
        d[0] = 0;
        int step = 1;
        us[0] = true;
        while (true) {
            int max = -101 * maxW;
            List<Integer> cur = new ArrayList<>();
            for (int i = 1; i < n; ++i){
                if (!us[i] && max < t[i]){
                    max = t[i];
                    cur.clear();
                    cur.add(i);
                } else if (!us[i] && max == t[i]){
                    max = t[i];
                    cur.add(i);
                }
            }
            if (cur.isEmpty()) break;
            for (Integer fr: cur){
                d[fr] = step;
                for (int j = 0; j < n; ++j){
                    if (a[fr][j] == 0){
                        if (us[j]) {
                            a[fr][j] = Math.max(Math.abs(d[fr] - d[j]), 1);
                            a[j][fr] = Math.max(Math.abs(d[fr] - d[j]), 1);
                        }
                    }
                }
                us[fr] =true;
            }
            ++step;
        }

        for (Pair p : edges){
            rw.print(a[p.a][p.b] + " ");
        }
    }

    private void solve() {
        int t = rw.nextInt();
        for (int i = 1; i <= t; ++i) {
            rw.print("Case #" + i + ": ");
            solveOne();
            rw.println();
        }
    }

    long gcd(long a, long b) {
        if (a == 0 || b == 0) return a + b;
        if (a > b) return gcd(a % b, b);
        return gcd(a, b % a);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    <T> void errArray(T[] a) {
        for (T i : a)
            System.err.print(i + " ");
        System.err.println();
    }

    private RW rw;
    private String FILE_NAME = "file";

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        rw = new RW(FILE_NAME + ".in", FILE_NAME + ".out");
        solve();
        rw.close();
    }

    private class RW {
        private StringTokenizer st;
        private PrintWriter out;
        private BufferedReader br;
        private boolean eof;

        RW(String inputFile, String outputFile) {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

            File f = new File(inputFile);
            if (f.exists() && f.canRead()) {
                try {
                    br = new BufferedReader(new FileReader(inputFile));
                    out = new PrintWriter(new FileWriter(outputFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    eof = true;
                    return "-1";
                }
            }
            return st.nextToken();
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private void println() {
            out.println();
        }

        private void println(Object o) {
            out.println(o);
        }

        private void print(Object o) {
            out.print(o);
        }

        private void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}
