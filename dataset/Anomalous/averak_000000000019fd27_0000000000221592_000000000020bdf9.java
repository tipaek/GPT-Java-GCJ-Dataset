import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    for (int testCase = 1; testCase <= testCases; testCase++) {
      int intervals = scanner.nextInt();
      int[][] schedule = new int[intervals][2];
      for (int i = 0; i < intervals; i++) {
        for (int j = 0; j < 2; j++) {
          schedule[i][j] = scanner.nextInt();
        }
      }
      processSchedule(schedule, testCase);
    }
  }

  private static void processSchedule(int[][] schedule, int caseNumber) {
    Arrays.sort(schedule, Comparator.comparingInt(interval -> interval[0]));
    StringBuilder result = new StringBuilder();
    result.append('C');
    int cEnd = schedule[0][1];
    int jEnd = 0;

    for (int i = 1; i < schedule.length; i++) {
      if (schedule[i][0] >= cEnd) {
        result.append('C');
        cEnd = schedule[i][1];
      } else if (schedule[i][0] >= jEnd) {
        result.append('J');
        jEnd = schedule[i][1];
      } else {
        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        return;
      }
    }
    System.out.println("Case #" + caseNumber + ": " + result.toString());
  }
}