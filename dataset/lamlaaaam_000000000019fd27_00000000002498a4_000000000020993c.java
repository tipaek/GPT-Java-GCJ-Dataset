import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int e = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= e; ++i) {
      int n = in.nextInt();
      int target = n * (n + 1) / 2;
      int wr = 0;
      int wc = 0;
      int t = 0;
      int[] dup = new int[n + 1];
      int[][] col = new int[n][n + 1];
      boolean[] added = new boolean[n];
      for (int p = 0; p < n; ++p) {
        Arrays.fill(dup, 0);
        boolean notAdded = true;
        for (int k = 0; k < n; ++k) {
          int q = in.nextInt();
          if (p == k) t += q;
          if (dup[q] != 0 && notAdded) {
            ++wr;
            notAdded = false;
          }
          ++dup[q];
          if (col[k][q] != 0 && !added[k]) {
            ++wc;
            added[k] = true;
          }
          ++col[k][q];
        }
      }
      System.out.println("Case #" + i + ": " + t + " " + wr + " " + wc);
    }
  }
}