import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int trace = Integer.parseInt(input[1]);

            if (isImpossible(n, trace)) {
                output.append(String.format("Case #%d: IMPOSSIBLE\n", testCase + 1));
                continue;
            }

            Integer[][] grid = new Integer[n][n];
            int[] values = determineValues(n, trace);

            fillDiagonal(grid, values[0], n - 2);
            grid[n - 2][n - 2] = values[1];
            grid[n - 1][n - 1] = values[2];

            if (values[0] != values[1]) {
                grid[n - 1][n - 2] = values[0];
                grid[n - 2][n - 1] = values[0];
            }

            placeRemainingValues(grid, values);

            output.append(String.format("Case #%d: POSSIBLE\n%s", testCase + 1, gridToString(grid)));
        }
        System.out.print(output);
    }

    private static boolean isImpossible(int n, int trace) {
        return trace == n + 1 || trace == n * n - 1 || (n == 3 && (trace == 5 || trace == 7));
    }

    private static int[] determineValues(int n, int trace) {
        int a = -1, b = -1, c = -1;

        if (trace % n == 0) {
            a = b = c = trace / n;
        } else {
            outer:
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    for (int k = j; k <= n; k++) {
                        if (i == k || (n == 3 && j == k)) continue;
                        if (i * (n - 2) + j + k == trace) {
                            a = i;
                            b = j;
                            c = k;
                            break outer;
                        }
                    }
                }
            }
        }
        return new int[]{a, b, c};
    }

    private static void fillDiagonal(Integer[][] grid, int value, int length) {
        for (int i = 0; i < length; i++) {
            grid[i][i] = value;
        }
    }

    private static void placeRemainingValues(Integer[][] grid, int[] values) {
        int n = grid.length;
        for (int value : values) {
            if (value != -1) {
                placeValue(grid, value);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != values[0] && i != values[1] && i != values[2]) {
                placeValue(grid, i);
            }
        }
    }

    private static void placeValue(Integer[][] grid, int value) {
        int n = grid.length;
        List<Edge>[] graph = createGraph(2 * n + 2);

        boolean[] validRow = new boolean[n];
        boolean[] validCol = new boolean[n];

        for (int i = 0; i < n; i++) {
            validRow[i] = !hasValueInRow(grid, i, value);
            validCol[i] = !hasValueInCol(grid, i, value);
        }

        for (int r = 0; r < n; r++) {
            if (!validRow[r]) continue;
            for (int c = 0; c < n; c++) {
                if (!validCol[c] || grid[r][c] != null) continue;
                addEdge(graph, r, n + c, 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (validRow[i]) addEdge(graph, 2 * n, i, 1);
            if (validCol[i]) addEdge(graph, n + i, 2 * n + 1, 1);
        }

        int[] cut = maxFlow(graph, 2 * n, 2 * n + 1);
        for (int i = 0; i < n; i++) {
            if (!validRow[i]) continue;
            for (Edge e : graph[i]) {
                if (e.flow > 0) {
                    grid[i][e.to - n] = value;
                }
            }
        }
    }

    private static String gridToString(Integer[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (Integer[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j] == null ? 0 : row[j]);
                if (j < row.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static boolean hasValueInRow(Integer[][] grid, int row, int value) {
        for (Integer cell : grid[row]) {
            if (cell != null && cell.equals(value)) return true;
        }
        return false;
    }

    private static boolean hasValueInCol(Integer[][] grid, int col, int value) {
        for (Integer[] row : grid) {
            if (row[col] != null && row[col].equals(value)) return true;
        }
        return false;
    }

    private static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    private static void addEdge(List<Edge>[] graph, int from, int to, double capacity) {
        graph[from].add(new Edge(to, graph[to].size(), capacity));
        graph[to].add(new Edge(from, graph[from].size() - 1, 0));
    }

    private static int[] maxFlow(List<Edge>[] graph, int source, int sink) {
        double flow = 0;
        int[] dist = new int[graph.length];
        while (bfs(graph, source, sink, dist)) {
            int[] ptr = new int[graph.length];
            double flowIncrement;
            while ((flowIncrement = dfs(graph, ptr, dist, sink, source, Double.MAX_VALUE)) > 0) {
                flow += flowIncrement;
            }
        }
        return dist;
    }

    private static boolean bfs(List<Edge>[] graph, int source, int sink, int[] dist) {
        Arrays.fill(dist, -1);
        dist[source] = 0;
        int[] queue = new int[graph.length];
        int size = 0;
        queue[size++] = source;
        for (int i = 0; i < size; i++) {
            for (Edge edge : graph[queue[i]]) {
                if (dist[edge.to] < 0 && edge.flow < edge.capacity) {
                    dist[edge.to] = dist[queue[i]] + 1;
                    queue[size++] = edge.to;
                }
            }
        }
        return dist[sink] >= 0;
    }

    private static double dfs(List<Edge>[] graph, int[] ptr, int[] dist, int sink, int node, double flow) {
        if (node == sink) return flow;
        for (; ptr[node] < graph[node].size(); ++ptr[node]) {
            Edge edge = graph[node].get(ptr[node]);
            if (dist[edge.to] == dist[node] + 1 && edge.flow < edge.capacity) {
                double increment = dfs(graph, ptr, dist, sink, edge.to, Math.min(flow, edge.capacity - edge.flow));
                if (increment > 0) {
                    edge.flow += increment;
                    graph[edge.to].get(edge.rev).flow -= increment;
                    return increment;
                }
            }
        }
        return 0;
    }

    static class Edge {
        int to, rev;
        double capacity, flow;

        Edge(int to, int rev, double capacity) {
            this.to = to;
            this.rev = rev;
            this.capacity = capacity;
        }
    }
}