import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {  
        int n = in.nextInt();
        int input[][] = new int[n][n];
        for (int p =0; p < n; p++) {
            for (int q =0; q < n; q++) {
                input[p][q] = in.nextInt();
            }
        }
        int[] res = findTraceAndIfLatin(input, n);
        System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
    }
  }
  
  public static int[] findTraceAndIfLatin(int[][] input, int n) {
      int[] res = new int[3];
      res[0] = findTrace(input, n);
      
      for (int i = 0; i < n; i++) {
          boolean[] seen = new boolean[n+1];
          for (int j = 0; j < n; j++) {
              if (seen[input[i][j]]) {
                  res[1]++;
                  break;
              }
              seen[input[i][j]] = true;
          }
          seen = new boolean[n+1];
          for (int j = 0; j < n; j++) {
              if (seen[input[j][i]]) {
                  res[2]++;
                  break;
              }
              seen[input[j][i]] = true;
          }
      }
      return res;
  }
  
  public static int findTrace(int[][] input, int n) {
      int trace = 0;
      for (int i=0; i < n; i++) {
          trace += input[i][i];
      }
      return trace;
  }
  
}