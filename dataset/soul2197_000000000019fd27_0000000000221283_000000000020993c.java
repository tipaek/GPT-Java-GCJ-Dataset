import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final int N = scanner.nextInt();
      final int[][] M = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          M[i][j] = scanner.nextInt();
        }
      }

      int k = 0;
      int r = 0;
      int c = 0;

      final Set<Integer> nums = new HashSet<>();

      for (int i = 0; i < N; i++) {
        k += M[i][i];

        nums.clear();
        for (int j = 0; j < N; j++) {
          if (!nums.add(M[i][j])) {
            r++;
            break;
          }
        }
        nums.clear();
        for (int j = 0; j < N; j++) {
          if (!nums.add(M[j][i])) {
            c++;
            break;
          }
        }
      }

      System.out.println(String.format("Case #%d: %d %d %d", t, k, r, c));
    }
  }
}
