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
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String res = solve(x, y);
            System.out.println(String.format("Case #%d: %s", t, res));
        }
    }

    private static String solve(int x, int y) {
        if (!isPossible(x, y)) {
            return IMPOSSIBLE;
        }
        Deque<String> moves = new ArrayDeque<>();

        Point p = new Point(x, y);
        int stepsCount = stepsCount(x, y);
        for (int s = stepsCount; s > 0; s--) {
            int len = stepLen(s);
            String move = chooseMove(p, len);
            moves.addFirst(invertMove(move));
            p = move(p, move, len);
        }
        return String.join("", moves);
    }

    private static String chooseMove(Point p, int len) {
        int n = len(move(p, "N", len));
        int w = len(move(p, "W", len));
        int s = len(move(p, "S", len));
        int e = len(move(p, "E", len));
        int min = IntStream.of(n, w, s, e).min().getAsInt();
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

    private static int stepLen(int step) {
        return IntMath.exp2(step - 1);
    }

    private static boolean isPossible(int x, int y) {
        return len(x, y) % 2 != 0;
    }

    private static int len(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    private static int len(Point p) {
        return len(p.x, p.y);
    }

    private static int stepsCount(int x, int y) {
        return IntMath.log2Floor(len(x, y)) + 1;
    }

    private static Point move(Point p, String move, int len) {
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

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class IntMath {

        public static int log2Floor(int x) {
            return (Integer.SIZE - 1) - Integer.numberOfLeadingZeros(x);
        }

        public static int exp2(int exp) {
            return (exp < Integer.SIZE) ? (1 << exp) : 0;
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

        public int[] nextInts(int size) {
            int[] array = new int[size];
            nextInts(array, 0, size);
            return array;
        }

        public void nextInts(int[] array, int from, int to) {
            for (int i = from; i < to; i++) {
                array[i] = nextInt();
            }
        }
    }
}
