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

  private static boolean isWithinMatrix(int N, int r, int c) {
    if (r < 0 || c < 0 || r >= N || c >= N) {
      return false;
    }
    return true;
  }

  private static void permutationsEqualToK(List<List<Integer>> results, int N, int k, int i, Integer[] currList, int currSum) {
    if (i == N) {
      if (currSum == k) {
        results.add(new ArrayList<Integer>(Arrays.asList(currList)));
      } else {
        return;
      }
    } else {
      if (currSum > N * N) {
        return;
      }
  
      /**
       * Two options:
       * 1) place 'j' at index i and recursively call function
       * 2) don't place 'j' at i and wait for another j
       */
      for (int j = N; j > 0; j--) {
        currList[i] = j;
        permutationsEqualToK(results, N, k, i+1, currList, currSum+j);
        currList[i] = 0;
      }
    }
  }

  private static void reduceSearchSpace(Map<Integer, Set<Integer>> validValues, List<Integer> trace) {
    for (int i = 0; i < trace.size(); i++) {
      Set<Integer> vals = validValues.get(i);
      vals.remove(trace.get(i));
      validValues.put(i, vals);
    }
  }
  
  private static boolean isPossible(int N, int k, int[][] matrix, List<Integer> p,
    Map<Integer, Set<Integer>> validRows, 
    Map<Integer, Set<Integer>> validCols, 
    int r, int c, int valuesPlaced){

    // // Base Case: We've placed all the values in our matrix and the diagonal is valid
    // if (valuesPlaced == (N*N)) {
    //   return true;
    // }
    // System.out.println("=======");
    // System.out.println(String.format("(%d,%d)",r,c));
    // System.out.println(String.format("Values Placed: %d", valuesPlaced));
    // printMatrix(matrix);
    // System.out.println();
    // If the value is on the diagonal, then we already know what valid value it should be
    if (r == c) {
      matrix[r][c] = p.get(r);
      valuesPlaced++;
      if (valuesPlaced == (N*N)) {
        return true;
      }
      for (int i = 0; i < 4; i++) {
        int rr = r + dx[i];
        int cc = c + dy[i];
        if (isWithinMatrix(N, rr, cc) && matrix[rr][cc] == 0) {
          if (isPossible(N, k, matrix, p, validRows, validCols, rr, cc, valuesPlaced)) {
            return true;
          }
        }
      }
      valuesPlaced--;
      matrix[r][c] = 0;
      return false;
    }

    Set<Integer> colVals = validCols.get(c);
    Set<Integer> rowVals = validRows.get(r);
    Set<Integer> mergedSet = new HashSet<>();
    mergedSet.addAll(colVals);
    mergedSet.retainAll(rowVals); // intersection of row and column values
    // System.out.print("Cols: ");
    // System.out.println(colVals);
    // System.out.print("Rows: ");
    // System.out.println(rowVals);
    // System.out.print("Merged: ");
    // System.out.println(mergedSet);
    // System.out.println("=======");

    // Make all possible valid moves
    for (Integer validValue : mergedSet) {
      matrix[r][c] = validValue;
      valuesPlaced++;
      if (valuesPlaced == (N*N)) {
        return true;
      }
      Boolean valueInCol = colVals.contains(validValue);
      colVals.remove(validValue);
      validCols.put(c,colVals);

      Boolean valueInRow = rowVals.contains(validValue);
      rowVals.remove(validValue);
      validRows.put(r, rowVals);
      
      for (int i = 0; i < 4; i++) {
        int rr = r + dx[i];
        int cc = c + dy[i];
        if (isWithinMatrix(N, rr, cc) && matrix[rr][cc] == 0) {
          if (isPossible(N, k, matrix, p, validRows, validCols, rr, cc, valuesPlaced)) {
            return true;
          }
        }
      }

      // cleanup dfs to restore state
      matrix[r][c] = 0;
      valuesPlaced--;
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
      // Read Standard Input
      int n = in.nextInt();
      int k = in.nextInt();

      // Init Set
      HashSet<Integer> setOfValues = new HashSet<>();
      for (int x = 1; x <= n; x++) {
        setOfValues.add(x);
      }

      // Only try populating all valid cases
      List<List<Integer>> permutations = new ArrayList<List<Integer>>();
      permutationsEqualToK(permutations, n, k, 0, new Integer[n], 0);

      boolean success = false;
      // Solve all potential cases
      for (List<Integer> p : permutations) {
        int[][] matrix = new int[n][n];
        // populateTrace(matrix, p);
        
        // Populate set of availabile values in each row and column of the matrix
        Map<Integer, Set<Integer>> validRows = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> validCols = new HashMap<Integer, Set<Integer>>();
        for (int x = 0; x < n; x++) {
          validRows.put(x, (Set<Integer>)setOfValues.clone());
          validCols.put(x, (Set<Integer>)setOfValues.clone());
        }

        reduceSearchSpace(validRows, p);
        reduceSearchSpace(validCols, p);

        if (isPossible(n, k, matrix, p, validRows, validCols, 0, 0, 0)) {
          String result = "POSSIBLE";
          String output = String.format("Case #%d: %s", i, result);
          System.out.println(output);
          printMatrix(matrix);
          success = true;
          break;
        }
      }

      if (!success) {
        String result = "IMPOSSIBLE";
        String output = String.format("Case #%d: %s", i, result);
        System.out.print(output);
      }

      if (i != t) {
        System.out.println();
      }
    }
  }
} 