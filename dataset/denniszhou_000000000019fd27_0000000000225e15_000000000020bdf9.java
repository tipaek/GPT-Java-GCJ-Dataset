import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = Integer.parseInt(in.nextLine());
      int[][] array = new int[n][2];
      Map<Integer, Boolean> map = new HashMap<>();
      Map<Integer, String> res = new LinkedHashMap<>();
      int count = n;
      for (int j = 0; j < n; j++) {
        String[] line = in.nextLine().split(" ");
        array[j][0] = Integer.parseInt(line[0]);
        array[j][1] = Integer.parseInt(line[1]);
        map.put(j, false);
        res.put(j, "");
      }

      int[] p1 = new int[1441];
      int[] p2 = new int[1441];

      for (int j = 0; j < array.length; j++) {
        boolean found = false;
        for (int k = array[j][0] + 1; k <= array[j][1]; k++) {
          if (p1[k] == 1) {
            found = true;
            break;
          }
        }
        for (int k = array[j][0] + 1; k <= array[j][1] && !found; k++) {
          p1[k] = 1;
        }
        if (!found) {
          map.put(j, true);
          res.put(j, "C");
          count--;
        }
      }

      for (int j = 0; j < array.length; j++) {
        if (map.get(j)) continue;
        boolean found = false;
        for (int k = array[j][0] + 1; k <= array[j][1]; k++) {
          if (p2[k] == 1) {
            found = true;
            break;
          }
        }
        for (int k = array[j][0] + 1; k <= array[j][1] && !found; k++) {
          p2[k] = 1;
        }
        if (!found) {
          map.put(j, true);
          res.put(j, "J");
          count--;
        }
      }

      StringBuilder sb = new StringBuilder();
      if (count == 0) {
        for (Map.Entry<Integer, String> entry : res.entrySet()) {
          sb.append(entry.getValue());
        }
      }

      String s = count > 0 ? "IMPOSSIBLE" : sb.toString();

      System.out.println("Case #" + i + ": " + s);
    }
  }
}