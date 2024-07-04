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

    private String bfs(int x, int y) {
        if (x == 0 && y == 0) return "IMPOSSIBLE";

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        Set<Point> visited = new HashSet<>();
        int jump = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int offset = 1 << (jump - 1);

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                if (visited.contains(current)) continue;
                visited.add(current);

                if (current.x == x && current.y == y) {
                    return constructPath(current);
                }

                addPoint(queue, visited, current, new Point(current.x + offset, current.y), 'E');
                addPoint(queue, visited, current, new Point(current.x - offset, current.y), 'W');
                addPoint(queue, visited, current, new Point(current.x, current.y + offset), 'N');
                addPoint(queue, visited, current, new Point(current.x, current.y - offset), 'S');
            }
            jump++;
        }

        return "IMPOSSIBLE";
    }

    private void addPoint(Queue<Point> queue, Set<Point> visited, Point parent, Point newPoint, char direction) {
        if (!visited.contains(newPoint)) {
            newPoint.parent = parent;
            newPoint.dir = direction;
            queue.add(newPoint);
        }
    }

    private String constructPath(Point dest) {
        StringBuilder path = new StringBuilder();
        while (dest != null && dest.dir != null) {
            path.insert(0, dest.dir);
            dest = dest.parent;
        }
        return path.toString();
    }

    private void printAnswer(String ans, int caseNumber) {
        System.out.println("Case #" + caseNumber + ": " + ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int T = Integer.parseInt(sc.nextLine());

        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            String[] coordinates = sc.nextLine().split("\\s");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            String result = solution.bfs(x, y);
            solution.printAnswer(result, caseNumber);
        }
    }
}