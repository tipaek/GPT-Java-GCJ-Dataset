import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = Integer.parseInt(in.nextLine());
      int[][] array = new int[n][n];
      for (int j = 0; j < n; j++) {
        String[] line = in.nextLine().split(" ");
        for (int k = 0; k < n; k++) {
          array[j][k] = Integer.parseInt(line[k]);
        }
      }
      Map<Integer, Set<Integer>> rows = new HashMap<>();
      Map<Integer, Set<Integer>> columns = new HashMap<>();
      int trace = 0;
      int row = 0;
      int column = 0;

      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (j == k) trace += array[j][k];
          if (!rows.containsKey(j)) rows.put(j, new HashSet<>());
          if (!columns.containsKey(k)) columns.put(k, new HashSet<>());
          rows.getOrDefault(j, new HashSet<>()).add(array[j][k]);
          columns.getOrDefault(k, new HashSet<>()).add(array[j][k]);
        }
      }

      for (Map.Entry<Integer, Set<Integer>> entry : rows.entrySet()) {
        if (entry.getValue().size() < n) row++;
      }

      for (Map.Entry<Integer, Set<Integer>> entry : columns.entrySet()) {
        if (entry.getValue().size() < n) column++;
      }

      System.out.println("Case #" + i + ": " + trace + " " + row + " " + column);
    }
  }
}