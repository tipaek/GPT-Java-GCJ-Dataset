import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
      List<List<Integer>> activityTimesList = new ArrayList<>(n);
      for (int j = 0; j < n; j++) {
        List<Integer> list = new ArrayList<>(3);
        list.add(j);
        list.add(in.nextInt());
        list.add(in.nextInt());
        activityTimesList.add(list);
      }
      activityTimesList.sort(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          int diff = o1.get(1) - o2.get(1);
          if (diff == 0) {
            diff = o1.get(2) - o2.get(2);
          }
          return diff;
        }
      });

      char[] resultArr = new char[n];
      resultArr[activityTimesList.get(0).get(0)] = CAMERON;
      int prevEnd = activityTimesList.get(0).get(2);
      for (int j = 1; j < n; j++) {
        int currStart = activityTimesList.get(j).get(1);
        if (prevEnd <= currStart) {
          resultArr[activityTimesList.get(j).get(0)] = CAMERON;
          prevEnd = activityTimesList.get(j).get(2);
        }
      }

      boolean impossible = false;
      int index = 0;
      while (index < n && resultArr[activityTimesList.get(index).get(0)] == CAMERON) {
        index++;
      }

      if (index < n) {
        resultArr[activityTimesList.get(index).get(0)] = JAMIE;
        prevEnd = activityTimesList.get(index).get(2);
        for (int j = index + 1; j < n; j++) {
          if (resultArr[activityTimesList.get(j).get(0)] != CAMERON) {
            int currStart = activityTimesList.get(j).get(1);
            if (prevEnd <= currStart) {
              resultArr[activityTimesList.get(j).get(0)] = JAMIE;
              prevEnd = activityTimesList.get(j).get(2);
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