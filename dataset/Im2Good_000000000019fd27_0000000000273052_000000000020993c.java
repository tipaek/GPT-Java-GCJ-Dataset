import java.io.*;
import java.util.*;
import static java.util.Arrays.*;

public class Vestigum {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st = new StringTokenizer("");

  static void FILL() { try { while(!st.hasMoreTokens()) st = new StringTokenizer(in.readLine()); } catch (Exception e) { throw new AssertionError(e); }}
  static int INT() { FILL(); return Integer.parseInt(st.nextToken()); }

  public static void main(String... args) throws Exception {
    int T = INT();
    for (int i = 0; i < T; i++) {
      System.out.printf("Case #%d: %s%n", i+1, new Vestigum().entry());
    }
  }

  String entry() {
    int n = INT();
    int[][] mat = new int[n][n];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        mat[i][j] = INT()-1;
      }
    }
    int trace = n;
    for (int i = 0; i < n; i++) trace += mat[i][i];
    int cols = 0;
    int rows = 0;
    for (int i = 0; i < n; i++) {
      cols += ok(mat, 0, i, 1, 0);
      rows += ok(mat, i, 0, 0, 1);
    }
    return String.format("%d %d %d", trace, rows, cols);
  }

  int ok(int[][] mat, int row, int col, int dr, int dc) {
    boolean[] found = new boolean[mat.length];
    for (int i = 0; i < mat.length; i++) {
      int r = row+dr*i;
      int c = col+dc*i;
      if (found[mat[r][c]]) return 1;
      found[mat[r][c]] = true;
    }
    return 0;
  }
}
