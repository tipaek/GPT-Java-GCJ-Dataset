import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Manish Agarwal
 * @Date : 2020-04-03 at 16:10
 * 3
 * 4
 * 1 2 3 4
 * 2 1 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 4
 * 2 2 2 2
 * 2 3 2 3
 * 2 2 2 3
 * 2 2 2 2
 * 3
 * 2 1 3
 * 1 3 2
 * 1 2 3
 */
public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n  = s.nextInt();
    for (int i = 0; i < n; i++) {
      int N = s.nextInt();
      int [][] arr = new int[N][N];
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          arr[j][k] = s.nextInt();
        }
      }
      int row = 0;
      int col = 0;
      int dg = 0;

      for (int j = 0; j < N; j++) {
        Map<Integer, Boolean> rmap = new HashMap<>();
        Map<Integer, Boolean> cmap = new HashMap<>();
        boolean rf = true, cf = true;
        dg += arr[j][j];
        for (int k = 0; k < N; k++) {
          if (rf) {
            if (rmap.containsKey(arr[j][k])) {
              row++;
              rf = false;
            } else {
              rmap.put(arr[j][k], Boolean.TRUE);
            }
          }
          if (cf) {
            if (cmap.containsKey(arr[k][j])) {
              col++;
              cf = false;
            } else {
              cmap.put(arr[k][j], Boolean.TRUE);
            }
          }

        }
      }
      System.out.println("Case #" + (i + 1) + ": " + dg + " " + row + " " + col);
    }
  }
}