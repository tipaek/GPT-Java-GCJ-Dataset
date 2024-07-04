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

public class Solution {

  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int n = scanner.nextInt();
      List<int[]> activ = new ArrayList<int[]>();
      for (int j = 0; j < n; j++) {
        int[] act = new int[2];
        act[0] = scanner.nextInt();
        act[1] = scanner.nextInt();
        activ.add(act);
      }

      String resp = solve(activ);
      out.printf("Case #%d: %s\n", i, resp);
    }

  }

  private static String solve(List<int[]> activ) {
    Collections.sort(activ, (int[] a1, int[] a2) -> Integer.compare(a1[0], a2[0]));
    String r = "C";
    boolean p = true;
    int ending = 0;

    for (int i = 1; i < activ.size(); i++) {
      if (activ.get(i - 1)[1] <= activ.get(i)[0]) {
        r += p ? "C" : "J";
      } else if (ending <= activ.get(i)[0]) {
        p = !p;
        ending = activ.get(i - 1)[1];
        r += p ? "C" : "J";
      } else {
        return "IMPOSSIBLE";
      }
    }
    return r;
  }

}
