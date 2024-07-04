import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int k = 0;
      int r = 0;
      int c = 0;
      boolean flagRow = false;
      boolean flagColumn = false;
      int[][] m1 = new int[n][n]; 

      for (int j = 0; j < m1.length; j++) {
        for (int j2 = 0; j2 < m1.length; j2++) {
          m1[j][j2] = in.nextInt();
        }
      }
      // row
      for (int j = 0; j < m1.length; j++) {
        k += m1[j][j];
        for (int j2 = 0; j2 < m1.length; j2++) {
          for (int l = j2 + 1; l < m1.length; l++) {
            if (m1[j][j2] == m1[j][l]) {
              flagRow = true;
              break;
            }
          }
          if (flagRow == true) {
            break;
          }
        }
        if (flagRow == true) {
          r += 1;
          flagRow = false;
        }
        // column
        for (int j2 = 0; j2 < m1.length; j2++) {
          for (int l = j2 + 1; l < m1.length; l++) {
            if (m1[j2][j] == m1[l][j]) {
              flagColumn = true;
              break;
            }
          }
          if (flagColumn == true) {
            break;
          }
        }
        if (flagColumn == true) {
          c += 1;
          flagColumn = false;
        }
      }
      System.out.println("Case #" + i + ": " + k + " " + r + " " + c + " " );
    }
  }
}