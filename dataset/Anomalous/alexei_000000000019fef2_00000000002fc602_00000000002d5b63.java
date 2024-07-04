import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        List<Point> points = initializePoints();

        for (int c = 1; c <= T; c++) {
            boolean foundCenter = false;

            for (Point point : points) {
                if (foundCenter) break;

                System.out.println(point.x + " " + point.y);
                String response = scanner.next();

                if (response.equals("CENTER")) {
                    foundCenter = true;
                    break;
                }

                if (response.equals("MISS")) continue;

                int right = binarySearch(point.x, 1000000000, point.y, true, scanner);
                int up = binarySearch(point.y, 1000000000, point.x, false, scanner);
                int left = binarySearch(-1000000000, point.x, point.y, true, scanner);
                int down = binarySearch(-1000000000, point.y, point.x, false, scanner);

                Point center = new Point((right + left) / 2, (up + down) / 2);

                if (checkCenter(center, scanner)) {
                    foundCenter = true;
                    break;
                }
            }
        }
    }

    private static List<Point> initializePoints() {
        List<Point> points = new ArrayList<>();
        int[] coords = {-1000000000, -750000000, -500000000, -250000000, 0, 250000000, 500000000, 750000000, 1000000000};

        for (int x : coords) {
            for (int y : coords) {
                points.add(new Point(x, y));
            }
        }

        return points;
    }

    private static int binarySearch(int from, int to, int fixed, boolean isXFixed, Scanner scanner) {
        while (from + 1 < to) {
            int mid = from + (to - from) / 2;
            if (isXFixed) {
                System.out.println(mid + " " + fixed);
            } else {
                System.out.println(fixed + " " + mid);
            }
            String response = scanner.next();
            if (response.equals("CENTER")) {
                System.exit(0);
            }
            if (response.equals("HIT")) {
                from = mid;
            } else {
                to = mid;
            }
        }
        return from;
    }

    private static boolean checkCenter(Point center, Scanner scanner) {
        int[][] offsets = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 0}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] offset : offsets) {
            System.out.println((center.x + offset[0]) + " " + (center.y + offset[1]));
            if (scanner.next().equals("CENTER")) {
                return true;
            }
        }

        return false;
    }
}