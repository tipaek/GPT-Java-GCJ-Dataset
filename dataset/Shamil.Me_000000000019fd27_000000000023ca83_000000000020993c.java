import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      
      int[][] m = new int[n][n];
      for(int r=0; r<n; r++) {
          for(int c=0; c<n; c++) {
              m[r][c] = in.nextInt();
          }
      }
      
      int k = 0;
      for(int r=0; r<n; r++) k += m[r][r];
      
      int rr = 0;
      for(int r=0; r<n; r++) {
          boolean map[] = new boolean[n+1];
          for(int c=0; c<n; c++) {
              if(map[m[r][c]]) {
                  rr ++;
                  break;
              }
              map[m[r][c]] = true;
          }
      }
      
      int cc = 0;
      for(int r=0; r<n; r++) {
          boolean map[] = new boolean[n+1];
          for(int c=0; c<n; c++) {
              if(map[m[c][r]]) {
                  cc ++;
                  break;
              }
              map[m[c][r]] = true;
          }
      }
      
      System.out.println("Case #" + i + ": " + k + " " + rr + " " + cc);
    
    }
  }
}