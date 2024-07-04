import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner((System.in))) {
      int t = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(String.format("Case #%d: %s", i, getDirectionsTo(x, y)));
      }
    }
  }

  static String getDirectionsTo(int x, int y) {
    if (x == 0 && y == 0) {
      return "";
    }
    Cell initial = new Cell(0, 0);
    LinkedList<Cell> paths = new LinkedList<>();
    LinkedList<Cell> t = new LinkedList<>();
    paths.add(initial);
    int step = 1;
    while (!paths.isEmpty()) {
      Cell path = paths.pollFirst();
      if (Math.abs(path.getI() - x) + Math.abs(path.getJ() - y) < step) {
        continue;
      }
      for (Direction d : Direction.values()) {
        int i = path.getI() + step * d.getI();
        int j = path.getJ() + step * d.getJ();
        if (i == x && j == y) {
          return path.getPath() + d.getDescription();
        } else {
          t.add(new Cell(i, j, path.getPath() + d.getDescription()));
        }
      }

      if (paths.isEmpty()) {
        step = 2 * step;
        paths.addAll(t);
        t.clear();
      }
    }
    return "IMPOSSIBLE";
  }

  enum Direction {
    SOUTH("S", 0, -1),
    NORTH("N", 0, 1),
    EAST("E", 1, 0),
    WEST("W", -1, 0);

    String description;
    int i;
    int j;

    Direction(String description, int i, int j) {
      this.description = description;
      this.i = i;
      this.j = j;
    }

    public String getDescription() {
      return description;
    }

    public int getI() {
      return i;
    }

    public int getJ() {
      return j;
    }
  }

  static class Cell {
    int i;
    int j;
    String path;

    public Cell(int i, int j) {
      this(i, j, "");
    }

    public Cell(int i, int j, String path) {
      this.i = i;
      this.j = j;
      this.path = path;
    }

    public int getI() {
      return i;
    }

    public int getJ() {
      return j;
    }

    public String getPath() {
      return path;
    }
  }
}
