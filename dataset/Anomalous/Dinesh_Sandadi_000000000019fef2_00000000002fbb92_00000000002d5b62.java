import java.util.*;

public class Solution {

    class Point {
        int x, y;
        Point parent;
        Character dir;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.parent = null;
            this.dir = null;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Point point = (Point) other;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private String findPath(int x, int y) {
        if (x == 0 && y == 0) return "IMPOSSIBLE";

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        Set<Point> visited = new HashSet<>();
        int jump = 1;
        Point destination = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int offset = 1 << (jump - 1);
            boolean found = false;

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                visited.add(current);

                if (current.x == x && current.y == y) {
                    destination = current;
                    found = true;
                    break;
                }

                Point[] nextPoints = {
                    new Point(current.x + offset, current.y),
                    new Point(current.x - offset, current.y),
                    new Point(current.x, current.y + offset),
                    new Point(current.x, current.y - offset)
                };

                char[] directions = {'E', 'W', 'N', 'S'};

                for (int j = 0; j < nextPoints.length; j++) {
                    Point nextPoint = nextPoints[j];
                    nextPoint.parent = current;
                    nextPoint.dir = directions[j];

                    if (!visited.contains(nextPoint)) {
                        queue.add(nextPoint);
                    }
                }
            }

            if (found) break;
            jump++;
        }

        if (destination == null) return "IMPOSSIBLE";

        StringBuilder path = new StringBuilder();
        while (destination != null && destination.dir != null) {
            path.insert(0, destination.dir);
            destination = destination.parent;
        }

        return path.toString();
    }

    private void printAnswer(String answer, int testCaseNumber) {
        System.out.println("Case #" + testCaseNumber + ": " + answer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCaseCount; i++) {
            String[] coordinates = scanner.nextLine().split("\\s");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            String answer = solution.findPath(x, y);
            solution.printAnswer(answer, i);
        }
    }
}