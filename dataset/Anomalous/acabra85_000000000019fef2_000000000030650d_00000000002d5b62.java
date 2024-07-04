import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 1; i <= testCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(String.format("Case #%d: %s", i, findPath(x, y)));
        }
    }

    protected static String findPath(int x, int y) {
        Cell target = new Cell(x, y);
        if (target.isDiagonal()) {
            return "IMPOSSIBLE";
        }

        Queue<Move> queue = new ArrayDeque<>();
        queue.add(new Move(new Cell(0, 0), "", 1));

        while (!queue.isEmpty()) {
            Move currentMove = queue.poll();
            if (currentMove.cell.equals(target)) {
                return currentMove.path;
            }

            for (Direction direction : Direction.values()) {
                Move nextMove = currentMove.move(direction);
                if (nextMove != null) {
                    queue.add(nextMove);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static final long LIMIT = 100;

    private static boolean inBounds(long x, long y) {
        return Math.abs(x) <= LIMIT && Math.abs(y) <= LIMIT;
    }

    enum Direction {
        N, S, E, W
    }

    static class Move {
        final String path;
        final long jumpSize;
        final Cell cell;

        Move(Cell cell, String path, long jumpSize) {
            this.cell = cell;
            this.path = path;
            this.jumpSize = jumpSize;
        }

        Move move(Direction direction) {
            long newJumpSize = jumpSize * 2;
            long x = cell.x;
            long y = cell.y;

            switch (direction) {
                case N: y += jumpSize; break;
                case S: y -= jumpSize; break;
                case E: x += jumpSize; break;
                case W: x -= jumpSize; break;
            }

            if (inBounds(x, y)) {
                return new Move(new Cell(x, y), path + direction, newJumpSize);
            }
            return null;
        }
    }

    static class Cell {
        final long x;
        final long y;

        Cell(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        boolean isDiagonal() {
            return x != 0 && Math.abs(x) == Math.abs(y);
        }
    }
}