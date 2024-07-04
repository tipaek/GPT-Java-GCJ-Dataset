import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      long n = s.nextLong();
      System.out.println(String.format("Case #%d:", t));

      System.out.println("1 1");
      n--;
      while (n > 0) {
        List<String> path = new ArrayList<>();
        long pathSum = 0;
        int i = 0, j = 0;
        long prev = 1;
        while (true) {
          if (i != j) {
            j++;
          }
          i++;
          long cur = get(i, j);
          String pos = (i + 1) + " " + (j + 1);
          if (n - pathSum - cur == 0) {
            n = 0;
            System.out.println(pos);
            break;
          }
          if (pathSum * 2 + cur + 1 > n) {
            n -= pathSum * 2 + 1 - prev;
            break;
          }
          pathSum += cur;
          prev = cur;
          System.out.println(pos);
          path.add(pos);
        }

        for (int k = path.size() - 2; k >= 0; k--) {
          System.out.println(path.get(k));
        }
        System.out.println("1 1");
      }
    }
  }

  private static List<List<Long>> rows = new ArrayList<>();

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
    return rows.get(x).get(y);
  }
}
