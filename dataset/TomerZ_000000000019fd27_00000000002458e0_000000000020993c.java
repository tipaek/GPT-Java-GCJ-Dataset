import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tests = scanner.nextInt();

    for (int t = 1; t <= tests; t++) {
      int n = scanner.nextInt();
      int[][] mat = new int[n][n];
      long trace = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = scanner.nextInt();
          trace += (i == j ? mat[i][j] : 0);
        }
      }

      int invalidRows = 0;
      Set<Integer> seenVals = new HashSet<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (mat[i][j] < 1 || mat[i][j] > n || seenVals.contains(mat[i][j])) {
            invalidRows++;
            break;
          }
          seenVals.add(mat[i][j]);
        }
        seenVals.clear();
      }

      int invalidCols = 0;

      for (int j = 0; j < n; j++) {
        for (int i = 0; i < n; i++) {
          if (mat[i][j] < 1 || mat[i][j] > n || seenVals.contains(mat[i][j])) {
            invalidCols++;
            break;
          }
          seenVals.add(mat[i][j]);
        }
        seenVals.clear();
      }

      System.out.println(String.format("Case #%s: %s %s %s", t, trace, invalidRows, invalidCols));
    }
  }
}
