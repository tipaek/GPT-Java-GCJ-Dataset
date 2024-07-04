import java.util.*;

public class Solution {

    public static int n;
    public static int trace;
    public static int[][] g;
    public static boolean[][] used;

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int nC = stdin.nextInt();

        for (int loop = 1; loop <= nC; loop++) {

            n = stdin.nextInt();
            trace = stdin.nextInt();
            g = new int[n][n];
            for (int[] row : g) Arrays.fill(row, -1);
            used = new boolean[n][n];

            if (isPossible()) {

                fillDiagonal();

                for (int i = 0; i < n; i++) {

                    boolean[] need = new boolean[n];
                    Arrays.fill(need, true);
                    need[g[i][i]] = false;

                    Dinic fGraph = new Dinic(2 * n);

                    for (int j = 0; j < n; j++) {
                        if (i != j) {
                            fGraph.add(j + n, 2 * n + 1, 1, 0);
                        }
                    }

                    for (int j = 0; j < n; j++) {
                        if (need[j]) {
                            fGraph.add(2 * n, j, 1, 0);

                            for (int k = 0; k < n; k++) {
                                if (!used[j][k]) {
                                    fGraph.add(j, k + n, 1, 0);
                                }
                            }
                        }
                    }

                    fGraph.flow();
                    ArrayList<int[]> add = fGraph.getFlows();

                    for (int[] item : add) {
                        int num = item[0];
                        int col = item[1];
                        used[num][col] = true;
                        g[i][col] = num;
                    }
                }

                System.out.println("Case #" + loop + ": POSSIBLE");
                for (int[] row : g) {
                    System.out.print(row[0] + 1);
                    for (int j = 1; j < n; j++) {
                        System.out.print(" " + (row[j] + 1));
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + loop + ": IMPOSSIBLE");
            }
        }
    }

    public static boolean isPossible() {
        if (trace < n || trace > n * n || trace == n + 1 || trace == n * n - 1) {
            return false;
        }
        if (n == 3 && (trace == 5 || trace == 7)) {
            return false;
        }
        return true;
    }

    public static void fillDiagonal() {
        int avg = trace / n - 1;
        int left = trace % n;

        for (int i = 0; i < n; i++) g[i][i] = avg;
        for (int i = 1; i <= left; i++) g[n - i][n - i]++;

        if (left == n - 1) {
            g[1][1]--;
            g[n - 1][n - 1]++;
        } else if (left == 1) {
            g[0][0]--;
            g[n - 2][n - 2]++;
        }

        for (int i = 0; i < n; i++) {
            used[g[i][i]][i] = true;
        }
    }
}

class Edge {
    int v1, v2, cap, flow;
    Edge rev;

    Edge(int V1, int V2, int Cap, int Flow) {
        v1 = V1;
        v2 = V2;
        cap = Cap;
        flow = Flow;
    }
}

class Dinic {

    ArrayDeque<Integer> q;
    ArrayList<Edge>[] adj;
    int n, s, t, oo = (int) 1E9;
    boolean[] blocked;
    int[] dist;

    public Dinic(int N) {
        n = N;
        s = n++;
        t = n++;
        blocked = new boolean[n];
        dist = new int[n];
        q = new ArrayDeque<>();
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    void add(int v1, int v2, int cap, int flow) {
        Edge e = new Edge(v1, v2, cap, flow);
        Edge rev = new Edge(v2, v1, 0, 0);
        adj[v1].add(rev.rev = e);
        adj[v2].add(e.rev = rev);
    }

    ArrayList<int[]> getFlows() {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < (n - 2) / 2; i++) {
            for (Edge e : adj[i]) {
                if (e.flow == 1) {
                    res.add(new int[]{e.v1, e.v2 - (n - 2) / 2});
                }
            }
        }
        return res;
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
        clear();
        int ret = 0;
        while (bfs()) {
            Arrays.fill(blocked, false);
            ret += dfs(s, oo);
        }
        return ret;
    }

    void clear() {
        for (ArrayList<Edge> edges : adj) {
            for (Edge e : edges) {
                e.flow = 0;
            }
        }
    }
}