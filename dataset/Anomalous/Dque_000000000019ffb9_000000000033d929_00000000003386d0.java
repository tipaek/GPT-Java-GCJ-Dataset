import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int pointCount = Integer.parseInt(reader.readLine());

            Point[] points = new Point[pointCount];
            for (int i = 0; i < pointCount; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                points[i] = new Point(x, y);
            }

            Set<Point> uniqueSlopes = new HashSet<>();

            for (int i = 0; i < pointCount; i++) {
                for (int j = i + 1; j < pointCount; j++) {
                    uniqueSlopes.add(calculateSlope(points[i], points[j]));
                }
            }

            int maxPairs = 0;
            for (Point slope : uniqueSlopes) {
                int pairCount = 0;
                for (int i = 0; i < pointCount; i++) {
                    for (int j = 0; j < pointCount; j++) {
                        if (i == j) continue;
                        if (slope.equals(calculateSlope(points[i], points[j]))) {
                            pairCount++;
                            break;
                        }
                    }
                }
                maxPairs = Math.max(maxPairs, pairCount);
            }

            int result = Math.min(pointCount, Math.max(4, maxPairs + 2));
            writer.println("Case #" + caseNumber + ": " + result);
        }

        writer.close();
    }

    private static Point calculateSlope(Point p1, Point p2) {
        int deltaX = p1.x - p2.x;
        int deltaY = p1.y - p2.y;

        if (deltaX < 0) {
            deltaX *= -1;
            deltaY *= -1;
        } else if (deltaX == 0 && deltaY < 0) {
            deltaY *= -1;
        }

        int gcdValue = deltaY < 0 ? gcd(deltaX, -deltaY) : gcd(deltaX, deltaY);
        return new Point(deltaX / gcdValue, deltaY / gcdValue);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static class Point {
        int x, y;

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
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}