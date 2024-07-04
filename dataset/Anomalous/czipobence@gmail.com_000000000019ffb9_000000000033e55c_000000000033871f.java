import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                  .stream()
                  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1,
                      LinkedHashMap::new
                  ));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int c = in.nextInt();
            int d = in.nextInt();

            LinkedHashMap<Integer, Integer> pots = new LinkedHashMap<>();
            pots.put(0, 0);
            for (int j = 1; j < c; j++) {
                pots.put(j, in.nextInt());
            }

            pots = sortByValue(pots);

            Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
            for (int j = 0; j < c; j++) {
                edges.put(j, new HashMap<>());
            }

            for (int j = 0; j < d; j++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                edges.get(from).put(to, j);
                edges.get(to).put(from, j);
            }

            Map<Integer, Integer> bfsVal = new HashMap<>();
            Map<Integer, Integer> bfsPrev = new HashMap<>();
            boolean[] visited = new boolean[c];

            bfsVal.put(0, 0);
            visited[0] = true;
            bfsPrev.put(0, -1);
            for (int j = 1; j < c; j++) {
                visited[j] = false;
            }

            int wp = 0;
            int sp = 1;
            while (wp < c) {
                int currentNode = bfsVal.get(wp);
                for (int nbor : edges.get(currentNode).keySet()) {
                    if (!visited[nbor]) {
                        visited[nbor] = true;
                        bfsVal.put(sp, nbor);
                        bfsPrev.put(nbor, currentNode);
                        sp++;
                    }
                }
                wp++;
            }

            Map<Integer, Integer> edgeCosts = new HashMap<>();

            for (int node : pots.keySet()) {
                if (node == 0) {
                    continue;
                }
                int routeCost = 0;
                int tmpnode = bfsPrev.get(node);
                while (bfsPrev.get(tmpnode) != -1) {
                    int prevNode = bfsPrev.get(tmpnode);
                    int edgeId = edges.get(tmpnode).get(prevNode);
                    routeCost += edgeCosts.getOrDefault(edgeId, 0);
                    tmpnode = prevNode;
                }

                int pot = -1 * pots.get(node);
                int lastEdgeId = edges.get(node).get(bfsPrev.get(node));
                edgeCosts.put(lastEdgeId, pot - routeCost);
            }

            List<Integer> computedEdgeCosts = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                computedEdgeCosts.add(edgeCosts.getOrDefault(j, c + 1));
            }

            System.out.println("Case #" + i + ": " + computedEdgeCosts.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }
}