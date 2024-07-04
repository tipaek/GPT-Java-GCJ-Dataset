import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        String digits = in.next();
        process(i, digits);
    }
  }
  
  private static void process(int kase, String s) {
      StringBuilder sb = new StringBuilder();
      int last = 0, cur = 0, diff;
      for(char c : s.toCharArray()) {
          cur = Character.getNumericValue(c);
          diff = last - cur;
          if(diff < 0) {
              addParans(sb, Math.abs(diff), '(');
          } else if(diff > 0) {
              addParans(sb, Math.abs(diff), ')');
          }
          sb.append(c);
          last = cur;
      }
      addParans(sb, cur, ')');
      System.out.printf("Case #%d: %s\n", kase, sb.toString());
  }
  
  private static void addParans(StringBuilder sb, int n, char b) {
      for(int i = 0; i < n; i++) sb.append(b);
  }
}