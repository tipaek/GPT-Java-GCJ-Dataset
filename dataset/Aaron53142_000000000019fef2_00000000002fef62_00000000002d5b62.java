import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class Solution {

  static class Point {
    int x, y;

    String path = "";

    Point(int ix, int iy) {
      x = ix;
      y = iy;
    }

    @Override public boolean equals(Object obj) {
      if (obj == this) { return true; }
      if (obj == null || obj.getClass() != this.getClass()) { return false; }
      Point p = (Point) obj;
      return x == p.x && y == p.y;
    }

    @Override public int hashCode() {
      final int prime = 9311;
      int result = 1;
      result = prime * x + prime * y;
      return result;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      String res = solveIt(new Point(x, y));
      System.out.println("Case #" + i + ": " + res);
    }
  }

    static String solveIt(Point target) {

      int[] delX = {1, 0, 0, -1};
      int[] delY = {0, 1, -1, 0};
      String[] dir = {"E", "N", "S", "W"};
      Queue<Point> q = new LinkedList<>();
      Point s = new Point(0, 0);
      q.offer(s);
      Set<Point> visited = new HashSet<>();
      visited.add(s);
      int indexL = 0;

      while(!q.isEmpty()) {
        int size = q.size();

        if(overSize(target, indexL)) { break; }

        for(int i = 0; i < size; i++) {
          Point cur = q.poll();

          for(int j = 0; j < 4; j++) {
            int nextX = cur.x + delX[j] * ((int) Math.pow(2, indexL));
            int nextY = cur.y + delY[j] * ((int) Math.pow(2, indexL));

            if(nextX == target.x && nextY == target.y) {
              return cur.path + dir[j];
            }

            Point next = new Point(nextX, nextY);
            if(visited.contains(next)) { continue; }

            next.path = cur.path + dir[j];
            q.offer(next);
            visited.add(next);
          }
        }
        indexL++;
      }

      return "IMPOSSIBLE";
    }

  static boolean overSize(Point t, int l) {
    int totalSize = (Math.abs(t.x) + Math.abs(t.y)) * 20;
    return totalSize < (int) Math.pow(2, l);
  }
}