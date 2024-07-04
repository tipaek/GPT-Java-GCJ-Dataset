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
      while (sum!=target) {
        sum += comb[row][col];
        sb.append(String.format("%d %d\n", row+1, col+1));
        diff = target - sum;
        if (diff<maxMoves-nMoves) {
          targetCol = 0;
        } else if (diff>row*comb[row][col]) {
          targetCol = 5;
        } else if (Math.sqrt(diff) < maxMoves - nMoves - 10) {
          targetCol = 1;
        } else if (Math.pow(diff, 1/3.0) < maxMoves - nMoves - 20) {
          targetCol = 2;
        } else if (Math.pow(diff, 1/4.0) < maxMoves - nMoves - 20) {
          targetCol = 3;
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
