import java.util.*;

public class Solution {
    
    public static int n;
    public static Point[] list;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int nCases = stdin.nextInt();
        
        for (int caseNum = 1; caseNum <= nCases; caseNum++) {
            n = stdin.nextInt();
            list = new Point[n];
            
            for (int i = 0; i < n; i++) {
                long x = stdin.nextLong();
                long y = stdin.nextLong();
                list[i] = new Point(x, y);
            }
            
            int result = (n <= 4) ? n : findMaxPointsOnLine();
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static int findMaxPointsOnLine() {
        int maxPoints = 4; // Minimum value if n > 4
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long deltaY = list[j].y - list[i].y;
                long deltaX = list[j].x - list[i].x;
                int points = computeMaxPoints(deltaY, deltaX);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return maxPoints;
    }

    public static int computeMaxPoints(long deltaY, long deltaX) {
        Dinic graph = new Dinic(2 * n);
        for (int i = 0; i < n; i++) {
            graph.addEdge(2 * n, i, 1, 0);
            graph.addEdge(n + i, 2 * n + 1, 1, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long currentDeltaY = list[j].y - list[i].y;
                long currentDeltaX = list[j].x - list[i].x;
                if (isSameSign(currentDeltaY, deltaY) && isSameSign(currentDeltaX, deltaX) &&
                        currentDeltaY * deltaX == currentDeltaX * deltaY) {
                    graph.addEdge(i, n + j, 1, 0);
                }
            }
        }
        int result = graph.maxFlow();
        return Math.min(n, 2 * result + 2);
    }

    public static boolean isSameSign(long a, long b) {
        return (a < 0 && b < 0) || (a > 0 && b > 0) || (a == 0 && b == 0);
    }
}

class Point {
    public long x;
    public long y;

    public Point(long x, long y) {
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
    public ArrayDeque<Integer> queue;
    public ArrayList<Edge>[] adjacencyList;
    public int[] distance;
    public boolean[] blocked;
    public int source, sink, nodeCount;
    public static final int INFINITY = (int) 1E9;

    public Dinic(int count) {
        nodeCount = count + 2;
        source = count;
        sink = count + 1;
        queue = new ArrayDeque<>();
        distance = new int[nodeCount];
        blocked = new boolean[nodeCount];
        adjacencyList = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int capacity, int flow) {
        Edge forwardEdge = new Edge(from, to, capacity, flow);
        Edge reverseEdge = new Edge(to, from, 0, 0);
        forwardEdge.reverse = reverseEdge;
        reverseEdge.reverse = forwardEdge;
        adjacencyList[from].add(forwardEdge);
        adjacencyList[to].add(reverseEdge);
    }

    public boolean bfs() {
        Arrays.fill(distance, -1);
        distance[sink] = 0;
        queue.clear();
        queue.add(sink);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == source) return true;
            for (Edge edge : adjacencyList[node]) {
                if (edge.reverse.capacity > edge.reverse.flow && distance[edge.to] == -1) {
                    distance[edge.to] = distance[node] + 1;
                    queue.add(edge.to);
                }
            }
        }
        return distance[source] != -1;
    }

    public int dfs(int node, int flow) {
        if (node == sink) return flow;
        int totalFlow = 0;

        for (Edge edge : adjacencyList[node]) {
            int currentFlow = 0;
            if (!blocked[edge.to] && distance[edge.to] == distance[node] - 1 && edge.capacity - edge.flow > 0) {
                currentFlow = dfs(edge.to, Math.min(flow - totalFlow, edge.capacity - edge.flow));
                edge.flow += currentFlow;
                edge.reverse.flow = -edge.flow;
                totalFlow += currentFlow;
            }
            if (totalFlow == flow) return totalFlow;
        }
        blocked[node] = totalFlow != flow;
        return totalFlow;
    }

    public int maxFlow() {
        int totalFlow = 0;
        while (bfs()) {
            Arrays.fill(blocked, false);
            totalFlow += dfs(source, INFINITY);
        }
        return totalFlow;
    }
}