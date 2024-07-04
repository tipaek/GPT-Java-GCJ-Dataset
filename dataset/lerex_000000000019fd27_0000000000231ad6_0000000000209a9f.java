import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String cur = in.next();
      StringBuffer result = new StringBuffer("");
      int val = 0;
      for(int k = 0;k<cur.length();k++){
          char a = cur.charAt(k);
          int temp = a-'0'-val;
          for(int l = temp;l>0;l--)
              result.append('(');
          for(int l = temp;l<0;l++)
              result.append(')');
          result.append(a);
          val = cur.charAt(k)-'0';
      }
      for(int l = val;l>0;l--)
              result.append(')');
      System.out.println("Case #" + i + ": " + result);
    }
  }
} 