import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      int R = in.nextInt();
      int C = in.nextInt();
      
      long[][]  s = new long[R][C];
      boolean[][] e = new boolean[R][C];
      long totalSum = 0;
      long roundSum = 0;
      for(int r=0; r<R; r++) {
          for(int c=0; c<C; c++) {
              s[r][c] = in.nextLong();
              e[r][c] = false;
              roundSum += s[r][c];
          }
      }
      
      boolean eliminated = true;
      
      while(eliminated) {
          eliminated = false;
          totalSum += roundSum;
          
          boolean[][] et = new boolean[R][C];
          
          for(int r=0; r<R; r++) {
              for(int c=0; c<C; c++) {
                  if(!e[r][c]) {
                      if(IsEliminating(r, c, s, e, R, C)) {
                          roundSum -= s[r][c];
                          et[r][c] = true;
                          eliminated = true;
                      }
                      else {
                          et[r][c] = false;
                      }
                  }
                  else et[r][c] = true;
              }
          }
          e = et;
      }
      
      System.out.println("Case #" + i + ": " + totalSum);
    }
  }
  
  public static boolean IsEliminating(int r, int c, long[][] s, boolean[][] e, int R, int C) {
    long nc = 0;
    long tot = 0;
    
    int t = c;
    while(--t>=0) if(!e[r][t]) { nc ++; tot += s[r][t]; break;}
    
    t = c;
    while(++t<C) if(!e[r][t]) { nc ++; tot += s[r][t]; break;}
    
    t = r;
    while(--t>=0) if(!e[t][c]) { nc ++; tot += s[t][c]; break;}

    t = r;
    while(++t<R) if(!e[t][c]) { nc ++; tot += s[t][c]; break;}
    
    if(nc == 0) return false;
    
    return s[r][c]*nc < tot;
  }
}