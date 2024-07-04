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
    boolean flipX = false;
    if (X < 0) {
      X = -X;
      flipX = true;
    }
    boolean flipY = false;
    if (Y < 0) {
      Y = -Y;
      flipY = true;
    }
    String ret = go(X, Y);
    if (ret == NOPE) return ret;
    if (flipX) ret = flipX(ret);
    if (flipY) ret = flipY(ret);
    return ret;
  }

  String NOPE = "IMPOSSIBLE";

  String go(long x, long y) {
 //   System.out.printf("At x = %d, y = %d%n", x, y);
    if (x == 0 && y == 0) return "";
    if ((x&1) == (y & 1)) return NOPE;
    if ((y & 1) == 1) {
    //  System.out.println("Flipping x and y");
      String ret = go(y, x);
      return ret == NOPE ? NOPE : flipXY(ret);
    }
    if (x == 1 && y == 0) return "E";

    String ret;
    if ((x&2) == (y&2)) {
   //   System.out.println("Going west");
      ret = "W" + go((x+1)>>1, y>>1);
    } else {
  //    System.out.println("Going east");
      ret = "E" + go((x-1)>>1, y>>1);
    }
    return ret;
  }

  String flipXY(String s) {
    String ret = "";
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'S') ret += 'W';
      if (c == 'N') ret += 'E';
      if (c == 'W') ret += 'S';
      if (c == 'E') ret += 'N';
    }
    return ret;
  }

  String flipX(String s) {
    String ret = "";
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'W') ret += 'E';
      else if (c == 'E') ret += 'W';
      else ret += c;
    }
    return ret;
  }

  String flipY(String s) {
    String ret = "";
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'S') ret += 'N';
      else if (c == 'N') ret += 'S';
      else ret += c;
    }
    return ret;
  }

}
