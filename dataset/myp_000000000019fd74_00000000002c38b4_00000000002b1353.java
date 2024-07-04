import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    // for (int i = 1; i < 10000; i++) {
    //   List<List<Integer>> ans = solve(i);
    //   int sum = 0;
    //   for (int j = 0; j < ans.size() - 1; j++) {
    //     int x0 = ans.get(j).get(0), y0 = ans.get(j).get(1);
    //     int x1 = ans.get(j + 1).get(0), y1 = ans.get(j + 1).get(1);
    //     if (x0 == x1) {
    //       System.out.println("wrong " + i + " " + String.format("x0 %d y0 %d, x1 %d y1 %d", x0, y0, x1, y1));
    //       System.out.println(ans);
    //     }
    //   }
    //   for (List<Integer> loc : ans) {
    //     sum += get(loc.get(0), loc.get(1));
    //   }
    //   if (sum != i || ans.size() > 500) {
    //     System.out.println(sum + " " + i);
    //   }
    // }
    for (int t = 1; t <= T; t++) {
      long n = s.nextLong();
      System.out.println(String.format("Case #%d:", t));
      List<List<Integer>> ans = solve(n);
      for (List<Integer> row : ans) {
        System.out.println((row.get(0) + 1) + " " + (row.get(1) + 1));
      }

    }
  }

  private static List<List<Long>> rows = new ArrayList<>();

  private static List<List<Integer>> solve(long n) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(Arrays.asList(0, 0));
    n--;
    while (n > 0) {
      List<List<Integer>> path = new ArrayList<>();
      long pathSum = 0;
      int i = 0, j = 0;
      long prev = 1;
      while (true) {
        i++;
        if (i % 2 == 0) j++;
        long cur = get(i, j);
        List<Integer> pos = Arrays.asList(i, j);
        if (n - pathSum - cur == 0) {
          n = 0;
          ans.add(pos);
          return ans;
        }
        if (pathSum * 2 + cur + 1 > n) {
          n -= pathSum * 2 + 1 - prev;
          break;
        }
        pathSum += cur;
        prev = cur;
        path.add(pos);
        ans.add(pos);
      }

      for (int k = path.size() - 2; k >= 0; k--) {
        ans.add(path.get(k));
      }
      ans.add(Arrays.asList(0, 0));
    }
    return ans;
  }

  private static long get(int x, int y) {
    if (rows.size() == 0) {
      rows.add(Arrays.asList(1L));
    }
    // System.out.println(x + " " + y + " " + rows);

    if (x >= rows.size()) {
      List<Long> cur = new ArrayList<>(), prev = rows.get(rows.size() - 1);
      cur.add(1L);
      for (int i = 0; i < prev.size() - 1; i++) {
        cur.add(prev.get(i) + prev.get(i + 1));
      }
      cur.add(1L);
      rows.add(cur);
    }
    // System.out.println(rows);
    return rows.get(x).get(y);
  }
}
