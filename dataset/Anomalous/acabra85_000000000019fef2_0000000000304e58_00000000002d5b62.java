import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(String.format("Case #%d: %s", i, solve(x, y)));
        }
    }

    protected static String solve(int x, int y) {
        Cell target = new Cell(x, y);
        if (target.isDiagonal()) {
            return "IMPOSSIBLE";
        }

        ArrayDeque<Move> queue = new ArrayDeque<>();
        queue.add(new Move(new Cell(0, 0), ""));

        while (!queue.isEmpty()) {
            Move currentMove = queue.pollLast();
            for (Move nextMove : currentMove.getPossibleMoves()) {
                if (nextMove != null) {
                    if (nextMove.cell.equals(target)) {
                        return nextMove.path;
                    }
                    queue.addFirst(nextMove);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static final long LIMIT = 1000000000;

    private static boolean inBounds(long x, long y) {
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

        Move moveN() {
            return createMove(cell.x, cell.y + getNewJumpSize(), "N");
        }

        Move moveS() {
            return createMove(cell.x, cell.y - getNewJumpSize(), "S");
        }

        Move moveE() {
            return createMove(cell.x + getNewJumpSize(), cell.y, "E");
        }

        Move moveW() {
            return createMove(cell.x - getNewJumpSize(), cell.y, "W");
        }

        private Move createMove(long x, long y, String direction) {
            if (inBounds(x, y)) {
                return new Move(new Cell(x, y), this.path + direction, getNewJumpSize());
            }
            return null;
        }

        private long getNewJumpSize() {
            return this.jumpSize == 0 ? 1 : this.jumpSize * 2;
        }

        List<Move> getPossibleMoves() {
            return Arrays.asList(moveN(), moveS(), moveE(), moveW());
        }

        @Override
        public String toString() {
            return "Move{" + "path='" + path + '\'' + ", cell=" + cell + '}';
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

        @Override
        public String toString() {
            return "Cell{" + "x=" + x + ", y=" + y + '}';
        }

        boolean isDiagonal() {
            return x != 0 && Math.abs(x) == Math.abs(y);
        }
    }
}