import java.io.*;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = read.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        //test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; ++x) {
                System.out.println("Case #" + x + ": " + getResult(in.nextLine()));
            }
        }
    }

    private static String getResult(String targetString) {
        String[] parts = targetString.split(" ");
        long targetX = Long.parseLong(parts[0]);
        long targetY = Long.parseLong(parts[1]);

        if (Math.abs(targetX % 2) == Math.abs(targetY % 2)) {
            return "IMPOSSIBLE";
        }

        final int maxDepth = 30;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0, 1, ""));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.depth == maxDepth) {
                return "IMPOSSIBLE";
            }

            long thisHop = point.nextHop;
            long nextHop = thisHop * 2;
            int nextDepth = point.depth + 1;

            if (processNextPoint(queue, point, targetX, targetY, nextDepth, nextHop, -thisHop, 0, "W") ||
                processNextPoint(queue, point, targetX, targetY, nextDepth, nextHop, thisHop, 0, "E") ||
                processNextPoint(queue, point, targetX, targetY, nextDepth, nextHop, 0, -thisHop, "S") ||
                processNextPoint(queue, point, targetX, targetY, nextDepth, nextHop, 0, thisHop, "N")) {
                return point.directionHistory;
            }
        }

        return "IMPOSSIBLE";
    }

    private static boolean processNextPoint(Queue<Point> queue, Point point, long targetX, long targetY, int nextDepth, long nextHop, long dx, long dy, String direction) {
        Point nextPoint = new Point(point.x + dx, point.y + dy, nextDepth, nextHop, point.directionHistory + direction);
        if (nextPoint.x == targetX && nextPoint.y == targetY) {
            point.directionHistory = nextPoint.directionHistory;
            return true;
        }
        queue.add(nextPoint);
        return false;
    }

    private static class Point {
        long x, y;
        int depth;
        long nextHop;
        String directionHistory;

        Point(long x, long y, int depth, long nextHop, String directionHistory) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.nextHop = nextHop;
            this.directionHistory = directionHistory;
        }
    }
}