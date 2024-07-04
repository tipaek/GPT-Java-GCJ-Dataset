import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseCount = in.nextInt();
    for (int t = 1; t <= testCaseCount; t++) {
      int intervalCount = in.nextInt();
      int[][] intervals = new int[intervalCount][2];
      Map<String, Integer> intervalMap = new HashMap<>();
      boolean impossible = false;

      for (int i = 0; i < intervalCount; i++) {
        intervals[i][0] = in.nextInt();
        intervals[i][1] = in.nextInt();
        String key = intervals[i][0] + "-" + intervals[i][1];
        
        if (!intervalMap.containsKey(key)) {
          intervalMap.put(key, i);
        } else {
          String extendedKey = key + "-";
          if (!intervalMap.containsKey(extendedKey)) {
            intervalMap.put(extendedKey, i);
          } else {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
            impossible = true;
            break;
          }
        }
      }

      if (!impossible) {
        assignSchedules(intervals, t, intervalMap);
      }
    }
  }

  public static void assignSchedules(int[][] intervals, int testCaseNumber, Map<String, Integer> intervalMap) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    char[] schedule = new char[intervals.length];
    int cEnd = intervals[0][1];
    int jEnd = 0;

    schedule[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';

    for (int i = 1; i < intervals.length; i++) {
      String key = intervals[i][0] + "-" + intervals[i][1];
      String extendedKey = key + "-";

      if (intervals[i][0] >= cEnd) {
        if (schedule[intervalMap.get(key)] == 0) {
          schedule[intervalMap.get(key)] = 'C';
        } else {
          schedule[intervalMap.get(extendedKey)] = 'C';
        }
        cEnd = intervals[i][1];
      } else if (intervals[i][0] >= jEnd) {
        if (schedule[intervalMap.get(key)] == 0) {
          schedule[intervalMap.get(key)] = 'J';
        } else {
          schedule[intervalMap.get(extendedKey)] = 'J';
        }
        jEnd = intervals[i][1];
      } else {
        System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        return;
      }
    }
    
    System.out.println("Case #" + testCaseNumber + ": " + new String(schedule));
  }
}