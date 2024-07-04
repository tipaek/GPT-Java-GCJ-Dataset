
import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int t = scanner.nextInt();

    for (int k = 1; k <= t; ++k) {
      int n = scanner.nextInt();
      int d = scanner.nextInt();

      long[] s = new long[n];
      for (int i = 0; i < n; i++) {
        s[i] = scanner.nextLong();
      }
      out.println("Case #" + k + ": " + solve(d, s));
    }
  }

  public static int solve(int d, long... nums) {
    Map<Long, Integer> m = new TreeMap<>();
    for (Long n : nums) {
      Integer f = m.get(n);
      if (f == null) {
        f = 0;
      }
      f = f + 1;
      m.put(n, f);
      if (f == d) {
        return 0;
      }
    }

    if (d == 2) {
      return 1;
    }

    for (Map.Entry<Long, Integer> e : m.entrySet()) {
      long n = e.getKey();
      int s = e.getValue();

      Integer s2 = m.get(n * 2);
      if (s2 != null && s2 * 3 > (d - s)) {
        return 1;
      }
    }

    return 2;
  }
}
