import java.io.*;
import java.util.*;

public class Solution {

  static class P {

    long x;
    long y;

    public P(long x, long y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      P p = (P) o;
      return x == p.x &&
          y == p.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  static class M {

    P p;
    Character d;

    public M(P p, Character d) {
      this.p = p;
      this.d = d;
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.println("Case #" + ks + ": " + expogo(input.nextInt(), input.nextInt()));
    }
  }

  private static String expogo(int x, int y) {
    if ((x + y) % 2 == 0) {
      return "IMPOSSIBLE";
    }
    P p = new P(x, y);

    Map<Integer, Map<P, M>> reverseMap = new HashMap<>();
    Map<P, M> mp = new HashMap<>();
    mp.put(new P(1, 0), new M(null, 'E'));
    mp.put(new P(-1, 0), new M(null, 'W'));
    mp.put(new P(0, 1), new M(null, 'N'));
    mp.put(new P(0, -1), new M(null, 'S'));
    reverseMap.put(1, mp);
    int v = 1;

    int i = 1;
    if (!mp.containsKey(p)) {
      while (i < 36) {
        v *= 2;
        mp = reverseMap.get(i);
        Map<P, M> newMp = new HashMap<>();
        reverseMap.put(i + 1, newMp);

        for (P point : mp.keySet()) {
          newMp.put(new P(point.x + v, point.y), new M(point, 'E'));
          newMp.put(new P(point.x - v, point.y), new M(point, 'W'));
          newMp.put(new P(point.x, point.y + v), new M(point, 'N'));
          newMp.put(new P(point.x, point.y - v), new M(point, 'S'));
        }
        i++;
        if (newMp.containsKey(p)) {
          break;
        }
      }
    }

    if (reverseMap.get(i).containsKey(p)) {
      StringBuilder str = new StringBuilder();
      while (i > 0) {
        str.append(reverseMap.get(i).get(p).d);
        p = reverseMap.get(i).get(p).p;
        i--;
      }
      return str.reverse().toString();
    } else {
      return "IMPOSSIBLE";
    }
  }
}