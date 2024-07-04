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
    long X = INT();
    long Y = INT();
    long high = Math.max(Long.highestOneBit(Math.abs(X)), Long.highestOneBit(Math.abs(Y))) << 1;
    return go(X, Y, high);
  }

  char[] dir = {'S', 'N', 'E', 'W'};
  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};
  String NOPE = "IMPOSSIBLE";

  String go(long x, long y, long m) {
    if (m == 0) return (x == 0 && y == 0) ? "" : NOPE;
    for(int i = 0; i < 4; i++) {
      String res = go(x+dx[i]*m, y+dy[i]*m, m>>1);
      if (res != NOPE) return res + dir[i];
    }
    return NOPE;
  }
}
