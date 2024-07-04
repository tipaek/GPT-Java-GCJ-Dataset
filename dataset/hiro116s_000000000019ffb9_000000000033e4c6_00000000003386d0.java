import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/C1";

    FastScanner in;
    PrintWriter out;

    class Slope {
        final Point p;

        public Slope(Point p) {
            if (p.x == 0) {
                if (p.y > 0) {
                    this.p = new Point(0, 1);
                } else if (p.y < 0) {
                    this.p = new Point(0, -1);
                } else {
                    throw new RuntimeException();
                }
            } else if (p.y == 0) {
                if (p.x > 0) {
                    this.p = new Point(1, 0);
                } else if (p.x < 0) {
                    this.p = new Point(-1, 0);
                } else {
                    throw new RuntimeException();
                }
            } else {
                int ax = Math.abs(p.x);
                int ay = Math.abs(p.y);
                int g = (int) MathUtil.gcd(ax, ay);
                this.p = new Point(p.x / g, p.y / g);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Slope slope = (Slope) o;
            return Objects.equals(p, slope.p);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p);
        }
    }

    class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point sub(Point p) {
            return new Point(x - p.x, y - p.y);
        }

        public long dist2(Point p) {
            long vx = x - p.x;
            long vy = y - p.y;
            return vx * vx + vy * vy;
        }
    }

    class Pair {
        final int a;
        final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public void solve() {
        int T = in.nextInt();
        for (int _times = 1; _times <= T; _times++) {
            int n = in.nextInt();
            if (n >= 8) {
                return;
            }

            Point[] ps = new Point[n];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                ps[i] = new Point(x, y);
            }

            List<Pair[]> allPairs = new ArrayList<>();
            enumeratePairs(n, new HashSet<>(), 0, new Pair[n/2], allPairs);
            Set<Slope> allSlopes = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        allSlopes.add(new Slope(ps[i].sub(ps[j])));
                    }
                }
            }
            int res = 1;
            int[] to = new int[n];
            for (Pair[] pairs : allPairs) {
                Arrays.fill(to, -1);
                for (Pair pair : pairs) {
                    to[pair.a] = pair.b;
                    to[pair.b] = pair.a;
                }
                for (Slope slope : allSlopes) {
                    for (int start = 0; start < n; start++) {
                        if (to[start] == -1) {
                            continue;
                        }

                        Set<Integer> visited = new HashSet<>();
                        visited.add(start);
                        visited.add(to[start]);
                        int cur = to[start];

                        final int MAX_TRIAL = 10;
                        for (int k = 0; k < MAX_TRIAL; k++) {
                            int minId = -1;
                            long minDist = Long.MAX_VALUE;
                            for (int next = 0; next < n; next++) {
                                if (cur == next) continue;

                                Slope curSlope = new Slope(ps[next].sub(ps[cur]));
                                if (slope.equals(curSlope)) {
                                    long ndist = ps[next].dist2(ps[cur]);
                                    if (minDist > ndist) {
                                        minId = next;
                                        minDist = ndist;
                                    }
                                }
                            }
                            if (minId == -1) {
                                break;
                            }
                            visited.add(minId);
                            if (to[minId] == -1) {
                                break;
                            }
                            visited.add(to[minId]);
                            cur = to[minId];
                        }
                        res = Math.max(res, visited.size());
                    }
                }
            }
            System.out.println(GcjUtil.format(_times, res + ""));
        }
    }

    private void enumeratePairs(int n, Set<Integer> used, int at, Pair[] cur, List<Pair[]> store) {
        if (at == cur.length) {
            store.add(Arrays.copyOf(cur, cur.length));
            return;
        }
        for (int a = 0; a < n; a++) {
            if (used.contains(a)) continue;
            for (int b = a + 1; b < n; b++) {
                if (used.contains(b)) continue;

                Set<Integer> newUsed = new HashSet<>(used);
                newUsed.add(a);
                newUsed.add(b);

                cur[at] = new Pair(a, b);
                enumeratePairs(n, newUsed, at + 1, cur, store);
            }
        }
    }

    public void run() {
        if (__FILE_DEBUG_FLAG__ == __t__) {
            try {
                is = new FileInputStream(__DEBUG_FILE_NAME__);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        } else {
            is = System.in;
        }
        in = new FastScanner(is);
        out = new PrintWriter(System.out);

        solve();
    }

    public static void main(final String[] args) {
        new Solution().run();
    }
}

class MathUtil {
    private MathUtil() {
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}

class GcjUtil {
    public static String format(final int x, final String s) {
        return "Case #" + x + ": " + s;
    }
}


class FastScanner {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
        // stream = new FileInputStream(new File("dec.in"));
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = nextInt();

        return array;
    }

    public int[][] nextIntMap(int n, int m) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextIntArray(m);
        }
        return map;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nextLong();

        return array;
    }

    public long[][] nextLongMap(int n, int m) {
        long[][] map = new long[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextLongArray(m);
        }
        return map;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nextDouble();

        return array;
    }

    public double[][] nextDoubleMap(int n, int m) {
        double[][] map = new double[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextDoubleArray(m);
        }
        return map;
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++)
            array[i] = next();

        return array;
    }

    public String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }

    public int[][] nextPackedIntArrays(int packN, int size) {
        int[][] res = new int[packN][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < packN; j++) {
                res[j][i] = nextInt();
            }
        }
        return res;
    }
}
