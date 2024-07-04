import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int e = in.nextInt();
            int[] arr = new int[n - 1];
            for (int cnt = 0; cnt < n - 1; cnt++) {
                arr[cnt] = in.nextInt();
            }
            int[][] edges = new int[e][2];
            for (int cnt = 0; cnt < e; cnt++) {
                edges[cnt][0] = in.nextInt() - 1;
                edges[cnt][1] = in.nextInt() - 1;
            }
            System.out.println("Case #" + i + ": " + solve(n, arr, edges));
        }
    }

    public static String solve(int n, int[] arr, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<String, Integer> edgeMap = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            edgeMap.put(edge[0] + " " + edge[1], 1000000);
        }

        Queue<int[]> pqR = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Queue<int[]> pqD = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < 0) {
                rank.put(i + 1, -arr[i]);
            } else {
                dist.put(i + 1, arr[i]);
            }
        }

        dist.put(0, 0);
        pqD.offer(new int[]{0, 0});
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!pqR.isEmpty() || !pqD.isEmpty()) {
            Set<int[]> setR = new HashSet<>();
            Set<int[]> setD = new HashSet<>();
            processQueue(pqR, graph, visited, list, rank, dist, setR, setD);
            processQueue(pqD, graph, visited, list, rank, dist, setR, setD);
            pqR.addAll(setR);
            pqD.addAll(setD);
        }

        int prevDist = 0;
        for (int i = 0; i < list.size(); i++) {
            int node = list.get(i);
            if (rank.containsKey(node)) {
                if (i != 0 && rank.containsKey(list.get(i - 1)) && rank.get(node).equals(rank.get(list.get(i - 1)))) {
                    dist.put(node, prevDist);
                } else {
                    dist.put(node, prevDist + 1);
                }
            }
            prevDist = dist.get(node);
        }

        updateEdgeMap(n, graph, dist, edgeMap);

        return buildResultString(edges, edgeMap);
    }

    private static void processQueue(Queue<int[]> pq, Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> list,
                                     Map<Integer, Integer> rank, Map<Integer, Integer> dist, Set<int[]> setR, Set<int[]> setD) {
        while (!pq.isEmpty()) {
            int node = pq.poll()[0];
            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    list.add(nei);
                    if (rank.containsKey(nei)) {
                        setR.add(new int[]{nei, rank.get(nei)});
                    } else {
                        setD.add(new int[]{nei, dist.get(nei)});
                    }
                }
            }
        }
    }

    private static void updateEdgeMap(int n, Map<Integer, Set<Integer>> graph, Map<Integer, Integer> dist, Map<String, Integer> edgeMap) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n];

        pq.offer(new int[]{0, 0});
        visited[0] = true;

        while (!pq.isEmpty()) {
            int node = pq.poll()[0];
            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    String key = node + " " + nei;
                    if (edgeMap.containsKey(key)) {
                        edgeMap.put(key, dist.get(nei) - dist.get(node));
                    } else {
                        key = nei + " " + node;
                        edgeMap.put(key, dist.get(nei) - dist.get(node));
                    }
                    pq.offer(new int[]{nei, dist.get(nei)});
                }
            }
        }
    }

    private static String buildResultString(int[][] edges, Map<String, Integer> edgeMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            sb.append(edgeMap.get(edge[0] + " " + edge[1]));
            if (i != edges.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}