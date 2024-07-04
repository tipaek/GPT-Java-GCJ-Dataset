import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; i++) {
      String s = in.nextLine();
      String s2 = "";
      for (int j = 0; j < s.length(); j++) {
         int temp = Integer.parseInt(s.charAt(j) + "");
         s2 += parens(temp);
      }
      while (s2.contains(")("))
         s2 = s2.replace(")(", "");
      System.out.println("Case #" + i + ": " + s2);
    }
  }
  
  public static String parens(int n) {
      String t = "";
      for (int i = 0; i < n; i++)
         t = "(" + t;
      t += n + "";
      for (int i = 0; i < n; i++)
         t = t + ")";
      return t;
  }
  
}