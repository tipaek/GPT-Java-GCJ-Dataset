import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] matrix = new int[n][n];
      int trace = 0;
      int traceIdx = 0;
      int rowCount = 0;
      int columnCount = 0;
      Set<Integer> rowSet = new HashSet<Integer>();
      Set<Integer>[] columnSets = new HashSet[n];
      for (int c = 0; c < n; c++) {
          for (int r = 0; r < n; r++){
              int curVal = in.nextInt();
              if (traceIdx == r) {
                     trace += curVal;
                 }
              if (columnSets[r] == null) {
                  columnSets[r] = new HashSet<Integer>();
              }
              columnSets[r].add(curVal);
              rowSet.add(curVal);
          }
          traceIdx++;
          if (rowSet.size() != n) rowCount++;
          rowSet.clear();
      }
      for (Set<Integer> element : columnSets) {
          if (element.size() != n) columnCount++;
      }
      System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + columnCount);
    }
  }
} 