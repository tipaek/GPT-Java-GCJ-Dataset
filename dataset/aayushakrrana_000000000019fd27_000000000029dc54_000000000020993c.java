import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int z = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= z; ++x) {
      int p = in.nextInt();
      int m = 0;
      int q = 0;
      int l = 0;
      boolean fr = false;
      boolean fc = false;
      int[][] mat = new int[p][p]; 

      for (int j = 0; j < mat.length; j++) {
        for (int j2 = 0; j2 < mat.length; j2++) {
          mat[j][j2] = in.nextInt();
        }
      }
      // row
      for (int j = 0; j < mat.length; j++) {
        m += mat[j][j];
        for (int j2 = 0; j2 < mat.length; j2++) {
          for (int l = j2 + 1; l < mat.length; l++) {
            if (mat[j][j2] == mat[j][l]) {
              fr = true;
              break;
            }
          }
          if (fr == true) {
            break;
          }
        }
        if (fr == true) {
          q += 1;
          fr = false;
        }
        // column
        for (int j2 = 0; j2 < mat.length; j2++) {
          for (int l = j2 + 1; l < mat.length; l++) {
            if (mat[j2][j] == mat[l][j]) {
              fc = true;
              break;
            }
          }
          if (fc == true) {
            break;
          }
        }
        if (fc == true) {
          l += 1;
          fc = false;
        }
      }
      System.out.println("Case #" + x + ": " + m + " " + q + " " + l + " " );
    }
  }
}
