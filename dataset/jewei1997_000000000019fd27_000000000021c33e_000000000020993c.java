import java.util.*;

public class Solution {

  private static int[] algo(int[][] arr) {
    // trace
    int trace = 0;
    int N = arr.length;
    for (int i = 0; i < N; i++) {
      trace += arr[i][i];
    }
    // num of diff rows
    int row_sum = 0;
    for (int i = 0; i < N; i++) {
      Set<Integer> row = new HashSet<>();
      for (int j = 0; j < N; j++) {
        if (row.contains(arr[i][j])) {
          row_sum++;
          break;
        }
        row.add(arr[i][j]);
      }
    }
    // num of diff cols
    int col_sum = 0;
    for (int j = 0; j < N; j++) {
      Set<Integer> col = new HashSet<>();
      for (int i = 0; i < N; i++) {
        if (col.contains(arr[i][j])) {
          col_sum++;
          break;
        }
        col.add(arr[i][j]);
      }
    }
    int[] ans = new int[3];
    ans[0] = trace;
    ans[1] = row_sum;
    ans[2] = col_sum;
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int[][] arr = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      int[] ans = algo(arr);
      System.out.printf("Case #" + (t+1) + ": %d %d %d", ans[0], ans[1], ans[2]);
      if (t != T-1) System.out.print("\n");
    }
  }
}