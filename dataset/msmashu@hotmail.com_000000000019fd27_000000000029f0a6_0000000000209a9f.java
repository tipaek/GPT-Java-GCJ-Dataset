import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String line = in.next();
      int prev = 0;
      int cur = 0;
      String res = "";
      for(int j=0; j<line.length(); j++) {
        cur = Integer.parseInt("" + line.charAt(j));
        int diff = cur - prev;
        if(diff>0) {
            for(int k=0; k<diff; k++) {
                res += "(";
            }
        } else if (diff<0) {
            for(int k=0; k<-diff; k++) {
                res += ")";
            }
        }
        res += cur;
        prev = cur;
      } 
      for(int k=0; k<cur; k++) {
         res += ")";
      }
      System.out.println("Case #" + i + ": " + res);
    }
  }
}