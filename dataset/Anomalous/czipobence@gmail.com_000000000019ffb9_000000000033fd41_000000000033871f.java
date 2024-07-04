import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> sortByValue(Map<K, V> map) {
        return map.entrySet().stream()
                   .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                   .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            Map<Integer, Integer> potentials = new LinkedHashMap<>();
            potentials.put(0, 0);
            for (int j = 1; j < c; j++) {
                potentials.put(j, scanner.nextInt());
            }

            List<Map.Entry<Integer, Integer>> potList = sortByValue(potentials);

            Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
            for (int j = 0; j < c; j++) {
                edges.put(j, new HashMap<>());
            }

            for (int j = 0; j < d; j++) {
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;
                edges.get(from).put(to, j);
                edges.get(to).put(from, j);
            }

            Map<Integer, Integer> bfsVal = new HashMap<>();
            Map<Integer, Integer> bfsPrev = new HashMap<>();
            boolean[] visited = new boolean[c];

            bfsVal.put(0, 0);
            visited[0] = true;
            bfsPrev.put(0, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int neighbor : edges.get(currentNode).keySet()) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        bfsVal.put(neighbor, neighbor);
                        bfsPrev.put(neighbor, currentNode);
                        queue.add(neighbor);
                    }
                }
            }

            Map<Integer, Integer> edgeCosts = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : potList) {
                Integer node = entry.getKey();
                if (node == 0) {
                    continue;
                }

                int tmpNode = bfsPrev.get(node);
                while (bfsPrev.get(tmpNode) != -1) {
                    tmpNode = bfsPrev.get(tmpNode);
                }

                int pot = -entry.getValue();
                int lastEdgeId = edges.get(node).get(bfsPrev.get(node));
                edgeCosts.put(lastEdgeId, pot + potentials.get(bfsPrev.get(node)));
            }

            List<Integer> computedEdgeCosts = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                computedEdgeCosts.add(edgeCosts.getOrDefault(j, c + 1));
            }

            System.out.println("Case #" + i + ": " + computedEdgeCosts.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }
}