import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int[][] grid = new int[N][N];
      for(int j=0;j<N;j++)
      {
          for(int k=0;k<N;k++)
          {
              grid[j][k] = in.nextInt();
          }
      }
      int trace = 0;
      for(int j=0;j<N;j++)
      {
          trace +=grid[j][j];
      }
      int numCol=0;
      for(int j=0;j<N;j++)
      {
          HashSet<Integer> presentnumbers = new HashSet<Integer>();
          boolean hadbad = false;
          for(int k=0;k<N;k++)
          {
              if(presentnumbers.contains(grid[k][j]))
              {hadbad = true;
              }else
              {
                  presentnumbers.add(grid[k][j]);
              }
          }
          if(hadbad)
                  numCol++;
      }
      int numRow=0;
      for(int j=0;j<N;j++)
      {
          HashSet<Integer> presentnumbers = new HashSet<Integer>();
          boolean hadbad = false;
          for(int k=0;k<N;k++)
          {
              if(presentnumbers.contains(grid[j][k]))
              {
hadbad=true;
              }else
              {
                  presentnumbers.add(grid[j][k]);
              }
          }
          if(hadbad)
                            numRow++;
      }
      System.out.println("Case #" + i + ": " + trace + " " + numRow + " " + numCol);
    }
  }
}