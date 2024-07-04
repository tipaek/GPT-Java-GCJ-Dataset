import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int rowsCols = in.nextInt();
      int traces = 0;
      int[][] givenMatrix = new int[rowsCols][rowsCols];
      for(int row = 0; row<rowsCols; row++) {
        for(int col = 0; col<rowsCols; col++) {
          givenMatrix[row][col] = in.nextInt();
          if(row == col) {
            traces += givenMatrix[row][col];
          }
        }
      }

      int rowDuplicate = 0;
      int colDuplicate = 0;

      for(int row = 0; row<rowsCols; row++) {
        HashSet<Integer> rowSet = new HashSet<>();
        for(int col = 0; col<rowsCols; col++) {
          if(rowSet.contains(givenMatrix[row][col])) {
            rowDuplicate++;
            break;
          }
          rowSet.add(givenMatrix[row][col]);
        }
      }

      for(int col = 0; col<rowsCols; col++) {
        HashSet<Integer> colSet = new HashSet<>();
        for(int row = 0; row<rowsCols; row++) {
          if(colSet.contains(givenMatrix[row][col])) {
            colDuplicate++;
            break;
          }
          colSet.add(givenMatrix[row][col]);
        }
      }
      System.out.println("Case #"+i+": "+traces+" "+rowDuplicate+" "+colDuplicate);
    }
  }
}