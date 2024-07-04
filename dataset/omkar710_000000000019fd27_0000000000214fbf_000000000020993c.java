import java.util.*;
import java.io.*;


public class Solution {

  public static void main(String[] args) {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt(); // size of matrix

      int[][] m = new int[n][n];

      for(int j = 0; j < n; j++) {
        for(int k = 0; k < n; k++) {
          m[j][k] = in.nextInt();
        }
      }

      int d = 0;
      int trace = 0;

      // Calculating trace
      while(d < n) {
        trace += m[d][d];
        d+=1;
      }

      int r_count = 0;
      int c_count = 0;

      for(int j = 0; j < n; j++) {
        HashSet<Integer> row_set = new HashSet<>();
        for(int k = 0; k < n; k++) {
          if(row_set.contains(m[j][k])) {
            r_count +=1;
            break;
          }
          row_set.add(m[j][k]);
        }
      }

      for(int j = 0; j < n; j++) {
        HashSet<Integer> col_set = new HashSet<>();
        for(int k = 0; k < n; k++) {
          if(col_set.contains(m[k][j])) {
            c_count +=1;
            break;
          }
          col_set.add(m[k][j]);
        }
      }

      System.out.printf("Case #%d: ", i+1);
      System.out.println(trace + " " + r_count + " " + c_count);

    }
  }
}