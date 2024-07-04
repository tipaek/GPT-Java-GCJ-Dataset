import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  private static final char CAMERON = 'C';

  private static final char JAMIE = 'J';

  private static final String IMPOSSIBLE = "IMPOSSIBLE";

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Number of test cases
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      // Number of activities
      int n = in.nextInt();
      int[][] activityTimes = new int[n][2];
      for (int j = 0; j < n; j++) {
        activityTimes[j][0] = in.nextInt();
        activityTimes[j][1] = in.nextInt();
      }

      int[][] cameronTimes = new int[n][2];
      int[][] jamieTimes = new int[n][2];
      int cameronCount = 0;
      int jamieCount = 0;
      StringBuilder result = new StringBuilder();

      for (int j = 0; j < n; j++) {
        int s = activityTimes[j][0];
        int e = activityTimes[j][1];

        if (cameronCount == 0) {
          cameronTimes[cameronCount][0] = s;
          cameronTimes[cameronCount][1] = e;
          cameronCount++;
          result.append(CAMERON);
          continue;
        }
        if (jamieCount == 0) {
          jamieTimes[jamieCount][0] = s;
          jamieTimes[jamieCount][1] = e;
          jamieCount++;
          result.append(JAMIE);
          continue;
        }

        boolean flag = false;
        for (int k = 0; k < cameronCount; k++) {
          int ts = cameronTimes[k][0];
          int te = cameronTimes[k][1];
//          if ((s <= ts || s >= te) && (e <= ts || e >= te)) {
          if ((s < ts && e <= ts) || (s >= te && e >= te)) {
            cameronTimes[cameronCount][0] = s;
            cameronTimes[cameronCount][1] = e;
            cameronCount++;
            result.append(CAMERON);
            flag = true;
            break;
          }
        }
        if (!flag) {
          flag = false;
          for (int k = 0; k < jamieCount; k++) {
            int ts = jamieTimes[k][0];
            int te = jamieTimes[k][1];
//            if ((s <= ts || s >= te) && (e <= ts || e >= te)) {
            if ((s < ts && e <= ts) || (s >= te && e >= te)) {
              jamieTimes[jamieCount][0] = s;
              jamieTimes[jamieCount][1] = e;
              jamieCount++;
              result.append(JAMIE);
              flag = true;
              break;
            }
          }

          if (!flag) {
            result = new StringBuilder(IMPOSSIBLE);
            break;
          }
        }
      }

      System.out.println("Case #" + i + ": " + result.toString());
    }
  }
}