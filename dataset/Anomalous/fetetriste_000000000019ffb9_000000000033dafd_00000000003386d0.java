import java.io.*;
import java.util.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
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

    static class WormholeSolver {
        int maxCount;
        int[] pairings;
        int pointsCount;
        int[] xCoords;
        int[] yCoords;

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
            pointsCount = x.length;
            if (pointsCount < 3) {
                return pointsCount;
            }
            this.xCoords = x;
            this.yCoords = y;
            maxCount = 0;
            pairings = new int[pointsCount];
            Arrays.fill(pairings, -1);
            generatePairings(0);
            return maxCount;
        }

        private void generatePairings(int pos) {
            if (pos == pointsCount) {
                for (int dir0 = 0; dir0 < pointsCount; dir0++) {
                    for (int dir1 = 0; dir1 < dir0; dir1++) {
                        long dx = xCoords[dir1] - xCoords[dir0];
                        long dy = yCoords[dir1] - yCoords[dir0];
                        for (int i = 0; i < pointsCount; i++) {
                            maxCount = Math.max(maxCount, simulateWormholeTraversal(i, dx, dy));
                        }
                    }
                }
                return;
            }

            generatePairings(pos + 1);
            for (int i = pos + 1; i < pointsCount; i++) {
                if (pairings[i] >= 0) {
                    continue;
                }
                pairings[pos] = i;
                pairings[i] = pos;
                generatePairings(pos + 1);
                pairings[pos] = -1;
                pairings[i] = -1;
            }
        }

        private int simulateWormholeTraversal(int start, long dx, long dy) {
            boolean[] visited = new boolean[pointsCount];
            int count = 0;
            for (int step = 0; step < 2 * pointsCount + 1; step++) {
                visited[start] = true;
                start = pairings[start];
                if (start < 0) {
                    break;
                }
                visited[start] = true;
                int next = -1;
                long closestDist = -1;
                for (int j = 0; j < pointsCount; j++) {
                    if (j == start) {
                        continue;
                    }
                    long odx = xCoords[j] - xCoords[start];
                    long ody = yCoords[j] - yCoords[start];
                    long distJ = odx * odx + ody * ody;
                    if (dotProduct(dx, dy, odx, ody) <= 0 || crossProduct(dx, dy, odx, ody) != 0) {
                        continue;
                    }
                    if (next < 0 || closestDist > distJ) {
                        next = j;
                        closestDist = distJ;
                    }
                }
                if (next < 0) {
                    break;
                }
                start = next;
            }
            for (boolean wasVisited : visited) {
                if (wasVisited) {
                    count++;
                }
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

    static class FastScanner {
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
}