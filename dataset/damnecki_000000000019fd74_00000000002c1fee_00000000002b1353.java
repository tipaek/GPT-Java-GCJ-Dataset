import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

  private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUT = System.out;

  public static void main(String[] args) {
    int T = IN.nextInt();
    int N;
    List<String> path = new ArrayList<>();
    int r, k, inc, n;
    for (int t = 1; t <= T; t++) {
      N = IN.nextInt();
      path.clear();
      r = k = 1;
      path.add(r + " " + k);
      if (N < 501) {
        for (int i = 0; i < N - 1; i++) {
          path.add((++r) + " " + k);
        }
      } else if (N < 1001) {
        path.add((++r) + " " + k);
        n = 2;
        inc = 1;
        while (n + (++inc) < N) {
          path.add((++r) + " " + (++k));
          n += inc;
        }
        if (n < N) {
          path.add(r + " " + (++k));
          n++;
        }
        while (n < N) {
          path.add((++r) + " " + (++k));
          n++;
        }
      }

      OUT.println("Case #" + t + ": ");
      toStr(path);
    }
  }

  static void toStr(List<String> l) {
    for (String s : l) {
      System.out.println(s);
    }
  }
}