import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.UncheckedIOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = solve(x, y);
            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }

    private static String solve(int x, int y) {
        if (!isPossible(x, y)) {
            return IMPOSSIBLE;
        }

        Deque<String> moves = new ArrayDeque<>();
        Point point = new Point(x, y);
        int totalSteps = calculateSteps(x, y);

        for (int step = totalSteps; step > 0; step--) {
            int stepLength = calculateStepLength(step);
            String move = determineMove(point, stepLength);
            moves.addFirst(reverseMove(move));
            point = executeMove(point, move, stepLength);
        }

        return String.join("", moves);
    }

    private static String determineMove(Point point, int stepLength) {
        int northDistance = calculateDistance(executeMove(point, "N", stepLength));
        int westDistance = calculateDistance(executeMove(point, "W", stepLength));
        int southDistance = calculateDistance(executeMove(point, "S", stepLength));
        int eastDistance = calculateDistance(executeMove(point, "E", stepLength));

        int minDistance = IntStream.of(northDistance, westDistance, southDistance, eastDistance).min().getAsInt();

        if (northDistance == minDistance) {
            return "N";
        } else if (westDistance == minDistance) {
            return "W";
        } else if (southDistance == minDistance) {
            return "S";
        } else if (eastDistance == minDistance) {
            return "E";
        } else {
            throw new AssertionError("Unexpected condition");
        }
    }

    private static String reverseMove(String move) {
        switch (move) {
            case "N": return "S";
            case "S": return "N";
            case "W": return "E";
            case "E": return "W";
            default: throw new AssertionError("Unsupported move: " + move);
        }
    }

    private static int calculateStepLength(int step) {
        return IntMath.powerOfTwo(step - 1);
    }

    private static boolean isPossible(int x, int y) {
        return calculateDistance(x, y) % 2 != 0;
    }

    private static int calculateDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    private static int calculateDistance(Point point) {
        return calculateDistance(point.x, point.y);
    }

    private static int calculateSteps(int x, int y) {
        return IntMath.logBase2(calculateDistance(x, y)) + 1;
    }

    private static Point executeMove(Point point, String move, int stepLength) {
        switch (move) {
            case "N": return new Point(point.x, point.y + stepLength);
            case "W": return new Point(point.x - stepLength, point.y);
            case "S": return new Point(point.x, point.y - stepLength);
            case "E": return new Point(point.x + stepLength, point.y);
            default: throw new AssertionError("Unsupported move: " + move);
        }
    }

    private static final class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class IntMath {

        public static int logBase2(int x) {
            return (Integer.SIZE - 1) - Integer.numberOfLeadingZeros(x);
        }

        public static int powerOfTwo(int exponent) {
            return (exponent < Integer.SIZE) ? (1 << exponent) : 0;
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

        public int[] nextInts(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}