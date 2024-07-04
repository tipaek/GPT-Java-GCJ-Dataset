import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int initialX = scanner.nextInt();
            int initialY = scanner.nextInt();
            char[] moves = scanner.next().toCharArray();
            Integer result = findStepsToOrigin(moves, initialX, initialY);
            String output = (result != null) ? String.valueOf(result) : "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", testIndex, output));
        }
    }

    private static Integer findStepsToOrigin(char[] moves, int x, int y) {
        Position position = new Position(x, y);
        for (int step = 0; step < moves.length; step++) {
            position = position.move(moves[step]);
            int distanceToOrigin = position.calculateManhattanDistance();
            if (distanceToOrigin <= step + 1) {
                return step + 1;
            }
        }
        return null;
    }

    private static final class Position {

        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position move(char direction) {
            switch (direction) {
                case 'N':
                    return new Position(x, y + 1);
                case 'W':
                    return new Position(x - 1, y);
                case 'S':
                    return new Position(x, y - 1);
                case 'E':
                    return new Position(x + 1, y);
                default:
                    throw new IllegalArgumentException("Invalid move: " + direction);
            }
        }

        public int calculateManhattanDistance() {
            return Math.abs(x) + Math.abs(y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
}