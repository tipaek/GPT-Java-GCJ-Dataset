import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tests = in.nextInt();  
    for (int i = 1; i <= tests; ++i) {
        int n = in.nextInt();
        int[][] square = new int[n][n];
        
        // build the square
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                square[x][y] = in.nextInt();
            }
        }
        
        Map<Integer, Set<Integer>> rowsMap = new HashMap();
        Map<Integer, Set<Integer>> colsMap = new HashMap();
        
        int traceSum = traverse(square, rowsMap, colsMap);
        int rowDups = getDupCount(rowsMap, n);
        int colDups = getDupCount(colsMap, n);

        System.out.println("Case #" + i + ": " + traceSum + " " + rowDups + " " + colDups);
    }
  }
  
  private static int getDupCount(Map<Integer, Set<Integer>> map, int n) {
      int dups = 0;
      for (int key : map.keySet()) {
          if (map.get(key).size() != n) {
              dups++;
          }
      }
      return dups;
  }
  
  private static int traverse(int[][] square, Map<Integer, Set<Integer>> rowsMap, Map<Integer, Set<Integer>> colsMap) {
      int traceSum = 0;
      for (int i = 0; i < square.length; i++) {
          for (int j = 0; j < square.length; j++) {
              int val = square[i][j];
              Set<Integer> seenRows;
              if (rowsMap.containsKey(i)) {
                  seenRows = rowsMap.get(i);
                  seenRows.add(val);
              } else {
                  seenRows = new HashSet();
                  seenRows.add(val);
                  rowsMap.put(i, seenRows);
              }
              
              Set<Integer> seenCols;
              if (colsMap.containsKey(j)) {
                  seenCols = colsMap.get(j);
                  seenCols.add(val);
              } else {
                  seenCols = new HashSet();
                  seenCols.add(val);
                  colsMap.put(j, seenCols);
              }
              if (i == j) {
                  traceSum += val;
              }
          }
      }
      return traceSum;
  }
}