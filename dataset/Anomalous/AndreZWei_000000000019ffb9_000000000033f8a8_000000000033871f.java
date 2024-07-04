import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = scanner.nextInt();
            }
            int[][] edges = new int[e][2];
            for (int i = 0; i < e; i++) {
                edges[i][0] = scanner.nextInt() - 1;
                edges[i][1] = scanner.nextInt() - 1;
            }
            System.out.println("Case #" + testCase + ": " + solve(n, arr, edges));
        }
    }

    public static String solve(int n, int[] arr, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<String, Integer> edgeWeights = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
            edgeWeights.put(edge[0] + " " + edge[1], 1000000);
        }

        Queue<int[]> rankQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Queue<int[]> distQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> ranks = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < 0) {
                ranks.put(i + 1, -arr[i]);
            } else {
                distances.put(i + 1, arr[i]);
            }
        }

        distances.put(0, 0);
        distQueue.offer(new int[]{0, 0});
        List<Integer> nodeList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!rankQueue.isEmpty() || !distQueue.isEmpty()) {
            Set<int[]> rankSet = new HashSet<>();
            Set<int[]> distSet = new HashSet<>();

            while (!rankQueue.isEmpty()) {
                int currentNode = rankQueue.poll()[0];
                for (int neighbor : graph.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        nodeList.add(neighbor);
                        if (ranks.containsKey(neighbor)) {
                            rankSet.add(new int[]{neighbor, ranks.get(neighbor)});
                        } else {
                            distSet.add(new int[]{neighbor, distances.get(neighbor)});
                        }
                    }
                }
            }

            while (!distQueue.isEmpty()) {
                int currentNode = distQueue.poll()[0];
                for (int neighbor : graph.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        nodeList.add(neighbor);
                        if (ranks.containsKey(neighbor)) {
                            rankSet.add(new int[]{neighbor, ranks.get(neighbor)});
                        } else {
                            distSet.add(new int[]{neighbor, distances.get(neighbor)});
                        }
                    }
                }
            }

            rankQueue.addAll(rankSet);
            distQueue.addAll(distSet);
        }

        int previousDistance = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            if (ranks.containsKey(nodeList.get(i))) {
                if (i != 0 && ranks.containsKey(nodeList.get(i - 1)) && ranks.get(nodeList.get(i)).equals(ranks.get(nodeList.get(i - 1)))) {
                    distances.put(nodeList.get(i), previousDistance);
                } else {
                    distances.put(nodeList.get(i), previousDistance + 1);
                }
            }
            previousDistance = distances.get(nodeList.get(i));
        }

        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        visited = new boolean[n];
        priorityQueue.offer(new int[]{0, 0});
        visited[0] = true;

        while (!priorityQueue.isEmpty()) {
            int size = priorityQueue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = priorityQueue.poll()[0];
                for (int neighbor : graph.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        String key = currentNode + " " + neighbor;
                        if (edgeWeights.containsKey(key)) {
                            edgeWeights.put(key, distances.get(neighbor) - distances.get(currentNode));
                        } else {
                            key = neighbor + " " + currentNode;
                            edgeWeights.put(key, distances.get(neighbor) - distances.get(currentNode));
                        }
                        priorityQueue.offer(new int[]{neighbor, distances.get(neighbor)});
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] edge : edges) {
            result.append(edgeWeights.get(edge[0] + " " + edge[1]));
            if (edge != edges[edges.length - 1]) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}