import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            Point[] points = new Point[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                points[i] = new Point(x, y);
            }

            Set<Point> uniqueSlopes = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    uniqueSlopes.add(calculateSlope(points[i], points[j]));
                }
            }

            int maxPairs = 0;
            for (Point slope : uniqueSlopes) {
                int pairCount = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        if (slope.equals(calculateSlope(points[i], points[j]))) {
                            pairCount++;
                            break;
                        }
                    }
                }
                maxPairs = Math.max(maxPairs, pairCount);
            }

            int result = Math.min(n, Math.max(4, maxPairs + 2));
            writer.println(result);
        }

        writer.close();
    }

    public static Point calculateSlope(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;

        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        }

        boolean isNegative = dy < 0;
        int gcd = isNegative ? gcd(dx, -dy) : gcd(dx, dy);

        return new Point(dx / gcd, dy / gcd);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
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
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}