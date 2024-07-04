import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      for (int j = 1; j<=n*n; j++) {
          int k = 0;
          if(j%(n+1)=1){
              k+=j;
          }
      }
      System.out.println("Case #" + i + ": " + k + " " + "hoge");
    }
  }
}
