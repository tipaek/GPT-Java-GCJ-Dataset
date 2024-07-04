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
            String res = solve(x, y);
            System.out.println(String.format("Case #%d: %s", t, res));
        }
    }

    private static String solve(long x, long y) {
        if (!isPossible(x, y)) {
            return IMPOSSIBLE;
        }
        Deque<String> moves = new ArrayDeque<>();

        Point p = new Point(x, y);
        long stepsCount = stepsCount(x, y);
        for (long s = stepsCount; s > 0; s--) {
            long len = stepLen(s);
            String move = chooseMove(p, len);
            moves.addFirst(invertMove(move));
            p = move(p, move, len);
        }
        return String.join("", moves);
    }

    private static String chooseMove(Point p, long len) {
        long n = len(move(p, "N", len));
        long w = len(move(p, "W", len));
        long s = len(move(p, "S", len));
        long e = len(move(p, "E", len));
        long min = LongStream.of(n, w, s, e).min().getAsLong();
        if (n == min) {
            return "N";
        } else if (w == min) {
            return "W";
        } else if (s == min) {
            return "S";
        } else if (e == min) {
            return "E";
        } else {
            throw new AssertionError();
        }
    }

    private static String invertMove(String move) {
        switch (move) {
            case "N":
                return "S";
            case "S":
                return "N";
            case "W":
                return "E";
            case "E":
                return "W";
            default:
                throw new AssertionError("Unsupported move: " + move);
        }
    }

    private static long stepLen(long step) {
        return LongMath.exp2(step - 1);
    }

    private static boolean isPossible(long x, long y) {
        return len(x, y) % 2 != 0;
    }

    private static long len(long x, long y) {
        return Math.abs(x) + Math.abs(y);
    }

    private static long len(Point p) {
        return len(p.x, p.y);
    }

    private static long stepsCount(long x, long y) {
        return LongMath.log2Floor(len(x, y)) + 1;
    }

    private static Point move(Point p, String move, long len) {
        switch (move) {
            case "N":
                return new Point(p.x, p.y + len);
            case "W":
                return new Point(p.x - len, p.y);
            case "S":
                return new Point(p.x, p.y - len);
            case "E":
                return new Point(p.x + len, p.y);
            default:
                throw new AssertionError("Unsupported move: " + move);
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

    public static class LongMath {

        public static long log2Floor(long x) {
            return (Long.SIZE - 1) - Long.numberOfLeadingZeros(x);
        }

        public static long exp2(long exp) {
            return (exp < Long.SIZE) ? (1 << exp) : 0;
        }

    }

    public static class FastScanner {

        private final StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        public int nextInt()  {
            try {
                streamTokenizer.nextToken();
                return (int) streamTokenizer.nval;
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
