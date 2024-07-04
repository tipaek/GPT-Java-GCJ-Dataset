import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      for (int i = 0; i < numberOfTestCase; i++) {
        boolean find = false;
        for (int r = -9; r < 8; r++) {
          for (int c = -9; c < 8; c++) {
            printCord(find, new Points(r, c));
            String response = sc.nextLine();
            if ("CENTER".equals(response)) {
              find = true;
              break;
            } else if ("HIT".equals(response)) {
            } else if ("MISS".equals(response)) {
            } else if ("WRONG".equals(response)) {
              System.exit(1);
            }
          }
          if (find) {
            break;
          }
        }
      }
    }
  }

  private static void printCord(boolean find, Points p) {
    if (!find) {
      System.out.println(String.format("%d %d", p.getX(), p.getY()));
    }
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