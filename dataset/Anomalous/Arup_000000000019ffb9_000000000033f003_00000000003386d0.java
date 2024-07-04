import java.util.*;

public class Solution {
    private static int n;
    private static Point[] points;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            n = scanner.nextInt();
            points = new Point[n];

            for (int i = 0; i < n; i++) {
                long x = scanner.nextLong();
                long y = scanner.nextLong();
                points[i] = new Point(x, y);
            }

            int result = (n <= 4) ? n : calculateMaxPoints();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean haveSameSign(long a, long b) {
        return (a < 0 && b < 0) || (a > 0 && b > 0) || (a == 0 && b == 0);
    }

    private static int calculateMaxPoints() {
        int maxPoints = 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long deltaY = points[j].y - points[i].y;
                long deltaX = points[j].x - points[i].x;
                int pointsOnLine = findPointsOnLine(deltaY, deltaX);
                maxPoints = Math.max(maxPoints, pointsOnLine);
            }
        }

        return maxPoints;
    }

    private static int findPointsOnLine(long deltaY, long deltaX) {
        Dinic dinic = new Dinic(2 * n);
        for (int i = 0; i < n; i++) {
            dinic.addEdge(2 * n, i, 1);
            dinic.addEdge(n + i, 2 * n + 1, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long currentDeltaY = points[j].y - points[i].y;
                long currentDeltaX = points[j].x - points[i].x;

                if (!haveSameSign(currentDeltaY, deltaY) || !haveSameSign(currentDeltaX, deltaX)) continue;

                if (currentDeltaY * deltaX == currentDeltaX * deltaY) {
                    dinic.addEdge(i, n + j, 1);
                }
            }
        }

        int flowResult = dinic.getMaxFlow();
        return Math.min(n, 2 * flowResult + 1);
    }
}

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Edge {
    int from, to, capacity, flow;
    Edge reverse;

    Edge(int from, int to, int capacity, int flow) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = flow;
    }
}

class Dinic {
    private static final int INFINITY = (int) 1E9;
    private List<Edge>[] graph;
    private int[] distance;
    private boolean[] blocked;
    private int source, sink, nodeCount;

    Dinic(int nodes) {
        nodeCount = nodes + 2;
        source = nodes;
        sink = nodes + 1;
        graph = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }
        distance = new int[nodeCount];
        blocked = new boolean[nodeCount];
    }

    void addEdge(int from, int to, int capacity) {
        Edge forwardEdge = new Edge(from, to, capacity, 0);
        Edge backwardEdge = new Edge(to, from, 0, 0);
        forwardEdge.reverse = backwardEdge;
        backwardEdge.reverse = forwardEdge;
        graph[from].add(forwardEdge);
        graph[to].add(backwardEdge);
    }

    int getMaxFlow() {
        int totalFlow = 0;
        while (bfs()) {
            Arrays.fill(blocked, false);
            int flow;
            while ((flow = dfs(source, INFINITY)) != 0) {
                totalFlow += flow;
            }
        }
        return totalFlow;
    }

    private boolean bfs() {
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sink);
        distance[sink] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == source) return true;
            for (Edge edge : graph[node]) {
                if (edge.reverse.capacity > edge.reverse.flow && distance[edge.to] == -1) {
                    distance[edge.to] = distance[node] + 1;
                    queue.add(edge.to);
                }
            }
        }
        return distance[source] != -1;
    }

    private int dfs(int node, int flow) {
        if (node == sink) return flow;
        int totalFlow = 0;

        for (Edge edge : graph[node]) {
            if (!blocked[edge.to] && distance[edge.to] == distance[node] - 1 && edge.capacity > edge.flow) {
                int currentFlow = dfs(edge.to, Math.min(flow - totalFlow, edge.capacity - edge.flow));
                edge.flow += currentFlow;
                edge.reverse.flow -= currentFlow;
                totalFlow += currentFlow;
                if (totalFlow == flow) return totalFlow;
            }
        }
        blocked[node] = totalFlow != flow;
        return totalFlow;
    }
}