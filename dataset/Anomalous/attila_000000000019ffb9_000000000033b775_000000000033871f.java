import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Edge {
        int from, to, index;
        int value = 1000000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String[] initialLine = reader.readLine().split(" ");
            int c = Integer.parseInt(initialLine[0]);
            int d = Integer.parseInt(initialLine[1]);

            String[] latencyLine = reader.readLine().split(" ");
            int[][] nodes = new int[latencyLine.length][2];
            int[] latency = new int[c + 1];
            Arrays.fill(latency, -1);
            latency[1] = 0;

            for (int i = 0; i < latencyLine.length; i++) {
                nodes[i][0] = Integer.parseInt(latencyLine[i]);
                nodes[i][1] = i + 2;
            }
            Arrays.sort(nodes, (a, b) -> Integer.compare(b[0], a[0]));

            Map<Integer, Map<Integer, Edge>> edgesMap = new HashMap<>();
            Map<Integer, List<Edge>> graph = new HashMap<>();

            for (int i = 1; i <= d; i++) {
                String[] edgeLine = reader.readLine().split(" ");
                int u = Integer.parseInt(edgeLine[0]);
                int v = Integer.parseInt(edgeLine[1]);
                addEdge(u, v, graph, i, edgesMap);
                addEdge(v, u, graph, i, null);
            }

            int i = 0;
            int targetLatency = 0;

            while (i < nodes.length) {
                targetLatency++;
                int currentLatency = nodes[i][0];
                List<Integer> sameLatencyNodes = new ArrayList<>();
                sameLatencyNodes.add(nodes[i][1]);

                while (i + 1 < nodes.length && nodes[i + 1][0] == currentLatency) {
                    sameLatencyNodes.add(nodes[++i][1]);
                }
                i++;

                for (int node : sameLatencyNodes) {
                    List<Integer> setNeighbours = getSetNeighbours(graph, node, latency);

                    for (int neighbour : setNeighbours) {
                        int neighbourLatency = latency[neighbour];
                        int latencyDifference = targetLatency - neighbourLatency;
                        if (latencyDifference == 0) latencyDifference = 1;
                        updateEdge(edgesMap, node, neighbour, latencyDifference);
                    }
                    latency[node] = targetLatency;
                }
            }

            int[] resultArray = new int[d + 1];
            for (Map<Integer, Edge> edgeMap : edgesMap.values()) {
                for (Edge edge : edgeMap.values()) {
                    resultArray[edge.index] = edge.value;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 1; j < resultArray.length; j++) {
                if (j > 1) {
                    result.append(' ');
                }
                result.append(resultArray[j]);
            }
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }

    private static void updateEdge(Map<Integer, Map<Integer, Edge>> edgesMap, int from, int to, int latency) {
        edgesMap.get(from).get(to).value = latency;
    }

    private static List<Integer> getSetNeighbours(Map<Integer, List<Edge>> graph, int node, int[] latency) {
        List<Integer> neighbours = new ArrayList<>();
        for (Edge edge : graph.get(node)) {
            int neighbour = edge.to;
            if (latency[neighbour] != -1) {
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    private static void addEdge(int from, int to, Map<Integer, List<Edge>> graph, int index, Map<Integer, Map<Integer, Edge>> edgesMap) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(createEdge(from, to, index));

        if (edgesMap != null) {
            edgesMap.computeIfAbsent(from, k -> new HashMap<>()).put(to, createEdge(from, to, index));
            edgesMap.computeIfAbsent(to, k -> new HashMap<>()).put(from, createEdge(to, from, index));
        }
    }

    private static Edge createEdge(int from, int to, int index) {
        Edge edge = new Edge();
        edge.from = from;
        edge.to = to;
        edge.index = index;
        return edge;
    }
}