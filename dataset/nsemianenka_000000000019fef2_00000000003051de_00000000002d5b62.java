import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; ++t) {
            int tx = in.nextInt();
            int ty = in.nextInt();

            if ((Math.abs(tx) + Math.abs(ty)) % 2 == 0) {
                System.out.println(String.format("Case #%s: IMPOSSIBLE", t));
            } else {
                String path = bfs(tx, ty);
                System.out.println(String.format("Case #%s: %s", t, path));
            }


        }
    }

    public static String bfs(int tx, int ty) {
        int i = 0;
        int j = 1;
        int curr = 0;
        int currj = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        Map<Integer, List<Point>> map = new HashMap<>();

        while(!queue.isEmpty()) {
            LinkedList<Point> next = new LinkedList<>();
            while(!queue.isEmpty()) {
                Point p = queue.poll();
                if (p.x + j == tx && p.y == ty ||
                        p.x - j == tx && p.y == ty ||
                        p.x == tx && p.y + j == ty ||
                        p.x == tx && p.y - j == ty) {
                    curr = i - 1;
                    currj = j;
                    next.clear();
                    break;
                } else {
                    next.add(new Point(p.x + j, p.y));
                    next.add(new Point(p.x - j, p.y));
                    next.add(new Point(p.x, p.y + j));
                    next.add(new Point(p.x, p.y - j));
                }
            }

            List<Point> copy = new ArrayList<>();
            for (Point p: next) {
                copy.add(p);
            }
            map.put(i, copy);
            i += 1;
            j *= 2;
            queue = next;
        }
        //System.out.println(map);

        StringBuilder sb = new StringBuilder();
//        int curr = i - 1;
//        int currj = j / 2;
        List<Point> path = new ArrayList<>();
        Point currPoint = new Point(tx, ty);
        while(curr >= 0) {
            List<Point> points = map.get(curr);
            for (Point p: points) {
                if (p.x + currj == currPoint.x && p.y == currPoint.y ||
                        p.x - currj == currPoint.x && p.y == currPoint.y ||
                        p.x == currPoint.x && p.y + currj == currPoint.y ||
                        p.x == currPoint.x && p.y - currj == currPoint.y) {
                    currPoint = p;
                    path.add(p);
                    break;
                }
            }
            curr -= 1;
            currj /= 2;
        }

        path.add(new Point(0, 0));
        Collections.reverse(path);
        path.add(new Point(tx, ty));

        for (int pi = 1; pi < path.size(); pi++) {
            if (path.get(pi - 1).x == path.get(pi).x) {
                if (path.get(pi - 1).y < path.get(pi).y) {
                    sb.append("N");
                } else {
                    sb.append("S");
                }
            } else {
                if (path.get(pi - 1).x < path.get(pi).x) {
                    sb.append("E");
                } else {
                    sb.append("W");
                }
            }
        }
        return sb.toString();
    }

    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
