import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int[][] tasks = new int[N][3];
      for(int j = 0; j<N; j++) {
        tasks[j][0] = in.nextInt();
        tasks[j][1] = in.nextInt();
        tasks[j][2] = j;
      }
      java.util.Arrays.sort(tasks, new java.util.Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
              return Integer.compare(a[0], b[0]);
          }
      });
      char[] ans = new char[N];
      boolean possible = true;
      int CRight = -1;
      int JRight = -1;
      for(int[] task : tasks) {
          int start = task[0];
          int end = task[1];
          if(start>=CRight) {
            CRight = end;
            ans[task[2]] = 'C';
          }
          else if(start>=JRight) {
            JRight = end;
            ans[task[2]] = 'J';
          }
          else {
            possible = false;
            break;
          }
      }
      String y;
      if(possible) {
        y = new String(ans);
      }
      else {
        y = "IMPOSSIBLE";
      }
      System.out.println("Case #" + i + ": " + y);
    }
  }
}