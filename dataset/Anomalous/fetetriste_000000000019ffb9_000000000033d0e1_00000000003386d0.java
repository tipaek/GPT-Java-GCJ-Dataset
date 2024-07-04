import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        WormholeSolver solver = new WormholeSolver();
        solver.solve(in, out);
        out.close();
    }
}

class WormholeSolver {
    private int ans;
    private int[] pair;
    private int n;
    private int[] x;
    private int[] y;

    public void solve(FastScanner in, PrintWriter out) {
        int numTests = in.nextInt();
        for (int test = 1; test <= numTests; test++) {
            n = in.nextInt();
            x = new int[n];
            y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            out.printf("Case #%d: %d\n", test, solve(x, y));
        }
    }

    private int solve(int[] x, int[] y) {
        if (x.length < 3) {
            return x.length;
        }
        this.n = x.length;
        this.x = x;
        this.y = y;
        ans = 0;
        pair = new int[n];
        Arrays.fill(pair, -1);
        rec(0);
        return ans;
    }

    private void rec(int pos) {
        if (pos == n) {
            for (int dir0 = 0; dir0 < n; dir0++) {
                for (int dir1 = dir0 + 1; dir1 < n; dir1++) {
                    int dx = x[dir1] - x[dir0];
                    int dy = y[dir1] - y[dir0];
                    for (int i = 0; i < n; i++) {
                        ans = Math.max(ans, simulate(i, dx, dy));
                    }
                }
            }
            return;
        }

        rec(pos + 1);
        for (int i = 0; i < n; i++) {
            if (i == pos || pair[i] >= 0) {
                continue;
            }
            pair[pos] = i;
            pair[i] = pos;
            rec(pos + 1);
            pair[pos] = -1;
            pair[i] = -1;
        }
    }

    private int simulate(int i, int dx, int dy) {
        boolean[][] was = new boolean[2][n];
        int res = 0;
        while (true) {
            if (was[0][i]) {
                break;
            }
            if (!was[0][i] && !was[1][i]) {
                ++res;
            }
            was[0][i] = true;
            i = pair[i];
            if (i < 0) {
                break;
            }
            if (was[1][i]) {
                break;
            }
            if (!was[0][i] && !was[1][i]) {
                ++res;
            }
            was[1][i] = true;
            int k = -1;
            long distK = -1;
            for (int j = 0; j < n; j++) {
                long odx = x[j] - x[i];
                long ody = y[j] - y[i];
                long distJ = odx * odx + ody * ody;
                if (dot(dx, dy, odx, ody) <= 0) {
                    continue;
                }
                if (cross(dx, dy, odx, ody) != 0) {
                    continue;
                }
                if (k < 0 || distK > distJ) {
                    k = j;
                    distK = distJ;
                }
            }
            if (k < 0) {
                break;
            }
            i = k;
        }
        return res;
    }

    private long dot(long x0, long y0, long x1, long y1) {
        return x0 * x1 + y0 * y1;
    }

    private long cross(long x0, long y0, long x1, long y1) {
        return x0 * y1 - x1 * y0;
    }
}

class FastScanner {
    private BufferedReader in;
    private StringTokenizer st;

    public FastScanner(InputStream stream) {
        in = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}