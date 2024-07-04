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
        solver.solve(1, in, out);
        out.close();
    }
}

class WormholeSolver {
    private int ans;
    private int[] pair;
    private int n;
    private int[] x;
    private int[] y;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int numTests = in.nextInt();
        for (int test = 1; test <= numTests; test++) {
            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            out.printf("Case #%d: %d\n", test, findMaxWormholes(x, y));
        }
    }

    private int findMaxWormholes(int[] x, int[] y) {
        this.n = x.length;
        if (n < 3) {
            return n;
        }
        this.x = x;
        this.y = y;
        ans = 0;
        pair = new int[n];
        Arrays.fill(pair, -1);
        generatePairs(0);
        return ans;
    }

    private void generatePairs(int pos) {
        if (pos == n) {
            calculateMaxWormholes();
            return;
        }
        generatePairs(pos + 1);
        for (int i = 0; i < n; i++) {
            if (i == pos || pair[i] >= 0) continue;
            pair[pos] = i;
            pair[i] = pos;
            generatePairs(pos + 1);
            pair[pos] = -1;
            pair[i] = -1;
        }
    }

    private void calculateMaxWormholes() {
        for (int dir0 = 0; dir0 < n; dir0++) {
            for (int dir1 = dir0 + 1; dir1 < n; dir1++) {
                long dx = x[dir1] - x[dir0];
                long dy = y[dir1] - y[dir0];
                for (int i = 0; i < n; i++) {
                    ans = Math.max(ans, simulate(i, dx, dy));
                }
            }
        }
    }

    private int simulate(int i, long dx, long dy) {
        boolean[][] visited = new boolean[2][n];
        int count = 0;
        while (true) {
            if (visited[0][i]) break;
            if (!visited[0][i] && !visited[1][i]) count++;
            visited[0][i] = true;
            i = pair[i];
            if (i < 0) break;
            if (visited[1][i]) break;
            if (!visited[0][i] && !visited[1][i]) count++;
            visited[1][i] = true;
            int next = findNext(i, dx, dy);
            if (next < 0) break;
            i = next;
        }
        return count;
    }

    private int findNext(int i, long dx, long dy) {
        int next = -1;
        long minDist = -1;
        for (int j = 0; j < n; j++) {
            if (j == i) continue;
            long odx = x[j] - x[i];
            long ody = y[j] - y[i];
            long dist = odx * odx + ody * ody;
            if (dotProduct(dx, dy, odx, ody) <= 0) continue;
            if (crossProduct(dx, dy, odx, ody) != 0) continue;
            if (next < 0 || minDist > dist) {
                next = j;
                minDist = dist;
            }
        }
        return next;
    }

    private long dotProduct(long x0, long y0, long x1, long y1) {
        return x0 * x1 + y0 * y1;
    }

    private long crossProduct(long x0, long y0, long x1, long y1) {
        return x0 * y1 - x1 * y0;
    }
}

class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}