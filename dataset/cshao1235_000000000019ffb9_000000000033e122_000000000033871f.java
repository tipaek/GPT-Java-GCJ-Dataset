import java.io.*;
import java.util.*;

public class Solution {
  static final int INF = 1000000;
  public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      TreeMap<Integer, Set<Integer>> info = new TreeMap<>();
      int[] times = new int[c];

      st = new StringTokenizer(f.readLine());
      for (int i = 1; i < c; i++) {
        int v = -1 * Integer.parseInt(st.nextToken());
        if (!info.containsKey(v)) {
          info.put(v, new HashSet<Integer>());
        }
        info.get(v).add(i);
      }

      int[][] edges = new int[d][3];
      for (int i = 0; i < d; i++) {
        st = new StringTokenizer(f.readLine());
        edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
        edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
        edges[i][2] = INF;
      }

      Set<Integer> frontier = new HashSet<Integer>();
      frontier.add(0);

      int bestTime = 0;
      for (int value : info.keySet()) {
        Set<Integer> next = info.get(value);
        Map<Integer, Integer> chosenEdges = new HashMap<>();

        int nextBestTime = bestTime + 1;
        for (int vertex : next) {
          for (int i = 0; i < d; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (vertex == u && frontier.contains(v)) { 
              nextBestTime = Math.max(nextBestTime, times[v] + 1);
              chosenEdges.put(vertex, i);
              break;
            } else if (vertex == v && frontier.contains(u)) {
              nextBestTime = Math.max(nextBestTime, times[u] + 1);
              chosenEdges.put(vertex, i);
              break;
            }
          }
        }

        for (int vertex : next) {
          int i = chosenEdges.get(vertex);
          int u = edges[i][0];
          int v = edges[i][1];
          if (vertex == u) {
            edges[i][2] = nextBestTime - times[v];
          } else if (vertex == v) {
            edges[i][2] = nextBestTime - times[u];
          }
          times[vertex] = nextBestTime;
        }

        bestTime = Math.max(bestTime, nextBestTime);
        frontier.addAll(next);
      }
      
      StringBuffer ans = new StringBuffer("Case #" + num + ":");
      for (int i = 0; i < d; i++) {
        ans.append(" " + edges[i][2]);
      }
      System.out.println(ans.toString());
		}
		f.close();
	}
}