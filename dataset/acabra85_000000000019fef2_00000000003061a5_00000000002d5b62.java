
import java.util.*;

    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int test = sc.nextInt();
            int current = 1;
            while (current <= test) {
                System.out.println(String.format("Case #%d: %s", current++, solution(sc.nextInt(), sc.nextInt())));
            }
        }

        protected static String solution(int x, int y) {
            Cell target = new Cell(x, y);
//            if (target.isDiagonal()) {
//                return "IMPOSSIBLE";
//            }
            Move curr = null;
            Move next = null;
            //Set<Cell> reached = new HashSet<>();
            ArrayDeque<Move> queue = new ArrayDeque<>();
            queue.add(new Move(new Cell(0, 0), ""));
            if (queue.peek().cell.equals(target)) {
                return queue.peek().path;
            }
            //reached.add(queue.peek().cell);
            try {
                while (!queue.isEmpty()) {
                    curr = queue.removeFirst();
                    next = curr.moveN();
                    //if (next != null && !reached.contains(next.cell)) {
                    if (next != null) {
                        if (next.cell.equals(target)) {
                            return next.path;
                        }
                        //reached.add(next.cell);
                        queue.addLast(next);
                    }
                    next = curr.moveS();
                    //if (next != null && !reached.contains(next.cell)) {
                    if (next != null) {
                        if (next.cell.equals(target)) {
                            return next.path;
                        }
                        //reached.add(next.cell);
                        queue.addLast(next);
                    }
                    next = curr.moveE();
                    if (next != null) {
                        //if (next != null && !reached.contains(next.cell)) {
                        if (next.cell.equals(target)) {
                            return next.path;
                        }
                        //reached.add(next.cell);
                        queue.addLast(next);
                    }
                    next = curr.moveW();
                    if (next != null) {
                        //if (next != null && !reached.contains(next.cell)) {
                        if (next.cell.equals(target)) {
                            return next.path;
                        }
                        //reached.add(next.cell);
                        queue.addLast(next);
                    }
                }
            }catch (Exception e) {}
            return "IMPOSSIBLE";
        }
        static long limit = 1000;

        private static boolean inBounds(long x, long y) {
            return Math.abs(x) <= limit && Math.abs(y) <= limit;
        }

        static class Move {
            final String path;
            final long jumpSize;
            private final Cell cell;

            public Move(Cell cell, String path) {
                this.cell = cell;
                this.path = path;
                this.jumpSize = 0;
            }

            public Move(Cell cell, String path, long jumpSize) {
                this.cell = cell;
                this.path = path;
                this.jumpSize = jumpSize;
            }

            public Move moveN() throws Exception {
                long newJumpSize = getNewJumpSize();
                long x = cell.x;
                long y = cell.y + newJumpSize;
                if (inBounds(x, y)) {
                    return new Move(new Cell(x, y), this.path + "N", newJumpSize);
                }
                return null;
            }

            private long getNewJumpSize() throws Exception {
                long l = this.jumpSize == 0 ? 1 : this.jumpSize * 2;
                if(l > limit*2) {
                    throw new Exception("");
                }
                return l;
            }

            public Move moveS() throws Exception {
                long newJumpSize = getNewJumpSize();
                long x = cell.x;
                long y = cell.y - newJumpSize;
                if (inBounds(x, y)) {
                    return new Move(new Cell(x, y), this.path + "S", newJumpSize);
                }
                return null;
            }

            public Move moveE() throws Exception {
                long newJumpSize = getNewJumpSize();
                long x = cell.x + newJumpSize;
                long y = cell.y;
                if (inBounds(x, y)) {
                    return new Move(new Cell(x, y), this.path + "E", newJumpSize);
                }
                return null;
            }

            public Move moveW() throws Exception {
                long newJumpSize = getNewJumpSize();
                long x = cell.x - newJumpSize;
                long y = cell.y;
                if (inBounds(x, y)) {
                    return new Move(new Cell(x, y), this.path + "W", newJumpSize);
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
            private final long x;
            private final long y;

            Cell(long x, long y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Cell cell = (Cell) o;
                return x == cell.x &&
                        y == cell.y;
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

            public boolean isDiagonal() {
                return x!=0 && Math.abs(x) == Math.abs(y);
            }
        }
    }