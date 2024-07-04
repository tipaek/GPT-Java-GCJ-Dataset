import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.printf("Case #%d: %s%n", i, findPath(x, y));
        }
    }

    private static String findPath(int x, int y) {
        Cell target = new Cell(x, y);
        if (target.isDiagonal()) {
            return "IMPOSSIBLE";
        }
        Queue<Move> queue = new ArrayDeque<>();
        queue.add(new Move(new Cell(0, 0), ""));
        while (!queue.isEmpty()) {
            Move currentMove = queue.poll();
            if (currentMove.cell.equals(target)) {
                return currentMove.path;
            }
            addIfValid(queue, currentMove.moveN());
            addIfValid(queue, currentMove.moveS());
            addIfValid(queue, currentMove.moveE());
            addIfValid(queue, currentMove.moveW());
        }
        return "IMPOSSIBLE";
    }

    private static void addIfValid(Queue<Move> queue, Move move) {
        if (move != null) {
            queue.add(move);
        }
    }

    private static final long LIMIT = 1_000_000_000;

    private static boolean inBounds(long x, long y) {
        return Math.abs(x) <= LIMIT && Math.abs(y) <= LIMIT;
    }

    static class Move {
        final String path;
        final long jumpSize;
        final Cell cell;

        Move(Cell cell, String path) {
            this(cell, path, 1);
        }

        Move(Cell cell, String path, long jumpSize) {
            this.cell = cell;
            this.path = path;
            this.jumpSize = jumpSize;
        }

        Move moveN() {
            return createMove(cell.x, cell.y + jumpSize, "N");
        }

        Move moveS() {
            return createMove(cell.x, cell.y - jumpSize, "S");
        }

        Move moveE() {
            return createMove(cell.x + jumpSize, cell.y, "E");
        }

        Move moveW() {
            return createMove(cell.x - jumpSize, cell.y, "W");
        }

        private Move createMove(long x, long y, String direction) {
            if (inBounds(x, y)) {
                return new Move(new Cell(x, y), path + direction, jumpSize * 2);
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