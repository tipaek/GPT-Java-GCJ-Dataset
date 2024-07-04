import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.print("Case #" + ks + ":");
      solve(input);
    }
  }

  private static void solve(Scanner input) {
    int n = input.nextInt();
    int[][] mat = new int[n][n];

    int trace = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = input.nextInt();
        if (i == j) {
          trace += mat[i][j];
        }
      }
    }

    int rowCount = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (set.contains(mat[i][j])) {
          rowCount++;
          break;
        }
        set.add(mat[i][j]);
      }
    }

    int colCount = 0;
    for (int j = 0; j < n; j++) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if (set.contains(mat[i][j])) {
          colCount++;
          break;
        }
        set.add(mat[i][j]);
      }
    }

    System.out.println(" " + trace + " " + rowCount + " " + colCount);
  }
}
