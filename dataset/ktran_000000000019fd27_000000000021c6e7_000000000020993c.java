import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      
      int trace = 0;
      int row = 0;
      int col = 0;
      int sum = N*(N+1)/2;
      
      int[][] cells = new int[N][N];
      
      for(int n1 = 0; n1 < N; n1++) {
          for(int n2 = 0; n2 < N; n2++) {
            cells[n1][n2] = in.nextInt();
            if(n1 == n2) {
                trace += cells[n1][n2];
            }
          }
      }
      
       
          
        for(int n1 = 0; n1 < N; n1++) {
           boolean[] rows = new boolean[N];
         
           for(int n2 = 0; n2 < N; n2++) {
               if(rows[cells[n1][n2]-1]) {
                   row++;
                   break;
               }
               rows[cells[n1][n2]-1] = true;
            }
         }    
         
         for(int n1 = 0; n1 < N; n1++) {
           boolean[] cols = new boolean[N];
         
           for(int n2 = 0; n2 < N; n2++) {
               if(cols[cells[n2][n1]-1]) {
                   col++;
                   break;
               }
               cols[cells[n2][n1]-1] = true;
            }
         }    
      
      
      
      
      
      
      System.out.println("Case #" + i + ": " + trace + " " + row + " "+col);
    }
  }
}