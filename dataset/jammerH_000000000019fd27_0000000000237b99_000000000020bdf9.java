
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
 * Template
 */
public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    InputStream inputStream = System.in;
    // String file = "/Users/hshankar/learn/codejam2020/src/com/company/test";
    // InputStream inputStream = new FileInputStream(file);
    Scanner in =
        new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
    int t = in.nextInt();
    outer: for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      List<Point> points = new ArrayList<>();
      for (int j = 0; j < n; ++j) {
        int s = in.nextInt();
        int e = in.nextInt();
        points.add(new Point(s, j, false));
        points.add(new Point(e, j, true));
      }
      List<Set<Integer>> overlaps = new ArrayList<>();
      for (int j = 0; j < n; ++j) {
        overlaps.add(new HashSet<>());
      }
      Collections.sort(points,
                       Comparator.<Point>comparingInt(r -> r.val).thenComparing(p -> p.end ? 0 : 1));

      Set<Integer> openIdx = new HashSet<>();
      for (Point p : points) {
        if (p.end) {
          openIdx.remove(p.idx);
        } else {
          for (int oi : openIdx) {
            Set<Integer> overlapsWithIdx = overlaps.get(oi);
            overlapsWithIdx.add(p.idx);
            overlaps.get(p.idx).add(oi);
          }
          openIdx.add(p.idx);
        }
      }

      char[] assignments = new char[n];
      Arrays.fill(assignments, 'X');
      boolean[] assigned = new boolean[n];
      int nxt = -1;
      while ((nxt = nextUnassigned(assignments)) != -1) {
        if (!propagate(assignments, overlaps, nxt, 'C')) {
          System.out.println("Case #" + i + ": IMPOSSIBLE");
          continue outer;
        }
      }




      System.out.println("Case #" + i + ": " + new String(assignments));
    }
  }

  private static boolean propagate(char[] assignments,
                                List<Set<Integer>> overlaps,
                                int nxt,
                                char c) {
    assignments[nxt] = c;
    Set<Integer> ol = overlaps.get(nxt);
    char other = (c == 'C' ? 'J' : 'C');
    for (int x : ol) {
      if (assignments[x] == c) {
        return false;
      } else if (assignments[x] != other) {
        if (!propagate(assignments, overlaps, x, other)) {
          return false;
        }
      }
    }
    return true;
  }

  private static int nextUnassigned(char[] assignments) {
    int i=0;
    while (i<assignments.length) {
      if (assignments[i] == 'X') {
        return i;
      }
      i++;
    }
    return -1;
  }

  static class Point {
    int val, idx;
    boolean end;

    Point(int val, int idx, boolean end) {
      this.val = val;
      this.end = end;
      this.idx = idx;
    }
  }
}