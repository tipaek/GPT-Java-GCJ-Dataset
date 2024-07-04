import java.util.*;

public class Solution {

    private static class Point {
        int x, y;
        String path;

        Point(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    private static class Direction {
        int dx, dy;
        char move;

        Direction(int dx, int dy, char move) {
            this.dx = dx;
            this.dy = dy;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Direction[] directions = {
            new Direction(0, -1, 'S'),
            new Direction(1, 0, 'E'),
            new Direction(0, 1, 'N'),
            new Direction(-1, 0, 'W')
        };

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            int totalSteps = Math.abs(targetX) + Math.abs(targetY);
            int maxStep = 1;
            while (maxStep <= totalSteps) {
                maxStep <<= 1;
            }

            int step = 1;
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0, ""));
            boolean found = false;

            while (step < maxStep && !found) {
                int queueSize = queue.size();
                for (int i = 0; i < queueSize && !found; ++i) {
                    Point current = queue.poll();
                    for (Direction dir : directions) {
                        int newX = current.x + step * dir.dx;
                        int newY = current.y + step * dir.dy;
                        if (newX == targetX && newY == targetY) {
                            System.out.println("Case #" + caseNum + ": " + current.path + dir.move);
                            found = true;
                            break;
                        }
                        queue.add(new Point(newX, newY, current.path + dir.move));
                    }
                }
                step <<= 1;
            }

            if (!found) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}