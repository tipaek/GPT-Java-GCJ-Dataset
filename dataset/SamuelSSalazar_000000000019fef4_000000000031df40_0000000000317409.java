import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());
    for (int c = 1; c <= t; ++c) {
      String[] parts = in.nextLine().split(" ");
      int x = Integer.parseInt(parts[0]);
      int y = Integer.parseInt(parts[1]);
      String path = parts[2];
      class Coordinate implements Comparable<Coordinate> {

        int x, y, t;

        Coordinate(int x, int y, int t) {
          this.x = x;
          this.y = y;
          this.t = t;
        }

        List<Coordinate> adj() {
          return Arrays.asList(new Coordinate(x + 1, y, t + 1),
                               new Coordinate(x - 1, y, t + 1),
                               new Coordinate(x, y + 1, t + 1),
                               new Coordinate(x, y - 1, t + 1));
        }

        @Override
        public int compareTo(Coordinate o) {
          return o.x == this.x && o.y == this.y ? 0 : 1;
        }

        @Override
        public String toString() {
          return x + "," + y;
        }
      }
      Map<String, Integer> G = new HashMap<>();
      Queue<Coordinate> Q = new LinkedList<>();
      Q.add(new Coordinate(0, 0, 0));
      Coordinate cat = new Coordinate(x, y, 0);
      Map<String, Integer> catPath = new HashMap<>();
      catPath.put(cat.toString(), 0);
      for (int i = 0; i < path.length(); i++) {
        switch (path.charAt(i)) {
          case 'N':
            cat = new Coordinate(cat.x, cat.y + 1, cat.t + 1);
            break;
          case 'S':
            cat = new Coordinate(cat.x, cat.y - 1, cat.t + 1);
            break;
          case 'E':
            cat = new Coordinate(cat.x + 1, cat.y, cat.t + 1);
            break;
          case 'W':
            cat = new Coordinate(cat.x - 1, cat.y, cat.t + 1);
            break;
        }
        catPath.put(cat.toString(), cat.t);
      }
      int minutes = path.length() + 1;
      while (!Q.isEmpty()) {
        Coordinate curr = Q.poll();
        G.put(curr.toString(), curr.t);
        if (catPath.containsKey(curr.toString())) {
          int catT = catPath.get(curr.toString());
          if (catT >= curr.t) {
            if(catT < minutes)
            {
              minutes = catT;
            }
          }
        }
        for (Coordinate next : curr.adj()) {
          if (!G.containsKey(next) && next.t <= path.length()) {
            Q.add(next);
          }
        }
      }

      System.out.println(
          String.format("Case #%d: %s", c, minutes > path.length() ? "IMPOSSIBLE" : minutes));
    }
  }

}