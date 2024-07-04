import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int cases = sc.nextInt();

        for (int t = 1; t <= cases; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[] x = new int[n];
            int[] tmp = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }

            for (int i = 1; i < n; i++) {
                x[i] -= x[0];
            }

            x[0] = 0;

            for (int i = 0; i < n; i++) {
                tmp[i] = sc.nextInt();
            }

            Range[] ranges = new Range[n];

            for (int i = 0; i < n - 1; i++) {
                ranges[i] = new Range(x[i], x[i + 1]);
            }

            ranges[n - 1] = new Range(x[n - 1], k);

            int[] reach = new int[n];

            for (int i = 0; i < n; i++) {
                Range currentRange = ranges[i];
                reach[i] = 0;

                for (int j = i + 1; j <= i + n; j++) {
                    Range checkRange;

                    if (j >= n) {
                        checkRange = ranges[j - n].slide(k);
                    } else {
                        checkRange = ranges[j];
                    }

                    currentRange = currentRange.flip(checkRange.start).intersect(checkRange);

                    if (currentRange.isEmpty()) {
                        break;
                    } else {
                        reach[i] = j - i;
                    }
                }
            }

            Range overallRange = ranges[0];
            for (int i = 1; i <= 3 * n; i++) {
                Range checkRange = ranges[i % n].slide(k * (i / n));
                overallRange = overallRange.flip(checkRange.start).intersect(checkRange);
            }

            boolean single = !overallRange.isEmpty();

            if (single) {
                pw.printf("Case #%d: %d\n", t, n);
            } else {
                int best = 2 * n;
                int[] dp = new int[2 * n];

                for (int i = 0; i < n; i++) {
                    Arrays.fill(dp, 2 * n);
                    dp[i] = 0;

                    for (int j = i; j < i + n; j++) {
                        for (int l = 1; l <= reach[j % n] && j + l <= i + n; l++) {
                            dp[j + l] = Math.min(dp[j + l], dp[j] + 1);
                        }
                    }

                    best = Math.min(best, dp[i + n]);
                }

                pw.printf("Case #%d: %d\n", t, n + best);
            }
        }

        pw.close();
        sc.close();
    }

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = Math.max(end, start);
        }

        public Range flip(int x) {
            return new Range(2 * x - end, 2 * x - start);
        }

        public Range slide(int x) {
            return new Range(start + x, end + x);
        }

        public Range intersect(Range other) {
            return new Range(Math.max(start, other.start), Math.min(end, other.end));
        }

        public boolean isEmpty() {
            return start == end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Range range = (Range) obj;
            return start == range.start && end == range.end;
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws Exception {
            return br.readLine();
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine(), " ");
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(nextToken());
        }

        public void close() throws Exception {
            br.close();
        }
    }

    public static void debug(Object obj) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.out.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.out.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.out.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.out.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.out.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.out.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.out.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.out.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.out.print(obj);
            }
            System.out.print(" ");
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.out.print("#");
            for (Object arg : args) {
                debug(arg);
            }
            System.out.println();
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.print(String.format("%3d ", cell));
                }
                System.out.println();
            }
        }
    }
}

interface Suspended {
    Object eval();
}