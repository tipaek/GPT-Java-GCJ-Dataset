import java.util.*;

class Point {
    private int x;
    private int y;
    private int t;

    Point(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getT() {
        return this.t;
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
        return String.format("Point:[x:%d, y:%d, t:%d]", this.x, this.y, this.t);
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

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String moves = sc.next();
            Point startPoint = new Point(x, y, -1);
            List<Point> path = new ArrayList<>();
            path.add(startPoint);

            for (int i = 0; i < moves.length(); i++) {
                char move = moves.charAt(i);
                if (move == 'N') y++;
                else if (move == 'S') y--;
                else if (move == 'E') x++;
                else if (move == 'W') x--;

                Point newPoint = new Point(x, y, i + 1);
                path.add(newPoint);
            }

            x = path.get(0).getX();
            y = path.get(0).getY();
            path.remove(0);

            int x1 = 0, y1 = 0;
            List<Point> targetPath = new ArrayList<>();
            boolean moveHorizontally = y >= x;

            for (int i = 0; i < path.size(); i++) {
                if (moveHorizontally) {
                    if (x1 == x) moveHorizontally = !moveHorizontally;
                    else x1++;
                } else {
                    if (y1 == y) moveHorizontally = !moveHorizontally;
                    else y1++;
                }
                targetPath.add(new Point(x1, y1, i + 1));
            }

            path.retainAll(targetPath);

            System.out.print("Case #" + caseNum + ": ");
            if (path.isEmpty()) {
                System.out.println("IMPOSSIBLE");
            } else {
                int minTime = path.stream().mapToInt(Point::getT).min().orElse(Integer.MAX_VALUE);
                System.out.println(minTime);
            }
        }

        sc.close();
    }
}