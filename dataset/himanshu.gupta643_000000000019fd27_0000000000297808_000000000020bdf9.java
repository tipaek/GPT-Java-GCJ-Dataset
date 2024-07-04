import java.util.Scanner;

import sun.nio.cs.ext.MacHebrew;

/**
 * @author himanshugupta - created on 05/04/20
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int tt = t;
    while (t-- != 0) {
      int n = sc.nextInt();
      int arr[][] = new int[n][2];
      for (int i = 0; i < n; i++) {
        arr[i][0] = sc.nextInt();
        arr[i][1] = sc.nextInt();
      }
      int cMin = -2, cMax = -1, jMin = -2, jMax = -1;
      System.out.println("Case #" + (tt - t) + ": " + makeSchedule(0, arr, cMin, cMax, jMin, jMax));
    }
  }

  private static String makeSchedule(int workNo, int[][] arr, int cMin, int cMax, int jMin, int jMax) {
    if (workNo >= arr.length) {
      return "";
    }
    String ans = "";
    int min = arr[workNo][0];
    int max = arr[workNo][1];
    if ((min >= cMax || max <= cMin)) {
      if (workNo == 0) {
        cMin = min;
        cMax = max;
      } else {
        cMin = Math.min(min, cMin);
        cMax = Math.max(max, cMax);
      }
      ans = makeSchedule(workNo + 1, arr, cMin, cMax, jMin, jMax);
      if (!"IMPOSSIBLE".equals(ans)) {
        return "C" + ans;
      }
    }
    if ((min >= jMax || max <= jMin)) {
      if (workNo == 0) {
        jMin = min;
        jMax = max;
      } else {
        jMin = Math.min(min, jMin);
        jMax = Math.max(max, jMax);
      }
      ans = makeSchedule(workNo + 1, arr, cMin, cMax, jMin, jMax);
      if (!"IMPOSSIBLE".equals(ans)) {
        return "J" + ans;
      } else {
        return ans;
      }
    } else {
      return "IMPOSSIBLE";
    }
  }
}
