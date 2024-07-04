import java.io.*;
import java.util.*;

public class Solution {
  static class Position { 
    int r;
    int c;

    public Position(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
  public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      long[][] dancers = new long[r][c];
      boolean[][] out = new boolean[r][c];
      for(int i = 0; i < r; i++) {
        st = new StringTokenizer(f.readLine());
        for(int j = 0; j < c; j++) {
          dancers[i][j] = Long.parseLong(st.nextToken());
        }
      }

      long sum = 0;
      boolean go = true;
      while(go) {
        go = false;

        List<Position> eliminated = new ArrayList<>();
        for(int i = 0; i < r; i++) {
          for(int j = 0; j < c; j++) {
            if (!out[i][j]) {
              sum += dancers[i][j];

              long numNeighbors = 0;
              long neighborSkill = 0;
              
              int di = 1;
              while (i - di >= 0) {
                if (!out[i - di][j]) {
                  numNeighbors++;
                  neighborSkill += dancers[i - di][j];
                  break;
                }
                di++;
              }
              di = 1;
              while (i + di < r) {
                if (!out[i + di][j]) {
                  numNeighbors++;
                  neighborSkill += dancers[i + di][j];
                  break;
                }
                di++;
              }

              int dj = 1;
              while (j - dj >= 0) {
                if (!out[i][j - dj]) {
                  numNeighbors++;
                  neighborSkill += dancers[i][j - dj];
                  break;
                }
                dj++;
              }
              dj = 1;
              while (j + dj < c) {
                if (!out[i][j + dj]) {
                  numNeighbors++;
                  neighborSkill += dancers[i][j + dj];
                  break;
                }
                dj++;
              }

              if (numNeighbors * dancers[i][j] < neighborSkill) {
                eliminated.add(new Position(i, j));
              }
            }
          }
        }

        for(Position p : eliminated) {
          out[p.r][p.c] = true;
        }
        go = !eliminated.isEmpty();
      }

      System.out.println("Case #" + num + ": " + sum);
		}
		f.close();
	}
}