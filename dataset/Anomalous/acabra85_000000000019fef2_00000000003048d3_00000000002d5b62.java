import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.printf("Case #%d: %s%n", i, findPathToTarget(x, y));
        }
    }

    private static String findPathToTarget(int x, int y) {
        Cell target = new Cell(x, y);
        if (target.isDiagonal()) {
            return "IMPOSSIBLE";
        }

        Set<Cell> visitedCells = new HashSet<>();
        ArrayDeque<Move> queue = new ArrayDeque<>();
        queue.add(new Move(new Cell(0, 0), ""));

        while (!queue.isEmpty()) {
            Move currentMove = queue.pollLast();
            if (currentMove.cell.equals(target)) {
                return currentMove.path;
            }

            for (Move nextMove : currentMove.getPossibleMoves()) {
                if (nextMove != null && visitedCells.add(nextMove.cell)) {
                    queue.addFirst(nextMove);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static final long LIMIT = 1_000_000_000;

    private static boolean isWithinBounds(long x, long y) {
        return Math.abs(x) <= LIMIT && Math.abs(y) <= LIMIT;
    }

    static class Move {
        final String path;
        final long jumpSize;
        final Cell cell;

        Move(Cell cell, String path) {
            this(cell, path, 0);
        }

        Move(Cell cell, String path, long jumpSize) {
            this.cell = cell;
            this.path = path;
            this.jumpSize = jumpSize;
        }

        List<Move> getPossibleMoves() {
            long newJumpSize = jumpSize == 0 ? 1 : jumpSize * 2;
            List<Move> moves = new ArrayList<>();
            addMoveIfValid(moves, cell.x, cell.y + newJumpSize, "N", newJumpSize);
            addMoveIfValid(moves, cell.x, cell.y - newJumpSize, "S", newJumpSize);
            addMoveIfValid(moves, cell.x + newJumpSize, cell.y, "E", newJumpSize);
            addMoveIfValid(moves, cell.x - newJumpSize, cell.y, "W", newJumpSize);
            return moves;
        }

        private void addMoveIfValid(List<Move> moves, long x, long y, String direction, long newJumpSize) {
            if (isWithinBounds(x, y)) {
                moves.add(new Move(new Cell(x, y), path + direction, newJumpSize));
            }
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

        boolean isDiagonal() {
            return x != 0 && Math.abs(x) == Math.abs(y);
        }
    }
}