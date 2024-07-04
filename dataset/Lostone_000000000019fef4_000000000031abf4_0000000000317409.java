
import java.util.Scanner;

public class Solution {
  static final int MOD = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < T; i++) {
      String[] str = sc.nextLine().split(" ");
      int X = Integer.parseInt(str[0]);
      int Y = Integer.parseInt(str[1]);
      String path = str[2];
      System.out.println("Case #" + (i + 1) + ": " + solve(X, Y, path));
    }
    sc.close();
  }

  private static String solve(int x, int y, String path) {
    for (int i = 0; i < path.length(); i++) {
      int[] xy = newCordinate(path.charAt(i), x, y);
      x = xy[0];
      y = xy[1];
      if (canBeReached(xy, i + 1)) {
        return String.valueOf(i + 1);
      }
    }
    return "IMPOSSIBLE";
  }

  private static boolean canBeReached(int[] xy, int i) {
    return Math.abs(xy[0]) + Math.abs(xy[1]) <= i;
  }

  private static int[] newCordinate(char charAt, int x, int y) {
    int[] xy = new int[2];
    xy[0] = x;
    xy[1] = y;
    if (charAt == 'N') {
      xy[1] = y + 1;
    } else if (charAt == 'S') {
      xy[1] = y - 1;
    } else if (charAt == 'E') {
      xy[0] = x + 1;
    } else {
      xy[0] = x - 1;
    }
    return xy;
  }
}
