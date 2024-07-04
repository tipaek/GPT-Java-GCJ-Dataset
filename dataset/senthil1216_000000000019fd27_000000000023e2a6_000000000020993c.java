import java.util.*;
import java.io.*;
import java.time.Instant;

public class Solution {

  public static String calculateSum(String path) {
    StringBuilder builder = new StringBuilder();
    String out = "";

    return builder.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int num = in.nextInt();
      long startTime = Instant.now().toEpochMilli();
      int trace = 0;
      List<Set<Integer>> cols = new ArrayList<Set<Integer>>();
      Set<Integer> colIds = new HashSet<Integer>();
      int dupsCols = 0, dupsRows = 0;
      for (int r = 0; r < num; r++) {
        Set<Integer> currRowSet = new HashSet<Integer>();
        int rowCountr = 0;
        for (int c = 0; c < num; c++) {
          Set<Integer> currColSet;
          if (cols.size() == c) {
            currColSet = new HashSet<Integer>();
            cols.add(currColSet);
          } else {
            currColSet = cols.get(c);
          }

          int val = in.nextInt();
          if (r == c) {
            trace += val;
          }
          if (currRowSet.contains(val)) rowCountr = 1;
          currRowSet.add(val);

          if (currColSet.contains(val)) {
            if (!colIds.contains(c)) {
              dupsCols++;
              colIds.add(c);
            }
          } else {
            currColSet.add(val);
          }
          cols.set(c, currColSet);
        }
        dupsRows += rowCountr;
      }
      long endTime = Instant.now().toEpochMilli();
      long timeElapsed = endTime - startTime;
      System.out.println("Case #" + i + ": " + trace + " " + dupsRows + " " + dupsCols);
      // System.out.println("Execution time in milliseconds: " + timeElapsed);
    }
  }
}

