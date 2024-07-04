import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);    
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();

      int k = 0;
      int r = 0;
      int c = 0;

      int sum = (n * (n+1)) / 2;
      int col[][] = new int[102][102];
      int[] colD = new int[102];
      for (int p = 1; p <= n; ++p) {

        int[] row = new int[102];
        boolean isRowDuplicate = false;
        for (int q = 1; q <= n; ++q) {
            
            int tmp = in.nextInt();
            
            if(p == q) {
                k += tmp;
            }
                 
            if(row[tmp] == 1) {
                isRowDuplicate = true;
            }
            row[tmp] += 1;
            
            

            if(col[q][tmp] == 1) {
                colD[q] = 1;
            }
            col[q][tmp] += 1;
            

            if(p == n && colD[q] == 1) {
                c++;
            } 
        }
        if(isRowDuplicate) {
            r++;
        }
      }

      System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
  }
} 