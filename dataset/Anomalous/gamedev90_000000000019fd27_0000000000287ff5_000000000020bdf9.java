import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
      
      String schedule = getSchedule(intervals, new char[] {'J', 'C'});
      String result = (schedule == null ? "IMPOSSIBLE" : schedule);
      System.out.println("Case #" + caseNumber + ": " + result);
      caseNumber++;
    }
  }

  static String getSchedule(String[][] intervals, char[] persons) {
    StringBuilder result = new StringBuilder();
    Map<String, Integer> timeIndexMap = new HashMap<>();
    
    for (int i = 0; i < intervals.length; i++) {
      String key = intervals[i][0] + "-" + intervals[i][1];
      timeIndexMap.put(key, i);
    }
    
    Arrays.sort(intervals, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
    
    int currentPerson = 0;
    int[] originalOrder = new int[intervals.length];
    originalOrder[0] = timeIndexMap.get(intervals[0][0] + "-" + intervals[0][1]);
    result.append(persons[currentPerson]);
    
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
      
      originalOrder[i] = timeIndexMap.get(current[0] + "-" + current[1]);
      result.append(persons[currentPerson]);
    }
    
    char[] finalSchedule = new char[result.length()];
    for (int i = 0; i < originalOrder.length; i++) {
      finalSchedule[originalOrder[i]] = result.charAt(i);
    }
    
    return new String(finalSchedule);
  }
}