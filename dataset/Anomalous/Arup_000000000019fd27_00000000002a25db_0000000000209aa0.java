import java.util.*;

public class Solution {
    public static int n;
    public static int trace;
    public static int[][] g;
    public static boolean[][] used;
    public static Random rndGen;
    public static int[] nums;

    public static void main(String[] args) {
        rndGen = new Random();
        Scanner stdin = new Scanner(System.in);
        int nC = stdin.nextInt();
        
        for (int loop = 1; loop <= nC; loop++) {
            n = stdin.nextInt();
            trace = stdin.nextInt();
            g = new int[n][n];
            for (int[] row : g) Arrays.fill(row, -1);
            used = new boolean[n][n];
            nums = new int[n];
            Arrays.fill(nums, n);
            
            if (isPossible()) {
                solve();
                printSolution(loop, "POSSIBLE");
            } else {
                printSolution(loop, "IMPOSSIBLE");
            }
        }
    }

    public static boolean isPossible() {
        if (trace < n || trace > n * n || trace == n + 1 || trace == n * n - 1) return false;
        if (n == 3 && (trace == 5 || trace == 7)) return false;
        return true;
    }

    public static void solve() {
        fillDiagonal();
        pair[] list = new pair[n];
        for (int i = 0; i < n; i++) list[i] = new pair(i, nums[i]);
        Arrays.sort(list);
        
        for (pair p : list) {
            int myNum = p.id;
            Dinic fGraph = new Dinic(2 * n);
            
            for (int j = 0; j < n; j++) {
                if (g[j][j] == myNum) continue;
                fGraph.add(j + n, 2 * n + 1, 1, 0);
                fGraph.add(2 * n, j, 1, 0);
            }
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (g[j][k] == -1) {
                        fGraph.add(j, k + n, 1, 0);
                    }
                }
            }
            
            fGraph.flow();
            List<int[]> add = fGraph.getFlows();
            
            for (int[] item : add) {
                int row = item[0];
                int col = item[1];
                g[row][col] = myNum;
            }
        }
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
            nums[g[i][i]]--;
        }
    }

    public static void printSolution(int loop, String result) {
        System.out.println("Case #" + loop + ": " + result);
        if (result.equals("POSSIBLE")) {
            for (int i = 0; i < n; i++) {
                System.out.print(g[i][0] + 1);
                for (int j = 1; j < n; j++) {
                    System.out.print(" " + (g[i][j] + 1));
                }
                System.out.println();
            }
        }
    }
}

class pair implements Comparable<pair> {
    public int id;
    public int freq;

    public pair(int id, int freq) {
        this.id = id;
        this.freq = freq;
    }

    @Override
    public int compareTo(pair other) {
        if (this.freq != other.freq) return this.freq - other.freq;
        return this.id - other.id;
    }
}

class Edge {
    int v1, v2, cap, flow;
    Edge rev;

    Edge(int v1, int v2, int cap, int flow) {
        this.v1 = v1;
        this.v2 = v2;
        this.cap = cap;
        this.flow = flow;
    }
}

class Dinic {
    ArrayDeque<Integer> q;
    ArrayList<Edge>[] adj;
    int n, s, t;
    boolean[] blocked;
    int[] dist;
    static final int INFINITY = (int) 1E9;

    public Dinic(int N) {
        n = N;
        s = n++;
        t = n++;
        blocked = new boolean[n];
        dist = new int[n];
        q = new ArrayDeque<>();
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    }

    void add(int v1, int v2, int cap, int flow) {
        Edge e = new Edge(v1, v2, cap, flow);
        Edge rev = new Edge(v2, v1, 0, 0);
        adj[v1].add(rev.rev = e);
        adj[v2].add(e.rev = rev);
    }

    List<int[]> getFlows() {
        List<int[]> res = new ArrayList<>();
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
            if (node == s) return true;
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
        if (pos == t) return min;
        int flow = 0;
        for (Edge e : adj[pos]) {
            int cur = 0;
            if (!blocked[e.v2] && dist[e.v2] == dist[pos] - 1 && e.cap - e.flow > 0) {
                cur = dfs(e.v2, Math.min(min - flow, e.cap - e.flow));
                e.flow += cur;
                e.rev.flow = -e.flow;
                flow += cur;
            }
            if (flow == min) return flow;
        }
        blocked[pos] = flow != min;
        return flow;
    }

    int flow() {
        clear();
        int ret = 0;
        while (bfs()) {
            Arrays.fill(blocked, false);
            ret += dfs(s, INFINITY);
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