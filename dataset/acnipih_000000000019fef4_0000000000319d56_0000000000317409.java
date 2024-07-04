import java.util.*;

public class Solution {

    static class Point{
        int x;
        int y;

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
    static class Pair {
        Point p;
        int time;

        public Pair(Point p, int time) {
            this.p = p;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String route = in.next();

            String res = solve(x, y, route);

            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

    private static String solve(int x, int y, String route) {
       List<Pair> list = buildRoute(x, y, route);
        int res = Integer.MAX_VALUE;
        for(Pair entry:list){
            Point p = entry.p;
            int time = entry.time;
            int myTime = Math.abs(p.x) + Math.abs(p.y);
            if(myTime <= time){
                res = Math.min(res, time);
            }
        }
        if(res == Integer.MAX_VALUE) return "IMPOSSIBLE";
        return String.valueOf(res);
    }
    private static List<Pair> buildRoute(int startX, int startY, String route) {
        Map<Point, Integer> map = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        int x = startX;
        int y = startY;
        int time = 0;
        list.add(new Pair(new Point(x, y), time));
//        map.put(new Point(x,y), time);
        for(int i = 0; i < route.length(); i++){
            char c = route.charAt(i);
            time++;
            switch (c){
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            list.add(new Pair(new Point(x, y), time));
//            map.put(new Point(x, y), time);
        }
        return list;
    }


    private static int findPeaks(int[] heights) {
        int n = heights.length;
        int res = 0;
        for(int i =1; i < n - 1; i++){
            if(heights[i] > heights[i-1] && heights[i] > heights[i + 1]) res++;
        }
        return res;
    }

}
