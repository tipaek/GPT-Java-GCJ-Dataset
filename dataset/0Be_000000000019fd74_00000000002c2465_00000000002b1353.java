import java.util.*;
import java.io.*;

class Solution {
  private static int[][] matrix;
  private static int N;
  private static int[][] nextI, nextJ;
  private static boolean[][] visited;
  private static int[] dx = {0, 0, 1, 1, -1, -1};
  private static int[] dy = {1, -1, 0, 1, -1, 0};

  private static void fillMatrix() {
    matrix = new int[30][30];
    for (int i = 0; i < 30; i++) {
      matrix[i][0] = 1;
      matrix[i][i] = 1;
      for (int j = 1; j < i; j++) {
        matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
      }
    }
  }
  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    fillMatrix();
    while (currTT++ < TT) {
      output.append("Case #" + currTT + ":\n");

      N = Integer.parseInt(in.readLine());
      nextI = new int[30][30];
      nextJ = new int[30][30];
      visited = new boolean[30][30];

      visited[0][0] = true;
      solve(0, 0, N - 1, 1);

      output.append("1 1\n");
      int i = nextI[0][0], j = nextJ[0][0];
      while(i != 0 || j != 0) {
        int _i = i, _j = j;
        output.append((i+1) + " " + (j+1) + "\n");
        i = nextI[_i][_j];
        j = nextJ[_i][_j];
      }
    }

    out.print(output);

    in.close();
    out.close();
  }

  private static boolean isValid(int cI, int cJ, int nI, int nJ) {
    if (nI < 0 || nI >= 30
      || nJ < 0 || nJ >= 30
      || nJ > nI
      || visited[nI][nJ]) {
      return false;
    }
    return true;
  }

  private static boolean solve(int i, int j, int r, int s) {
    if (s > 500 || r < 0) {
      return false;
    }
    if (r == 0) {
      return true;
    }

    for (int k = 0; k < 6; k++) {
      int _i = i + dx[k];
      int _j = j + dy[k];
      if (isValid(i, j, _i, _j)) {
        nextI[i][j] = _i; 
        nextJ[i][j] = _j;
        visited[_i][_j] = true;
        if (solve(_i, _j, r - matrix[_i][_j], s + 1)) {
          return true;
        }
        nextI[i][j] = 0; 
        nextJ[i][j] = 0; 
        visited[_i][_j] = false;
      }
    }
    return false;
  }

}