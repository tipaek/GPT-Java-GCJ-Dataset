import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    Map<String, Integer> pascal = new HashMap<>();
    for (int i = 1; i <= 500; i++) {
      for (int j = 1; j <= i; j++) {
        String key = getKey(i, j);
        if (j == 1 || j == i) {
          pascal.put(key, 1);
        } else {
          pascal.put(key, pascal.get(getKey(i - 1, j - 1)) + pascal.get(getKey(i - 1, j)));
        }
      }
    }

    for (int tci = 1; tci <= t; ++tci) {
      int n = in.nextInt();
      AtomicBoolean flag = new AtomicBoolean(false);
//      List<String> path = new ArrayList<>();
      Set<String> path = new LinkedHashSet<>();

      pascalWalk(pascal, n, path, 0, 0, 1, 1, flag);
      System.out.println("Case #" + tci + ":");
      for (String step : path) {
        System.out.println(step);
      }
    }
  }

  private static void pascalWalk(Map<String, Integer> pascal, int n, Set<String> path, int sum,
      int count, int i, int j, AtomicBoolean flag) {
    if (flag.get()) {
      return;
    }
    String key = getKey(i, j);
    if (path.contains(key)) {
      return;
    }
    sum += pascal.get(key);
    count++;
    path.add(key);
    if (sum == n) {
      boolean flagExp = flag.compareAndSet(false, true);
      return;
    } else {
      if (count < 500 && sum < n) {
        int[][] positions = new int[6][2];
        positions[0][0] = i - 1;
        positions[0][1] = j - 1;
        positions[1][0] = i - 1;
        positions[1][1] = j;
        positions[2][0] = i;
        positions[2][1] = j - 1;
        positions[3][0] = i;
        positions[3][1] = j + 1;
        positions[4][0] = i + 1;
        positions[4][1] = j;
        positions[5][0] = i + 1;
        positions[5][1] = j + 1;
        for (int[] position : positions) {
          if (position[0] >= 1 && position[1] >= 1 && position[1] <= position[0]) {
            pascalWalk(pascal, n, path, sum, count, position[0], position[1], flag);
          }
        }
      }
    }
    // sum -= pascal.get(getKey(i, j));
    // count--;
    if (flag.get()) {
      return;
    }
    path.remove(key);
  }

  private static String getKey(int i, int j) {
    return i + " " + j;
  }
}