import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= tc; ++t) {
      int n = in.nextInt();
      int[][] arr = new int[n][n]; // boot it up

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          arr[i][j] = in.nextInt();
        }
      }
      int[] rDict, cDict; // duplicator check
      int r = 0;
      boolean rFound = false, cFound = false;
      int c = 0;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        rDict = new int[n + 1]; // clean it up
        cDict = new int[n + 1]; // clean it up
        for (int j = 0; j < n; j++) {
          if (i == j) sum += arr[i][j];

          if (rDict[arr[i][j]] > 0) rFound = true;
          rDict[arr[i][j]]++; // increment row

          if (cDict[arr[j][i]] > 0) cFound = true;
          cDict[arr[j][i]]++;
        }
        if (rFound) r++;
        if (cFound) c++;
      }
      System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);
    }
  }
}