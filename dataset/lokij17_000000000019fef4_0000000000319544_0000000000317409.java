import java.util.*;

import static java.lang.Math.abs;

class Solution {

  static class  Pair {
    int a,b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int x = in.nextInt();
      int y = in.nextInt();

      String M = in.next();

      int m = -1;
      if (x == 0 && y == 0) {
        System.out.println("Case #" + (t + 1) + ": 0");
        continue;
      }
      for (int i = 0; i < M.length(); i++) {
        switch (M.charAt(i)) {
        case 'N':
          y++;
          break;
        case 'S':
          y--;
        case 'E':
          x++;
        case 'W':
          x--;
        }

        if(dist(x, y) <= (i+1)) {
          m = i+1;
          break;
        }
      }

      System.out.println("Case #" + (t + 1) + ": " + (m > 0 ? m : "IMPOSSIBLE"));
    }
  }

  static int dist(int x, int y) {
    return abs(x) + abs(y);
  }
}