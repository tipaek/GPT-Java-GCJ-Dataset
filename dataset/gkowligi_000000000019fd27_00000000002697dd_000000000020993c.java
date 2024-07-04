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
      
      // populate matrix, get trace and number of repeated rows
      for (int row = 0; row < matrixSize; row++) {
          boolean repeat = false;
          Set<Integer> tempSet = new HashSet<Integer>();
          for (int col = 0; col < matrixSize; col++) {
              matrix[row][col] = in.nextInt();
              if (row == col) {
                  trace += matrix[row][col];
              }
              if(!tempSet.add(matrix[row][col])) {
                  repeat = true;
              }
          }
          if (repeat == true) {
              rowRepeat += 1;
          }
      }
      
      // get number of repeated columns
      for (int col = 0; col < matrixSize; col++) {
          boolean repeat = false;
          Set<Integer> tempSet = new HashSet<Integer>();
          for (int row = 0; row < matrixSize; row++) {
              if(!tempSet.add(matrix[row][col])) {
                  repeat = true;
              }
          }
          if (repeat == true) {
              colRepeat += 1;
          }
      }
      
      System.out.println("Case #" + i + ": " + trace + " " + rowRepeat + " " + colRepeat);
    }
  }
}
