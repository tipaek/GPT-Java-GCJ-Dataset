import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int size = in.nextInt();
      int trace = 0;
      int currentInt = 0;
      int dupRow = 0;
      int dupCol = 0;
      int[][] rowMatrix = new int[size][size];
      int[][] colMatrix = new int[size][size];
      for (int row = 0; row < size; row++) {
        for (int col = 0; col < size; col++) {
          currentInt = in.nextInt();
          if (row == col) trace += currentInt;
          currentInt--;
          rowMatrix[row][currentInt] += 1;
          colMatrix[col][currentInt] += 1;
        }
      }
      for (int row = 0; row < size; row++) {
        for (int col = 0; col < size; col++) {
          if(rowMatrix[row][col] > 1){
            dupRow++;
            break;
          }
        }
      }
      for (int col = 0; col < size; col++) {
       for (int row = 0; row < size; row++) {
         if(colMatrix[col][row] > 1){
            dupCol++;
            break;
          }
        }
      }
      
      System.out.println("Case #" + t + ": " + trace + " " + dupRow + " " + dupCol);
    }
  }
}
