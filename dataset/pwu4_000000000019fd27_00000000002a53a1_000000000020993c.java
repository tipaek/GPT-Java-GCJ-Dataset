import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    int res = 0;
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
      int n = in.nextInt();
      int[][] arr = new int[n][n];
      for(int j = 0; j < n; j++){
          for(int k = 0; k < n; k++){
              
              int line = in.nextInt();
              if(j==k){
                  res += line;
              }
            //   System.out.println(line);
          }
      }
      int r = 0;
      int c = 0;
      
      int m = in.nextInt();
      System.out.println("Case #" + n + ": " + res + r + " " + c);
    }
  }
}