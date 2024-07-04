import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int n = scanner.nextInt();
      List<int[]> activ = new ArrayList<int[]>();
      for (int j = 0; j < n; j++) {
        int[] act = new int[4];
        act[0] = scanner.nextInt();
        act[1] = scanner.nextInt();
        act[2] = j;
        act[3] = -1;
        activ.add(act);
      }

      String resp = solve(activ);
      out.printf("Case #%d: %s\n", i, resp);
    }

  }

  private static String solve(List<int[]> activ) {
    Collections.sort(activ, (int[] a1, int[] a2) -> Integer.compare(a1[0], a2[0]));

    boolean p = true;
    int ending = 0;
    activ.get(0)[3] = 1;
    for (int i = 1; i < activ.size(); i++) {
      int[] a = activ.get(i);
      if (activ.get(i - 1)[1] <= a[0]) {
        a[3] = p ? 1 : 0;
      } else if (ending <= a[0]) {
        p = !p;
        ending = activ.get(i - 1)[1];
        a[3] = p ? 1 : 0;
      } else {
        return "IMPOSSIBLE";
      }
    }
    Collections.sort(activ, (int[] a1, int[] a2) -> Integer.compare(a1[2], a2[2]));
    return activ.stream().map(a -> a[3] == 1 ? "C" : "J").collect(Collectors.joining());

  }

}
