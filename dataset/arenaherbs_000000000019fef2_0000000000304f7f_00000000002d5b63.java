import java.util.*;
import java.io.*;
import java.util.function.Function;

import static java.lang.Math.*;

public class Solution {
    static long LINF = Long.MAX_VALUE / 4;
    static long IING = Integer.MAX_VALUE / 4;
    static FastScanner sc = new FastScanner();
    static final int CENTER = 1;
    static final int HIT = 0;
    static final int MISS = -1;
    static final int WRONG = -2;
    static final long bigten = 1_000_000_000L;
    static final long upperBoundary = bigten;
    static final long lowerBoundary = upperBoundary * -1;

    static final int TERMINATEEARLY = 3;
    static final int CONTINUE = 4;
    static final boolean TEST = false;

    public static void main(String[] args) {
//        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        long A = sc.nextLong();
        long B = sc.nextLong();
        long p = upperBoundary/2;
        long n = -p;
        long[][] quadrants = new long[][] {
                {n, p}, {0, p}, {p, p},
                {n, 0}, {0, 0}, {p, 0},
                {n, n}, {0, n}, {p, n}};
        testcase:
        for (int t = 1; t <= T; t++) {
            long[] firsthit = null;
            for (long[] point : quadrants) {
                int guess = guess(point);
                if (guess == CENTER) {
                    continue testcase;
                }
                if (guess == HIT) {
                    firsthit = point;
                    break;
                }
            }
            if (firsthit == null) {
                sad();
            }
            final long[] origin = firsthit;
            //// Do 4 binary searches.
            Function<Long, Integer> horizontalpos = x -> {
                return guess(origin[0] + x, origin[1]);
            };
            Function<Long, Integer> horizontalneg = x -> {
                return guess(origin[0] - x, origin[1]);
            };
            // REMEMBER TO ACCOUNT FOR ENDING EARLY!!!
            Result resPosX = binarySearch(horizontalpos, 0, upperBoundary - origin[0]);
            if (resPosX.terminateEarly) {
                continue testcase;
            }
            if (TEST) {
                System.err.println("POS X BOUNDARY = " + resPosX.value);
            }
            Result resNegX = binarySearch(horizontalneg, 0,  origin[0] - lowerBoundary);
            if (resNegX.terminateEarly) {
                continue testcase;
            }
            if (TEST) {
                System.err.println("NEG X BOUNDARY = " + resNegX.value);
            }
            long xupper = resPosX.value + origin[0];
            long xlower = origin[0] - resNegX.value;
            final long centerX = (xupper - xlower) / 2 + xlower;
            if (TEST) {
                System.err.println("CENTERX = " + centerX);
            }

            //binarysearch positive direction


            Function<Long, Integer> verticalPos = y -> {
                return guess(centerX, origin[1] + y);
            };
            Function<Long, Integer> verticalNeg = y -> {
                return guess(centerX, origin[1] - y);
            };
            Result resPosY = binarySearch(verticalPos, 0, upperBoundary - origin[1]);
            if (resPosY.terminateEarly) {
                continue testcase;
            }
            Result resNegY = binarySearch(verticalNeg, 0, origin[1] - lowerBoundary);
            if (resNegY.terminateEarly) {
                continue testcase;
            }
            long yupper = resPosY.value + origin[1];
            long ylower = origin[1] - resNegY.value;
            final long centerY = (yupper - ylower) / 2 + ylower;
            if (guess(centerX, centerY) != CENTER) {
                sad();
            }
        }
        System.out.print(sb);
        if (TEST) {
            Assert(false);
        }
    }

    static final Result binarySearch(Function<Long, Integer> testFunc, long lowerBound, long upperBound) {
        // will always be true at lowerBound.
        long lower = lowerBound;
        long upper = upperBound;
        while (upper - lower > 1) {
            long mid = (upper - lower) / 2 + lower;
            if (TEST) {
                System.err.println("mid = " + mid + ", lower = " + lower + ", upper = " + upper);
            }
            int guess = testFunc.apply(mid);
            if (guess == CENTER) {
                return new Result(true, 0);
            }
            if (guess == HIT) {
                lower = mid;
            } else {
                upper = mid;
            }
        }
        if (TEST) {
            System.err.println("lower = " + lower + ", upper = " + upper);
        }
        int guess = testFunc.apply(upper);
        if (guess == CENTER) {
            return new Result(true, 0);
        }
        if (guess == HIT) {
            return new Result(false, upper);
        }
        return new Result(false, lower);
    }

    static class Result {
        boolean terminateEarly;
        long value = 0;
        public Result(boolean _terminate, long _value) {
            terminateEarly = _terminate;
            value = _value;
        }
    }

    static int guess(long x, long y) {
        System.out.println(x + " " + y);
        if (TEST) {
            System.err.println(x + " " + y);
        }
        System.out.flush();
        String in = sc.next();
        if (in.equals("CENTER")) {
            if (TEST) {
                System.err.println("CENTER");
            }
            return CENTER;
        }
        if (in.equals("HIT")) {
            if (TEST) {
                System.err.println("HIT");
            }
            return HIT;
        }
        if (in.equals("MISS")) {
            if (TEST) {
                System.err.println("MISS");
            }
            return MISS;
        }
        if (TEST) {
            System.err.println("WRONG");
        }
        return WRONG;
    }
    static int guess(long[] points) {
        return guess(points[0], points[1]);
    }

    static void sad() {
        System.out.println(":(");
        if (TEST) {
            System.err.println(":(");
        }
        System.exit(0);
    }

    static void Assert(boolean b) {
        if (!b) throw new Error("Assertion Failed");
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
