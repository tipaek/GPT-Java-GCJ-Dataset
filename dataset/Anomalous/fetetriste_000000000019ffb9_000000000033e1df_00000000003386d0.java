import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner scanner = new FastScanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        WormholeSolver solver = new WormholeSolver();
        solver.solve(scanner, writer);
        writer.close();
    }
}

class WormholeSolver {
    private int answer;
    private int[] pairings;
    private int n;
    private int[] xCoordinates;
    private int[] yCoordinates;

    public void solve(FastScanner scanner, PrintWriter writer) {
        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            n = scanner.nextInt();
            xCoordinates = new int[n];
            yCoordinates = new int[n];
            for (int i = 0; i < n; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
            }
            writer.printf("Case #%d: %d\n", test, calculate());
        }
    }

    private int calculate() {
        if (n < 3) return n;
        answer = 0;
        pairings = new int[n];
        Arrays.fill(pairings, -1);
        recurse(0);
        return answer;
    }

    private void recurse(int pos) {
        if (pos == n) {
            for (int dir0 = 0; dir0 < n; dir0++) {
                for (int dir1 = 0; dir1 < dir0; dir1++) {
                    long dx = xCoordinates[dir1] - xCoordinates[dir0];
                    long dy = yCoordinates[dir1] - yCoordinates[dir0];
                    for (int i = 0; i < n; i++) {
                        answer = Math.max(answer, simulate(i, dx, dy));
                    }
                }
            }
            return;
        }

        recurse(pos + 1);
        if (pairings[pos] >= 0) return;

        for (int i = pos + 1; i < n; i++) {
            if (pairings[i] >= 0) continue;
            pairings[pos] = i;
            pairings[i] = pos;
            recurse(pos + 1);
            pairings[pos] = -1;
            pairings[i] = -1;
        }
    }

    private int simulate(int i, long dx, long dy) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int step = 0; step < 2 * n + 1; step++) {
            visited[i] = true;
            i = pairings[i];
            if (i < 0) break;
            visited[i] = true;
            int k = -1;
            long closestDistance = -1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                long odx = xCoordinates[j] - xCoordinates[i];
                long ody = yCoordinates[j] - yCoordinates[i];
                long distanceJ = odx * odx + ody * ody;
                if (dotProduct(dx, dy, odx, ody) <= 0) continue;
                if (crossProduct(dx, dy, odx, ody) != 0) continue;
                if (k < 0 || closestDistance > distanceJ) {
                    k = j;
                    closestDistance = distanceJ;
                }
            }
            if (k < 0) break;
            i = k;
        }
        for (boolean wasVisited : visited) {
            if (wasVisited) count++;
        }
        return count;
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