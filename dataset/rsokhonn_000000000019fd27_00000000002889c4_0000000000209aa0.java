import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[][] matrix = new int[n][n];
            
            boolean possible = true;
            
            if(!buildSuccessful(matrix, n, k))
                possible = false;
            
            if (!possible)
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            else {
                System.out.println("Case #" + tc + ": POSSIBLE");
                printBoard(matrix);
            }
        }
    }
    
    public static boolean buildSuccessful(int[][] matrix, int n, int k) {
      for (int row = 0; row < n; row++) {
          for (int column = 0; column < n; column++) {
              if (matrix[row][column] == 0) {
                  for (int t = 1; t <= n; t++) {
                      matrix[row][column] = t;
                      if (isValid(matrix, row, column) && buildSuccessful(matrix, n, k) && trace(matrix) == k) {
                          return true;
                      }
                      matrix[row][column] = 0;
                  }
                  return false;
              }
          }
      }
      return true;
    }

    public static boolean isValid(int[][] matrix, int row, int column) {
        return (rowConstraint(matrix, row)
          && columnConstraint(matrix, column));
    }

    public static boolean rowConstraint(int[][] matrix, int row) {
    boolean[] constraint = new boolean[matrix.length];
        return IntStream.range(0, matrix.length)
          .allMatch(column -> checkConstraint(matrix, row, constraint, column));
    }

    public static boolean columnConstraint(int[][] matrix, int column) {
        boolean[] constraint = new boolean[matrix.length];
        return IntStream.range(0, matrix.length)
          .allMatch(row -> checkConstraint(matrix, row, constraint, column));
    }

    public static boolean checkConstraint(
        int[][] matrix, 
        int row, 
        boolean[] constraint, 
        int column) {
        if (matrix[row][column] != 0) {
            if (!constraint[matrix[row][column] - 1]) {
                constraint[matrix[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length-1; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println(matrix[row][matrix.length-1]);
        }
    }

    public static int trace(int[][] matrix) {
      int trace = 0;

      for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix.length; j++) {
          if (i == j) trace += matrix[i][j];
        }
      }

      return trace;
    }
}