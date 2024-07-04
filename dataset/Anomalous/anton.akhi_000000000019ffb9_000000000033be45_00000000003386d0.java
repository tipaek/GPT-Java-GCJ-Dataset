import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private long gcd(long x, long y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (y > 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    private class Point {
        long x, y;
        Point start, end, next, prev;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        Point(long x, long y, Point start, Point end) {
            this.x = x;
            this.y = y;
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return (int) (x * 997 + y);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;
        }

        long distanceTo(Point p) {
            return (p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y);
        }
    }

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            int n = nextInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(nextInt(), nextInt());
            }
            Map<Point, List<Point>> directions = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long dx = points[j].x - points[i].x;
                    long dy = points[j].y - points[i].y;
                    long gcd = gcd(dx, dy);
                    Point direction = new Point(dx / gcd, dy / gcd, points[i], points[j]);
                    directions.computeIfAbsent(direction, k -> new ArrayList<>()).add(direction);
                    direction = new Point(-dx / gcd, -dy / gcd, points[j], points[i]);
                    directions.computeIfAbsent(direction, k -> new ArrayList<>()).add(direction);
                }
            }

            int best = 1;
            for (Point prime : directions.keySet()) {
                for (Point point : points) {
                    point.prev = null;
                    point.next = null;
                }
                for (Point direction : directions.get(prime)) {
                    if (direction.start.next == null || direction.start.distanceTo(direction.start.next) > direction.start.distanceTo(direction.end)) {
                        direction.start.next = direction.end;
                    }
                }
                for (Point point : points) {
                    if (point.next != null) {
                        point.next.prev = point;
                    }
                }
                int ans = 0, ones = 0, odds = 0;
                for (Point point : points) {
                    if (point.prev != null) continue;
                    int length = 0;
                    Point current = point;
                    while (current != null) {
                        current = current.next;
                        length++;
                    }
                    if (length > 1) {
                        ans += length;
                        if (length % 2 == 1) odds++;
                    } else {
                        ones++;
                    }
                }
                ans += Math.min(ones, odds % 2 == 0 ? 2 : 1);
                best = Math.max(best, ans);
            }
            out.println(best);
        }
    }
}