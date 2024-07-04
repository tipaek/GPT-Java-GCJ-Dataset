import java.util.Scanner;
import java.util.function.IntFunction;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        final int FULL = 1000000000;

        for (int t = 0; t < testCases; t++) {
            if (A >= FULL - 50) {
                int upperBound = findBoundary(-1, 101, scanner, offset -> new Point(0, FULL - offset));
                int lowerBound = findBoundary(-1, 101, scanner, offset -> new Point(0, -FULL + offset));
                int leftBound = findBoundary(-1, 101, scanner, offset -> new Point(-FULL + offset, 0));
                int rightBound = findBoundary(-1, 101, scanner, offset -> new Point(FULL - offset, 0));

                int x = (-FULL + leftBound + FULL - rightBound) / 2;
                int y = (FULL - upperBound + -FULL + lowerBound) / 2;

                if (tryAllPoints(scanner, x, y)) continue;
            } else {
                Point probedPoint = probeInitialPoints(scanner, FULL);
                int upperBound = findBoundary(-1, FULL - probedPoint.y, scanner, offset -> new Point(probedPoint.x, FULL - offset));
                int lowerBound = findBoundary(-1, probedPoint.y + FULL, scanner, offset -> new Point(probedPoint.x, -FULL + offset));
                int leftBound = findBoundary(-1, probedPoint.x + FULL, scanner, offset -> new Point(-FULL + offset, probedPoint.y));
                int rightBound = findBoundary(-1, FULL - probedPoint.x, scanner, offset -> new Point(FULL - offset, probedPoint.y));

                int x = (-FULL + leftBound + FULL - rightBound) / 2;
                int y = (FULL - upperBound + -FULL + lowerBound) / 2;

                if (tryAllPoints(scanner, x, y)) continue;
            }
        }
    }

    private static int findBoundary(int lowerBound, int upperBound, Scanner scanner, IntFunction<Point> toPoint) {
        while (upperBound - lowerBound > 1) {
            int mid = (upperBound - lowerBound) / 2 + lowerBound;
            makeGuess(toPoint.apply(mid));
            switch (readGuess(scanner)) {
                case CENTER:
                    throw new RuntimeException("Unexpected CENTER guess.");
                case HIT:
                    upperBound = mid;
                    break;
                case MISS:
                    lowerBound = mid;
                    break;
                case WRONG:
                    throw new RuntimeException("Unexpected WRONG guess.");
            }
        }
        return upperBound;
    }

    private static boolean tryAllPoints(Scanner scanner, int x, int y) {
        for (int xx = x - 1; xx <= x + 1; xx++) {
            for (int yy = y - 1; yy <= y + 1; yy++) {
                makeGuess(new Point(xx, yy));
                switch (readGuess(scanner)) {
                    case CENTER:
                        return true;
                    case HIT:
                    case MISS:
                        break;
                    case WRONG:
                        throw new RuntimeException("Unexpected WRONG guess.");
                }
            }
        }
        return false;
    }

    private static Point probeInitialPoints(Scanner scanner, int FULL) {
        int probe = FULL / 3;
        Point[] probingPoints = {
            new Point(probe, probe),
            new Point(probe, -probe),
            new Point(-probe, probe),
            new Point(-probe, -probe)
        };

        for (Point probing : probingPoints) {
            makeGuess(probing);
            if (readGuess(scanner) == Guess.HIT) {
                return probing;
            }
        }
        return probingPoints[3]; // Should never reach here logically
    }

    private static void makeGuess(Point point) {
        System.out.println(point.x + " " + point.y);
        System.out.flush();
    }

    private static Guess readGuess(Scanner scanner) {
        return Guess.valueOf(scanner.next());
    }

    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public enum Guess {
        CENTER, HIT, MISS, WRONG;
    }
}