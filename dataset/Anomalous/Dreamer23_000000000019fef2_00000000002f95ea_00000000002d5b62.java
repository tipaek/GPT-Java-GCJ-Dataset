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
        if (targetX % 2 == 1 && targetY % 2 == 1) return "IMPOSSIBLE";

        Queue<Point> queue = new ArrayDeque<>();
        final int maxDepth = 4;
        queue.add(new Point(0, 0, 0, 1, ""));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.depth == maxDepth) return "IMPOSSIBLE";

            long thisHop = p.nextHop;
            long nextHop = p.nextHop * 2;
            int nextDepth = p.depth + 1;

            for (Direction dir : Direction.values()) {
                Point n = p.move(dir, thisHop, nextHop, nextDepth);
                if (n.x == targetX && n.y == targetY) return n.directionHistory;
                queue.add(n);
            }
        }

        return "IMPOSSIBLE";
    }

    private static class Point {
        private final long x, y;
        private final int depth;
        private final long nextHop;
        private final String directionHistory;

        private Point(long x, long y, int depth, long nextHop, String directionHistory) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.nextHop = nextHop;
            this.directionHistory = directionHistory;
        }

        private Point move(Direction direction, long thisHop, long nextHop, int nextDepth) {
            long newX = x + direction.dx * thisHop;
            long newY = y + direction.dy * thisHop;
            return new Point(newX, newY, nextDepth, nextHop, directionHistory + direction.symbol);
        }
    }

    private enum Direction {
        WEST(-1, 0, "W"),
        EAST(1, 0, "E"),
        SOUTH(0, -1, "S"),
        NORTH(0, 1, "N");

        private final int dx, dy;
        private final String symbol;

        Direction(int dx, int dy, String symbol) {
            this.dx = dx;
            this.dy = dy;
            this.symbol = symbol;
        }
    }
}