import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

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
      Map<String, P> me = new HashMap<>();
      me.put("", new P(0,0));

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
        Map<String, P> me2 = new HashMap<>();
        for (Map.Entry<String, P> e : me.entrySet()) {
          P p = e.getValue();
          me2.put(e.getKey(), p);
          me2.put(e.getKey()+"N", new P(p.x,p.y+1));
          me2.put(e.getKey()+"S", new P(p.x,p.y-1));
          me2.put(e.getKey()+"E", new P(p.x+1,p.y));
          me2.put(e.getKey()+"W", new P(p.x-1,p.y));
        }
        me = me2;
        for (Map.Entry<String, P> e : me.entrySet()) {
          if (pos.equals(e.getValue())) {
            OUT.println("Case #" + t + ": " + i);
            found = true;
            break;
          }
        }
        if (found) {
          break;
        }
      }
      if (!found) OUT.println("Case #" + t + ": IMPOSSIBLE");
    }
  }
}