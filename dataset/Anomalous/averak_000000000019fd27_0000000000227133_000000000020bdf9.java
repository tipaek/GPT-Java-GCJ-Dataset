import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int countTest = in.nextInt();
      for (int i = 1; i <= countTest; i++) {
        int sizeI = in.nextInt();
        int[][] intervals = new int[sizeI][2];
        Map<String, Integer> indexMap = new HashMap<>();
        boolean isImpossible = false;

        for (int j = 0; j < sizeI; j++) {
          intervals[j][0] = in.nextInt();
          intervals[j][1] = in.nextInt();
          String key = intervals[j][0] + "-" + intervals[j][1];
          if (!indexMap.containsKey(key)) {
            indexMap.put(key, j);
          } else {
            String duplicateKey = key + "-";
            if (!indexMap.containsKey(duplicateKey)) {
              indexMap.put(duplicateKey, j);
            } else {
              System.out.println("Case #" + i + ": IMPOSSIBLE");
              isImpossible = true;
              break;
            }
          }
        }

        if (!isImpossible) {
          assignTasks(intervals, i, indexMap);
        }
      }
    }
  }

  private static void assignTasks(int[][] intervals, int caseNumber, Map<String, Integer> indexMap) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    char[] result = new char[intervals.length];
    int cEnd = intervals[0][1];
    int jEnd = 0;
    result[indexMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';

    for (int i = 1; i < intervals.length; i++) {
      String key = intervals[i][0] + "-" + intervals[i][1];
      if (intervals[i][0] >= cEnd) {
        assignCharacter(result, indexMap, key, 'C');
        cEnd = intervals[i][1];
      } else if (intervals[i][0] >= jEnd) {
        assignCharacter(result, indexMap, key, 'J');
        jEnd = intervals[i][1];
      } else {
        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        return;
      }
    }
    System.out.println("Case #" + caseNumber + ": " + new String(result));
  }

  private static void assignCharacter(char[] result, Map<String, Integer> indexMap, String key, char character) {
    if (!indexMap.containsKey(key + "-")) {
      result[indexMap.get(key)] = character;
    } else {
      result[indexMap.get(key + "-")] = character;
    }
  }
}