import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    //        System.out.println(" " + (2 ^ 2));
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();

      Solver solver = new Solver(x, y);
      System.out.println("Case # " + i + ": " + solver.getResult());
    }
  }

  private static class Solver {
    private final int x;
    private final int y;

    public Solver(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public String getResult() {
      int result[] = solve(x, y);
      if (result == null) return "IMPOSSIBLE";
      StringBuilder builder = new StringBuilder();
      for (int d : result) {
        if (d == 11) {
          builder.append('W');
        } else if (d == 12) {
          builder.append('E');

        } else if (d == 1) {
          builder.append('S');
        } else if (d == 2) {
          builder.append('N');
        }
      }
      return builder.toString();
    }

    private int[] solve(int targetX, int targetY) {
      for (int l = 1; l < 10; l++) {
        for (int x = 0; x < (1 << l) + 1; x++) {
          int hops[] = new int[l];
          for (int s = 0; s < l; s++) {
            hops[s] = (1 << s) * ((x & (1 << s)) > 0 ? -1 : 1);
          }

          for (int y = 0; y < (1 << l) + 1; y++) {
            int sumX = 0;
            int sumY = 0;
            for (int s = 0; s < l; s++) {
              if ((y & (1 << s)) > 0) {
                sumX += hops[s];
              } else {
                sumY += hops[s];
              }
            }
            //            System.out.println("l = " + l + " sum = " + sumX + "," + sumY);
            if (sumX == targetX && sumY == targetY) {
              int result[] = new int[l];
              for (int j = 0; j < l; j++) {
                result[j] = ((x & (1 << j)) > 0 ? 1 : 2) + ((y & (1 << j)) > 0 ? 10 : 0);
              }
              return result;
            }
          }
        }
      }
      return null;
    }
  }
}
