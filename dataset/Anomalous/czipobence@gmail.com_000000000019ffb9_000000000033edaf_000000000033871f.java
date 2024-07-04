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
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int cities = scanner.nextInt();
            int roads = scanner.nextInt();

            LinkedHashMap<Integer, Integer> potentials = new LinkedHashMap<>();
            potentials.put(0, 0);
            for (int city = 1; city < cities; city++) {
                potentials.put(city, scanner.nextInt());
            }

            List<Map.Entry<Integer, Integer>> sortedPotentials = sortByValue(potentials);

            Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
            for (int city = 0; city < cities; city++) {
                edges.put(city, new HashMap<>());
            }

            for (int road = 0; road < roads; road++) {
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;
                edges.get(from).put(to, road);
                edges.get(to).put(from, road);
            }

            Map<Integer, Integer> bfsValue = new HashMap<>();
            Map<Integer, Integer> bfsPrevious = new HashMap<>();
            boolean[] visited = new boolean[cities];

            bfsValue.put(0, 0);
            visited[0] = true;
            bfsPrevious.put(0, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int neighbor : edges.get(currentNode).keySet()) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        bfsValue.put(neighbor, neighbor);
                        bfsPrevious.put(neighbor, currentNode);
                        queue.add(neighbor);
                    }
                }
            }

            Map<Integer, Integer> edgeCosts = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : sortedPotentials) {
                Integer node = entry.getKey();
                if (node == 0) continue;

                int routeCost = 0;
                int temporaryNode = bfsPrevious.get(node);
                while (bfsPrevious.get(temporaryNode) != -1) {
                    int previousNode = bfsPrevious.get(temporaryNode);
                    int edgeId = edges.get(temporaryNode).get(previousNode);
                    routeCost += edgeCosts.getOrDefault(edgeId, 0);
                    temporaryNode = previousNode;
                }

                int potential = -entry.getValue();
                int lastEdgeId = edges.get(node).get(bfsPrevious.get(node));
                edgeCosts.put(lastEdgeId, potential - routeCost);
            }

            List<Integer> computedEdgeCosts = new ArrayList<>();
            for (int road = 0; road < roads; road++) {
                computedEdgeCosts.add(edgeCosts.getOrDefault(road, cities + 1));
            }

            System.out.println("Case #" + testCase + ": " + computedEdgeCosts.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}