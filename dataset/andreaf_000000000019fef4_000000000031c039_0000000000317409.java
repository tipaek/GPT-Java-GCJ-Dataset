import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      for (int test = 0; test < numberOfTestCase; test++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String move = sc.next();
        GridPoint pepperPosition = GridPoint.create(x, y);
        GridPoint root = GridPoint.create(0, 0);

        int meetingPoint = getMeetingPoint(move, pepperPosition, root);
        if (meetingPoint == -1) {
          System.out.println(String.format("Case #%d: %s", (test + 1), "IMPOSSIBLE"));
        } else {
          System.out.println(String.format("Case #%d: %s", (test + 1), meetingPoint));
        }
      }
    }
  }

  private static int getMeetingPoint(String move, GridPoint pepperPosition, GridPoint root) {
    int tourLength = move.length();
    for (int i = 1; i <= tourLength; i++) {
      GridPoint position = getPosition(pepperPosition, move.substring(0, i));
      int distance = Math.max(i, distance(root, position));
      if (distance <= tourLength && i >= distance) {
        return distance;
      }
    }
    return -1;
  }

  private static int distance(GridPoint p, GridPoint o) {
    return Math.abs(p.getX() - o.getX()) + Math.abs(p.getY() - o.getY());
  }

  private static GridPoint getPosition(GridPoint start, String path) {
    GridPoint result = GridPoint.create(start.getX(), start.getY());
    for (char c : path.toCharArray()) {
      result.navigateTo(c);
    }
    return result;
  }

  private static class GridPoint {
    private int x;
    private int y;

    private GridPoint(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public static GridPoint create(int x, int y) {
      return new GridPoint(x, y);
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public void navigateTo(char c) {
      switch (c) {
        case 'N':
          y++;
          break;
        case 'S':
          y--;
          break;
        case 'W':
          x--;
          break;
        case 'E':
          x++;
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
  }

}
