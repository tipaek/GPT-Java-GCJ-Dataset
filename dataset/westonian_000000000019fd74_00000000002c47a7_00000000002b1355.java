
import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * V2020.1
 * <p>
 * Suitable for regular or interactive problems.
 */
public final class Solution {

    /**
     * Your code here!
     *
     * @param r read input from this
     * @param w write output to this
     */
    public static void solve(Scanner r, PrintWriter w) {
        loopCase(r, (c) -> {
            w.print("Case #" + c + ": ");

            w.println(solveCase(r));
        });
    }

    private static String solveCase(Scanner r) {
        StringBuilder sb = new StringBuilder();
        int row = r.nextInt();
        int col = r.nextInt();
        Floor floor = new Floor(row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int s = r.nextInt();
                floor.add(i, j, s);
            }
        }

        floor.scoreUp();

        long result = 0;
        while (floor != null) {
            result += floor.floorInterest;
            floor = floor.elimitate();
        }

        sb.append(result);
        return sb.toString();
    }

    public static class Floor {
        Quad[][] floor;
        long floorInterest;
        private int row;
        private int col;

        public Floor(int row, int col) {
            this.row = row;
            this.col = col;
            floor = new Quad[row][col];
        }

        public void add(int i, int j, int s) {
            floor[i][j] = new Quad(s);
            floorInterest += s;
        }

        private int scoreUp() {
            int result = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Quad quad = floor[i][j];
                    quad.left = get(i - 1, j);
                    quad.right = get(i + 1, j);
                    quad.top = get(i, j + 1);
                    quad.bottom = get(i, j - 1);
                }
            }
            return result;
        }

        private Floor elimitate() {
            int e = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Quad quad = floor[i][j];
                    if (!quad.eliminated && quad.lessThanAvg()) {
                        quad.mark();
                        e++;
                    }
                }
            }

            if (e == 0) return null;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Quad quad = floor[i][j];
                    if (quad.markForEliminated && quad.skill > 0) {
                        floorInterest -= quad.skill;
                        quad.terminate();
                    }
                }
            }
            return this;
        }

        private Quad get(int i, int j) {
            if (i >= 0 && i < row && j >= 0 && j < col) {
                return floor[i][j];
            }
            return null;
        }
    }

    public static class Quad {
        Quad top;
        Quad left;
        Quad right;
        Quad bottom;
        long skill;
        private boolean eliminated;
        private boolean markForEliminated;

        public Quad(int s) {
            skill = s;
        }

        public boolean lessThanAvg() {
            int competitorCount = 0;
            int score = 0;

            if (left != null) {
                competitorCount++;
                score += left.skill;
            }
            if (right != null) {
                competitorCount++;
                score += right.skill;
            }
            if (top != null) {
                competitorCount++;
                score += top.skill;
            }
            if (bottom != null) {
                competitorCount++;
                score += bottom.skill;
            }

            if (competitorCount == 0) {
                return false;
            }

            return (skill * competitorCount) < score;
        }

        public void mark() {
            markForEliminated = true;
        }

        public void terminate() {
            skill = 0;
            if (left != null) {
                if (left.right != this) throw new AssertionError();
                left.right = right;
            }
            if (right != null) {
                if (right.left != this) throw new AssertionError();
                right.left = left;
            }
            if (top != null) {
                if (top.bottom != this) throw new AssertionError();
                top.bottom = bottom;
            }
            if (bottom != null) {
                if (bottom.top != this) throw new AssertionError();
                bottom.top = top;
            }
            left = null;
            right = null;
            top = null;
            bottom = null;
            eliminated = true;
            markForEliminated = false;
        }

        @Override
        public String toString() {
            return "" + skill;
        }
    }

    /**
     * Pipes {@link System#in} to {@link #solve} and writes output to {@link System#out}
     *
     * @param args Ignored
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            try (PrintWriter output = new PrintWriter(System.out)) {
                solve(input, output);
            }
        }
    }

    /**
     * Use for unit testing.
     * Pipe a string into {@link #solve} and get result as a string.
     *
     * @param input input string
     * @return output string
     */
    public static String run(final String input) {
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
            StringWriter out = new StringWriter();
            try (PrintWriter writer = new PrintWriter(out)) {
                solve(scanner, writer);
                return out.toString();
            }
        }
    }

    private static void loopCase(Scanner r, Case perCase) {
        final int loops = r.nextInt();
        for (int i = 1; i <= loops; i++)
            perCase.run(i);
    }

    public interface Case {
        void run(final int c);
    }
}
