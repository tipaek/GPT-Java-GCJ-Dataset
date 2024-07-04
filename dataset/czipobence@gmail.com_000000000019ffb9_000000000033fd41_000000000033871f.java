import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        return list;
    }

   public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
       for (int i = 1; i <= t; ++i) {
           int c = in.nextInt();
           int d = in.nextInt();

           LinkedHashMap<Integer, Integer> potentials = new LinkedHashMap<>();
           potentials.put(0, 0);
           for (int j = 1; j < c; j++) {
               potentials.put(j, in.nextInt());
           }

           List<Map.Entry<Integer, Integer>> potList = sortByValue(potentials);

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
               for (int nbor: edges.get(currentNode).keySet()) {
                   if (!visited[nbor]) {
                       visited[nbor] = true;
                       bfsVal.put(sp, nbor);
                       bfsPrev.put(nbor, currentNode);
                       sp++;
                   }
               }
               wp++;
           }

           /*for (int j = 0; j < c; j++) {
               System.out.println(j + " " + bfsPrev.get(j));
           }*/


            Map<Integer, Integer> edgeCosts = new HashMap<>();

           for (Map.Entry<Integer, Integer> entry: potList) {
               Integer node = entry.getKey();
               if (node == 0) {
                   continue;
               }
               int tmpnode = bfsPrev.get(node);
               while (bfsPrev.get(tmpnode) != -1) {
                   tmpnode = bfsPrev.get(tmpnode);
               }

               int pot = -1 * entry.getValue();

               int lastEdgeId = edges.get(node).get(bfsPrev.get(node));
               edgeCosts.put(lastEdgeId, pot + potentials.get(bfsPrev.get(node)));
           }

           List<Integer> computedEdgeCosts = new ArrayList<>();
           for (int j = 0; j < d; j++) {
               computedEdgeCosts.add(edgeCosts.getOrDefault(j, c+1));
           }

           System.out.println("Case #" + i + ": " + computedEdgeCosts.stream().map(Object::toString).collect(Collectors.joining(" ")));
       }
    }
}