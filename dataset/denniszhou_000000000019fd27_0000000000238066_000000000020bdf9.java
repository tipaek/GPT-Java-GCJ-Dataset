import java.util.*;
import java.io.*;

public class Solution {

  private static List<String> res = new ArrayList<>();
  private static Map<Integer, Integer> cmap = new HashMap<>();
  private static Map<Integer, Integer> jmap = new HashMap<>();


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= t; ++i) {
      int n = Integer.parseInt(in.nextLine());
      int[][] array = new int[n][2];
      for (int j = 0; j < n; j++) {
        String[] line = in.nextLine().split(" ");
        array[j][0] = Integer.parseInt(line[0]);
        array[j][1] = Integer.parseInt(line[1]);
      }

      res = new ArrayList<>();
      cmap = new HashMap<>();
      jmap = new HashMap<>();

      boolean possible = true;
      int[] counts = new int[1441];
      for (int j = 0; j < array.length; j++) {
        for (int start = array[j][0] + 1; start <= array[j][1]; start++) {
          counts[start]++;
          if (counts[start] > 2) {
            possible = false;
            break;
          }
        }
      }

      if (possible) {
        dfs(array, new StringBuilder(), 0);
        System.out.println("Case #" + i + ": " + res.get(0).toString());
      } else {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      }
    }
  }

  private static void dfs(int[][] array, StringBuilder sb, int start) {
    if (start == array.length) {
      res.add(sb.toString());
    } else {
      for (int i = start; i < array.length && res.size() == 0; i++) {
        if (!overlap(array[i], cmap)) {
          cmap.put(array[i][0], array[i][1]);
          sb.append("C");
          dfs(array, sb, start + 1);
          cmap.remove(array[i][0]);
          sb.deleteCharAt(sb.length() - 1);
        }
        if (!overlap(array[i], jmap)) {
          jmap.put(array[i][0], array[i][1]);
          sb.append("J");
          dfs(array, sb, start + 1);
          jmap.remove(array[i][0]);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }
  }

  private static boolean overlap(int[] range, Map<Integer, Integer> map) {
    for (Map.Entry<Integer, Integer> p : map.entrySet()) {
      if (Math.max(p.getKey(), range[0]) < Math.min(p.getValue(), range[1])) {
        return true;
      }
    }
    return false;
  }
}