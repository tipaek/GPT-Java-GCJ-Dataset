import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner((System.in))) {
      int t = in.nextInt();
      in.nextLine();
      for (int k = 1; k <= t; ++k) {
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(String.format("Case #%d: %s", k, getDirectionsTo(x, y)));
      }
    }
  }

  static String getDirectionsTo(int x, int y) {
    if (x == 0 && y == 0) {
      return "";
    }
    Cell initial = new Cell(0, 0);
    LinkedList<Cell> paths = new LinkedList<>();
    paths.add(initial);
    while (!paths.isEmpty()) {
      Cell path = paths.pollLast();

      for (Direction d : Direction.values()) {
        int i = path.getI() + path.getStep() * d.getI();
        int j = path.getJ() + path.getStep() * d.getJ();
        if (i == x && j == y) {
          return path.getPath() + d.getDescription();
        } else {
          if (path.getStep() < (1 << 10)) {
            paths.add(new Cell(i, j, path.getPath() + d.getDescription(), 2 * path.getStep()));
          }
        }
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
    int step;

    public Cell(int i, int j) {
      this(i, j, "", 1);
    }

    public Cell(int i, int j, String path, int step) {
      this.i = i;
      this.j = j;
      this.path = path;
      this.step = step;
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

    public int getStep() {
      return step;
    }

    @Override
    public String toString() {
      return "Cell{" +
          "i=" + i +
          ", j=" + j +
          ", path='" + path + '\'' +
          ", step=" + step +
          '}';
    }
  }
}
