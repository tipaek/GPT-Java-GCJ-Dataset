import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      solve(i, in);
    }
  }

  static void solve(int c, Scanner in) {
    StringBuilder res = new StringBuilder();
    List<int[]> C = new ArrayList<>();
    List<int[]> J = new ArrayList<>();
    int tasks = in.nextInt();
    boolean impossible = false;
    for (int i = 0; i < tasks; ++i) {
      if (impossible) continue;
      int start = in.nextInt();
      int end = in.nextInt();
      boolean cCanTake = true;
      boolean jCanTake = true;
      for (int[] pair : C) {
        if ((start >= pair[0] && start < pair[1]) ||
            (end > pair[0] && end <= pair[1]) ||
            (pair[0] >= start && pair[1] <= end)) {
              cCanTake = false;
              break;
            }
      }
      if (cCanTake) {
        C.add(new int[]{start, end});
        res.append('C');
        continue;
      } else {
        for (int[] pair : J) {
          if ((start >= pair[0] && start < pair[1]) ||
              (end > pair[0] && end <= pair[1]) ||
              (pair[0] >= start && pair[1] <= end)) {
                jCanTake = false;
                break;
              }
        }
        if (jCanTake) {
          J.add(new int[]{start, end});
          res.append('J');
          continue;
        } else {
          impossible = true;
          continue;
        }
      }

    }
    if (impossible) System.out.println("Case #" + c + ": IMPOSSIBLE");
    else System.out.println("Case #" + c + ": " + res.toString());
  }
}