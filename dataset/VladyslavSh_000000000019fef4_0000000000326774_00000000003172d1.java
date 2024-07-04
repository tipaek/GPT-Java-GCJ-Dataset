
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;
import java.util.NavigableMap;
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
    TreeMap<Long, Integer> freqs = new TreeMap<>();
    for (Long n : nums) {
      Integer f = freqs.get(n);
      if (f == null) {
        f = 0;
      }
      f = f + 1;
      freqs.put(n, f);
      if (f == d) {
        return 0;
      }
    }

    if (d == 2) {
      return 1;
    }

    int min = d - 1;
    for (Map.Entry<Long, Integer> e : freqs.entrySet()) {
      long n = e.getKey();
      int s = e.getValue();
      Integer s2 = solveForFixedSize(n, d - s, freqs.tailMap(n, false));
      if (s2 != null) {
        min = Math.min(min, s2);
      }
    }

    return min;
  }

  private static Integer solveForFixedSize(long n, int d, NavigableMap<Long, Integer> freqs) {
    if (freqs.isEmpty()) {
      return null;
    } else if (d == 1) {
      return 1;
    }

    int cuts = 0;
    for (Map.Entry<Long, Integer> e : freqs.entrySet()) {
      if (e.getKey() % n == 0) {
        long maxSlises = e.getKey() / n;
        int num = e.getValue();

        while (d >= maxSlises && num > 0) {
          d -= maxSlises;
          cuts += (maxSlises - 1);
          num--;
        }

        if (num > 0) {
          return cuts + d;
        }
      }
    }
    cuts += d;

    return cuts;
  }
}
