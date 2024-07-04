import java.util.*;

class Point {
    private int x, y, t;

    public Point(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getT() {
        return t;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return String.format("Point:[x:%d, y:%d, t:%d]", x, y, t);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y && t == point.t;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, t);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i1 = 1; i1 <= t; i1++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String m = sc.next();
            Point startPoint = new Point(x, y, -1);

            List<Point> points = new ArrayList<>();
            points.add(startPoint);

            for (int i = 0; i < m.length(); i++) {
                char direction = m.charAt(i);
                if (direction == 'N') y++;
                else if (direction == 'S') y--;
                else if (direction == 'E') x++;
                else if (direction == 'W') x--;

                points.add(new Point(x, y, i + 1));
            }

            x = points.get(0).getX();
            y = points.get(0).getY();
            points.remove(0);

            int x1 = 0, y1 = 0;
            List<Point> targetPoints = new ArrayList<>();
            boolean moveHorizontally = y >= x;

            for (int i = 0; i < points.size(); i++) {
                if (moveHorizontally) {
                    if (x1 == x) moveHorizontally = false;
                    else x1++;
                } else {
                    if (y1 == y) moveHorizontally = true;
                    else y1++;
                }
                targetPoints.add(new Point(x1, y1, i + 1));
            }

            points.retainAll(targetPoints);

            if (points.isEmpty()) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i1);
            } else {
                System.out.printf("Case #%d: %d%n", i1, points.get(0).getT());
            }
        }
    }
}