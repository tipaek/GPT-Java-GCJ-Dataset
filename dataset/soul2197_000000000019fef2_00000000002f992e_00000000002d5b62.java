import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final int X = scanner.nextInt();
      final int Y = scanner.nextInt();

      final String path = findPath("", 1, X, Y);


      System.out.println(String.format("Case #%d: %s", t, path != null ? path : "IMPOSSIBLE"));
    }
  }

  static String findPath(String path, int start, int x, int y) {
    if (x == 0 && y == 0) {
      return path;
    }

    if (start > 1000000000) {
      return null;
    }

    final boolean moveX = ((x & start) != 0);
    final boolean moveY = ((y & start) != 0);
    if (!(moveX ^ moveY)) {
      return null;
    }

    if (moveX) {
      if (y == 0 && Math.abs(x) == start) {
        if (x == start) {
          return path + "E";
        } else {
          return path + "W";
        }
      }

      final String moveLeft = findPath(path + "E", start * 2, x - start, y);
      final String moveRight = findPath(path + "W", start * 2, x + start, y);
      if (moveLeft != null && moveRight != null && moveLeft.length() <= moveRight.length()) {
        return moveLeft;
      } else if (moveRight == null) {
        return moveLeft;
      } else {
        return moveRight;
      }
    } else {
      if (x == 0 && Math.abs(y) == start) {
        if (y == start) {
          return path + "N";
        } else {
          return path + "S";
        }
      }

      final String moveUp = findPath(path + "N", start * 2, x, y - start);
      final String moveDown = findPath(path + "S", start * 2, x, y + start);
      if (moveUp != null && moveDown != null && moveUp.length() <= moveDown.length()) {
        return moveUp;
      } else if (moveDown == null) {
        return moveUp;
      } else {
        return moveDown;
      }
    }
  }
}
