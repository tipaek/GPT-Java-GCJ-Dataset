import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] arr = new int[n][n];
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          int x = in.nextInt();
          arr[j][k] = x;
        }
      }
      int diag = getDiag(arr);
      int rows = getRows(arr);
      int columns = getColumns(arr);
      System.out.println("Case #" + i + ": " + diag + " " + rows + " " + columns);
    }
  }

  public static int getDiag(int mat[][]) {
    int sum = 0;
    for (int i = 0; i < mat.length; i++) {
      sum += mat[i][i];
    }
    return sum;
  }

  public static int getRows(int mat[][]) {
    int res = 0;
    for (int i = 0; i < mat.length; i++) {
      res += getRepeated(mat[i]) ? 1 : 0;
    }
    return res;
  }

  public static int getColumns(int mat[][]) {
    int res = 0;
    for (int i = 0; i < mat.length; i++) {
      int[] arr = new int[mat.length];
      for (int j = 0; j < mat.length; j++) {
        arr[j] = mat[j][i];
      }
      res += getRepeated(arr) ? 1 : 0;
    }
    return res;
  }

  public static boolean getRepeated(int mat[]) {
    boolean hasRepeated = false;
    Set<Integer> s = new HashSet<Integer>();
    int i = 0;
    while (!hasRepeated && i < mat.length) {
      int num = mat[i];
      if (s.contains(num)) {
        hasRepeated = true;
      } else {
        s.add(num);
      }
      i++;
    }
    return hasRepeated;
  }
}