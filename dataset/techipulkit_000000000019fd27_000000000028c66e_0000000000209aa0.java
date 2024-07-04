  import java.util.*;
    import java.io.*;
    public class Solution {
    
      public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[][] matrix = new int[n][n];
      if (getMatrix(n, k, 0, matrix)) {
        System.out.println("Case #" + i + ": POSSIBLE");
        print(matrix, n);
      } else {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      }
    }
  }
  
  private static void print(int[][] matrix, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static boolean getMatrix(int n, int k, int i, int[][] matrix) {
    if (k < 0 || (k > 0 && i >= n) || (k == 0 && i != n)) {
      return false;
    }
    if (k == 0 && i == n) {
      return getMat(matrix, n);
    }
    for (int j = 1; j <= n; j++) {
      matrix[i][i] = j;
      if (getMatrix(n, (k - j), i + 1, matrix)) {
        return true;
      }
      matrix[i][i] = 0;
    }
    return false;
  }
  
  private static boolean getMat(int[][] matrix, int n) {
    int a = -1, b = -1;
    boolean isComplete = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          isComplete = false;
          a = i;
          b = j;
          break;
        }
      }
      if (!isComplete) {
        break;
      }
    }

    if (isComplete) {
      return true;
    }


    for (int k = 1; k <= n; k++) {
      if (canPlace(matrix, a, b, k)) {
        matrix[a][b] = k;
        if (getMat(matrix, n)) {
          return true;
        } else {
          matrix[a][b] = 0;
        }
      }
    }
    return false;
  }
  
  private static boolean canPlace(int[][] matrix, int i, int j, int num) {
    int size = matrix[0].length;
    for (int k = 0; k < size; k++) {
      if (matrix[i][k] == num)
        return false;
      if (matrix[k][j] == num) {
        return false;
      }
    }
    return true;
  }
      
      
      
    }