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
    int n = INT();
    Act[] acts = new Act[n];
    for(int i = 0; i < n; i++) {
      acts[i] = new Act(INT(), INT(), i);
    }
    Arrays.sort(acts);
    int cb = -1;
    int jb = -1;
    for(int i = 0; i < n; i++) {
      if (cb <= acts[i].s) {
        acts[i].who = 'C';
        cb = acts[i].e;
      } else if (jb <= acts[i].s) {
        acts[i].who = 'J';
        jb = acts[i].e;
      } else return "IMPOSSIBLE";
    }
    Arrays.sort(acts, Comparator.comparingInt(Act::getO));
    char[] ret = new char[n];
    for(int i = 0 ; i < n; i++) ret[i] = acts[i].who;
    return new String(ret);
  }

  class Act implements Comparable<Act> {
    int s, e, o;
    char who;
    Act(int ss, int ee, int oo) { s = ss; e = ee; o = oo;}
    public int compareTo(Act a) {
      return s - a.s;
    }
    int getO() { return o;}
  }
}
