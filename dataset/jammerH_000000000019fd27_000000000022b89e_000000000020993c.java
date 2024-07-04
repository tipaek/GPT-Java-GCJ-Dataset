

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

  public static void main(String[] args) throws FileNotFoundException {

    InputStream inputStream = System.in;
    String file = "/Users/hshankar/learn/codejam2020/src/com/company/test";
    // InputStream inputStream = new FileInputStream(file);
    Scanner in =
        new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      boolean[][] cols = new boolean[n][n];
      int trace = 0;
      boolean[] br = new boolean[n];
      boolean[] bc = new boolean[n];
      for (int j = 0; j < n; ++j) {
        boolean[] rs = new boolean[n];
        for (int k = 0; k < n; ++k) {
          int num = in.nextInt() - 1;
          if (j == k) {
            trace += num + 1;
          }
          if (rs[num]) {
            br[j] = true;
          } else {
            rs[num] = true;
          }
          if (cols[k][num]) {
            bc[k] = true;
          } else {
            cols[k][num] = true;
          }
        }
      }
      int badRows = 0, badCols = 0;
      for (int j = 0; j < n; ++j) {
        if (br[j]) {
          badRows++;
        }
      }
      for (int j = 0; j < n; ++j) {
        if (bc[j]) {
          badCols++;
        }
      }
      System.out.println(
          "Case #" + i + ": " + trace + " " + badRows + " " + badCols);
    }
  }
}
