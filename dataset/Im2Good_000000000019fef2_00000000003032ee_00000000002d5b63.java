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
      new Solution().entry();
    }
  }

  void entry() {
    INT();
    INT();
    for(int x = -10; x <= 10; x++) {
      for(int y = -10; y <= 10; y++) {
        System.out.printf("%d %d%n", x, y);
        if (STR().equals("CENTER")) return;
      }
    }
  }

}
