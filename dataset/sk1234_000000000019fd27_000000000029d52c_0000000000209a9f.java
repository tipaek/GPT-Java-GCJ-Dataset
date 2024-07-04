import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String n = in.next();
      String ans = "";
      int a = 0;
      int b = 0; 
      int c = 0;
      int ln = n.length();
      for (int j = 0; j < ln; j++){
          b = Integer.parseInt(n.substring(0,1));
          n = n.substring(1);
          c = b - a;
          if (c > 0){
              for (int x = 0; x < c; x++){
                  ans += "(";
              }
          }
          if (c < 0){
              for (int x = 0; x > c; x--){
                  ans += ")";
              }
          }
          a = b;
          ans += b;
      }
      for (int x = 0; x < b; x++){
          ans += ")";
      }
      System.out.println("Case # " + i + " " + ans);
    }
  }
}