import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int caseNumber = 1;

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[][] intervals = new String[n][2];

      for (int i = 0; i < n; i++) {
        intervals[i] = br.readLine().split(" ");
      }

      String schedule = findSchedule(intervals, new char[] {'J', 'C'});
      System.out.println("Case #" + caseNumber + ": " + (schedule != null ? schedule : "IMPOSSIBLE"));
      caseNumber++;
    }
  }

  static String findSchedule(String[][] intervals, char[] persons) {
    StringBuilder result = new StringBuilder();
    Map<String, List<Integer>> timeIndexMap = new HashMap<>();
    for (int i = 0; i < intervals.length; i++) {
      String key = intervals[i][0] + "-" + intervals[i][1];
      timeIndexMap.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
    }

    Arrays.sort(intervals, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

    int currentPerson = 0;
    result.append(persons[currentPerson]);
    int[] originalIndices = new int[intervals.length];
    originalIndices[0] = timeIndexMap.get(intervals[0][0] + "-" + intervals[0][1]).remove(0);

    for (int i = 1; i < intervals.length; i++) {
      String[] current = intervals[i];
      String[] previous = intervals[i - 1];

      if (Integer.parseInt(current[0]) < Integer.parseInt(previous[1])) {
        if (i > 1 && Integer.parseInt(current[0]) < Integer.parseInt(intervals[i - 2][1])) {
          return null;
        } else {
          currentPerson = 1 - currentPerson;
        }
      }

      originalIndices[i] = timeIndexMap.get(current[0] + "-" + current[1]).remove(0);
      result.append(persons[currentPerson]);
    }

    char[] finalResult = new char[result.length()];
    for (int i = 0; i < originalIndices.length; i++) {
      finalResult[originalIndices[i]] = result.charAt(i);
    }

    return new String(finalResult);
  }
}