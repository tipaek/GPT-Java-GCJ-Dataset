import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine());
        for (int test = 0; test < testCases; test++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int trace = Integer.parseInt(input[1]);

            if (trace == n + 1 || trace == n * n - 1) {
                output.append(String.format("Case #%d: IMPOSSIBLE\n", test + 1));
                continue;
            }

            Integer[][] grid = new Integer[n][n];
            int a = -1, b = -1, c = -1;

            if (trace % n == 0) {
                a = b = c = trace / n;
            } else {
                outerLoop:
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (i == j) continue;
                        for (int k = j; k <= n; k++) {
                            if (i == k || (n == 3 && j == k)) continue;
                            if (i * (n - 2) + j + k == trace) {
                                a = i;
                                b = j;
                                c = k;
                                break outerLoop;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n - 2; i++) {
                grid[i][i] = a;
            }
            grid[n - 2][n - 2] = b;
            grid[n - 1][n - 1] = c;

            if (a != b) {
                grid[n - 1][n - 2] = a;
                grid[n - 2][n - 1] = a;
            }

            if (b != a) placeValue(grid, b);
            if (c != b && c != a) placeValue(grid, c);

            for (int i = 1; i <= n; i++) {
                if (i != a && i != b && i != c) {
                    placeValue(grid, i);
                }
            }

            output.append(String.format("Case #%d: POSSIBLE\n%s", test + 1, gridToString(grid)));
        }
        System.out.print(output);
    }

    static void placeValue(Integer[][] grid, int value) {
        int n = grid.length;
        List<Edge>[] graph = createGraph(2 * n + 2);

        boolean[] validRow = new boolean[n];
        boolean[] validCol = new boolean[n];

        for (int i = 0; i < n; i++) {
            validRow[i] = !rowHasValue(grid, i, value);
            validCol[i] = !colHasValue(grid, i, value);
        }

        for (int r = 0; r < n; r++) {
            if (!validRow[r]) continue;
            for (int c = 0; c < n; c++) {
                if (!validCol[c]) continue;
                if (grid[r][c] == null) addEdge(graph, r, n + c, 1);
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
                    grid[i][e.vertex - n] = value;
                }
            }
        }
    }

    static String gridToString(Integer[][] grid) {
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

    static boolean rowHasValue(Integer[][] grid, int row, int value) {
        for (Integer cell : grid[row]) {
            if (cell != null && cell == value) return true;
        }
        return false;
    }

    static boolean colHasValue(Integer[][] grid, int col, int value) {
        for (Integer[] row : grid) {
            if (row[col] != null && row[col] == value) return true;
        }
        return false;
    }

    static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    static void addEdge(List<Edge>[] graph, int from, int to, double capacity) {
        graph[from].add(new Edge(to, graph[to].size(), capacity));
        graph[to].add(new Edge(from, graph[from].size() - 1, 0));
    }

    static int[] maxFlow(List<Edge>[] graph, int source, int sink) {
        double flow = 0;
        int[] distances = new int[graph.length];

        while (bfs(graph, source, sink, distances)) {
            int[] pointer = new int[graph.length];
            while (true) {
                double df = dfs(graph, pointer, distances, sink, source, Double.MAX_VALUE);
                if (df == 0) break;
                flow += df;
            }
        }
        return distances;
    }

    static boolean bfs(List<Edge>[] graph, int source, int sink, int[] distances) {
        Arrays.fill(distances, -1);
        distances[source] = 0;
        int[] queue = new int[graph.length];
        int size = 0;
        queue[size++] = source;

        for (int i = 0; i < size; i++) {
            for (Edge edge : graph[queue[i]]) {
                if (distances[edge.vertex] < 0 && edge.flow < edge.capacity) {
                    distances[edge.vertex] = distances[queue[i]] + 1;
                    queue[size++] = edge.vertex;
                }
            }
        }
        return distances[sink] >= 0;
    }

    static double dfs(List<Edge>[] graph, int[] pointer, int[] distances, int sink, int node, double flow) {
        if (node == sink) return flow;

        for (; pointer[node] < graph[node].size(); ++pointer[node]) {
            Edge edge = graph[node].get(pointer[node]);
            if (distances[edge.vertex] == distances[node] + 1 && edge.flow < edge.capacity) {
                double df = dfs(graph, pointer, distances, sink, edge.vertex, Math.min(flow, edge.capacity - edge.flow));
                if (df > 0) {
                    edge.flow += df;
                    graph[edge.vertex].get(edge.reverse).flow -= df;
                    return df;
                }
            }
        }
        return 0;
    }

    static class Edge {
        int vertex, reverse;
        double capacity, flow;

        Edge(int vertex, int reverse, double capacity) {
            this.vertex = vertex;
            this.reverse = reverse;
            this.capacity = capacity;
            this.flow = 0;
        }
    }
}