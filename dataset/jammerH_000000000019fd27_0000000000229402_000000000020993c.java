import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Vestigium {

  public static void main(String[] args) {
    Scanner in =
        new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t =
        in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      boolean[][] cols = new boolean[n][n];
      int trace = 0;
      boolean[] br = new boolean[n];
      boolean[] bc = new boolean[n];
      for (int j = 0; j < n; ++j) {
        boolean[] rs = new boolean[n];
        for (int k = 0; k < n; ++k) {
          int num = in.nextInt();
          if (j == k) {
            trace += num;
          }
          if (rs[num]) {
            br[j] = true;
          } else {
            rs[num] = true;
          }
          if (cols[j][num]) {
            bc[k] = true;
          } else {
            cols[j][num] = true;
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