import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int x = 1;

        while (t-- > 0) {
            x++;
            int[] arr = new int[3];
            int a = nextInt();
            int b = nextInt();

            if (findCoordinate(arr, -1000000000, 0, 0)) continue;
            if (findCoordinate(arr, 0, 1000000000, 1)) continue;

            System.out.println("0 -1");
            System.out.flush();
            String str = next();

            boolean isBottom = true;
            int l, r;

            if (str.equals("HIT")) {
                l = -1000000000;
                r = 0;
            } else if (str.equals("CENTER")) {
                continue;
            } else {
                l = 0;
                r = 1000000000;
                isBottom = false;
            }

            if (findCoordinate(arr, l, r, 2, isBottom)) continue;

            Circle circle = CircleThree.circleFromPoints(
                new Point(arr[0], 0),
                new Point(arr[1], 0),
                new Point(arr[2], 0)
            );

            System.out.println((int) circle.center.x + " " + (int) circle.center.y);
            if (!next().equals("CENTER")) return;
        }
    }

    private static boolean findCoordinate(int[] arr, int l, int r, int index) throws IOException {
        return findCoordinate(arr, l, r, index, true);
    }

    private static boolean findCoordinate(int[] arr, int l, int r, int index, boolean isBottom) throws IOException {
        while (l < r) {
            int m = (l + r) / 2;
            System.out.println(m + " " + (index == 2 ? m : 0));
            System.out.flush();
            String s = next();
            if (s.equals("HIT")) {
                if (index == 2) {
                    if (isBottom) r = m;
                    else l = m;
                } else {
                    r = m;
                }
            } else if (s.equals("CENTER")) {
                return true;
            } else {
                if (index == 2) {
                    if (isBottom) l = m + 1;
                    else r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        arr[index] = l;
        return false;
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}

class CircleThree {
    static final double TOL = 0.0000001;

    public static Circle circleFromPoints(final Point p1, final Point p2, final Point p3) {
        double offset = Math.pow(p2.x, 2) + Math.pow(p2.y, 2);
        double bc = (Math.pow(p1.x, 2) + Math.pow(p1.y, 2) - offset) / 2.0;
        double cd = (offset - Math.pow(p3.x, 2) - Math.pow(p3.y, 2)) / 2.0;
        double det = (p1.x - p2.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p2.y);

        if (Math.abs(det) < TOL) {
            throw new IllegalArgumentException("Points are collinear");
        }

        double idet = 1 / det;
        double centerx = (bc * (p2.y - p3.y) - cd * (p1.y - p2.y)) * idet;
        double centery = (cd * (p1.x - p2.x) - bc * (p2.x - p3.x)) * idet;
        double radius = Math.sqrt(Math.pow(p2.x - centerx, 2) + Math.pow(p2.y - centery, 2));

        return new Circle(new Point(centerx, centery), radius);
    }
}

class Circle {
    final Point center;
    final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Center= " + center + ", r=" + radius;
    }
}

class Point {
    final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}