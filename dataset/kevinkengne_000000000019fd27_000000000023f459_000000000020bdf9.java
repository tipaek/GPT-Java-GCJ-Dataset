import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int caseNum = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ks = 1; ks <= caseNum; ++ks) {
      System.out.println("Case #" + ks + ": " + solve(in));
    }
  }

  public static String solve(Scanner in) {
      
      int N = in.nextInt();
      char[] ans = new char[N];
      int[][] activities = new int[N][2];

      Map<int[], Integer> indexes = new HashMap<>();

      for (int i = 0; i < N; i++) {
          for (int j = 0; j < 2; j++) {
              activities[i][j] = in.nextInt();
              indexes.put(activities[i], i);
          }
      }

      Arrays.sort(activities, (x1, x2) -> x1[0] - x2[0]);

      int[] CJ  = new int[2];
      for (int i = 0; i < activities.length; i++) {
          if (CJ[0] > activities[i][0]  && CJ[1] > activities[i][0]) return "IMPOSSIBLE";
          else if (CJ[0] <= activities[i][0]) {
              ans[indexes.get(activities[i])] = 'C';
              CJ[0] = activities[i][1];
          } else if (CJ[1] <= activities[i][0]) {
              ans[indexes.get(activities[i])] = 'J';
              CJ[1] = activities[i][1];
          }
      }
      return new String(ans);
  }
}