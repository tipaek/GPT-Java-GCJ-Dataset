

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 4/3/20.
 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(reader.readLine());
      int[][] matrix = new int[N][];
      for (int i = 0; i<N; i++) matrix[i] = new int[N];
      for (int i = 0; i<N; i++) {
        String[] tokens = reader.readLine().split(" ");
        for (int j = 0; j<N; j++) {
          matrix[i][j] = Integer.parseInt(tokens[j]);
        }
      }

      int k = 0;
      for (int i = 0; i<N; i++) {
        k += matrix[i][i];
      }

      boolean[][] rV = init(N);
      boolean[][] cV = init(N);
      boolean[] r = new boolean[N];
      boolean[] c = new boolean[N];
      for (int i = 0; i<N; i++) {
        for (int j = 0; j<N; j++) {
          if (rV[i][matrix[i][j] - 1]) {
            r[i] = true;
          }else {
            rV[i][matrix[i][j] - 1] = true;
          }

          if (cV[j][matrix[i][j] - 1]) {
            c[j] = true;
          } else {
            cV[j][matrix[i][j] - 1] = true;
          }
        }
      }
      int rC = 0;
      for (int i = 0; i<N; i++) if (r[i]) rC++;
      int cC = 0;
      for (int i = 0; i<N; i++) if (c[i]) cC++;
      System.out.println("Case #" + t + ": " + k + " " + rC + " " + cC);
    }
  }


  private static boolean[][] init(int N) {
    boolean[][] rV = new boolean[N][];
    for (int i = 0; i<N; i++) {
      rV[i] = new boolean[N];
      for (int j = 0; j < N; j++) {
        rV[i][j] =false;
      }
    }
    return rV;
  }

}
