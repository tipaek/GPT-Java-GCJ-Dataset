import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int size = in.nextInt();
      int k = 0, r = 0, c = 0;
      boolean[][] columnCheck = new boolean[size + 1][size + 1];
      boolean[] isAreadySeenC = new boolean[size];
      for (int m = 0; m < size; m++) {
        boolean[] rowCheck = new boolean[size + 1];
        boolean isAlreaySeen = false;
        for (int n = 0; n < size; n++) {
          int element = in.nextInt();
          if (m == n) {
            k += element;
          }
          if (!rowCheck[element]) {
            rowCheck[element] = true;
          } else {
            if (!isAlreaySeen) {
              r += 1;
              isAlreaySeen = true;
            }
          }

          if (!columnCheck[element][n]) {
            columnCheck[element][n] = true;
          } else {
            if (!isAreadySeenC[n]) {
              isAreadySeenC[n] = true;
              c += 1;
            }
          }

        }
      }
      System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);

    }
  }

}
