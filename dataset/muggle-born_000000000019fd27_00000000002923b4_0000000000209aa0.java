import java.util.*;
import java.io.*;

public class Solution {
  static int[] dx = new int[] {-1,1,0,0};
  static int[] dy = new int[] {0,0,-1,1};

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j]);
        if (j != matrix.length-1) {
          System.out.print(" ");
        }
      }
      if (i != matrix.length - 1) {
        System.out.println();
      }
    }
  }

  private static int getTrace(int[][] matrix) {
    int trace = 0;
    for (int i = 0; i < matrix.length; i++) {
      trace += matrix[i][i];
    }
    return trace;
  }

  private static boolean isValidCell(int[][] matrix, int N, int r, int c) {
    if (r < 0 || c < 0 || r >= N || c >= N || matrix[r][c] != 0) {
      return false;
    }
    return true;
  }

  private static boolean isPossible(int N, int k, int[][] matrix, 
    Map<Integer, Set<Integer>> validRows, 
    Map<Integer, Set<Integer>> validCols, 
    int r, int c, int valuesPlaced){
    
    if (validCols.get(c).isEmpty() || validRows.get(r).isEmpty()) {
      return false;
    }

    Set<Integer> colVals = validCols.get(c);
    Set<Integer> rowVals = validRows.get(r);
    Set<Integer> mergedSet = new HashSet<>();
    mergedSet.addAll(colVals);
    mergedSet.retainAll(rowVals); // intersection of row and column values
    
    // Make all possible valid moves
    for (Integer validValue : mergedSet) {
      valuesPlaced++;
      matrix[r][c] = validValue;
      
      Boolean valueInCol = false;
      if (colVals.contains(validValue)) {
        colVals.remove(validValue);
        validCols.put(c,colVals);
        valueInCol = true;
      }
      Boolean valueInRow = false;
      if (rowVals.contains(validValue)) {
        rowVals.remove(validValue);
        validRows.put(r, rowVals);
        valueInRow = true;
      }

      if (colVals.isEmpty() && rowVals.isEmpty() && (valuesPlaced == N*N) && getTrace(matrix) == k) {
        return true;
      }
      
      for (int i = 0; i < 4; i++) {
        int rr = r + dx[i];
        int cc = c + dy[i];
        if (isValidCell(matrix, N, rr, cc)) {
          if (isPossible(N, k, matrix, validRows, validCols, rr, cc, valuesPlaced)) {
            return true;
          }
        }
      }

      // cleanup dfs to restore state
      valuesPlaced--;
      matrix[r][c] = 0;
      if (valueInCol) {
        colVals.add(validValue);
        validCols.put(c,colVals);
      }

      if(valueInRow) {
        rowVals.add(validValue);
        validRows.put(r, rowVals);
      }

    }
    return false;
    
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    Map<String, int[][]> memo = new HashMap<String, int[][]>();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int k = in.nextInt();
      
      // Skip impossible cases
      int minTrace = n;
      int maxTrace = n*n;
      if (k < minTrace || k > maxTrace) {
        String result = "IMPOSSIBLE";
        String output = String.format("Case #%d: %s", i, result);
        System.out.print(output);
        if (i != t) {
          System.out.println();
        }
        continue;
      }
      
      // // Skip cases we have already solved
      // String id = String.format("n%dk%d",n,k);
      // if (memo.containsKey(id)) {

      // }

      // Continue with Normal Cases
      HashSet<Integer> validInts = new HashSet<>();
      for (int x = 1; x <= n; x++) {
        validInts.add(x);
      }

      Map<Integer, Set<Integer>> validRows = new HashMap<Integer, Set<Integer>>();
      Map<Integer, Set<Integer>> validCols = new HashMap<Integer, Set<Integer>>();
      for (int x = 0; x < n; x++) {
        validRows.put(x, (Set<Integer>)validInts.clone());
        validCols.put(x, (Set<Integer>)validInts.clone());
      }

      int[][] matrix = new int[n][n];
      String result;
      if (isPossible(n,k,matrix,validRows,validCols,0,0,0)) {
        result = "POSSIBLE";
        String output = String.format("Case #%d: %s", i, result);
        System.out.println(output);
        printMatrix(matrix);
      } else {
        result = "IMPOSSIBLE";
        String output = String.format("Case #%d: %s", i, result);
        System.out.print(output);
      }

      if (i != t) {
        System.out.println();
      }
    }
  }
} 