import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {

      int n = in.nextInt();
      int[][] arr = new int[n][n];
      int noOfRepRows = 0;
      boolean isNumRepeated = false;
      int noOfRepColumns = 0;
      HashSet<Integer> uSet = new HashSet<>(n);
      int trace = 0;

      for(int j = 0; j < n; j++) {
        uSet.clear();
        isNumRepeated = false;
        for(int k = 0; k < n; k++) {
          int m = in.nextInt();
          arr[j][k] = m;
          if(!isNumRepeated && uSet.contains(m)) {
            isNumRepeated = true;
            noOfRepRows++;
          }
         uSet.add(m);
        }
      }

      for(int j = 0; j < n; j++) {
        uSet.clear();
        isNumRepeated = false;
        for(int k = 0; k < n; k++) {
          int m = arr[k][j];
          if(!isNumRepeated && uSet.contains(m)) {
            isNumRepeated = true;
            noOfRepColumns++;
          }
        uSet.add(m);


          if(k == j) {
            trace = trace + m;
          }
        }
      }
      System.out.println("Case #" + i + ": " + trace + " " + noOfRepRows + " " + noOfRepColumns);
    }
  }
}
