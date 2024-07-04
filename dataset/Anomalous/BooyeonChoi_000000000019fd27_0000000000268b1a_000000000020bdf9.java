import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int numCases = Integer.parseInt(reader.readLine());

    for (int caseNum = 1; caseNum <= numCases; caseNum++) {
      int numTests = Integer.parseInt(reader.readLine());
      List<int[]> intervals = new ArrayList<>();
      for (int i = 0; i < numTests; i++) {
        String[] parts = reader.readLine().split(" ");
        intervals.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
      }

      String result = assignTasks(intervals);
      System.out.printf("Case #%d: %s\n", caseNum, result);
    }

    reader.close();
  }

  private static String assignTasks(List<int[]> intervals) {
    int[] jEnd = {0};
    int[] cEnd = {0};
    StringBuilder result = new StringBuilder();

    for (int[] interval : intervals) {
      if (interval[0] >= jEnd[0]) {
        jEnd[0] = interval[1];
        result.append('J');
      } else if (interval[0] >= cEnd[0]) {
        cEnd[0] = interval[1];
        result.append('C');
      } else {
        return "IMPOSSIBLE";
      }
    }

    return result.toString();
  }
}