import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int q = 1; q <= t; ++q) {
      String s = in.next();
      
      String ret = "";
      int d = 0;
      for(int i = 0; i < s.length(); i++) {
          int k = (int)s.charAt(i) - (int)'0';
          while( k != d) {
              if(d<k) {
                  ret = ret+"(";
                  d++;
              } else {
                  ret = ret + ")";
                  d--;
              }
          }
          ret = ret + k;
      }
      for(int j = 0; j < d; j++) ret = ret + ")";
      
      System.out.println("Case #" + q + ": " + ret);
      

    }
  }
}