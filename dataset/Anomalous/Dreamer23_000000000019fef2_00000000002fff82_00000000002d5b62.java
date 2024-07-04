import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    
    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the following line to run the test method
        // test();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= t; i++) {
                System.out.println("Case #" + i + ": " + getResult(scanner.nextLine()));
            }
        }
    }

    private static String getResult(String targetString) {
        String[] coordinates = targetString.split(" ");
        long targetX = Long.parseLong(coordinates[0]);
        long targetY = Long.parseLong(coordinates[1]);

        if (Math.abs(targetX % 2) == Math.abs(targetY % 2)) {
            return "IMPOSSIBLE";
        }

        Queue<Point> queue = new ArrayDeque<>();
        final int maxDepth = 20;
        queue.add(new Point(0, 0, 0, 1, new StringBuilder()));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.depth == maxDepth) {
                return "IMPOSSIBLE";
            }

            long thisHop = current.nextHop;
            long nextHop = thisHop * 2;
            int nextDepth = current.depth + 1;

            Point[] nextPoints = {
                new Point(current.x - thisHop, current.y, nextDepth, nextHop, new StringBuilder(current.directionHistory).append("W")),
                new Point(current.x + thisHop, current.y, nextDepth, nextHop, new StringBuilder(current.directionHistory).append("E")),
                new Point(current.x, current.y - thisHop, nextDepth, nextHop, new StringBuilder(current.directionHistory).append("S")),
                new Point(current.x, current.y + thisHop, nextDepth, nextHop, new StringBuilder(current.directionHistory).append("N"))
            };

            for (Point next : nextPoints) {
                if (next.x == targetX && next.y == targetY) {
                    return next.directionHistory.toString();
                }
                queue.add(next);
            }
        }

        return "IMPOSSIBLE";
    }

    private static class Point {
        private final long x, y;
        private final int depth;
        private final long nextHop;
        private final StringBuilder directionHistory;

        private Point(long x, long y, int depth, long nextHop, StringBuilder directionHistory) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.nextHop = nextHop;
            this.directionHistory = directionHistory;
        }
    }
}