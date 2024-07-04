
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  /**
   * Algo
   * <p>
   * Players(char) Set<Char> available = {C, J} in the beginning Point (pos, st, player) void
   * setPlayerVal(char ) sets the value of player Interval endpoints share the same player instance
   * <p>
   * Iterate over points in order of pos end points come before start for same pos If processing
   * start point pick available from `available' set it as player remove picked item from available
   * if nothing available print impossible end if processing end point return player val to
   * available
   */

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Set<Character> available = new HashSet<>();
      available.add('C');
      available.add('J');

      ArrayList<Point> points = new ArrayList<>(n);
      StringBuilder sb = new StringBuilder(n);
      for (int j = 0; j < n; j++) {
        sb.append('C');
      }
      boolean imp = false;
      // Input
      for (int j = 0; j < n; j++) {
        int start = in.nextInt();
        Player p = new Player();
        points.add(new Point(start, true, p, j));
        int end = in.nextInt();
        points.add(new Point(end, false, p, j));
      }
      points.sort(new PointC());

      for (int j = 0; j < points.size(); j++) {
        Point point = points.get(j);
        if (point.isStart()) {
          if (available.isEmpty()) {
            imp = true;
            break;
          } else {
            Iterator<Character> iterator = available.iterator();
            Character a = iterator.next();
            point.player.c = a;
            iterator.remove();
            sb.setCharAt(point.index, a);
          }
        } else {
          available.add(point.player.c);
        }
      }
      if (imp) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
        System.out.println("Case #" + i + ": " + sb);
      }
    }
  }


  static class Player {

    char c;
  }

  static class Point {

    private final int pos;
    private final int type; // 0 = end and 1 = st
    private final Player player;
    private final int index;


    Point(int pos, boolean st, Player player, int index) {
      this.pos = pos;
      this.type = st ? 1 : 0;
      this.player = player;
      this.index = index;
    }

    boolean isStart() {
      return type == 1;
    }
  }

  static class PointC implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
      if (o1.pos == o2.pos) {
        return Integer.compare(o1.type, o2.type);
      }
      return Integer.compare(o1.pos, o2.pos);
    }
  }

}
