import java.math.BigInteger;
import java.util.*;

class Kattis {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int rr = in.nextInt();
    for (int welp = 1; welp <= rr; welp++) {
      int n = in.nextInt();
      int[][] mat = new int[n][n];
      int k = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = in.nextInt();
          if (i == j) {
            k += mat[i][j];
          }
        }
      }
      int r = 0, c = 0;
      for (int i = 0; i < n; i++) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int j = 0; j < n; j++) {
          row.add(mat[i][j]);
          col.add(mat[j][i]);
        }
        if (row.size() != n)
          r++;
        if (col.size() != n)
          c++;
      }
      System.out.println("Case #" + welp + ": " + k + " " + r + " " + c);
    }
  }
}