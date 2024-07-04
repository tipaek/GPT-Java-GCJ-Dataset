import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 0; i < t; ++i) {
      int n = in.nextInt();
      int[][] mat = new int[n][n];
      for (int j = 0; j < n; ++j) {
          for (int k = 0; k < n; ++k) {
            mat[j][k] = in.nextInt();
          }
      }
      System.out.println("Case #" + (i+1) + ": " + trace(mat, n) + " " + duplicateRows(mat, n) + " " + duplicateColumns(mat, n));
    }
  }
  
  private static int trace(int[][] mat, int n) {
    int trace = 0;
    for (int i = 0; i < n; ++i) {
        trace += mat[i][i];
    }
    return trace;
  }

  private static int duplicateRows(int[][] mat, int n) {
    int dup = 0;
    for (int row = 0; row < n; ++row) {
      boolean[] seen = new boolean[n];
      for (int column = 0; column < n; ++column) {
        if (seen[mat[row][column]-1]) {
	  dup += 1;
	  break;
	}
	seen[mat[row][column]-1] = true;
      }
    }
    return dup;
  }

private static int duplicateColumns(int[][] mat, int n) {
    int dup = 0;
    for (int c = 0; c < n; ++c) {
      boolean[] seen = new boolean[n];
      for (int r = 0; r < n; ++r) {
        if (seen[mat[r][c]-1]) {
	  dup += 1;
	  break;
	}
	seen[mat[r][c]-1] = true;
      }
    }
    return dup;
  }


}
 
