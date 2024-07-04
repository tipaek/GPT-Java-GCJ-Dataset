import java.util.*;
import java.io.*;

public class Solution {
  private static int[][] buildMatrix(int n, Scanner in) {
    int[][] matrix = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        matrix[i][j] = in.nextInt();
      }
    }

    return matrix;
  }

  private static void process(int testCaseCount, int[][] matrix) {
    int diagSum = 0;

    for(int i = 0; i < matrix.length; i++) {
      diagSum += matrix[i][i];
    }

    int targetSum = 0;

    for(int i = 1; i <= matrix.length; i++) {
      targetSum += i;
    }
    int colCount = 0, rowCount = 0;

    for(int j = 0; j < matrix[0].length; j++) {
      boolean[] isUsed = new boolean[matrix.length];
      boolean repeating = false;
      for(int i = 0; i < matrix.length; i++) {
        int n = matrix[i][j];
        if(isUsed[n - 1]) repeating = true;
        isUsed[n - 1] = true;
      }

      if(repeating) colCount++;
    }

    for(int i = 0; i < matrix.length; i++) {
      boolean[] isUsed = new boolean[matrix.length];
      boolean repeating = false;
      for(int j = 0; j < matrix[i].length; j++) {
        int n = matrix[i][j];
        if(isUsed[n - 1]) repeating = true;
        isUsed[n - 1] = true;
      }

      if(repeating) rowCount++;
    }

    System.out.println("Case #" + testCaseCount + ": " + diagSum + " " + rowCount + " " + colCount);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseCount = in.nextInt();

    for (int i = 1; i <= testCaseCount; ++i) {  
      int N = in.nextInt();
      
      int[][] matrix = buildMatrix(N, in);
      
      process(testCaseCount, matrix);

    }
  }
}