import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; ++i) {
      int N = sc.nextInt();
      int[][] mat = new int[N][N];
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          mat[j][k] = sc.nextInt();
        }
      }
      String ans = solve(mat, N);
      System.out.println("Case #" + (i + 1) + ": " + ans);
    }
  }

  private static String solve(int[][] mat, int n) {
    String ans = "";
    ans = findSum(mat) + " " + findRow(mat) + " " + findCol(mat);
    return ans;
  }

  private static String findCol(int[][] mat) {
    int count = 0;
    for (int i = 0; i < mat.length; ++i) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < mat.length; ++j) {
        if (set.contains(mat[j][i])) {
          count++;
          break;
        } else {
          set.add(mat[j][i]);
        }
      }
    }
    return String.valueOf(count);
  }

  private static String findRow(int[][] mat) {
    int count = 0;
    for (int i = 0; i < mat.length; ++i) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < mat.length; ++j) {
        if (set.contains(mat[i][j])) {
          count++;
          break;
        } else {
          set.add(mat[i][j]);
        }
      }
    }
    return String.valueOf(count);
  }

  private static String findSum(int[][] mat) {
    int sum = 0;
    for (int i = 0; i < mat.length; ++i) {
      sum += mat[i][i];
    }
    return String.valueOf(sum);
  }
}
