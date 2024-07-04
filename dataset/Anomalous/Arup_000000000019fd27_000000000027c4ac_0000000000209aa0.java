import java.util.*;

public class Solution {

    public static int n;
    public static int trace;
    public static int[][] grid;
    public static boolean[][] used;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            n = stdin.nextInt();
            trace = stdin.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(grid[i], -1);
            used = new boolean[n][n];

            if (isPossible()) {
                fillDiagonal();

                for (int i = 0; i < n; i++) {
                    boolean[] need = new boolean[n];
                    Arrays.fill(need, true);
                    need[grid[i][i]] = false;

                    Dinic flowGraph = new Dinic(2 * n);

                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        flowGraph.add(j + n, 2 * n + 1, 1, 0);
                    }

                    for (int j = 0; j < n; j++) {
                        if (need[j]) {
                            flowGraph.add(2 * n, j, 1, 0);
                            for (int k = 0; k < n; k++) {
                                if (!used[j][k]) {
                                    flowGraph.add(j, k + n, 1, 0);
                                }
                            }
                        }
                    }

                    int junk = flowGraph.flow();
                    ArrayList<int[]> add = flowGraph.getFlows();

                    for (int[] item : add) {
                        int num = item[0];
                        int col = item[1];
                        used[num][col] = true;
                        grid[i][col] = num;
                    }
                }

                System.out.println("Case #" + caseNum + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    System.out.print(grid[i][0] + 1);
                    for (int j = 1; j < n; j++) {
                        System.out.print(" " + (grid[i][j] + 1));
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    public static boolean isPossible() {
        if (trace < n) return false;
        if (trace > n * n) return false;
        if (trace == n + 1) return false;
        if (trace == n * n - 1) return false;
        if (n == 3 && (trace == 5 || trace == 7)) return false;
        return true;
    }

    public static void fillDiagonal() {
        int avg = trace / n - 1;
        int remainder = trace % n;

        for (int i = 0; i < n; i++) {
            grid[i][i] = avg;
        }
        for (int i = 1; i <= remainder; i++) {
            grid[n - i][n - i]++;
        }

        if (remainder == n - 1) {
            grid[1][1]--;
            grid[n - 1][n - 1]++;
        } else if (remainder == 1) {
            grid[0][0]--;
            grid[n - 2][n - 2]++;
        }

        for (int i = 0; i < n; i++) {
            used[grid[i][i]][i] = true;
        }
    }

    public static void printGrid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Edge {
        int from, to, capacity, flow;
        Edge reverse;

        Edge(int from, int to, int capacity, int flow) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
            this.flow = flow;
        }
    }

    static class Dinic {
        ArrayDeque<Integer> queue;
        ArrayList<Edge>[] adjacencyList;
        int numNodes, source, sink, infinity = (int) 1E9;
        boolean[] blocked;
        int[] distance;

        public Dinic(int numNodes) {
            this.numNodes = numNodes;
            this.source = numNodes++;
            this.sink = numNodes++;
            this.blocked = new boolean[numNodes];
            this.distance = new int[numNodes];
            this.queue = new ArrayDeque<>();
            this.adjacencyList = new ArrayList[numNodes];
            for (int i = 0; i < numNodes; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        void add(int from, int to, int capacity, int flow) {
            Edge edge = new Edge(from, to, capacity, flow);
            Edge reverseEdge = new Edge(to, from, 0, 0);
            adjacencyList[from].add(reverseEdge.reverse = edge);
            adjacencyList[to].add(edge.reverse = reverseEdge);
        }

        ArrayList<int[]> getFlows() {
            ArrayList<int[]> result = new ArrayList<>();
            for (int i = 0; i < (numNodes - 2) / 2; i++) {
                for (Edge edge : adjacencyList[i]) {
                    if (edge.flow == 1) {
                        result.add(new int[]{edge.from, edge.to - (numNodes - 2) / 2});
                    }
                }
            }
            return result;
        }

        boolean bfs() {
            queue.clear();
            Arrays.fill(distance, -1);
            distance[sink] = 0;
            queue.add(sink);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (node == source) {
                    return true;
                }
                for (Edge edge : adjacencyList[node]) {
                    if (edge.reverse.capacity > edge.reverse.flow && distance[edge.to] == -1) {
                        distance[edge.to] = distance[node] + 1;
                        queue.add(edge.to);
                    }
                }
            }
            return distance[source] != -1;
        }

        int dfs(int node, int minFlow) {
            if (node == sink) {
                return minFlow;
            }
            int totalFlow = 0;
            for (Edge edge : adjacencyList[node]) {
                if (!blocked[edge.to] && distance[edge.to] == distance[node] - 1 && edge.capacity - edge.flow > 0) {
                    int currentFlow = dfs(edge.to, Math.min(minFlow - totalFlow, edge.capacity - edge.flow));
                    edge.flow += currentFlow;
                    edge.reverse.flow = -edge.flow;
                    totalFlow += currentFlow;
                }
                if (totalFlow == minFlow) {
                    return totalFlow;
                }
            }
            blocked[node] = totalFlow != minFlow;
            return totalFlow;
        }

        int flow() {
            clear();
            int totalFlow = 0;
            while (bfs()) {
                Arrays.fill(blocked, false);
                totalFlow += dfs(source, infinity);
            }
            return totalFlow;
        }

        void clear() {
            for (ArrayList<Edge> edges : adjacencyList) {
                for (Edge edge : edges) {
                    edge.flow = 0;
                }
            }
        }
    }
}