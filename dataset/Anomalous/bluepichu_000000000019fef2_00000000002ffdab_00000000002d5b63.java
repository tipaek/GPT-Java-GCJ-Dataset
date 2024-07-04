import java.io.*;
import java.util.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int cases = sc.nextInt();

        for (int t = 1; t <= cases; t++) {
            Point start = findInitialPoint(pw, sc);

            if (start.center) {
                continue;
            }

            while (true) {
                int lo = start.x;
                int hi = 1_000_000_000;

                while (lo < hi) {
                    int mx = (lo + hi + 1) / 2;
                    debug("hi x", lo, hi, mx);
                    Point p = new Point(mx, start.y);
                    test(p, pw, sc);

                    if (p.center) {
                        continue;
                    } else if (p.hit) {
                        lo = mx;
                    } else {
                        hi = mx - 1;
                    }
                }

                int left = lo;
                lo = -1_000_000_000;
                hi = start.x;

                while (lo < hi) {
                    int mx = (lo + hi - 1) / 2;
                    debug("lo x", lo, hi, mx);
                    Point p = new Point(mx, start.y);
                    test(p, pw, sc);

                    if (p.center) {
                        continue;
                    } else if (p.hit) {
                        hi = mx;
                    } else {
                        lo = mx + 1;
                    }
                }

                int right = lo;

                debug("BS complete:", left, right);
                start = new Point((left + right) / 2, start.y);
                test(start, pw, sc);

                if (start.center) {
                    continue;
                }

                lo = start.y;
                hi = 1_000_000_000;

                while (lo < hi) {
                    int my = (lo + hi + 1) / 2;
                    debug("hi y", lo, hi, my);
                    Point p = new Point(start.x, my);
                    test(p, pw, sc);

                    if (p.center) {
                        continue;
                    } else if (p.hit) {
                        lo = my;
                    } else {
                        hi = my - 1;
                    }
                }

                int top = lo;
                lo = -1_000_000_000;
                hi = start.y;

                while (lo < hi) {
                    int my = (lo + hi - 1) / 2;
                    debug("lo y", lo, hi, my);
                    Point p = new Point(start.x, my);
                    test(p, pw, sc);

                    if (p.center) {
                        continue;
                    } else if (p.hit) {
                        hi = my;
                    } else {
                        lo = my + 1;
                    }
                }

                int bottom = lo;

                debug("BS complete:", top, bottom);
                start = new Point(start.x, (top + bottom) / 2);
                test(start, pw, sc);

                if (start.center) {
                    continue;
                }
            }
        }

        pw.close();
        sc.close();
    }

    static Point findInitialPoint(PrintWriter pw, FastScan sc) throws Exception {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = -750_000_000 + 500_000_000 * i;
                int y = -750_000_000 + 500_000_000 * j;
                Point p = new Point(x, y);
                test(p, pw, sc);
                if (p.hit) {
                    return p;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = -500_000_000 + 500_000_000 * i;
                int y = -500_000_000 + 500_000_000 * j;
                Point p = new Point(x, y);
                test(p, pw, sc);
                if (p.hit) {
                    return p;
                }
            }
        }

        throw new Exception("No initial point found");
    }

    static void test(Point p, PrintWriter pw, FastScan sc) throws Exception {
        debug(">", p.x, p.y);
        pw.printf("%d %d\n", p.x, p.y);
        pw.flush();
        String out = sc.nextLine();
        debug("<", out);

        if (out.equals("HIT")) {
            p.hit = true;
        } else if (out.equals("CENTER")) {
            p.hit = true;
            p.center = true;
        }
    }

    static class Point {
        int x;
        int y;
        boolean hit;
        boolean center;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.hit = false;
            this.center = false;
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.err.print("#");
            for (Object arg : args) {
                System.err.print(arg + " ");
            }
            System.err.println();
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}