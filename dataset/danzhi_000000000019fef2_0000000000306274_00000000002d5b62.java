
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

// 2020 CodeJam Round 1B Problem 1
public class Solution {
  // The complete absolute path from where application was initialized.
  // For example: C:\Users\danzhi\workspace\CodeJam
  final static String USER_DIR = System.getProperty("user.dir");
  final static String CNAME = MethodHandles.lookup().lookupClass().getName();
  final static Random RAND = new Random();

  static String join(Collection<?> objs) {
    StringBuilder sb = new StringBuilder();
    Iterator<?> it = objs.iterator();
    boolean first = true;
    while (it.hasNext()) {
      if (!first) sb.append(',');
      sb.append(it.next().toString());
      first = false;
    }
    return sb.toString();
  }

  static final TreeSet<Integer> POW2 = new TreeSet<>();
  static final TreeMap<Integer,Integer> RANKS = new TreeMap<>();
  static {
    for (int i = 0; i < 31; i++) {
      RANKS.put(1 << i, i);
      POW2.add(1 << i);
    }
  }

  final static String IMPOSSIBLE = "IMPOSSIBLE";

  static boolean select(boolean ok1, boolean ok2,
      StringBuilder sb1, StringBuilder sb2, StringBuilder sb) {
    if (ok1 && ok2) {
      String s1 = sb1.toString().trim();
      String s2 = sb2.toString().trim();
      sb.setLength(0);
      sb.append(s1.length() <= s2.length() ? sb1 : sb2);
      return true;
    } else if (ok1) {
      sb.setLength(0);
      sb.append(sb1);
      return true;
    } else if (ok2) {
      sb.setLength(0);
      sb.append(sb2);
      return true;
    } {
      return false;
    }
  }

  static boolean solve(int x, int y, StringBuilder sb) {
    // System.out.format("solve(%2d,%2d) pows:%s\n", x, y, sb.toString());
    if (x == 0 && y == 0) {
      // verify no gap
      int i = sb.length()-1;
      while (i >= 0 && sb.charAt(i) == ' ') {
        i--;
      }
      for (int j = 0; j < i; j++) {
        if (sb.charAt(j) == ' ') {
          return false;
        }
      }
      return true;
    }
    if (x > 0) {
      int f = POW2.floor(x);
      int c = POW2.ceiling(x);
      int rf = RANKS.get(f);
      int rc = RANKS.get(c);
      if (c == f) {
        if (sb.charAt(rc) != ' ') {
          return false;
        }
        sb.setCharAt(rc, 'E');
        boolean ok = solve(0, y, sb);
        if (!ok) {
          sb.setCharAt(rc, ' ');
        }
        return ok;
      } else {
        boolean ok1 = false;
        StringBuilder s1 = null;
        if (sb.charAt(rc) == ' ') {
          s1 = new StringBuilder(sb);
          s1.setCharAt(rc, 'E');
          ok1 = solve(x-c, y, s1);
        }
        boolean ok2 = false;
        StringBuilder s2 = null;
        if (sb.charAt(rf) == ' ') {
          s2 = new StringBuilder(sb);
          s2.setCharAt(rf, 'E');
          ok2 = solve(x-f, y, s2);
        }
        return select(ok1, ok2, s1, s2, sb);
      }
    } else if (x < 0) {
      int f = POW2.floor(-x);
      int c = POW2.ceiling(-x);
      int rf = RANKS.get(f);
      int rc = RANKS.get(c);
      if (c == f) {
        if (sb.charAt(rc) != ' ') {
          return false;
        }
        sb.setCharAt(rc, 'W');
        boolean ok = solve(0, y, sb);
        if (!ok) {
          sb.setCharAt(rc, ' ');
        }
        return ok;
      } else {
        boolean ok1 = false;
        StringBuilder s1 = null;
        if (sb.charAt(rc) == ' ') {
          s1 = new StringBuilder(sb);
          s1.setCharAt(rc, 'W');
          ok1 = solve(x+c, y, s1);
        }
        boolean ok2 = false;
        StringBuilder s2 = null;
        if (sb.charAt(rf) == ' ') {
          s2 = new StringBuilder(sb);
          s2.setCharAt(rf, 'W');
          ok2 = solve(x+f, y, s2);
        }
        return select(ok1, ok2, s1, s2, sb);
      }
    } else if (y > 0) {
      int f = POW2.floor(y);
      int c = POW2.ceiling(y);
      int rf = RANKS.get(f);
      int rc = RANKS.get(c);
      if (c == f) {
        if (sb.charAt(rc) != ' ') {
          return false;
        }
        sb.setCharAt(rc, 'N');
        boolean ok = solve(x, 0, sb);
        if (!ok) {
          sb.setCharAt(rc, ' ');
        }
        return ok;
      } else {
        boolean ok1 = false;
        StringBuilder s1 = null;
        if (sb.charAt(rc) == ' ') {
          s1 = new StringBuilder(sb);
          s1.setCharAt(rc, 'N');
          ok1 = solve(0, y-c, s1);
        }
        boolean ok2 = false;
        StringBuilder s2 = null;
        if (sb.charAt(rf) == ' ') {
          s2 = new StringBuilder(sb);
          s2.setCharAt(rf, 'N');
          ok2 = solve(0, y-f, s2);
        }
        return select(ok1, ok2, s1, s2, sb);
      }
    } else if (y < 0) {
      int f = POW2.floor(-y);
      int c = POW2.ceiling(-y);
      int rf = RANKS.get(f);
      int rc = RANKS.get(c);
      if (c == f) {
        if (sb.charAt(rc) != ' ') {
          return false;
        }
        sb.setCharAt(rc, 'S');
        boolean ok = solve(x, 0, sb);
        if (!ok) {
          sb.setCharAt(rc, ' ');
        }
        return ok;
      } else {
        boolean ok1 = false;
        StringBuilder s1 = null;
        if (sb.charAt(rc) == ' ') {
          s1 = new StringBuilder(sb);
          s1.setCharAt(rc, 'S');
          ok1 = solve(0, y+c, s1);
        }
        boolean ok2 = false;
        StringBuilder s2 = null;
        if (sb.charAt(rf) == ' ') {
          s2 = new StringBuilder(sb);
          s2.setCharAt(rf, 'S');
          ok2 = solve(0, y+f, s2);
        }
        return select(ok1, ok2, s1, s2, sb);
      }
    }
    return false;
  }

  static String solveMe(int x, int y) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      sb.append(' ');
    }
    boolean ok = solve(x, y, sb);
    return ok ? sb.toString().trim() : IMPOSSIBLE;
  }

  public static void main(String[] args) throws FileNotFoundException {
    File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
    Scanner in = fin.exists()? new Scanner(fin) : new Scanner(System.in);
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      int X = in.nextInt();
      int Y = in.nextInt();

      System.out.format("Case #%d: %s\n", t, solveMe(X, Y));
    }
    in.close();
  }
}
