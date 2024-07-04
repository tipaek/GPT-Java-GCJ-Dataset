import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            Point[] points = new Point[2 * n];
            for (int i = 0; i < n; i++) {
                points[2 * i] = new Point(scanner.nextInt(), i, 1);
                points[2 * i + 1] = new Point(scanner.nextInt(), i, -1);
            }
            Arrays.sort(points, (p1, p2) -> {
                if (p1.number == p2.number) {
                    return p1.type - p2.type;
                }
                return p1.number - p2.number;
            });

            char[] schedule = new char[n];
            boolean impossible = false;
            int balance = 0;
            boolean[] active = new boolean[2];
            for (Point point : points) {
                balance += point.type;
                if (balance >= 3) {
                    impossible = true;
                }
                if (point.type == -1) {
                    if (schedule[point.index] == 'C') {
                        active[0] = false;
                    } else {
                        active[1] = false;
                    }
                }
                if (balance > 0 && point.type == 1) {
                    if (!active[0]) {
                        schedule[point.index] = 'C';
                        active[0] = true;
                    } else {
                        schedule[point.index] = 'J';
                        active[1] = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (q + 1) + ": " + new String(schedule));
            }
        }
    }

    static class Point {
        int number;
        int index;
        int type;

        Point(int number, int index, int type) {
            this.number = number;
            this.index = index;
            this.type = type;
        }
    }
}