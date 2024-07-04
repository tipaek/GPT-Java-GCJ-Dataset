import java.util.*;
import java.io.*;
public class Solution {
  static String[] open = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
  static String[] close = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int iTest = 1; iTest <= t; ++iTest) {
      String s = in.nextLine().trim();
      StringBuilder result = new StringBuilder();
      char cur = s.charAt(0);
      result.append(open[cur-'0']);
      result.append(cur);
      for (int i=1; i<s.length(); i++) {
        char prev = s.charAt(i-1);
        cur = s.charAt(i);
        if (cur>prev) {
          result.append(open[cur-prev]);
        } else if (cur<prev) {
          result.append(close[prev-cur]);
        }
        result.append(cur);
      }
      cur = s.charAt(s.length()-1);
      result.append(close[cur-'0']);
      System.out.println("Case #" + iTest + ": " + result);
    }
  }
}