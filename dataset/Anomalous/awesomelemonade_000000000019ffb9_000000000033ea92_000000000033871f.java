import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int t = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < t; tt++) {
            StringTokenizer info = new StringTokenizer(reader.readLine());
            int c = Integer.parseInt(info.nextToken());
            int d = Integer.parseInt(info.nextToken());
            int[] computers = new int[c];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < c - 1; i++) {
                computers[i + 1] = Integer.parseInt(tokenizer.nextToken());
            }
            Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
            for (int i = 0; i < c; i++) {
                edges.put(i, new HashMap<>());
            }
            for (int i = 0; i < d; i++) {
                StringTokenizer edgeInfo = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(edgeInfo.nextToken()) - 1;
                int v = Integer.parseInt(edgeInfo.nextToken()) - 1;
                edges.get(u).put(v, i);
                edges.get(v).put(u, i);
            }
            int[] edgeLatencies = new int[d];
            int[] vertexLatencies = new int[c];
            Arrays.fill(vertexLatencies, -1);
            Arrays.fill(edgeLatencies, -1);
            vertexLatencies[0] = 0; // source computer

            List<Set<Integer>> buckets = new ArrayList<>(Collections.nCopies(c, new HashSet<>()));
            for (int i = 1; i < computers.length; i++) {
                if (computers[i] < 0) {
                    buckets.get(-computers[i]).add(i);
                }
            }

            int currentLatency = 0;
            for (int i = 0; i < buckets.size(); i++) {
                if (buckets.get(i).isEmpty()) {
                    continue;
                }
                Map<Integer, Integer> minParents = new HashMap<>();
                Map<Integer, Integer> minLatencies = new HashMap<>();
                Map<Integer, Integer> minEdgeIds = new HashMap<>();

                for (int vertex : buckets.get(i)) {
                    Map<Integer, Integer> adjacentEdges = edges.get(vertex);
                    int minLatency = Integer.MAX_VALUE;
                    int minParent = -1;
                    int minEdgeId = -1;
                    for (int neighbor : adjacentEdges.keySet()) {
                        if (vertexLatencies[neighbor] == -1) {
                            continue;
                        }
                        if (vertexLatencies[neighbor] < minLatency) {
                            minLatency = vertexLatencies[neighbor];
                            minParent = neighbor;
                            minEdgeId = adjacentEdges.get(neighbor);
                        }
                    }
                    minParents.put(vertex, minParent);
                    minLatencies.put(vertex, minLatency);
                    minEdgeIds.put(vertex, minEdgeId);
                }
                int maxLatency = Integer.MIN_VALUE;
                for (int latency : minLatencies.values()) {
                    maxLatency = Math.max(latency, maxLatency);
                }
                int newLatency = Math.max(maxLatency + 1, currentLatency + 1);

                for (int vertex : minParents.keySet()) {
                    int edgeId = minEdgeIds.get(vertex);
                    int latencyDiff = newLatency - minLatencies.get(vertex);
                    edgeLatencies[edgeId] = latencyDiff;
                    vertexLatencies[vertex] = newLatency;
                }
                currentLatency = Math.max(currentLatency, newLatency);
            }

            writer.printf("Case #%d: ", tt + 1);
            writer.print(edgeLatencies[0]);
            for (int i = 1; i < edgeLatencies.length; i++) {
                writer.print(' ');
                if (edgeLatencies[i] == -1) {
                    edgeLatencies[i] = 1000000; // 1e6
                }
                writer.print(edgeLatencies[i]);
            }
            writer.println();
        }

        reader.close();
        writer.close();
    }

    static class Vertex {
        int id;
        int latency = 0;
        int info = 0;
        Vertex parent;
        int edgeTraversed;

        public Vertex(int id, Vertex parent, int edgeTraversed, int info) {
            this.id = id;
            this.parent = parent;
            this.edgeTraversed = edgeTraversed;
            this.info = info;
        }

        public void setLatency(int latency) {
            this.latency = latency;
        }

        public int getLatency() {
            return latency;
        }
    }
}