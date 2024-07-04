import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[][] grid = null;
            if (isValidConfiguration(n, k)) {
                grid = initializeGrid(n, k);
                if (isSpecialCase(n, k)) {
                    adjustGridForSpecialCase(grid);
                }
                while (!solve(grid)) {
                    // Retry until solved
                }
            }
            printResult(t, grid);
        }
    }

    private static boolean isValidConfiguration(int n, int k) {
        return k != n + 1 && k != n * n - 1 && (n > 3 || k % n == 0);
    }

    private static int[][] initializeGrid(int n, int k) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i][i] = k / n;
            if (i < k % n) {
                grid[i][i]++;
            }
        }
        return grid;
    }

    private static boolean isSpecialCase(int n, int k) {
        return k % n == 1 || k % n == n - 1;
    }

    private static void adjustGridForSpecialCase(int[][] grid) {
        grid[1][1]++;
        grid[2][2]--;
    }

    private static void printResult(int t, int[][] grid) {
        System.out.printf("Case #%d: %s\n", t, grid != null ? "POSSIBLE" : "IMPOSSIBLE");
        if (grid != null) {
            for (int[] row : grid) {
                for (int j = 0; j < row.length; j++) {
                    if (j != 0) {
                        System.out.print(' ');
                    }
                    System.out.print(row[j]);
                }
                System.out.println();
            }
        }
    }

    static boolean solve(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            Dinic g = new Dinic(n * 2 + 2);
            for (int cj = 0; cj < n; cj++) {
                g.add(g.s, cj, 1, 0);
                if (grid[i][cj] != 0) {
                    g.add(cj, grid[i][cj] + n, 1, 0);
                } else {
                    boolean[] block = new boolean[n + 1];
                    for (int ci = 0; ci < n; ci++) {
                        block[grid[ci][cj]] = true;
                    }
                    for (int x = 1; x <= n; x++) {
                        if (!block[x]) {
                            g.add(cj, x + n, 1, 0);
                        }
                    }
                    Collections.shuffle(g.adj[cj]);
                }
            }
            for (int x = 1; x <= n; x++) {
                g.add(x + n, g.t, 1, 0);
            }

            if (g.flow() != n) {
                return false;
            }

            for (int cj = 0; cj < n; cj++) {
                for (Dinic.Edge e : g.adj[cj]) {
                    if (e.flow == 1 && e.v2 != g.s) {
                        grid[i][cj] = e.v2 - n;
                    }
                }
            }
        }
        return true;
    }

    static class Dinic {
        static class Edge {
            int v1, v2, cap, flow;
            Edge rev;

            Edge(int V1, int V2, int Cap, int Flow) {
                v1 = V1;
                v2 = V2;
                cap = Cap;
                flow = Flow;
            }
        }

        ArrayDeque<Integer> q;
        ArrayList<Edge>[] adj;
        int n, s, t, mS, mT, oo = (int) 1E9;
        boolean[] blocked;
        int[] dist;

        public Dinic(int N) {
            n = N;
            s = n++;
            t = n++;
            mS = n++;
            mT = n++;
            blocked = new boolean[n];
            dist = new int[n];
            q = new ArrayDeque<>();
            adj = new ArrayList[n];
            for (int i = 0; i < n; ++i) {
                adj[i] = new ArrayList<>();
            }
        }

        Edge add(int v1, int v2, int cap, int flow) {
            Edge e = new Edge(v1, v2, cap, flow);
            Edge rev = new Edge(v2, v1, 0, 0);
            adj[v1].add(rev.rev = e);
            adj[v2].add(e.rev = rev);
            return e;
        }

        boolean bfs() {
            q.clear();
            Arrays.fill(dist, -1);
            dist[t] = 0;
            q.add(t);

            while (!q.isEmpty()) {
                int node = q.poll();
                if (node == s) {
                    return true;
                }
                for (Edge e : adj[node]) {
                    if (e.rev.cap > e.rev.flow && dist[e.v2] == -1) {
                        dist[e.v2] = dist[node] + 1;
                        q.add(e.v2);
                    }
                }
            }
            return dist[s] != -1;
        }

        int dfs(int pos, int min) {
            if (pos == t) {
                return min;
            }
            int flow = 0;
            for (Edge e : adj[pos]) {
                int cur = 0;
                if (!blocked[e.v2] && dist[e.v2] == dist[pos] - 1 && e.cap - e.flow > 0) {
                    cur = dfs(e.v2, Math.min(min - flow, e.cap - e.flow));
                    e.flow += cur;
                    e.rev.flow = -e.flow;
                    flow += cur;
                }
                if (flow == min) {
                    return flow;
                }
            }
            blocked[pos] = flow != min;
            return flow;
        }

        int flow() {
            int ret = 0;
            while (bfs()) {
                Arrays.fill(blocked, false);
                ret += dfs(s, oo);
            }
            return ret;
        }
    }
}