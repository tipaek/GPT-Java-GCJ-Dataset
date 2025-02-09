import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

  private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUT = System.out;

  static class P {
    int x,y;
    public P(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      P p = (P) o;
      return x == p.x &&
          y == p.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "P{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }

  public static void main(String[] args) {
    int T = IN.nextInt();
    for (int t = 1; t <= T; t++) {
      int x = IN.nextInt();
      int y = IN.nextInt();
      String path = IN.next();
      int n = path.length();
      boolean found = false;

      P pos = new P(x,y);
      Set<P> me = new HashSet<>();
      me.add(new P(0,0));

      for (int i = 1; i <= n; i++) {
        switch (path.charAt(i-1)) {
          case 'N':
            pos = new P(pos.x,pos.y+1);
            break;
          case 'S':
            pos = new P(pos.x,pos.y-1);
            break;
          case 'E':
            pos = new P(pos.x-1,pos.y);
            break;
          case 'W':
            pos = new P(pos.x+1,pos.y);
            break;
        }
        Set<P> me2 = new HashSet<>();
        for (P p : me) {
          me2.add(p);
          me2.add(new P(p.x,p.y+1));
          me2.add(new P(p.x,p.y-1));
          me2.add(new P(p.x+1,p.y));
          me2.add(new P(p.x-1,p.y));
        }
        for (P p : me2) {
          if (pos.equals(p)) {
            OUT.println("Case #" + t + ": " + i);
            found = true;
            break;
          }
        }
        if (found) {
          break;
        }
        me = me2;
      }
      if (!found) OUT.println("Case #" + t + ": IMPOSSIBLE");
    }
  }
}