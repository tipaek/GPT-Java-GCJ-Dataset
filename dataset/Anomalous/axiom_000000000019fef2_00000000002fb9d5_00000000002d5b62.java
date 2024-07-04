import java.util.*;
import java.io.*;

public class Solution {
    static class Point {
        int x, y;
        String path;

        Point(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    private static final Map<String, Point> paths = new HashMap<>();
    private static final int MAX = 256;

    static {
        initializePaths();
    }

    private static void initializePaths() {
        paths.put("1_0", new Point(1, 0, "E"));
        paths.put("0_1", new Point(0, 1, "N"));
        paths.put("-1_0", new Point(-1, 0, "W"));
        paths.put("0_-1", new Point(0, -1, "S"));

        int i = 2;
        while (true) {
            int len = (int) Math.pow(2.0, i - 1.0);
            Set<Point> temp = new HashSet<>();
            for (Point point : paths.values()) {
                addNewPoints(temp, point, len);
            }
            updatePaths(temp);
            if (shouldBreak(len)) break;
            i++;
        }
    }

    private static void addNewPoints(Set<Point> temp, Point point, int len) {
        temp.add(new Point(point.x + len, point.y, point.path + "E"));
        temp.add(new Point(point.x, point.y + len, point.path + "N"));
        temp.add(new Point(point.x - len, point.y, point.path + "W"));
        temp.add(new Point(point.x, point.y - len, point.path + "S"));
    }

    private static void updatePaths(Set<Point> temp) {
        for (Point point : temp) {
            String key = point.x + "_" + point.y;
            paths.putIfAbsent(key, point);
        }
    }

    private static boolean shouldBreak(int len) {
        for (Point point : paths.values()) {
            if (Math.abs(point.x) > MAX || Math.abs(point.y) > MAX || len > MAX) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            String res = solve(n, m);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(int x, int y) {
        String key = x + "_" + y;
        return paths.getOrDefault(key, new Point(0, 0, "IMPOSSIBLE")).path;
    }
}