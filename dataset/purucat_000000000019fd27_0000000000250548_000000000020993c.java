
import java.util.HashSet;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt();
      int[][] M = new int[N][N];
      int k = 0, r = 0, c = 0;
      for (int i = 0; i < N; i++) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < N; j++) {
          M[i][j] = sc.nextInt();
          if (i == j) k += M[i][j];
          set.add(M[i][j]);
        }
        if (set.size() != N) {
          r++;
        }
      }
      for (int i = 0; i < N; i++) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < N; j++) {
          set.add(M[j][i]);
        }
        if (set.size() != N) {
          c++;
        }
      }
      System.out.println(String.format("#%d: %d %d %d", t, k, r, c));
    }
  }
}
