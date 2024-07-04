import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
            processTest(in, i);
        }
  }
  
  private static void processTest(final Scanner scannerInput, int count) {
      final int matrixCount = scannerInput.nextInt();
      int[][] multiples = new int[matrixCount][matrixCount];
      
      int diagonalFlag = 0;
      int rowFlag = 0;
      int columnFlag = 0;
      
      for(int i = 0; i < matrixCount; i++) {
          for(int j = 0; j < matrixCount; j++) {
              multiples[i][j] = scannerInput.nextInt();
          }
      }
      
      for(int i = 0; i < matrixCount; i++) {
        int[] columnArray = new int[matrixCount+1];
        int[] rowArray = new int[matrixCount+1];

        for(int j = 0; j < matrixCount; j++) {
              if(i == j) {
                  diagonalFlag += multiples[i][j];
              }
              
              if(rowArray[multiples[i][j]] != 0 && rowArray[0] == 0) {
                  rowArray[0] = 1;
                  rowFlag++;
                } else {
                    rowArray[multiples[i][j]]++;
                }
                  
              if(columnArray[multiples[j][i]] != 0 && columnArray[0] == 0) {
                  columnArray[0] = 1;
                  columnFlag++;
                  } else {
                      columnArray[multiples[j][i]]++;
                  }
          }
      }
      System.out.println("Case #" +count+ ": "+ diagonalFlag+ " " + rowFlag+ " " + columnFlag+ " ");
      
  }
} 