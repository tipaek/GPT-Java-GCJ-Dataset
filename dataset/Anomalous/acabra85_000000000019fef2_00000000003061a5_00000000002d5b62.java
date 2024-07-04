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
        ArrayDeque<Move> queue = new ArrayDeque<>();
        queue.add(new Move(new Cell(0, 0), "", 0));

        while (!queue.isEmpty()) {
            Move currentMove = queue.poll();
            if (currentMove.cell.equals(target)) {
                return currentMove.path;
            }

            addNextMove(queue, currentMove, currentMove.cell.x, currentMove.cell.y + currentMove.nextJumpSize(), "N");
            addNextMove(queue, currentMove, currentMove.cell.x, currentMove.cell.y - currentMove.nextJumpSize(), "S");
            addNextMove(queue, currentMove, currentMove.cell.x + currentMove.nextJumpSize(), currentMove.cell.y, "E");
            addNextMove(queue, currentMove, currentMove.cell.x - currentMove.nextJumpSize(), currentMove.cell.y, "W");
        }

        return "IMPOSSIBLE";
    }

    private static void addNextMove(ArrayDeque<Move> queue, Move currentMove, long newX, long newY, String direction) {
        if (Math.abs(newX) <= LIMIT && Math.abs(newY) <= LIMIT) {
            queue.add(new Move(new Cell(newX, newY), currentMove.path + direction, currentMove.nextJumpSize()));
        }
    }

    private static final long LIMIT = 1000;

    static class Move {
        final Cell cell;
        final String path;
        final long jumpSize;

        Move(Cell cell, String path, long jumpSize) {
            this.cell = cell;
            this.path = path;
            this.jumpSize = jumpSize;
        }

        long nextJumpSize() {
            return jumpSize == 0 ? 1 : jumpSize * 2;
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
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Cell cell = (Cell) obj;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}