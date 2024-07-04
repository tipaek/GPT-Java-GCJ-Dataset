import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        in.nextLine();
        for(int id = 1; id <= t; id++) {
            solution(in, id);
        }
    }

    private static void solution(Scanner in, int id) {
        int x = in.nextInt();
        int y = in.nextInt();

        Point result = solve(x, y);
        if(result == null) {
            System.out.println("Case #" + id + ": IMPOSSIBLE");
        }else{
            System.out.println("Case #" + id + ": " + result.dir);
        }
    }

    private static Point solve(int x, int y) {
        HashSet<Point> points = new HashSet<>();
        points.add(new Point(0, 0, ""));
        Point target = new Point(x, y, "");

        int dist = 1;
        while(true) {
            HashSet<Point> new_points = new HashSet<>();
            for(Point point : points) {
                if(
                        Math.floorMod(point.x, dist) == Math.floorMod(x, dist)
                        && Math.floorMod(point.y, dist) == Math.floorMod(y, dist)) {
                    new_points.add(new Point(point.x + dist, point.y, point.dir + "E"));
                    new_points.add(new Point(point.x - dist, point.y, point.dir + "W"));
                    new_points.add(new Point(point.x, point.y + dist, point.dir + "N"));
                    new_points.add(new Point(point.x, point.y - dist, point.dir + "S"));
                }
            }
            if(new_points.isEmpty()) return null;
            if(new_points.contains(target)) {
                for(Point point : new_points) {
                    if(point.equals(target)) {
                        return point;
                    }
                }
            }
//            System.out.println(new_points.size());
//            System.out.println(Arrays.toString(new_points.toArray()));
            points = new_points;
            dist *= 2;
        }
    }
}

class Point {
    int x;
    int y;
    String dir;

    public Point(int x, int y, String dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    @Override
    public String toString() {
        return "[" + x + " " + y + "]";
    }
}