import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static int[] f(int[][] m) {
    int n = m.length;
    int[] ans = new int[3];

    for (int i = 0; i < n; i++) ans[0] += m[i][i];

    search: for (int i = 0; i < n; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (set.contains(m[i][j])) {
          ans[1]++;
          continue search;
        }
        set.add(m[i][j]);
      }
    }

    search: for (int i = 0; i < n; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (set.contains(m[j][i])) {
          ans[2]++;
          continue search;
        }
        set.add(m[j][i]);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    for (int c = 0; c < t; c++) {
      int n = input.nextInt();
      int[][] m = new int[n][n];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          m[i][j] = input.nextInt();

      int[] ans = f(m);
      System.out.printf("Case #%d: %d %d %d\n", c + 1, ans[0], ans[1], ans[2]);
    }
  }
}
