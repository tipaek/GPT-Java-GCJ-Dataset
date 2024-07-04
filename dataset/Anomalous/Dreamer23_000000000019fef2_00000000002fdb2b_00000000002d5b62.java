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
        // Uncomment the following line to run the test method
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; ++x) {
                System.out.println("Case #" + x + ": " + getResult(in.nextLine()));
            }
        }
    }

    private static String getResult(String targetString) {
        String[] t = targetString.split(" ");
        long targetX = Long.parseLong(t[0]);
        long targetY = Long.parseLong(t[1]);

        if (Math.abs(targetX % 2) == Math.abs(targetY % 2)) {
            return "IMPOSSIBLE";
        }

        Queue<Point> queue = new ArrayDeque<>();
        final int maxDepth = 4;
        queue.add(new Point(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.depth == maxDepth) {
                return "IMPOSSIBLE";
            }

            long thisHop = p.nextHop;
            long nextHop = p.nextHop * 2;
            int nextDepth = p.depth + 1;

            for (Direction direction : Direction.values()) {
                Point n = p.move(direction, thisHop, nextDepth, nextHop);
                if (n.x == targetX && n.y == targetY) {
                    return n.directionHistory.toString();
                }
                queue.add(n);
            }
        }

        return "IMPOSSIBLE";
    }

    private static class Point {
        long x, y;
        int depth;
        long nextHop;
        StringBuilder directionHistory;

        Point(long x, long y, int depth, long nextHop) {
            this(x, y, depth, nextHop, new StringBuilder());
        }

        Point(long x, long y, int depth, long nextHop, StringBuilder directionHistory) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.nextHop = nextHop;
            this.directionHistory = new StringBuilder(directionHistory);
        }

        Point move(Direction direction, long thisHop, int nextDepth, long nextHop) {
            long newX = x + direction.dx * thisHop;
            long newY = y + direction.dy * thisHop;
            StringBuilder newHistory = new StringBuilder(directionHistory).append(direction);
            return new Point(newX, newY, nextDepth, nextHop, newHistory);
        }
    }

    private enum Direction {
        W(-1, 0), E(1, 0), S(0, -1), N(0, 1);

        final int dx, dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }
}