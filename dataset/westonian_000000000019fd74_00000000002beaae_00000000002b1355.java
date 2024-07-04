
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

        int result = 0;
        while (floor != null) {
            result += floor.floorInterest;
            floor = floor.elimitate();
        }

        sb.append(result);
        return sb.toString();
    }

    public static class Floor {
        Quad[][] floor;
        int floorInterest;
        private int row;
        private int col;

        public Floor(int row, int col) {
            this.row = row;
            this.col = col;
            floor = new Quad[row][col];
        }

        public void add(int i, int j, int s) {
            floor[i][j] = new Quad(s, i, j);
            floorInterest += s;
        }

        private int scoreUp() {
            int result = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i > 0) floor[i][j].left = floor[i - 1][j].skill;
                    if (i < row - 1) floor[i][j].right = floor[i + 1][j].skill;
                    if (j > 0) floor[i][j].top = floor[i][j - 1].skill;
                    if (j < col - 1) floor[i][j].bottom = floor[i][j + 1].skill;
                }
            }
            return result;
        }

        private Floor elimitate() {
            Floor floor2 = cloneFloor();

            int e = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Quad quad = floor[i][j];
                    if (quad.skill > 0 && quad.lessThanAvg(row,col)) {
                        e++;
                        floor2.kill(i, j);
                    }
                }
            }
            return e > 0 ? floor2 : null;
        }

        private void kill(int i, int j) {
            Quad quad = floor[i][j];
            floorInterest -= quad.skill;
            quad.skill = 0;

            { // the skill on my left, goes to my neigbor on right
                Quad quadR = get(quad.rightI, j);
                if (quadR != null) {
                    quadR.left = quad.left;
                    quadR.leftI = quad.leftI;
                }
            }
            {
                Quad quadL = get(quad.leftI, j);
                if (quadL != null) {
                    quadL.right = quad.right;
                    quadL.rightI = quad.rightI;
                }
            }
            {
                Quad quadT = get(i, quad.topJ);
                if (quadT != null) {
                    quadT.bottom = quad.bottom;
                    quadT.bottomJ = quad.bottomJ;
                }
            }
            {
                Quad quadB = get(i, quad.bottomJ);
                if (quadB != null) {
                    quadB.top = quad.top;
                    quadB.topJ = quad.topJ;
                }
            }
        }

        private Quad get(int i, int j) {
            if (i >= 0 && i < row && j >= 0 && j < col) {
                return floor[i][j];
            }
            return null;
        }

        private Floor cloneFloor() {
            Floor floor2 = new Floor(row, col);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    floor2.floor[i][j] = floor[i][j].cloneQuad();
                }
            }
            floor2.floorInterest = floorInterest;
            return floor2;
        }
    }

    public static class Quad {
        int top;
        int left;
        int right;
        int bottom;
        int topJ;
        int leftI;
        int rightI;
        int bottomJ;
        int skill;
        final int i;
        final int j;

        public Quad(int s, int i, int j) {
            skill = s;
            this.i = i;
            this.j = j;
            leftI = i - 1;
            rightI = i + 1;
            topJ = j - 1;
            bottomJ = j + 1;
        }

        public boolean lessThanAvg(int r, int c) {
            int competitorCount = 0;
            if(leftI >= 0) competitorCount++;
            if(rightI < r) competitorCount++;
            if(topJ >= 0) competitorCount++;
            if(bottomJ < c) competitorCount++;

            return skill * competitorCount < (left + top + bottom + right);
        }

        public Quad cloneQuad() {
            Quad quad = new Quad(skill, i, j);
            quad.top = top;
            quad.bottom = bottom;
            quad.right = right;
            quad.left = left;
            quad.topJ = topJ;
            quad.bottomJ = bottomJ;
            quad.rightI = rightI;
            quad.leftI = leftI;
            return quad;
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
