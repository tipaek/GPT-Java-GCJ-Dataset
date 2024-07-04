import java.util.*;

public class Solution {
    public static void main(String[] args) {

        String exampleString = "5\n" +
                "2\n" +
                "0 0\n" +
                "5 5\n" +
                "3\n" +
                "0 0\n" +
                "5 5\n" +
                "5 0\n" +
                "5\n" +
                "0 0\n" +
                "5 5\n" +
                "5 0\n" +
                "3 2\n" +
                "2 4\n" +
                "7\n" +
                "0 0\n" +
                "1 1\n" +
                "2 1\n" +
                "3 1\n" +
                "8 2\n" +
                "11 2\n" +
                "14 2\n" +
                "1\n" +
                "-1000000000 1000000000\n";
        Scanner in = new Scanner(System.in);
        //in = new Scanner(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));

        int cases = in.nextInt();
        cases:
        for (int i = 1; i <= cases; i++) {
            solve(in, i);
        }

    }

    public static void solve(Scanner in, int caseNumber) {
        int n = in.nextInt();
        Map<String, Set<Point>> slopes = new HashMap<>();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = in.nextInt() + 1000000000;
            points[i][1] = in.nextInt() + 1000000000;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int gcd = gcd(dx, dy);
                String slope = (dx / gcd) + "/" + (dy / gcd);
                if (!slopes.containsKey(slope)) {
                    slopes.put(slope, new HashSet<>());
                }
                Set<Point> pointsInSlope = slopes.get(slope);
                pointsInSlope.add(new Point(points[i][0], points[i][1]));
                pointsInSlope.add(new Point(points[j][0], points[j][1]));
                max = Math.max(max, pointsInSlope.size());
            }
        }
        max += (max % 2 == 0 ? Math.min(2, n - max) : Math.min(1, n - max));
        System.out.printf("Case #%d: %d", caseNumber, max);
        System.out.println();


    }

    private static int gcd(int dx, int dy) {
        if (dy == 0) return dx;
        return gcd(dy, dx % dy);
    }

    private static void printImpossible(int caseNumber) {
        System.out.printf("Case #%d: %s", caseNumber, "IMPOSSIBLE");
        System.out.println();
    }

    private static class Point {
        public int x;
        public int y;

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
    }
}
