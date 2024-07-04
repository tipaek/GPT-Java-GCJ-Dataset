import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static boolean solve(int index, int[][] m, long[] row, long[] col, int k) {
    int n = m.length;
    int x = index / n;
    int y = index % n;

    if (k < 0) return false;
    if (index == n * n) {
//      System.out.println("row");
//      System.out.println(Arrays.toString(row));
//      System.out.println("col");
//      System.out.println(Arrays.toString(col));
//      System.out.println(Arrays.deepToString(m));
      return k == 0;
    }

    for (int i = 0; i < n; i++) {
      long b = (1 << i);
//      System.out.println(b);
      int nk = x == y ? k - (i + 1) : k;

      if ((row[x] & b) == 0 && (col[y] & b) == 0) {
//        System.out.printf("x: %d y: %d b: %d nk: %d \n", x, y, b, nk);

        m[x][y] = i + 1;
        row[x] ^= b;
        col[y] ^= b;
        if (solve(index + 1, m, row, col, nk)) return true;
        row[x] ^= b;
        col[y] ^= b;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    for (int c = 0; c < t; c++) {
      int n = input.nextInt();
      int k = input.nextInt();
      int[][] m = new int[n][n];
      long[] row = new long[n];
      long[] col = new long[n];
      if (solve(0, m, row, col, k)) {
        System.out.printf("Case #%d: POSSIBLE\n", c + 1);
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++)
            System.out.printf("%d ", m[i][j]);
          System.out.println();
        }

      } else {
        System.out.printf("Case #%d: IMPOSSIBLE\n", c + 1);
      }
    }
  }
}
