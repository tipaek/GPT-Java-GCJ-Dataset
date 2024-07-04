import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int len = input.nextInt();
            int trace = input.nextInt();

            if (len == 2 && trace == 3) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                continue;
            }
            if (len == 3 && trace % 3 != 0) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                continue;
            }
            if (trace == len + 1 || trace == len * len - 1) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                continue;
            }

            long[][] grid = new long[len][len];
            for (int i = 0; i < len; i++) {
                grid[i][i] = trace / len;
                if (i < trace % len)
                    grid[i][i]++;
            }
            if (trace % len == 1 || trace % len == len - 1) {
                grid[1][1]++;
                grid[len - 2][len - 2]--;
            }

            for (int num = 1; num <= len; num++) {
                for (int i = 0; i < len; i++)
                    for (int j = 0; j < len; j++)
                        if (grid[i][j] == num)
                            grid[i][j] = -999999;
                minimumMatching(grid, num);
            }

            System.out.printf("Case #%d: POSSIBLE\n", caseNum);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++)
                    System.out.printf("%d ", grid[i][j]);
                System.out.println();
            }
        }
    }

    static void minimumMatching(long[][] originalCosts, long num) {
        int H = originalCosts.length;
        int W = originalCosts[0].length;
        long[][] costs = new long[H][W];
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                costs[i][j] = originalCosts[i][j];

        if (H <= W)
            for (int i = 0; i < H; i++) {
                long minCost = Long.MAX_VALUE;
                for (int j = 0; j < W; j++)
                    if (costs[i][j] < minCost)
                        minCost = costs[i][j];
                for (int j = 0; j < W; j++)
                    costs[i][j] -= minCost;
            }
        if (W <= H)
            for (int j = 0; j < W; j++) {
                long minCost = Long.MAX_VALUE;
                for (int i = 0; i < H; i++)
                    if (costs[i][j] < minCost)
                        minCost = costs[i][j];
                for (int i = 0; i < H; i++)
                    costs[i][j] -= minCost;
            }

        Graph<String> graph = Graph.create();
        for (int i = 0; i < H; i++)
            graph.addDirectedEdge("start", "row" + i, 1);
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (costs[i][j] == 0)
                    graph.addDirectedEdge("row" + i, "col" + j);
        for (int j = 0; j < W; j++)
            graph.addDirectedEdge("col" + j, "end", 1);

        long totalFlow = 0;
        while (true) {
            totalFlow += graph.maxFlow("start", "end");

            if (totalFlow == Math.min(H, W)) {
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if (graph.getTotalWeight("col" + j, "row" + i) > 0)
                            originalCosts[i][j] = num;
                return;
            }

            Set<String> Z = new HashSet<>();
            for (int i = 0; i < H; i++)
                if (graph.getTotalWeight("row" + i, "start") == 0)
                    Z.add("row" + i);
            List<String> vertices = new ArrayList<>(Z);
            for (int level = 0; !vertices.isEmpty(); level++) {
                List<String> nextVertices = new ArrayList<>();
                for (String u : vertices)
                    for (String v : graph.outgoing.get(u).keySet())
                        if (!Z.contains(v))
                            if (level % 2 == 0) {
                                if (v.startsWith("col") && graph.getTotalWeight(v, u) == 0)
                                    nextVertices.add(v);
                            } else {
                                if (v.startsWith("row") && graph.getTotalWeight(u, v) > 0)
                                    nextVertices.add(v);
                            }
                Z.addAll(nextVertices);
                vertices = nextVertices;
            }

            Set<String> minVertexCover = new HashSet<>();
            for (int i = 0; i < H; i++)
                if (!Z.contains("row" + i))
                    minVertexCover.add("row" + i);
            for (int j = 0; j < W; j++)
                if (Z.contains("col" + j))
                    minVertexCover.add("col" + j);

            long minCost = Long.MAX_VALUE;
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++)
                    if (costs[i][j] < minCost && !minVertexCover.contains("row" + i) && !minVertexCover.contains("col" + j))
                        minCost = costs[i][j];
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++) {
                    if (minVertexCover.contains("row" + i) && minVertexCover.contains("col" + j))
                        costs[i][j] += minCost;
                    else if (!minVertexCover.contains("row" + i) && !minVertexCover.contains("col" + j))
                        costs[i][j] -= minCost;
                    if (costs[i][j] == 0)
                        graph.addDirectedEdge("row" + i, "col" + j);
                }
        }
    }

    static class Graph<T> {

        final Set<T> vertices = new HashSet<>();
        final Map<T, Map<T, Long>> outgoing = new HashMap<>();

        static <T> Graph<T> create() {
            return new Graph<>();
        }

        long getTotalWeight(T start, T end) {
            return outgoing.computeIfAbsent(start, key -> new HashMap<>()).getOrDefault(end, 0L);
        }

        void setTotalWeight(T start, T end, long weight) {
            outgoing.computeIfAbsent(start, key -> new HashMap<>()).put(end, weight);
        }

        Graph<T> addDirectedEdge(T start, T end) {
            return addDirectedEdge(start, end, 1);
        }

        Graph<T> addDirectedEdge(T start, T end, long weight) {
            vertices.add(start);
            vertices.add(end);
            outgoing.computeIfAbsent(start, key -> new HashMap<>()).put(end, weight);
            return this;
        }

        long maxFlow(T start, T end) {
            long flow = 0;
            while (true) {
                Map<T, T> prevVertex = new HashMap<>();
                List<T> currentVertices = new ArrayList<>();
                currentVertices.add(start);
                Set<T> visited = new HashSet<>();
                while (!currentVertices.isEmpty() && !visited.contains(end)) {
                    List<T> nextVertices = new ArrayList<>();
                    for (T u : currentVertices)
                        for (T v : outgoing.get(u).keySet())
                            if (!visited.contains(v) && getTotalWeight(u, v) > 0) {
                                prevVertex.put(v, u);
                                visited.add(v);
                                nextVertices.add(v);
                            }
                    currentVertices = nextVertices;
                }
                if (!visited.contains(end))
                    return flow;

                long minWeight = Long.MAX_VALUE;
                for (T v = end; v != start; v = prevVertex.get(v)) {
                    long weight = getTotalWeight(prevVertex.get(v), v);
                    if (weight < minWeight)
                        minWeight = weight;
                }
                for (T v = end; v != start; v = prevVertex.get(v)) {
                    T u = prevVertex.get(v);
                    setTotalWeight(u, v, getTotalWeight(u, v) - minWeight);
                    setTotalWeight(v, u, getTotalWeight(v, u) + minWeight);
                }
                flow += minWeight;
            }
        }
    }
}
