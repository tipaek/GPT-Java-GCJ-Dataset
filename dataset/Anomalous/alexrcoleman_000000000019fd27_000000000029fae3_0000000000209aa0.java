import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] grid = solve(n, k);
            System.out.printf("Case #%d: %s\n", t, grid != null ? "POSSIBLE" : "IMPOSSIBLE");
            if (grid != null) {
                for (int[] row : grid) {
                    System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
                }
            }
        }
    }

    static int[][] solve(int n, int k) {
        if (k == n + 1 || k == n * n - 1 || (n <= 3 && k % n != 0)) {
            return null;
        }

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i][i] = k / n + (i < k % n ? 1 : 0);
        }

        if (k % n == 1 || k % n == n - 1) {
            grid[1][1]++;
            grid[2][2]--;
        }

        while (true) {
            if (fillGrid(grid)) {
                return grid;
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], 0);
                grid[i][i] = k / n + (i < k % n ? 1 : 0);
            }
        }
    }

    static boolean fillGrid(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            Dinic dinic = new Dinic(n * 2 + 2);
            for (int cj = 0; cj < n; cj++) {
                dinic.add(dinic.s, cj, 1, 0);
                if (grid[i][cj] != 0) {
                    dinic.add(cj, grid[i][cj] + n, 1, 0);
                } else {
                    boolean[] block = new boolean[n + 1];
                    for (int ci = 0; ci < n; ci++) {
                        block[grid[ci][cj]] = true;
                    }
                    for (int x = 1; x <= n; x++) {
                        if (!block[x]) {
                            dinic.add(cj, x + n, 1, 0);
                        }
                    }
                    Collections.shuffle(dinic.adj[cj]);
                }
            }
            for (int x = 1; x <= n; x++) {
                dinic.add(x + n, dinic.t, 1, 0);
            }

            if (dinic.flow() != n) {
                return false;
            }

            for (int cj = 0; cj < n; cj++) {
                for (Dinic.Edge edge : dinic.adj[cj]) {
                    if (edge.flow == 1 && edge.v2 != dinic.s) {
                        grid[i][cj] = edge.v2 - n;
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

            Edge(int v1, int v2, int cap, int flow) {
                this.v1 = v1;
                this.v2 = v2;
                this.cap = cap;
                this.flow = flow;
            }
        }

        ArrayDeque<Integer> queue;
        ArrayList<Edge>[] adj;
        int n, s, t;
        boolean[] blocked;
        int[] dist;
        final int INF = (int) 1E9;

        Dinic(int n) {
            this.n = n;
            this.s = n++;
            this.t = n++;
            this.blocked = new boolean[n];
            this.dist = new int[n];
            this.queue = new ArrayDeque<>();
            this.adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        Edge add(int v1, int v2, int cap, int flow) {
            Edge edge = new Edge(v1, v2, cap, flow);
            Edge rev = new Edge(v2, v1, 0, 0);
            adj[v1].add(rev.rev = edge);
            adj[v2].add(edge.rev = rev);
            return edge;
        }

        boolean bfs() {
            Arrays.fill(dist, -1);
            dist[t] = 0;
            queue.clear();
            queue.add(t);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (node == s) return true;
                for (Edge edge : adj[node]) {
                    if (edge.rev.cap > edge.rev.flow && dist[edge.v2] == -1) {
                        dist[edge.v2] = dist[node] + 1;
                        queue.add(edge.v2);
                    }
                }
            }
            return dist[s] != -1;
        }

        int dfs(int pos, int min) {
            if (pos == t) return min;
            int flow = 0;
            for (Edge edge : adj[pos]) {
                if (!blocked[edge.v2] && dist[edge.v2] == dist[pos] - 1 && edge.cap - edge.flow > 0) {
                    int curFlow = dfs(edge.v2, Math.min(min - flow, edge.cap - edge.flow));
                    edge.flow += curFlow;
                    edge.rev.flow = -edge.flow;
                    flow += curFlow;
                }
                if (flow == min) return flow;
            }
            blocked[pos] = flow != min;
            return flow;
        }

        int flow() {
            int totalFlow = 0;
            while (bfs()) {
                Arrays.fill(blocked, false);
                totalFlow += dfs(s, INF);
            }
            return totalFlow;
        }
    }
}