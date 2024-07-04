
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
        final int t = r.nextInt();
        final int a = r.nextInt();
        final int b = r.nextInt();
        for (int i = 1; i <= t; i++)
            solveCase(r, w, a, b);
    }

    static final int LIMIT = 1_000_000_000;
    static final int WIDTH = 2 * LIMIT;
    static final int HALF_LIMIT = LIMIT / 2;

    private static void solveCase(Scanner r, PrintWriter w, int a, int b) {
        int guess = 0;

        int minX = LIMIT;
        int minY = LIMIT;
        int maxX = -LIMIT;
        int maxY = -LIMIT;

        int firstGridPrecision = 5;

        Result[][] grid = new Result[firstGridPrecision][firstGridPrecision];

        int step = WIDTH / (firstGridPrecision - 1);

        for (int i = 0; i < firstGridPrecision; i++) {
            for (int j = 0; j < firstGridPrecision; j++) {
                Coords coords = new Coords(i * step - LIMIT, j * step - LIMIT);
                Result test = test(r, w, coords);
                if (test == Result.CENTER) return;
                grid[i][j] = test;
                if (test == Result.HIT) {
                    if (coords.x < minX) {
                        minX = coords.x;
                    }
                    if (coords.y < minY) {
                        minY = coords.y;
                    }
                    if (coords.x > maxX) {
                        maxX = coords.x;
                    }
                    if (coords.y > maxY) {
                        maxY = coords.y;
                    }
                }
            }
        }

        Coords center = new Coords((minX + maxX) / 2, (minY + maxY) / 2);
        while (true) {
            Result centerR = test(r, w, center);
            if (centerR == Result.CENTER) return;
            Coords ca = new Coords(center.x, LIMIT);
            Coords cb = new Coords(LIMIT, center.y);
            Coords cd = new Coords(center.x, -LIMIT);

            CoordResult edgeA = binarySearch(r, w, center, ca);
            CoordResult edgeB = binarySearch(r, w, center, cb);
            CoordResult edgeD = binarySearch(r, w, center, cd);

            long lya = Math.abs(edgeA.c.y - center.y);
            long lyd = Math.abs(edgeD.c.y - center.y);
            long lxb = Math.abs(edgeB.c.x - center.x);

            long deltaY = (lya - lyd) / 2;
            long averageY = (lya + lyd) / 2;
            long deltaX = lxb - averageY;

            int lx = edgeB.c.x - center.x;

            //if (Math.abs(lx) > Math.abs(ly)) {
            center = new Coords((int) (center.x + deltaX), (int) (center.y + deltaY));
//            } else {
//                center = new Coords(center.x, center.y + deltaY);
//            }
        }

//        Result top = test(r, w, new Coords(HALF_LIMIT, HALF_LIMIT));
//
//        while (guess < 300) {
//            guess++;
//
//
//            binarySearch(r, w, new Coords(0, 0), new Coords(HALF_LIMIT, HALF_LIMIT));
//
//        }
    }

    private static CoordResult binarySearch(Scanner r, PrintWriter w, Coords from, Coords to) {
        Result a = test(r, w, from);
        if (a == Result.CENTER) return new CoordResult(from, a);
        Result b = test(r, w, to);
        if (b == Result.CENTER) return new CoordResult(to, b);

        Coords L = from; //HIT
        Coords R = to; //MISS

        while (L.x != R.x || L.y != R.y) {
            Coords mid = L.average(R);

            Result midTest = test(r, w, mid);
            switch (midTest) {
                case CENTER:
                    return new CoordResult(mid, midTest);
                case HIT:
                    L = mid;
                    break;
                case MISS:
                    R = mid;
                    break;
            }

            if (Math.abs(L.x - R.x) + Math.abs(L.y - R.y) <= 1) {
                return new CoordResult(L, Result.HIT);
            }
        }

        //function binary_search(A, n, T) is
        //    L := 0
        //    R := n − 1
        //    while L ≤ R do
        //        m := floor((L + R) / 2)
        //        if A[m] < T then
        //            L := m + 1
        //        else if A[m] > T then
        //            R := m - 1
        //        else:
        //            return m
        //    return unsuccessful

        return null;
    }

    private static Result test(Scanner r, PrintWriter w, Coords coords) {
        w.println(String.format("%d %d", coords.x, coords.y));
        w.flush();
        String next = r.next();
        if ("MISS".equals(next)) return Result.MISS;
        if ("HIT".equals(next)) return Result.HIT;
        if ("CENTER".equals(next)) return Result.CENTER;
        throw new AssertionError(next);
    }

    static enum Result {
        CENTER,
        HIT,
        MISS
    }

    static class Coords {
        final int x;
        final int y;

        Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Coords average(Coords other) {
            int x = (int) ((this.x + (long) other.x) / 2);
            int y = (int) ((this.y + (long) other.y) / 2);
            return new Coords(x, y);
        }

        @Override
        public String toString() {
            return "Coords{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class CoordResult {
        final Coords c;
        final Result result;

        CoordResult(Coords c, Result result) {
            this.c = c;
            this.result = result;
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

    public interface Case {
        void run(final int c);
    }
}
