import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      String direction = in.next();
      Solver solver = new Solver(x, y, direction);
      if (solver.getMinWalks() == Long.MAX_VALUE) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
        System.out.println("Case #" + i + ": " + solver.getMinWalks());
      }
    }
  }

  private static class Solver {
    private final int x;
    private final int y;
    private final String directions;

    public Solver(int x, int y, String directions) {
      this.x = x;
      this.y = y;
      this.directions = directions;
    }

    public long getMinWalks() {
      long min = Long.MAX_VALUE;

      long curX = x;
      long curY = y;

      for (int i = 0; i < directions.length(); i++) {
        char dir = directions.charAt(i);
        switch(dir) {
          case 'S':
            curY -= 1;
            break;
          case 'N':
            curY += 1;
            break;
          case 'W':
            curX -=1;
            break;
          case 'E':
            curX +=1;
            break;
        }
        long distance = Math.abs(curX) + Math.abs(curY);
        if ( (i + 1) >= distance && ((i + 1) < min)) {
          min = i + 1;
        }
      }
      return min;
    }
  }
}
