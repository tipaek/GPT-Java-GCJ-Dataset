import java.io.*;
import java.util.*;
import java.math.BigInteger;

import static java.lang.Math.*;

public class Solution {

    private static final int LIMIT = 1_000_000_000;
    private final Random random = new Random();
    private final int m = 10;
    private final long[][] delta = new long[(2 * m + 1) * (2 * m + 1)][];

    static class TheEnd extends Exception {
        final boolean wa;

        public TheEnd(boolean wa) {
            this.wa = wa;
        }
    }

    private boolean hit(Interactor interactor, long x, long y) throws TheEnd {
        if (abs(x) > LIMIT || abs(y) > LIMIT) {
            return false;
        }
        interactor.print(x + " " + y);
        interactor.println();
        interactor.flush();

        String result = interactor.next();
        switch (result) {
            case "CENTER":
                throw new TheEnd(false);
            case "HIT":
                return true;
            case "MISS":
                return false;
            case "WRONG":
                throw new TheEnd(true);
            default:
                throw new IllegalStateException(result);
        }
    }

    private long binarySearch(Interactor interactor, long x, long y, boolean isHorizontal, boolean isPositive) throws TheEnd {
        long l = isPositive ? x : -LIMIT;
        long r = isPositive ? LIMIT : x;

        if (hit(interactor, isHorizontal ? r : x, isHorizontal ? y : r)) {
            return r;
        }
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (hit(interactor, isHorizontal ? mid : x, isHorizontal ? y : mid)) {
                if (isPositive) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                if (isPositive) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        return isPositive ? l : r;
    }

    private void solve(Interactor interactor, long min, long max) throws TheEnd {
        long x = 0, y = 0;

        while (!hit(interactor, x, y)) {
            x = random.nextInt(2 * LIMIT) - LIMIT;
            y = random.nextInt(2 * LIMIT) - LIMIT;
        }

        long lx = binarySearch(interactor, x, y, true, false);
        long rx = binarySearch(interactor, x, y, true, true);
        x = (lx + rx) / 2;

        long dy = binarySearch(interactor, x, y, false, false);
        long uy = binarySearch(interactor, x, y, false, true);
        y = (dy + uy) / 2;

        lx = binarySearch(interactor, x, y, true, false);
        rx = binarySearch(interactor, x, y, true, true);
        x = (lx + rx) / 2;

        for (long[] point : delta) {
            hit(interactor, x + point[0], y + point[1]);
        }
    }

    private void initializeDelta() {
        int index = 0;
        for (long dx = -m; dx <= m; dx++) {
            for (long dy = -m; dy <= m; dy++) {
                delta[index++] = new long[]{dx, dy};
            }
        }
        Arrays.sort(delta, Comparator.comparingLong(point -> abs(point[0] * point[0] + point[1] * point[1])));
    }

    public void run(Interactor interactor) {
        initializeDelta();
        int tests = interactor.nextInt();
        long min = interactor.nextInt();
        long max = interactor.nextInt();

        for (int test = 1; test <= tests; test++) {
            try {
                solve(interactor, min, max);
            } catch (TheEnd e) {
                if (e.wa) {
                    return;
                }
            }
        }
    }

    static class Interactor extends PrintWriter {
        private final BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public Interactor(InputStream inputStream, OutputStream outputStream) {
            super(outputStream);
            this.reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        @Override
        public void close() {
            super.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        String next() {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (Interactor interactor = new Interactor(System.in, System.out)) {
            new Solution().run(interactor);
        }
    }
}