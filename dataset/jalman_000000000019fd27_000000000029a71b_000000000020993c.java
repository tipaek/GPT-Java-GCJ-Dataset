import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int q = 1; q <= t; ++q) {
      int n = in.nextInt();
      int[][] m = new int[n][n];
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            m[i][j] = in.nextInt();
        }
      }
      
      int trace = 0;
      int rows = 0;
      int cols = 0;
      boolean rr  = false;
      boolean cc = false;
      
      for(int i = 0; i < n; i++) {
        boolean[] haver = new boolean[n];
        boolean[] havec = new boolean[n];
        Arrays.fill(haver,false);
        Arrays.fill(havec,false);
        rr=false;
        cc=false;
        for(int j = 0; j < n; j++) {
            if(haver[m[i][j]-1]) rr=true;
            if(havec[m[j][i]-1]) cc=true;
            haver[m[i][j]-1] = true;
            havec[m[j][i]-1] = true;
        }
        if(rr) rows++;
        if(cc) cols++;
        trace += m[i][i];
      }
      
      System.out.println("Case #" + q + ": " + trace + " " + rows + " " + cols);
      

    }
  }
}