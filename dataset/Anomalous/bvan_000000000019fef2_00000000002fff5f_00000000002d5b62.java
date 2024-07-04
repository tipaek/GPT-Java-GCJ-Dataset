import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.UncheckedIOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.LongStream;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            String result = findPath(x, y);
            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }

    private static String findPath(long x, long y) {
        if (!canReach(x, y)) {
            return IMPOSSIBLE;
        }
        Deque<String> path = new ArrayDeque<>();
        Point current = new Point(x, y);
        long steps = calculateSteps(x, y);

        for (long step = steps; step > 0; step--) {
            long distance = computeStepLength(step);
            String direction = determineDirection(current, distance);
            path.addFirst(reverseDirection(direction));
            current = movePoint(current, direction, distance);
        }
        return String.join("", path);
    }

    private static String determineDirection(Point point, long distance) {
        long north = calculateDistance(movePoint(point, "N", distance));
        long west = calculateDistance(movePoint(point, "W", distance));
        long south = calculateDistance(movePoint(point, "S", distance));
        long east = calculateDistance(movePoint(point, "E", distance));
        long minDistance = LongStream.of(north, west, south, east).min().getAsLong();

        if (north == minDistance) return "N";
        if (west == minDistance) return "W";
        if (south == minDistance) return "S";
        if (east == minDistance) return "E";
        throw new AssertionError();
    }

    private static String reverseDirection(String direction) {
        switch (direction) {
            case "N": return "S";
            case "S": return "N";
            case "W": return "E";
            case "E": return "W";
            default: throw new AssertionError("Unsupported direction: " + direction);
        }
    }

    private static long computeStepLength(long step) {
        return MathUtils.powerOfTwo(step - 1);
    }

    private static boolean canReach(long x, long y) {
        return calculateDistance(x, y) % 2 != 0;
    }

    private static long calculateDistance(long x, long y) {
        return Math.abs(x) + Math.abs(y);
    }

    private static long calculateDistance(Point point) {
        return calculateDistance(point.x, point.y);
    }

    private static long calculateSteps(long x, long y) {
        return MathUtils.log2(calculateDistance(x, y)) + 1;
    }

    private static Point movePoint(Point point, String direction, long distance) {
        switch (direction) {
            case "N": return new Point(point.x, point.y + distance);
            case "W": return new Point(point.x - distance, point.y);
            case "S": return new Point(point.x, point.y - distance);
            case "E": return new Point(point.x + distance, point.y);
            default: throw new AssertionError("Unsupported direction: " + direction);
        }
    }

    private static final class Point {
        private final long x;
        private final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class MathUtils {

        public static long log2(long x) {
            return (Long.SIZE - 1) - Long.numberOfLeadingZeros(x);
        }

        public static long powerOfTwo(long exponent) {
            return (exponent < Long.SIZE) ? (1L << exponent) : 0;
        }
    }

    public static class FastScanner {

        private final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        public int nextInt() {
            try {
                tokenizer.nextToken();
                return (int) tokenizer.nval;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}