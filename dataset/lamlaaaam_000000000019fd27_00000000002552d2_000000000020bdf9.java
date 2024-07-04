import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int k = 1; k <= t; ++k) {
      StringBuilder res = new StringBuilder();
      List<int[]> C = new ArrayList<>();
      List<int[]> J = new ArrayList<>();
      int tasks = in.nextInt();
      boolean impossible = false;
      for (int i = 0; i < tasks; ++i) {
        int start = in.nextInt();
        int end = in.nextInt();
        if (impossible) continue;
        boolean cCanTake = true;
        boolean jCanTake = true;
        for (int[] pair : J) {
          if ((start > pair[0] && start < pair[1]) ||
              (end > pair[0] && end < pair[1]) ||
              (pair[0] >= start && pair[1] <= end && pair[0] != end && pair[1] != start)) {
                jCanTake = false;
                break;
              }
        }
        if (jCanTake) {
          J.add(new int[]{start, end});
          res.append('J');
          continue;
        } else {
          for (int[] pair : C) {
            if ((start > pair[0] && start < pair[1]) ||
                (end > pair[0] && end < pair[1]) ||
                (pair[0] >= start && pair[1] <= end && pair[0] != end && pair[1] != start)) {
                  cCanTake = false;
                  break;
                }
          }
          if (cCanTake) {
            C.add(new int[]{start, end});
            res.append('C');
            continue;
          } else {
            impossible = true;
            continue;
          }
        }

      }
      if (impossible) System.out.println("Case #" + k + ": IMPOSSIBLE");
      else System.out.println("Case #" + k + ": " + res.toString());
    }
  }
}