import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int nodes = scanner.nextInt();
            int edgesCount = scanner.nextInt();
            int[] values = new int[nodes - 1];
            
            for (int i = 0; i < nodes - 1; i++) {
                values[i] = scanner.nextInt();
            }
            
            int[][] edges = new int[edgesCount][2];
            for (int i = 0; i < edgesCount; i++) {
                edges[i][0] = scanner.nextInt() - 1;
                edges[i][1] = scanner.nextInt() - 1;
            }
            
            System.out.println("Case #" + testCase + ": " + solve(nodes, values, edges));
        }
    }

    public static String solve(int nodes, int[] values, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<String, Integer> edgeWeights = new HashMap<>();
        
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            edgeWeights.put(edge[0] + " " + edge[1], 1000000);
        }

        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distances = new HashMap<>();
        
        for (int i = 0; i < nodes - 1; i++) {
            if (values[i] < 0) {
                distances.put(i + 1, -values[i]);
            }
        }
        
        boolean[] visited = new boolean[nodes];
        distances.put(0, 0);
        priorityQueue.offer(new int[]{0, 0});
        visited[0] = true;
        
        while (!priorityQueue.isEmpty()) {
            int currentNode = priorityQueue.poll()[0];
            
            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    String edgeKey = currentNode + " " + neighbor;
                    
                    if (edgeWeights.containsKey(edgeKey)) {
                        edgeWeights.put(edgeKey, distances.get(neighbor) - distances.get(currentNode));
                    } else {
                        edgeKey = neighbor + " " + currentNode;
                        edgeWeights.put(edgeKey, distances.get(neighbor) - distances.get(currentNode));
                    }
                    
                    priorityQueue.offer(new int[]{neighbor, distances.get(neighbor)});
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            result.append(edgeWeights.get(edge[0] + " " + edge[1]));
            if (i != edges.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}