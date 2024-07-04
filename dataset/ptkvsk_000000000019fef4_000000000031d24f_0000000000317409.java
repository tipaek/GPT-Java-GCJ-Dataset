import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String[] s = in.nextLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            String p = s[2];
            System.out.println("Case #" + i + ": " + intercept(x, y, p));
        }
    }

    private static String intercept(int x, int y, String path) {
        if (x == 0 && y == 0) {
            return "0";
        }

        Point p = new Point(x, y);

        for (Character c : path.toCharArray()) {
            p = p.move(c);

            if (p.manhattan() <= p.getT()) {
                return Integer.toString(p.getT());
            }
        }

        return "IMPOSSIBLE";
    }

    public static class Point {
        private final int x;
        private final int y;
        private final int t;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.t = 0;
        }

        private Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public int getT() {
            return t;
        }

        public int manhattan() {
            return Math.abs(x) + Math.abs(y);
        }

        public Point move(char dir) {
            switch (dir) {
                case 'N':
                    return new Point(x, y + 1, t + 1);
                case 'S':
                    return new Point(x, y - 1, t + 1);
                case 'E':
                    return new Point(x + 1, y, t + 1);
                case 'W':
                    return new Point(x - 1, y, t + 1);
                default:
                    throw new IllegalArgumentException("Unexpected dir " + dir);
            }
        }
    }
}