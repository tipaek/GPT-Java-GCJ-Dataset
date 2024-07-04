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

    protected static String findPath(int x, int y) {
        Cell target = new Cell(x, y);
        ArrayDeque<Move> queue = new ArrayDeque<>();
        queue.add(new Move(new Cell(0, 0), ""));

        while (!queue.isEmpty()) {
            Move currentMove = queue.poll();
            if (currentMove.cell.equals(target)) {
                return currentMove.path;
            }
            for (Move nextMove : currentMove.getPossibleMoves()) {
                if (nextMove != null) {
                    queue.add(nextMove);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static long limit = 100;

    private static boolean inBounds(long x, long y) {
        return Math.abs(x) <= limit && Math.abs(y) <= limit;
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
            List<Move> moves = new ArrayList<>();
            try {
                moves.add(moveTo(0, jumpSize, "N"));
                moves.add(moveTo(0, -jumpSize, "S"));
                moves.add(moveTo(jumpSize, 0, "E"));
                moves.add(moveTo(-jumpSize, 0, "W"));
            } catch (Exception e) {
                // Ignored
            }
            return moves;
        }

        private Move moveTo(long dx, long dy, String direction) throws Exception {
            long newJumpSize = jumpSize == 0 ? 1 : jumpSize * 2;
            long newX = cell.x + dx * newJumpSize;
            long newY = cell.y + dy * newJumpSize;
            if (inBounds(newX, newY)) {
                return new Move(new Cell(newX, newY), path + direction, newJumpSize);
            }
            return null;
        }

        @Override
        public String toString() {
            return "Move{" +
                    "path='" + path + '\'' +
                    ", cell=" + cell +
                    '}';
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
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}