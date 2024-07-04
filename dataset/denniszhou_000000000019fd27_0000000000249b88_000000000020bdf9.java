import java.util.*;
import java.io.*;

public class Solution {

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
      System.out.println("Case #" + i + ": " + getResult(array));
    }
  }

  private static String getResult(int[][] array) {
    List<List<Integer>> overlaps = new ArrayList<>();
    Map<Integer, List<Integer>> relation = new HashMap<>();
    Map<Integer, String> res = new TreeMap<>();

    for (int j = 0; j < array.length; j++) {
      int start = array[j][0];
      int end = array[j][1];
      for (List<Integer> overlap : overlaps) {
        if (start < overlap.get(1) && end > overlap.get(0)) {
          return "IMPOSSIBLE";
        }
      }
      for (int k = 0; k < j; k++) {
        if (start < array[k][1] && end > array[k][0]) {
          overlaps.add(Arrays.asList(Math.max(start, array[k][0]), Math.min(end, array[k][1])));
          List<Integer> list1 = relation.getOrDefault(j, new ArrayList<>());
          list1.add(k);
          relation.put(j, list1);
          List<Integer> list2 = relation.getOrDefault(k, new ArrayList<>());
          list2.add(j);
          relation.put(k, list2);
        }
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < array.length; i++) {
      if (!res.containsKey(i)) {
        queue = new LinkedList<>();
        queue.offer(i);
        res.put(i, "C");
        while (!queue.isEmpty()) {
          int num = queue.poll();
          for (Integer j : relation.getOrDefault(num, new ArrayList<>())) {
            if (!res.containsKey(j)) {
              res.put(j, res.get(num).equals("C") ? "J" : "C");
              queue.offer(j);
            } else if (res.get(j).equals(res.get(num))) {
              return "IMPOSSIBLE";
            }
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, String> entry : res.entrySet()) {
      sb.append(entry.getValue());
    }
    return sb.toString();
  }
}