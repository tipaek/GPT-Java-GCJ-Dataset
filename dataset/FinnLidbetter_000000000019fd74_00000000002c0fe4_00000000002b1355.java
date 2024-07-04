/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      String[] s = br.readLine().split(" ");
      int nRows = Integer.parseInt(s[0]);
      int nCols = Integer.parseInt(s[1]);
      long[][] grid = new long[nRows][nCols];
      for (int r=0; r<nRows; r++) {
        s = br.readLine().split(" ");
        for (int c=0; c<nCols; c++) {
          grid[r][c] = Integer.parseInt(s[c]);
        }
      }
      long sum = 0;
      boolean removed = true;
      while (removed) {
        removed = false;
        ArrayList<Integer> removeRows = new ArrayList<>();
        ArrayList<Integer> removeCols = new ArrayList<>();
        for (int r=0; r<nRows; r++) {
          for (int c=0; c<nCols; c++) {
            if (grid[r][c]==-1)
              continue;
            sum += grid[r][c];
            long north = 0;
            long south = 0;
            long east = 0;
            long west = 0;
            int nNbrs = 0;
            for (int r2=r-1; r2>=0; r2--) {
              if (grid[r2][c]!=-1) {
                north = grid[r2][c];
                nNbrs++;
                break;
              }
            }
            for (int r2=r+1; r2<nRows; r2++) {
              if (grid[r2][c]!=-1) {
                south = grid[r2][c];
                nNbrs++;
                break;
              }
            }
            for (int c2=c-1; c2>=0; c2--) {
              if (grid[r][c2]!=-1) {
                west = grid[r][c2];
                nNbrs++;
                break;
              }
            }
            for (int c2=c+1; c2<nCols; c2++) {
              if (grid[r][c2]!=-1) {
                east = grid[r][c2];
                nNbrs++;
                break;
              }
            }
            long nbrSum = north+south+east+west;
            if (grid[r][c]*nNbrs<nbrSum) {
              removeRows.add(r);
              removeCols.add(c);
            }
          }
        }
        if (removeRows.size()>0) {
          removed = true;
          for (int i=0; i<removeRows.size(); i++) {
            grid[removeRows.get(i)][removeCols.get(i)] = -1;
          }
        }
      }
      
      sb.append(String.format("Case #%d: %d\n", test+1,sum));
    }
    System.out.print(sb);
  }
}
