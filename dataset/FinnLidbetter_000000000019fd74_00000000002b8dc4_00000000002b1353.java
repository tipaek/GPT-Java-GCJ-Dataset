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
    
    int max = 501;
    long[][] comb = new long[max][max];
    for (int i=0; i<max; i++) {
      comb[i][i] = 1;
      comb[i][0] = 1;
    }
    for (int i=2; i<max; i++) {
      for (int j=1; j<max-1; j++) {
        comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
      }
    }

    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      long target = Long.parseLong(br.readLine());
      sb.append(String.format("Case #%d:\n", test+1));
      long sum = 0;
      int row = 0;
      int col = 0;
      int nMoves = 0;
      int maxMoves = 500;
      long diff = target - sum;
      int targetCol = 0;
      int maxCol = 5;
      while (sum!=target) {
        sum += comb[row][col];
        sb.append(String.format("%d %d\n", row+1, col+1));
        diff = target - sum;
        long minRemainder = 0;
        for (int i=0; i<=col; i++) {
          minRemainder += comb[row+1][i];
        }
        if (minRemainder>diff && col>0) {
          targetCol = col-1;
          maxCol = col-1;
        } else if (diff<maxMoves-nMoves) {
          targetCol = 0;
        } else  {
          targetCol = maxCol;
        }
        //System.err.printf("nMoves: %d, Sum: %d, diff: %d, targetCol: %d\n", nMoves, sum, diff, targetCol);
        if (col==targetCol || col>=row) {
          row++;
        } else if (col<targetCol) {
          col++;
        } else {
          col--;
        }
        nMoves++;
      }
    }
    System.out.print(sb);

  }
}
