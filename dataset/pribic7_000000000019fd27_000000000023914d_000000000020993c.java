//package Q2020;

import java.util.Scanner;

public class Solution {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i = 1; i<= t; i++) {
      int N = sc.nextInt();
      boolean[] row = new boolean[N + 1];
      boolean[] col = new boolean[N + 1];
      boolean[][] rowPresent = new boolean[N+1][N+1];
      boolean[][] colPresent = new boolean[N+1][N+1];
      long trace = 0;
      for (int x = 1; x <= N; x++) {
        for (int y = 1; y <= N; y++) {
          int num = sc.nextInt();
          if (x == y)
            trace += num;
          if (!rowPresent[x][num])
            rowPresent[x][num] = true;
          else
            row[x] = true;
          if (!colPresent[y][num])
            colPresent[y][num] = true;
          else
            col[y] = true;
        }
      }
      int rowcnt = 0;
      for(boolean b : row) {
        if(b)
          rowcnt++;
      }
      int colcnt = 0;
      for(boolean b : col) {
        if(b)
          colcnt++;
      }
      System.out.println(String.format("Case #%d: %d %d %d", i, trace, rowcnt, colcnt));
    }
    sc.close();
  }
}
