
import java.util.*;
import java.io.*;

class Solution {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String argv[]) {
        int t = scanner.nextInt();
        for (int tc=1; tc <= t; tc++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.nextLine().trim();
            int res = solve(x, y, path);
            String result = (res == -1) ? "IMPOSSIBLE" : "" + res;
            System.out.println("Case #" + tc + ": " + result);
        }
    }


    private static int solve(int x, int y, String path) {
        int time = 0;
        for (char c: path.toCharArray()) {
            if (c == 'S') {
                y--;
            } else if (c == 'N') {
                y++;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            time++;
            if (canReach(x, y, time)) {
              return time;
            }
        }
        return -1;
    }

    private static boolean canReach(int x, int y, int time) {
      int dist = Math.abs(x) + Math.abs(y);
      return dist <= time;
    }
}