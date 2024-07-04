import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int cases = in.nextInt();

    for (int c = 1; c <= cases; c++) {
      String answer = "Case #" + c + ": ";
      int R = in.nextInt();
      int C = in.nextInt();
      long score = 0;
      int[][] dancers = new int[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          dancers[i][j] = in.nextInt();
        }
      }
      int[][] nextRound = new int[R][C];
      copy(dancers,nextRound);

      boolean ends = false;
      while (!ends) {
        ends = true;
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            score += dancers[i][j];
            if (dancers[i][j] != 0 && eliminated(dancers, i, j)) {
              ends = false;
              nextRound[i][j] = 0;
            }
          }
        }
        copy(nextRound,dancers);
      }

      out.println(answer + score);
    }

    in.close();
    out.close();
  }

  private static void copy(int[][] src, int[][] dst) {
    for (int i = 0; i < src.length; i++) {
      for (int j = 0; j < src[0].length; j++) {
        dst[i][j] = src[i][j];
      }

    }
  }

  private static boolean eliminated(int[][] dancers, int i, int j) {
    int neighbors = 0;
    int neighborScore = 0;

    int x = i-1;
    while (x>-1 && dancers[x][j] == 0) x--;
    if(x>=0){ neighbors++; neighborScore += dancers[x][j];}

    x = i+1;
    while (x<dancers.length && dancers[x][j] == 0) x++;
    if(x<dancers.length){ neighbors++; neighborScore += dancers[x][j];}

    int y = j-1;
    while (y>-1 && dancers[i][y] == 0) y--;
    if(y>=0){ neighbors++; neighborScore += dancers[i][y];}

    y = j + 1;
    while (y<dancers[0].length && dancers[i][y] == 0) y++;
    if(y<dancers[0].length){ neighbors++; neighborScore += dancers[i][y];}

    if(neighbors == 0) return false;
    return dancers[i][j]*neighbors < neighborScore;
  }
}
