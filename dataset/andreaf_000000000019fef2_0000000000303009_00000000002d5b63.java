import java.io.*;
import java.util.*;

public class Solution {

  private static final int X_CORD[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
  private static final int Y_CORD[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      int minRadius = sc.nextInt();
      int maxRadius = sc.nextInt();
      for (int i = 0; i < numberOfTestCase; i++) {
        int maxDistance = maxRadius;
        Points external;
        Points internal;
        Points attempt;
        for (int r = -8; r < 8; r++) {
          for (int c = -8; c < 8; c++) {
            attempt = new Points(r, c);
            printCord(attempt);
            String response = sc.nextLine();
            if ("CENTER".equals(response)) {
              break;
            } else if ("HIT".equals(response)) {
              internal = new Points(attempt.getX(), attempt.getY());
            } else if ("MISS".equals(response)) {
              external = new Points(attempt.getX(), attempt.getY());
            } else if ("WRONG".equals(response)) {
              System.exit(1);
            }
          }
        }
      }
    }
  }


  private static Points toWallCoordinates(int x, int y) {
    return new Points(x + 1_000_000_000, y + 1_000_000_000);
  }

  private static void printCord(Points p) {
    System.out.println(String.format("%d %d", p.getX(), p.getY()));
  }

  private static class Points {
    private final int x;
    private final int y;

    private Points(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Points points = (Points) o;
      return x == points.x &&
          y == points.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}