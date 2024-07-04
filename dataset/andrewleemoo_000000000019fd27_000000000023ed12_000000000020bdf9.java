import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int[][] tasks = new int[N][2];
      for(int j = 0; j<N; j++) {
        tasks[j][0] = in.nextInt();
        tasks[j][1] = in.nextInt();
      }
      java.util.Arrays.sort(tasks, new java.util.Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
              return Integer.compare(a[0], b[0]);
          }
      });
      String y = "";
      int CRight = -1;
      int JRight = -1;
      for(int[] task : tasks) {
          int start = task[0];
          int end = task[1];
          if(start>=CRight) {
            CRight = end;
            y += "C";
          }
          else if(start>=JRight) {
            JRight = end;
            y += "J";
          }
          else {
            y = "IMPOSSIBLE";
            break;
          }
      }
      System.out.println("Case #" + i + ": " + y);
    }
  }
}