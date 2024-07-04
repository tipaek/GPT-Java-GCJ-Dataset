import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        // Uncomment to test with file input
        // test();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int x = 1; x <= t; ++x) {
            System.out.println("Case #" + x + ": " + getResult(in.nextLine()));
        }
        in.close();
    }

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = read.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    private static String getResult(String targetString) {
        String[] coordinates = targetString.split(" ");
        long targetX = Long.parseLong(coordinates[0]);
        long targetY = Long.parseLong(coordinates[1]);

        if (Math.abs(targetX % 2) == Math.abs(targetY % 2)) return "IMPOSSIBLE";

        Queue<Point> queue = new ArrayDeque<>();
        final int maxDepth = 15;
        queue.add(new Point(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.depth == maxDepth) return "IMPOSSIBLE";

            long thisHop = point.nextHop;
            long nextHop = point.nextHop * 2;
            int nextDepth = point.depth + 1;
            long x = point.x;
            long y = point.y;

            Point[] nextPoints = {
                new Point(x - thisHop, y, nextDepth, nextHop, point.directionHistory + "W"),
                new Point(x + thisHop, y, nextDepth, nextHop, point.directionHistory + "E"),
                new Point(x, y - thisHop, nextDepth, nextHop, point.directionHistory + "S"),
                new Point(x, y + thisHop, nextDepth, nextHop, point.directionHistory + "N")
            };

            for (Point nextPoint : nextPoints) {
                if (nextPoint.x == targetX && nextPoint.y == targetY) {
                    return nextPoint.directionHistory;
                }
                queue.add(nextPoint);
            }
        }

        return "IMPOSSIBLE";
    }

    private static class Point {
        long x, y;
        int depth;
        long nextHop;
        String directionHistory;

        Point(long x, long y, int depth, long nextHop) {
            this(x, y, depth, nextHop, "");
        }

        Point(long x, long y, int depth, long nextHop, String directionHistory) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.nextHop = nextHop;
            this.directionHistory = directionHistory;
        }
    }
}