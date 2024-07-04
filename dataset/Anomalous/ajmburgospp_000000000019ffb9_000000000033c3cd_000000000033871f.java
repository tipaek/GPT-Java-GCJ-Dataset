import java.util.*;
import java.io.*;

public class Solution {
    static class EdgeList extends ArrayList<Edge> {}

    static class Edge {
        int u, v, cost;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
            this.cost = 1000000;
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
        int[] nums;
        int numVertices;

        Graph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new EdgeList[numVertices];
            nums = new int[numVertices];
            for (int i = 0; i < numVertices; i++) {
                adjacencyList[i] = new EdgeList();
            }
        }

        void setNum(int index, int num) {
            nums[index] = num;
        }

        void addEdge(Edge edge) {
            adjacencyList[edge.u].add(edge);
            adjacencyList[edge.v].add(edge);
        }

        void solve() {
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
            boolean[] visited = new boolean[numVertices];
            visited[0] = true;

            for (Edge edge : adjacencyList[0]) {
                priorityQueue.add(new Pair(0, edge, nums[edge.other(0)]));
            }

            while (!priorityQueue.isEmpty()) {
                Pair currentPair = priorityQueue.poll();
                int vertex = currentPair.edge.other(currentPair.prev);
                if (visited[vertex]) {
                    currentPair.edge.cost = 1000000;
                    continue;
                }
                int cost = nums[vertex] - nums[currentPair.prev];
                if (cost == 0) continue;
                visited[vertex] = true;
                currentPair.edge.cost = cost;
                for (Edge edge : adjacencyList[vertex]) {
                    int otherVertex = edge.other(vertex);
                    if (!visited[otherVertex]) {
                        priorityQueue.add(new Pair(vertex, edge, nums[otherVertex]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numVertices = scanner.nextInt();
            int numEdges = scanner.nextInt();
            Edge[] edges = new Edge[numEdges];
            Graph graph = new Graph(numVertices);

            for (int j = 1; j < numVertices; j++) {
                graph.setNum(j, -scanner.nextInt());
            }

            for (int j = 0; j < numEdges; j++) {
                edges[j] = new Edge(scanner.nextInt() - 1, scanner.nextInt() - 1);
                graph.addEdge(edges[j]);
            }

            graph.solve();

            System.out.printf("Case #%d: %d", i, edges[0].cost);
            for (int j = 1; j < numEdges; j++) {
                System.out.print(" " + edges[j].cost);
            }
            System.out.println();
        }
    }
}