import java.util.*;
import java.io.*;
import javafx.util.Pair;

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
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int j = 0; j < array.length; j++) {
          boolean overlap = false;
          for (Pair<Integer, Integer> p : list) {
            if (array[j][0] <= p.getKey() && array[j][1] > p.getKey() ||
                array[j][0] < p.getValue() && array[j][1] >= p.getValue()) {
              sb.append("J");
              overlap = true;
              break;
            }
          }
          if (!overlap) {
            list.add(new Pair<>(array[j][0], array[j][1]));
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
  