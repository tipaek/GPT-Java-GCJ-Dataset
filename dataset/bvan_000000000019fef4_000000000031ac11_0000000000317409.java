import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] catMoves = scanner.next().toCharArray();
            Integer steps = solve(catMoves, x, y);
            String answer = (steps != null) ? String.valueOf(steps) : "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", t, answer));
        }
    }

    private static Integer solve(char[] catMoves, int x, int y) {
        Point catPoint = new Point(x, y);
        for (int i = 0; i < catMoves.length; i++) {
            char catMove = catMoves[i];
            catPoint = catPoint.move(catMove);
            int lengthToStart = catPoint.lengthToStart();
            if (lengthToStart == i + 1 || lengthToStart == i) {
                return i + 1;
            }
        }
        return null;
    }

    private static final class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point move(char move) {
            switch (move) {
                case 'N':
                    return new Point(x, y + 1);
                case 'W':
                    return new Point(x - 1, y);
                case 'S':
                    return new Point(x, y - 1);
                case 'E':
                    return new Point(x + 1, y);
                default:
                    throw new AssertionError("illegal move: " + move);
            }
        }

        public int lengthToStart() {
            return Math.abs(x) + Math.abs(y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
}
