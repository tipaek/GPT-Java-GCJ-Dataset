import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        try (PrintWriter pw = new PrintWriter(System.out);
             FastScan sc = new FastScan()) {

            int cases = sc.nextInt();

            for (int t = 1; t <= cases; t++) {
                int n = sc.nextInt();
                Point[] points = new Point[n];

                for (int i = 0; i < n; i++) {
                    points[i] = new Point(sc.nextLong(), sc.nextLong());
                }

                int best = Math.min(n, 4);

                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        long dx = points[j].x - points[i].x;
                        long dy = points[j].y - points[i].y;
                        Point direction = new Point(-dy, dx);

                        Map<Long, Integer> map = new HashMap<>();

                        for (Point point : points) {
                            long value = point.dot(direction);
                            map.put(value, map.getOrDefault(value, 0) + 1);
                        }

                        int[] counts = new int[map.size()];
                        int k = 0;

                        for (int count : map.values()) {
                            counts[k++] = count;
                        }

                        Arrays.sort(counts);

                        if (counts[counts.length - 1] == 3 && counts[counts.length - 2] < 2) {
                            best = Math.max(best, 2 + counts[counts.length - 2] + counts[counts.length - 3]);
                            continue;
                        }

                        int ans = 0;
                        for (k = counts.length - 1; k >= 0; k--) {
                            if (counts[k] < 2) {
                                ans += counts[k] + counts[k - 1];
                                break;
                            } else {
                                ans += counts[k];
                            }
                        }

                        best = Math.max(best, ans);
                    }
                }

                pw.printf("Case #%d: %d%n", t, best);
                pw.flush();
            }
        }
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long dot(Point other) {
            return this.x * other.x + this.y * other.y;
        }
    }

    public static void debug(Object obj, String end) {
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
            System.out.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.out.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.out.println();
        }
    }

    public static void debug(Suspended suspended) {
        if (DEBUG) {
            debug(suspended.eval());
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

    static class FastScan implements AutoCloseable {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}