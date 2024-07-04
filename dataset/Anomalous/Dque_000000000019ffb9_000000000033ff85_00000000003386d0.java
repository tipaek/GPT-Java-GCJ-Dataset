import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Point[] points = new Point[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            HashSet<Point> slopes = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        slopes.add(calculateSlope(points[i], points[j]));
                    }
                }
            }

            int maxPairCount = 0;
            for (Point slope : slopes) {
                int pairCount = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i != j && slope.equals(calculateSlope(points[i], points[j]))) {
                            pairCount++;
                            break;
                        }
                    }
                }
                maxPairCount = Math.max(maxPairCount, pairCount);
            }

            int result = Math.min(n, maxPairCount + 2);
            writer.println("Case #" + t + ": " + result);
        }

        writer.close();
    }

    private static Point calculateSlope(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;

        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        } else if (dx == 0 && dy < 0) {
            dy = -dy;
        }

        int gcdValue = gcd(dx, dy);
        return new Point(dx / gcdValue, dy / gcdValue);
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return x + "?" + y;
        }
    }
}