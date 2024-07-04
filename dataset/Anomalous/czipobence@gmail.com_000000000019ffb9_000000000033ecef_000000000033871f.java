import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                  .stream()
                  .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1,
                      LinkedHashMap::new
                  ));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int cities = scanner.nextInt();
            int roads = scanner.nextInt();

            LinkedHashMap<Integer, Integer> potions = new LinkedHashMap<>();
            potions.put(0, 0);
            for (int i = 1; i < cities; i++) {
                potions.put(i, scanner.nextInt());
            }

            potions = sortByValue(potions);

            Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>();
            for (int i = 0; i < cities; i++) {
                adjacencyList.put(i, new HashMap<>());
            }

            for (int i = 0; i < roads; i++) {
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;
                adjacencyList.get(from).put(to, i);
                adjacencyList.get(to).put(from, i);
            }

            Map<Integer, Integer> bfsValue = new HashMap<>();
            Map<Integer, Integer> bfsPrevious = new HashMap<>();
            boolean[] visited = new boolean[cities];

            bfsValue.put(0, 0);
            visited[0] = true;
            bfsPrevious.put(0, -1);

            for (int i = 1; i < cities; i++) {
                visited[i] = false;
            }

            int writePointer = 0;
            int searchPointer = 1;

            while (writePointer < cities) {
                int currentNode = bfsValue.get(writePointer);
                for (int neighbor : adjacencyList.get(currentNode).keySet()) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        bfsValue.put(searchPointer, neighbor);
                        bfsPrevious.put(neighbor, currentNode);
                        searchPointer++;
                    }
                }
                writePointer++;
            }

            Map<Integer, Integer> edgeCosts = new HashMap<>();

            for (int node : potions.keySet()) {
                if (node == 0) continue;

                int routeCost = 0;
                int tempNode = bfsPrevious.get(node);
                while (bfsPrevious.get(tempNode) != -1) {
                    int prevNode = bfsPrevious.get(tempNode);
                    int edgeId = adjacencyList.get(tempNode).get(prevNode);
                    routeCost += edgeCosts.getOrDefault(edgeId, 0);
                    tempNode = prevNode;
                }

                int potionValue = -potions.get(node);
                int lastEdgeId = adjacencyList.get(node).get(bfsPrevious.get(node));
                edgeCosts.put(lastEdgeId, potionValue - routeCost);
            }

            List<Integer> computedEdgeCosts = new ArrayList<>();
            for (int i = 0; i < roads; i++) {
                computedEdgeCosts.add(edgeCosts.getOrDefault(i, cities + 1));
            }

            System.out.println("Case #" + caseNum + ": " + computedEdgeCosts.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }
}