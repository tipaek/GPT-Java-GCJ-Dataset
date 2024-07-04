
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int t = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = scanner.nextInt();

      int[][] matrix = new int[n][];
      for (int j = 0; j < n; j++) {
        int[] line = new int[n];
        for (int k = 0; k < n; k++) {
          line[k] = scanner.nextInt();
        }
        matrix[j] = line;
      }
      out.println("Case #" + i + ": " + new Q1(matrix).solve());
    }
  }

  public static class Q1 {
    private final int[][] m;

    public Q1(int[][] matrix) {
      this.m = matrix;
    }

    public String solve() {
      int cntI = 0;
      int cntJ = 0;
      for (int i = 0; i < m.length; i++) {
        cntI += hasRepeat(i, i + 1, 0, m.length);
        cntJ += hasRepeat(0, m.length, i, i + 1);
      }

      return "" + trace() + " " + cntI + " " + cntJ;
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
      int sum = 0;
      for (int i = 0; i < m.length; i++) {
        sum += m[i][i];
      }
      return sum;
    }
  }
}
