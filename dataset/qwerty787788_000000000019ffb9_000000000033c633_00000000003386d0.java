import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    class Point {
        final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean canReach(int dx, int dy, Point a, Point b) {
        long dx2 = b.x - a.x;
        long dy2 = b.y - a.y;
        return (dx2 * dy - dy2 * dx == 0) && dx * dx2 + dy * dy2 > 0;
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = in.nextInt();
            Point[] a = new Point[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = new Point(in.nextInt(), in.nextInt());
            }
            int res = 1;
            boolean[][] g = new boolean[n][n];
            int[] ends = new int[n];
            int[] next = new int[n];
            for (int start = 0; start < n; start++) {
                for (int finish = 0; finish < n; finish++) {
                    if (start == finish) {
                        continue;
                    }
                    int dx = a[finish].x - a[start].x;
                    int dy = a[finish].y - a[start].y;
                    for (int i = 0; i < n; i++) {
                        next[i] = i;
                        for (int j = 0; j < n; j++) {
                            g[i][j] = canReach(dx, dy, a[i], a[j]);
                            if (g[i][j]) {
                                next[i] = j;
                            }
                        }
                    }
                    Arrays.fill(ends, 0);
                    for (int i = 0; i < n; i++) {
                        while (next[next[i]] != next[i]) {
                            next[i] = next[next[i]];
                        }
                        ends[next[i]]++;
                    }
                    int cntOnes = 0, curres = 0, cntOdds = 0;
                    for (int i = 0; i < n; i++) {
                        if (ends[i] == 1) {
                            cntOnes++;
                        } else if (ends[i] % 2 == 1) {
                            cntOdds++;
                            curres += (ends[i] - 1);
                        } else {
                            curres += ends[i];
                        }
                    }
                    curres += cntOdds / 2 * 2;
                    cntOdds %= 2;
                    curres += Math.min(2, cntOnes + cntOdds);
                    res = Math.max(res, curres);
                }
            }
            out.println("Case #" + (t + 1) + ": " + res);
        }
    }


    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}