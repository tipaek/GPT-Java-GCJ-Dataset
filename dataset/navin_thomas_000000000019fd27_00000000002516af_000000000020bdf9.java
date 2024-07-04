import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
      Arrays.sort(activityTimes, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          int diff = o1[0] - o2[0];
          if (diff == 0) {
            diff = o1[1] - o2[1];
          }
          return diff;
        }
      });

      char[] resultArr = new char[n];
      resultArr[0] = CAMERON;
      int prevEnd = activityTimes[0][1];
      for (int j = 1; j < n; j++) {
        int currStart = activityTimes[j][0];
        if (prevEnd <= currStart) {
          resultArr[j] = CAMERON;
          prevEnd = activityTimes[j][1];
        }
      }

      boolean impossible = false;
      int index = 1;
      while (index < n && resultArr[index] == CAMERON) {
        index++;
      }

      if (index < n) {
        resultArr[index] = JAMIE;
        prevEnd = activityTimes[index][1];
        for (int j = index + 1; j < n; j++) {
          if (resultArr[j] != CAMERON) {
            int currStart = activityTimes[j][0];
            if (prevEnd <= currStart) {
              resultArr[j] = JAMIE;
              prevEnd = activityTimes[j][1];
            } else {
              impossible = true;
              break;
            }
          }
        }
      }

      StringBuilder result = new StringBuilder();
      if (impossible) {
        result.append(IMPOSSIBLE);
      } else {
        for (char ch : resultArr) {
          result.append(ch);
        }
      }

      System.out.println("Case #" + i + ": " + result.toString());
    }
  }
}