import java.util.*;
import java.io.*;
import java.util.function.Function;

import static java.lang.Math.*;

public class Solution {
    private static final long LINF = Long.MAX_VALUE / 4;
    private static final long IING = Integer.MAX_VALUE / 4;
    private static final FastScanner sc = new FastScanner();
    private static final int CENTER = 1;
    private static final int HIT = 0;
    private static final int MISS = -1;
    private static final int WRONG = -2;
    private static final long BIG_TEN = 1_000_000_000L;
    private static final long UPPER_BOUNDARY = BIG_TEN;
    private static final long LOWER_BOUNDARY = -BIG_TEN;
    private static final int TERMINATE_EARLY = 3;
    private static final int CONTINUE = 4;
    private static final boolean TEST = false;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        long A = sc.nextLong();
        long B = sc.nextLong();
        long p = UPPER_BOUNDARY / 2;
        long n = -p;
        long[][] quadrants = {
            {n, p}, {0, p}, {p, p},
            {n, 0}, {0, 0}, {p, 0},
            {n, n}, {0, n}, {p, n}
        };

        for (int t = 1; t <= T; t++) {
            long[] firstHit = null;
            for (long[] point : quadrants) {
                int guessResult = guess(point);
                if (guessResult == CENTER) {
                    continue;
                }
                if (guessResult == HIT) {
                    firstHit = point;
                    break;
                }
            }
            if (firstHit == null) {
                sad();
            }
            final long[] origin = firstHit;

            Result resPosX = binarySearch(x -> guess(origin[0] + x, origin[1]), 0, UPPER_BOUNDARY - origin[0]);
            if (resPosX.terminateEarly) {
                continue;
            }
            Result resNegX = binarySearch(x -> guess(origin[0] - x, origin[1]), 0, origin[0] - LOWER_BOUNDARY);
            if (resNegX.terminateEarly) {
                continue;
            }
            long xUpper = resPosX.value + origin[0];
            long xLower = origin[0] - resNegX.value;
            final long centerX = (xUpper - xLower) / 2 + xLower;

            Result resPosY = binarySearch(y -> guess(centerX, origin[1] + y), 0, UPPER_BOUNDARY - origin[1]);
            if (resPosY.terminateEarly) {
                continue;
            }
            Result resNegY = binarySearch(y -> guess(centerX, origin[1] - y), 0, origin[1] - LOWER_BOUNDARY);
            if (resNegY.terminateEarly) {
                continue;
            }
            long yUpper = resPosY.value + origin[1];
            long yLower = origin[1] - resNegY.value;
            final long centerY = (yUpper - yLower) / 2 + yLower;
            if (guess(centerX, centerY) != CENTER) {
                sad();
            }
        }
        System.out.print(sb);
        if (TEST) {
            assertCondition(false);
        }
    }

    private static Result binarySearch(Function<Long, Integer> testFunc, long lowerBound, long upperBound) {
        long lower = lowerBound;
        long upper = upperBound;
        while (upper - lower > 1) {
            long mid = (upper - lower) / 2 + lower;
            int guessResult = testFunc.apply(mid);
            if (guessResult == CENTER) {
                return new Result(true, 0);
            }
            if (guessResult == HIT) {
                lower = mid;
            } else {
                upper = mid;
            }
        }
        int guessResult = testFunc.apply(upper);
        if (guessResult == CENTER) {
            return new Result(true, 0);
        }
        if (guessResult == HIT) {
            return new Result(false, upper);
        }
        return new Result(false, lower);
    }

    private static int guess(long x, long y) {
        System.out.println(x + " " + y);
        System.out.flush();
        String response = sc.next();
        switch (response) {
            case "CENTER":
                return CENTER;
            case "HIT":
                return HIT;
            case "MISS":
                return MISS;
            default:
                return WRONG;
        }
    }

    private static int guess(long[] points) {
        return guess(points[0], points[1]);
    }

    private static void sad() {
        System.out.println(":(");
        System.exit(0);
    }

    private static void assertCondition(boolean condition) {
        if (!condition) throw new AssertionError("Assertion Failed");
    }

    private static class Result {
        boolean terminateEarly;
        long value;

        Result(boolean terminateEarly, long value) {
            this.terminateEarly = terminateEarly;
            this.value = value;
        }
    }

    private static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        int[] readIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        long[] readLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }
}