import java.util.*;
import java.io.*;

public class Solution {
    static class Point {
        int x;
        int y;
        String path;

        public Point(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    private static Map<String, Point> paths = new HashMap<>();
    //    private static final int MAX = (int) Math.pow(10.0, 9.0);
    private static final int MAX = 256;

    static {
        paths.put("1_0", new Point(1, 0, "E"));
        paths.put("0_1", new Point(0, 1, "N"));
        paths.put("-1_0", new Point(-1, 0, "W"));
        paths.put("0_-1", new Point(0, -1, "S"));

        int i = 2;
        while (true) {
            Iterator<Point> iter1 = paths.values().iterator();
            int len = (int) Math.pow(2.0, i - 1.0);
            int x = 1;
            int y = 1;
            Set<Point> temp = new HashSet<>();
            while (iter1.hasNext()) {
                Point point = iter1.next();
                x = point.x;
                y = point.y;
                String p = point.path;

                Point pe = new Point(x + len, y, p + "E");
                Point pn = new Point(x, y + len, p + "N");
                Point pw = new Point(x - len, y, p + "W");
                Point ps = new Point(x, y - len, p + "S");
                if (!temp.contains(pe)) {
                    temp.add(pe);
                }
                if (!temp.contains(pn)) {
                    temp.add(pn);
                }
                if (!temp.contains(pw)) {
                    temp.add(pw);
                }
                if (!temp.contains(ps)) {
                    temp.add(ps);
                }
            }
            Iterator<Point> iter2 = temp.iterator();
            while (iter2.hasNext()) {
                Point point = iter2.next();
                String k = point.x + "_" + point.y;
                if (!paths.containsKey(k)) {
                    paths.put(k, point);
                }
            }
            if (Math.abs(x) > MAX || Math.abs(y) > MAX || len > MAX) {
                break;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            String res = solve(n, m);
            System.out.println("Case #" + i + ": " + res);
        }
    }


    private static String solve(int x, int y) {
        String k = x + "_" + y;
        if (paths.containsKey(k)) {
            return paths.get(k).path;
        }
        return "IMPOSSIBLE";
    }
}