import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);

    int cases = read.nextInt();

    for (int x = 0; x < cases; x++) {
      int n = read.nextInt();
      int[][] a = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int k = read.nextInt();
          a[i][j] = k;
        }
        read.nextLine();
      }

      solve(x + 1, a);
    }
  }

  public static void solve(int test, int[][] a) {
    int k = 0;
    int r = 0;
    int c = 0;
    for (int i = 0; i < a.length; i++) {
      k += a[i][i];
    }


    for (int i = 0; i < a.length; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < a.length; j++) {
        if (set.contains(a[i][j])) {
          r++;
          break;
        } else {
          set.add(a[i][j]);
        }
      }
    }

    for (int j = 0; j < a.length; j++) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < a.length; i++) {
        if (set.contains(a[i][j])) {
          c++;
          break;
        } else {
          set.add(a[i][j]);
        }
      }
    }

    System.out.printf("Case #%s: %d %d %d\n", test, k, r, c);
  }
}
