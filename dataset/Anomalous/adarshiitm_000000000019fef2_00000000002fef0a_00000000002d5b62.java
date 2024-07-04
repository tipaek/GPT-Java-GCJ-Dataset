import java.io.*;
import java.util.*;

public class Solution {

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Move {
        Point point;
        Character direction;

        public Move(Point point, Character direction) {
            this.point = point;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + caseNum + ": " + findPath(x, y));
        }
    }

    private static String findPath(int x, int y) {
        if ((x + y) % 2 == 0) {
            return "IMPOSSIBLE";
        }

        Point target = new Point(x, y);
        Map<Integer, Map<Point, Move>> reverseMap = new HashMap<>();
        Map<Point, Move> initialMoves = new HashMap<>();
        initialMoves.put(new Point(1, 0), new Move(null, 'E'));
        initialMoves.put(new Point(-1, 0), new Move(null, 'W'));
        initialMoves.put(new Point(0, 1), new Move(null, 'N'));
        initialMoves.put(new Point(0, -1), new Move(null, 'S'));
        reverseMap.put(1, initialMoves);

        int stepValue = 1;
        int stepCount = 1;

        while (!initialMoves.containsKey(target) && stepCount < 36) {
            stepValue *= 2;
            Map<Point, Move> currentMoves = reverseMap.get(stepCount);
            Map<Point, Move> newMoves = new HashMap<>();
            reverseMap.put(stepCount + 1, newMoves);

            for (Point point : currentMoves.keySet()) {
                newMoves.put(new Point(point.x + stepValue, point.y), new Move(point, 'E'));
                newMoves.put(new Point(point.x - stepValue, point.y), new Move(point, 'W'));
                newMoves.put(new Point(point.x, point.y + stepValue), new Move(point, 'N'));
                newMoves.put(new Point(point.x, point.y - stepValue), new Move(point, 'S'));
            }
            stepCount++;
            if (newMoves.containsKey(target)) {
                break;
            }
        }

        if (reverseMap.get(stepCount).containsKey(target)) {
            StringBuilder path = new StringBuilder();
            while (stepCount > 0) {
                Move move = reverseMap.get(stepCount).get(target);
                path.append(move.direction);
                target = move.point;
                stepCount--;
            }
            return path.reverse().toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}