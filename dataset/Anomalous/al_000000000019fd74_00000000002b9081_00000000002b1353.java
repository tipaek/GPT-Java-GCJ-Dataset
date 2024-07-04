import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Map<Point, Integer> pascalCache = new HashMap<>();
    private static Set<Point> visitedPoints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int targetSum = scanner.nextInt();
            visitedPoints = new HashSet<>();
            List<Point> path = new ArrayList<>();
            Point startingPoint = new Point(1, 1);
            path.add(startingPoint);
            visitedPoints.add(startingPoint);
            pascalCache.put(startingPoint, 1);
            findPath(targetSum - 1, startingPoint, path);
            StringBuilder output = new StringBuilder();
            output.append("Case #").append(testIndex + 1).append(":\n");
            for (Point point : path) {
                output.append(point.row).append(" ").append(point.column).append("\n");
            }
            System.out.print(output.toString());
        }
    }

    private static boolean findPath(int remainingSum, Point currentPoint, List<Point> path) {
        if (remainingSum == 0) {
            return true;
        }
        if (remainingSum < 0 || visitedPoints.size() >= 500) {
            return false;
        }

        List<Point> adjacentPoints = Arrays.asList(
            new Point(currentPoint.row - 1, currentPoint.column - 1),
            new Point(currentPoint.row - 1, currentPoint.column),
            new Point(currentPoint.row, currentPoint.column - 1),
            new Point(currentPoint.row, currentPoint.column + 1),
            new Point(currentPoint.row + 1, currentPoint.column),
            new Point(currentPoint.row + 1, currentPoint.column + 1)
        );

        for (Point point : adjacentPoints) {
            if (isValidPosition(point, remainingSum)) {
                int pointValue = computePascalValue(point);
                path.add(point);
                visitedPoints.add(point);
                if (findPath(remainingSum - pointValue, point, path)) {
                    return true;
                }
                visitedPoints.remove(point);
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private static int computePascalValue(Point point) {
        if (point.row < 1 || point.column < 1 || point.row < point.column) {
            return 0;
        }
        if (pascalCache.containsKey(point)) {
            return pascalCache.get(point);
        }
        int upperLeftValue = computePascalValue(new Point(point.row - 1, point.column - 1));
        int upperRightValue = computePascalValue(new Point(point.row - 1, point.column));
        int value = upperLeftValue + upperRightValue;
        pascalCache.put(point, value);
        return value;
    }

    private static boolean isValidPosition(Point point, int remainingSum) {
        if (point.row < 1 || point.column < 1 || point.row < point.column || visitedPoints.contains(point)) {
            return false;
        }
        int pointValue = computePascalValue(point);
        return remainingSum - pointValue >= 0;
    }

    public static class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return row == point.row && column == point.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}