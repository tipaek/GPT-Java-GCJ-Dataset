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

  public Jump(int x, int y, int level, String route) {
    this(x, y);
    this.level = level;
    this.route = new StringBuilder(route);
  }
}


public class Solution {
  private static int[] horizontal = { 1, 0, -1, 0 };
  private static int[] vertical = { 0, 1, 0, -1 };
  private static char[] directions = { 'E', 'N', 'W', 'S' };

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    in.nextLine();
    testcase: for (int i = 1; i <= testCases; i++) {
      int[] coords = readCoordinates(in);

      int maxJumps = Math.max(Math.abs(coords[0]), Math.abs(coords[1]));

      Set<String> visited = new HashSet<>();
      Queue<Jump> queue = new LinkedList<>();
      queue.offer(new Jump(0, 0));

      while (!queue.isEmpty()) {
        Jump jump = queue.poll();

        int x = jump.position[0];
        int y = jump.position[1];

        if (x == coords[0] && y == coords[1]) {
          System.out.println(String.format("Case %d: %s", i, jump.route.toString()));
          continue testcase;
        }

        int distance = (int) Math.pow(2, jump.level);

        visited.add(distance + "" + x + "" + y);

        if (jump.level <= maxJumps) {
          for (int j = 0; j < 4; j++) {
            int nx = x + horizontal[j] * distance;
            int ny = y + vertical[j] * distance;

            if (!hasVisited(visited, nx, ny, distance)) {
              Jump njump = new Jump(nx, ny, jump.level + 1, jump.route.toString());
              njump.route.append(directions[j]);
              queue.offer(njump);
            }
          }
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

  private static boolean isDiagonal(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p1[1]) == Math.abs(p2[0] - p2[1]);
  }
}
