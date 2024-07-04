import java.util.*;

public class B {
    static class EdgeList extends ArrayList<Edge> {}

    static class Edge {
        int u, v, cost;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
            this.cost = -100;
        }
        int other(int x) {
            return x == u ? v : u;
        }
    }

    static class Pair implements Comparable<Pair> {
        int prev;
        Edge edge;
        int cost;
        Pair(int prev, Edge edge, int cost) {
            this.prev = prev;
            this.edge = edge;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static class Graph {
        EdgeList[] adjacencyList;
        int[] nodeValues;
        int nodeCount;

        Graph(int nodeCount) {
            this.nodeCount = nodeCount;
            adjacencyList = new EdgeList[nodeCount];
            nodeValues = new int[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                adjacencyList[i] = new EdgeList();
            }
        }

        void setNodeValue(int index, int value) {
            nodeValues[index] = value;
        }

        void addEdge(Edge edge) {
            adjacencyList[edge.u].add(edge);
            adjacencyList[edge.v].add(edge);
        }

        void solve() {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[nodeCount];
            visited[0] = true;

            for (Edge edge : adjacencyList[0]) {
                pq.add(new Pair(0, edge, nodeValues[edge.other(0)]));
            }

            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                int v = pair.edge.other(pair.prev);
                if (visited[v]) {
                    pair.edge.cost = 1000000;
                    continue;
                }
                visited[v] = true;
                pair.edge.cost = nodeValues[v] - nodeValues[pair.prev];

                for (Edge edge : adjacencyList[v]) {
                    int other = edge.other(v);
                    if (!visited[other]) {
                        pq.add(new Pair(v, edge, nodeValues[other]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int nodeCount = scanner.nextInt();
            int edgeCount = scanner.nextInt();
            Edge[] edges = new Edge[edgeCount];
            Graph graph = new Graph(nodeCount);

            for (int i = 1; i < nodeCount; i++) {
                graph.setNodeValue(i, -scanner.nextInt());
            }

            for (int i = 0; i < edgeCount; i++) {
                edges[i] = new Edge(scanner.nextInt() - 1, scanner.nextInt() - 1);
                graph.addEdge(edges[i]);
            }

            graph.solve();

            System.out.printf("Case #%d: %d", testCase, edges[0].cost);
            for (int i = 1; i < edgeCount; i++) {
                System.out.print(" " + edges[i].cost);
            }
            System.out.println();
        }

        scanner.close();
    }
}