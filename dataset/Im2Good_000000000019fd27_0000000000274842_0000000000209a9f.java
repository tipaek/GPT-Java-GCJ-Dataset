import java.io.*;
import java.util.*;
import static java.util.Arrays.*;

public class Solution {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st = new StringTokenizer("");

  static void FILL() { try { while(!st.hasMoreTokens()) st = new StringTokenizer(in.readLine()); } catch (Exception e) { throw new AssertionError(e); }}
  static int INT() { FILL(); return Integer.parseInt(st.nextToken()); }
  static String STR() { FILL(); return st.nextToken(); }

  public static void main(String... args) throws Exception {
    int T = INT();
    for (int i = 0; i < T; i++) {
      System.out.printf("Case #%d: %s%n", i+1, new Solution().entry());
    }
  }

  String entry() {
    String input = STR();
    StringBuilder ret = new StringBuilder();
    int at = 0;
    for (int i = 0; i < input.length(); i++) {
      int d = input.charAt(i)-'0';
      while (at < d) {
        ret.append('(');
        at++;
      }
      while(at > d) {
        ret.append(')');
        at--;
      }
      ret.append((char)(d+'0'));
    }
    while(at > 0) {
      ret.append(')');
      at--;
    }
    return ret.toString();
  }
}
