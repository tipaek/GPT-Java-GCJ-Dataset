import java.util.*;
import java.io.*;

class Jump {
  StringBuilder route;
  int[] position;
  int level = 0;

  public Jump (int[] position) {
    route = new StringBuilder();
    this.position = position;
  }

  public Jump(int x, int y) {
    this(new int[] { x, y });
  }

  public Jump(int x, int y, int level, StringBuilder route) {
    this(x, y);
    this.level = level;
    this.route = route;
  }
}


public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    in.nextLine();
    testcase: for (int i = 1; i <= testCases; i++) {
      int[] coords = readCoordinates(in);

      Set<String> visited = new HashSet<>();
      Queue<Jump> queue = new LinkedList<>();
      queue.offer(new Jump(0, 0));

      while (!queue.isEmpty()) {
        Jump jump = queue.poll();

        int x = jump.position[0];
        int y = jump.position[1];

        int distance = (int) Math.pow(2, jump.level);

        visited.add(distance + "" + x + "" + y);

        if (x == coords[0] && y == coords[1]) {
          System.out.println(String.format("Case %d: %s", i, jump.route.toString()));
          continue testcase;
        }

        if (x - distance >= -100 && !hasVisited(visited, x - distance, y, distance)) {
          Jump njump = new Jump(x - distance, y, jump.level + 1, new StringBuilder(jump.route));
          njump.route.append("W");
          queue.offer(njump);
        }

        if (x + distance <= 100 && !hasVisited(visited, x + distance, y, distance)) {
          Jump njump = new Jump(x + distance, y, jump.level + 1, new StringBuilder(jump.route));
          njump.route.append("E");
          queue.offer(njump);
        }

        if (y - distance >= -100 && !hasVisited(visited, x, y - distance, distance)) {
          Jump njump = new Jump(x, y - distance, jump.level + 1, new StringBuilder(jump.route));
          njump.route.append("S");
          queue.offer(njump);
        }

        if (y + distance <= 100 && !hasVisited(visited, x, y + distance, distance)) {
          Jump njump = new Jump(x, y + distance, jump.level + 1, new StringBuilder(jump.route));
          njump.route.append("N");
          queue.offer(njump);
        }
      }

      System.out.println(String.format("Case %d: IMPOSSIBLE", i));
    }
  }

  private static int[] readCoordinates (Scanner in) {
    int[] coords = new int[2];

    String[] splits = in.nextLine().split(" ");
    coords[0] = Integer.parseInt(splits[0]);
    coords[1] = Integer.parseInt(splits[1]);

    return coords;
  }

  private static boolean hasVisited (Set<String> visited, int x, int y, int distance) {
    return visited.contains(distance + "" + x + "" + y);
  }
}
