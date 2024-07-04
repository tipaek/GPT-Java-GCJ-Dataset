

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 4/10/20.
 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      String[] tokens = getTokens(reader);
      int R = Integer.parseInt(tokens[0]);
      int C = Integer.parseInt(tokens[1]);
      int[][] map = new int[R][];
      for (int i = 0; i<R; i++) {
        map[i] = new int[C];
        tokens = getTokens(reader);
        for (int j = 0; j<C; j++) {
          map[i][j] = Integer.parseInt(tokens[j]);
        }
      }

      int sum = 0;
      boolean stop = false;
      while (!stop) {
        int[] diex = new int[R*C];
        int[] diey = new int[R*C];
        int k = 0;
        for (int x = 0; x<R; x++) {
          for (int y = 0; y<C; y++) {
            if (map[x][y] > 0) {
              sum += map[x][y];
              if (die(map, R, C, x, y)) {
                diex[k] = x;
                diey[k] = y;
                k++;
              }
            }
          }
        }

        for (int i = 0; i<k; i++) {
          map[diex[i]][diey[i]] = 0;
        }
        if (k == 0) stop = true;
      }

      System.out.println("Case #" + t + ": " + sum);
    }
  }

  private static boolean die(int[][] map, int R, int C, int x, int y) {
    double sum = 0;
    int ct = 0;
    int i=x - 1;
    while (i >=0 && map[i][y] ==0) i--;
    if (i >=0) {
      sum += map[i][y];
      ct ++;
    }

    i = x +1;
    while (i < R && map[i][y] == 0) i++;
    if (i<R)  {
      sum += map[i][y];
      ct++;
    }

    i = y -1;
    while (i >=0 && map[x][i] == 0) i--;
    if (i >=0) {
      sum += map[x][i];
      ct++;
    }

    i = y+1;
    while (i < C && map[x][i] ==0) i++;
    if (i<C) {
      sum += map[x][i];
      ct++;
    }

    if (ct == 0) return false;
    return sum > map[x][y] * ct;
  }

  private static String[] getTokens(BufferedReader reader) throws IOException {
    return reader.readLine().trim().split(" ");
  }

  private static int getInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine().trim());
  }
}
