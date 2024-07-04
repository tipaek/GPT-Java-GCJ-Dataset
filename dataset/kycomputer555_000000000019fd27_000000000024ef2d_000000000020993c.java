import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int iTest = 1; iTest <= t; ++iTest) {
      int n = in.nextInt();
      int[][] a = new int[n][n];
      for (int i=0; i<n; i++) {
          for (int j=0; j<n; j++) {
            a[i][j] = in.nextInt();
          }
      }

      int k = 0, r = 0, c = 0;
      for (int i=0; i<n; i++) {
        k += a[i][i];
        Set<Integer> setRow = new HashSet<Integer>();
        Set<Integer> setCol = new HashSet<Integer>();
        boolean flagRow = true;
        boolean flagCol = true;
        for (int j=0; j<n; j++) {
          if (flagRow && !setRow.add(a[i][j])) {
            flagRow = false;
            r++;
          }
          if (flagCol && !setCol.add(a[j][i])) {
            flagCol = false;
            c++;
          }
        }
      }
      System.out.println("Case #" + iTest + ": " + k + " " + r + " " + c);
    }
  }
}