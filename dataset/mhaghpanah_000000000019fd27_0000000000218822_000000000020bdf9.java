
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    input.nextLine();
    search: for (int c = 0; c < t; c++) {
      int n = input.nextInt();
      int[][] interval = new int[n][2];
      Integer[] index = new Integer[n];
      for (int i = 0; i < n; i++) {
        interval[i][0] = input.nextInt();
        interval[i][1] = input.nextInt();
        index[i] = i;
      }
      Arrays.sort(index, (a, b) -> interval[a][0] == interval[b][0] ? interval[a][1] - interval[b][1] : interval[a][0] - interval[b][0]);
      int[] last = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
      char[] ans = new char[n];
      for (int i = 0; i < n; i++) {
        if (last[0] <= interval[index[i]][0]) {
          last[0] = interval[index[i]][1];
          ans[index[i]] = 'C';
        } else if (last[1] <= interval[index[i]][0]) {
          last[1] = interval[index[i]][1];
          ans[index[i]] = 'J';
        } else {
          System.out.printf("Case #%d: IMPOSSIBLE\n", c + 1);
          continue search;
        }
      }

      System.out.printf("Case #%d: %s\n", c + 1, String.valueOf(ans));
    }
  }
}
