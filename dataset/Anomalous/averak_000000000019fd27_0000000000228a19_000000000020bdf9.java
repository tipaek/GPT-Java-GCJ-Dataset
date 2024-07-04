import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    
    for (int testCase = 1; testCase <= testCases; testCase++) {
      int intervalsCount = scanner.nextInt();
      int[][] intervals = new int[intervalsCount][2];
      Map<String, Integer> intervalMap = new HashMap<>();
      boolean isImpossible = false;
      
      for (int j = 0; j < intervalsCount; j++) {
        for (int k = 0; k < 2; k++) {
          intervals[j][k] = scanner.nextInt();
        }
        
        String intervalKey = intervals[j][0] + "-" + intervals[j][1];
        if (intervalMap.get(intervalKey) == null) {
          intervalMap.put(intervalKey, j);
        } else {
          String extendedKey = intervalKey + "-";
          if (intervalMap.get(extendedKey) == null) {
            intervalMap.put(extendedKey, j);
          } else {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            isImpossible = true;
            break;
          }
        }
      }
      
      if (!isImpossible) {
        assignTasks(intervals, testCase, intervalMap);
      }
    }
  }

  private static void assignTasks(int[][] intervals, int testCaseNumber, Map<String, Integer> intervalMap) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    char[] result = new char[intervals.length];
    int cEnd = intervals[0][1];
    int jEnd = 0;
    
    result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
    
    for (int i = 1; i < intervals.length; i++) {
      String intervalKey = intervals[i][0] + "-" + intervals[i][1];
      String extendedKey = intervalKey + "-";
      
      if (intervals[i][0] >= cEnd) {
        if (result[intervalMap.get(intervalKey)] == 0) {
          result[intervalMap.get(intervalKey)] = 'C';
        } else {
          result[intervalMap.get(extendedKey)] = 'C';
        }
        cEnd = intervals[i][1];
      } else if (intervals[i][0] >= jEnd) {
        if (result[intervalMap.get(intervalKey)] == 0) {
          result[intervalMap.get(intervalKey)] = 'J';
        } else {
          result[intervalMap.get(extendedKey)] = 'J';
        }
        jEnd = intervals[i][1];
      } else {
        System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        return;
      }
    }
    
    System.out.println("Case #" + testCaseNumber + ": " + new String(result));
  }
}