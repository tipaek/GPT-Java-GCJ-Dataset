import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String directions = in.next();
            int ans = solve(x, y, directions);
            System.out
                .println("Case #" + i + ": " + (ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans));
        }
    }

    static class Point {

        int x;
        int y;
        int t;

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    private static int solve(int x, int y, String directions) {

        if (x == 0 && y == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'S') {
                y -= 1;
            } else if (directions.charAt(i) == 'N') {
                y += 1;
            } else if (directions.charAt(i) == 'E') {
                x += 1;
            } else if (directions.charAt(i) == 'W') {
                x -= 1;
            }
            q.add(new Point(x, y, i + 1));
        }

        while (!q.isEmpty()) {
            Point p = q.remove();

            int X = Math.abs(0 - p.x);
            int Y = Math.abs(0 - p.y);

            int curr = X + Y;

            if (curr <= p.t) {
                ans = Math.min(p.t, ans);
            }

        }

        return ans;
    }

}
