import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int matrixSize = in.nextInt();
      
      int[][] matrix = new int[matrixSize][matrixSize];
      int trace = 0;
      int rowRepeat = 0;
      int colRepeat = 0;
      
      int sum = (matrixSize * (matrixSize + 1)) / 2;
      
      // populate matrix, get trace and number of repeated rows
      for (int row = 0; row < matrixSize; row++) {
          int rowSum = 0;
          for (int col = 0; col < matrixSize; col++) {
              matrix[row][col] = in.nextInt();
              rowSum += matrix[row][col];
              if (row == col) {
                  trace += matrix[row][col];
              }
          }
          if (rowSum != sum) {
              rowRepeat += 1;
          }
      }
      
      // get number of repeated columns
      for (int col = 0; col < matrixSize; col++) {
          int colSum = 0;
          for (int row = 0; row < matrixSize; row++) {
              colSum += matrix[row][col];
          }
          if (colSum != sum) {
              colRepeat += 1;
          }
      }
      
      System.out.println("Case #" + i + ": " + trace + " " + rowRepeat + " " + colRepeat);
    }
  }
}
