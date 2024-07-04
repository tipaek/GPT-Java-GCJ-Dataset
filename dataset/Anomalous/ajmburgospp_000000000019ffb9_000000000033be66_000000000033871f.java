import java.util.*;
import java.io.*;

public class Solution {
    static class EdgeList extends ArrayList<Edge> {}
    
    static class Edge {
        int u, v, cost;
        
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
            this.cost = -100;
        }
        
        int other(int vertex) {
            return vertex == u ? v : u;
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
        int numberOfNodes;
        
        Graph(int numberOfNodes) {
            this.numberOfNodes = numberOfNodes;
            adjacencyList = new EdgeList[numberOfNodes];
            nodeValues = new int[numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
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
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
            boolean[] visited = new boolean[numberOfNodes];
            visited[0] = true;
            
            for (Edge edge : adjacencyList[0]) {
                priorityQueue.add(new Pair(0, edge, nodeValues[edge.other(0)]));
            }
            
            while (!priorityQueue.isEmpty()) {
                Pair pair = priorityQueue.poll();
                int vertex = pair.edge.other(pair.prev);
                
                if (visited[vertex]) {
                    pair.edge.cost = 1000000;
                    continue;
                }
                
                visited[vertex] = true;
                pair.edge.cost = nodeValues[vertex] - nodeValues[pair.prev];
                
                for (Edge edge : adjacencyList[vertex]) {
                    int otherVertex = edge.other(vertex);
                    if (!visited[otherVertex]) {
                        priorityQueue.add(new Pair(vertex, edge, nodeValues[otherVertex]));
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            Edge[] edgeArray = new Edge[edges];
            Graph graph = new Graph(nodes);
            
            for (int i = 1; i < nodes; i++) {
                graph.setNodeValue(i, -scanner.nextInt());
            }
            
            for (int i = 0; i < edges; i++) {
                edgeArray[i] = new Edge(scanner.nextInt() - 1, scanner.nextInt() - 1);
                graph.addEdge(edgeArray[i]);
            }
            
            graph.solve();
            
            System.out.printf("Case #%d: %d", testCase, edgeArray[0].cost);
            for (int i = 1; i < edges; i++) {
                System.out.print(" " + edgeArray[i].cost);
            }
            System.out.println();
        }
    }
}