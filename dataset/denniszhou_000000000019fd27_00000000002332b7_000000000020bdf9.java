import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer
        .parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = Integer.parseInt(in.nextLine());
      int[][] array = new int[n][2];
      for (int j = 0; j < n; j++) {
        String[] line = in.nextLine().split(" ");
        array[j][0] = Integer.parseInt(line[0]);
        array[j][1] = Integer.parseInt(line[1]);
      }

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
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < array.length; j++) {
          boolean overlap = false;
          for (Map.Entry<Integer, Integer> p : map.entrySet()) {
            if (Math.max(p.getKey(), array[j][0]) < Math.min(p.getValue(), array[j][1])) {
              sb.append("J");
              overlap = true;
              break;
            }
          }
          if (!overlap) {
            map.put(array[j][0], array[j][1]);
            sb.append("C");
          }
        }
        System.out.println("Case #" + i + ": " + sb.toString());
      } else {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      }
    }
  }
}