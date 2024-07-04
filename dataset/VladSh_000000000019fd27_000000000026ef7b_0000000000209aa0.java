import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int t = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      out.println("Case #" + i + ": " + (new Q5(n, k).solve() ? "POSSIBLE" : "IMPOSSIBLE"));
    }
  }

  public static class Q5 {
    private final int[][] m;
    private final int n;
    private final int k;
    private final List<Integer> nums;

    public Q5(int n, int k) {
      this.m = new int[n][];
      for (int j = 0; j < n; j++) {
        m[j] = new int[n];
      }
      this.n = n;
      this.k = k;
      this.nums = IntStream.range(1, n + 1).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public boolean solve() {
      if (k > n * n) {
        return false;
      }
      return solve(0, 0, newNums()) != 0;
    }

    private Collection<Integer> newNums() {
      return new ArrayList<>(nums);
    }

    private int solve(int i, int j, Collection<Integer> avail) {
      if (j == n) {
        return solve(i + 1, 0, newNums());
      } else if (i == n) {
        return trace() == k ? 1 : 0;
      }
      int cnt = 0;
      for (Integer k : new ArrayList<>(avail)) {
        if (check(i, j, k)) {
          m[i][j] = k;
          avail.remove(k);
          cnt += solve(i, j + 1, avail);
          avail.add(k);
          if (cnt > 0) {
            break;
          }
        }
      }
      return cnt;
    }

    private boolean check(int i, int j, int v) {
      for (int k = 0; k < j; k++) {
        if (m[i][k] == v) {
          return false;
        }
      }
      for (int k = 0; k < i; k++) {
        if (m[k][j] == v) {
          return false;
        }
      }
      return true;
    }

    private int hasRepeat(int iFrom, int iTo, int jFrom, int jTo) {
      Set<Integer> set = new HashSet<>();
      for (int i = iFrom; i < iTo; i++) {
        for (int j = jFrom; j < jTo; j++) {
          Integer v = Integer.valueOf(m[i][j]);
          if (set.contains(v)) {
            return 1;
          } else {
            set.add(v);
          }
        }
      }
      return 0;
    }

    private int trace() {
      return trace(m.length);
    }

    private int trace(int len) {
      int sum = 0;
      for (int i = 0; i < len; i++) {
        sum += m[i][i];
      }
      return sum;
    }
  }
}
