import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ti = 1; ti <= t; ++ti) {
      int n = in.nextInt();
      boolean rowNums[][] = new boolean[n][101];
      boolean colNums[][] = new boolean[n][101];
      int numberOfDistinctNumsForRows[] = new int[n];
      int numberOfDistinctNumsForCols[] = new int[n];
      int rowCounts = 0;
      int colCounts = 0;
      int trace = 0;
      
      for(int i = 0; i < n; i++) {
          for(int j = 0; j < n; j++) {
            int num = in.nextInt();
            if(i == j) {
                trace += num;
            }
            if(rowNums[i][num] == false) {
                numberOfDistinctNumsForRows[i]++;
                rowNums[i][num] = true;
            }
            if(colNums[j][num] == false) {
                numberOfDistinctNumsForCols[j]++;
                colNums[j][num] = true;
            }
            
          }
      }
      for(int i = 0; i < n; i++) {
          if(numberOfDistinctNumsForRows[i] != n) {
              rowCounts++;
          }
          if(numberOfDistinctNumsForCols[i] != n) {
              colCounts++;
          }
          
      }
      System.out.println("Case #" + ti + ": " + trace + " " + rowCounts + " " + colCounts);
    }
  }
}