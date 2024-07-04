import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static long limit = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String res = findPath(x, y);

            System.out.println("Case #" + caseNum + ": " + res);
        }
    }
    static class Point {
        long x;
        long y;
        public Point(long x, long y){
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
    static class Parent {
        Point p;
        String direction;
        Parent(Point p, String d){
            this.p = p;
            this.direction = d;
        }
    }
    private static List<Parent> neigbs(Point p, int step, int tx, int ty) {
        final int txp = tx < 0 ? -tx : tx;
        final int typ = ty < 0 ? - ty: ty;
        return Stream.of(new Parent(new Point(p.x-step, p.y),"W"), new Parent(new Point(p.x + step, p.y), "E"),
                new Parent(new Point(p.x, p.y-step), "N"), new Parent(new Point(p.x, p.y + step), "S"))
                .filter(k -> k.p.x >= -txp && k.p.x <= txp && k.p.y >=-typ && k.p.y <= typ)
                .collect(Collectors.toList());
    }

    private static String findPath(int x, int y) {
//        if(x < 0) return findPath(-x, y);
//        if(y < 0) return findPath(x, - y);
        Point start = new Point(0, 0);
        Point target = new Point(x, y);
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(start);
        Set<Point> visited = new HashSet<>();
        visited.add(start);
        Map<Point, Parent> parents = new HashMap<>();
        int step = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i<n; i++){
                Point current = queue.poll();
                if(current.equals(target)){
                    return reconstruct(current, parents, start);
                } else {
                    for(Parent p: neigbs(current, 1 << step, x, y)){
                        if(!visited.contains(p.p)){
                            visited.add(p.p);
                            queue.offer(p.p);
                            parents.put(p.p, new Parent(current, p.direction));
                        }
                    }
                }
            }
            step++;

        }


        return "IMPOSSIBLE";
    }

     static String reconstruct(Point current, Map<Point, Parent> parents, Point start) {
        StringBuilder sb = new StringBuilder();
        while(!current.equals(start)){
            Parent pp = parents.get(current);
            sb.append(pp.direction);
            current = pp.p;
        }
//        sb.reverse();
        return sb.toString();

    }
}
