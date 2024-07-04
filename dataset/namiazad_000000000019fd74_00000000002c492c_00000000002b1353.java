import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PascalWalk {
    public static class Point {
        int r;
        int k;

        public Point(int r, int k) {
            this.r = r;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r &&
                    k == point.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, k);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", k=" + k +
                    '}';
        }
    }

    private static long[][] pascal() {
        long[][] p = new long[500][500];
        for (int i = 0; i < 500; i++) {
            p[i][0] = 1;
            p[i][i] = 1;

            for (int v = 1; v < i; v++) {
                p[i][v] = p[i-1][v] + p[i-1][v-1];
            }
        }
        return p;
    }

    private static List<Point> adjacent(Point p) {
        List<Point> ps = new ArrayList<>();

        if (p.r - 1 >= 0 && p.k - 1 >= 0) {
            ps.add(new Point(p.r - 1, p.k - 1));
        }
        if (p.r - 1 >= 0 && p.k <= p.r - 1) {
            ps.add(new Point(p.r - 1, p.k));
        }
        if (p.k - 1 >= 0) {
            ps.add(new Point(p.r, p.k - 1));
        }
        if (p.k + 1 <= p.r) {
            ps.add(new Point(p.r, p.k + 1));
        }
        if (p.r + 1 < 500) {
            ps.add(new Point(p.r + 1, p.k));
        }
        if (p.r + 1 < 500 && p.k + 1 <= p.r + 1) {
            ps.add(new Point(p.r + 1, p.k + 1));
        }

        return ps;
    }

    private static boolean findInternal(long target, long sum, Point p, ArrayList<Point> result, long[][] pascal) {
        List<Point> ads = adjacent(p);

        for (Point ad : ads) {
            if (result.contains(ad)) {
                continue;
            }
            long newSum = sum + pascal[ad.r][ad.k];

            if (newSum > target) {
                continue;
            }

            if (newSum == target) {
                result.add(ad);
                return true;
            }

            result.add(ad);
            boolean r = findInternal(target, newSum, ad, result, pascal);

            if (r) return true;
            result.remove(result.size() - 1);
        }

        return false;
    }

    private static List<Point> find(int n) {
        long[][] pascal = pascal();

        ArrayList<Point> points = new ArrayList<>();
        Point start = new Point(0, 0);
        points.add(start);

        boolean r = findInternal(n, 1, start, points, pascal);

        return points;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim());
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = Integer.parseInt(in.nextLine().trim());
            List<Point> solution = find(n);
            System.out.println(String.format("Case #%d:", testCase));
            for (Point p : solution) {
                System.out.println(String.format("%d %d", p.r + 1, p.k + 1));
            }
        }
    }
}
