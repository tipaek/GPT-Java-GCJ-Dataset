import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            long t1 = in.nextLong();
            long t2 = in.nextLong();
            System.out.println("Case #" + i + ": " + tasks(new Point(t1,t2,"")));
        }
    }

    private static String tasks(Point p) {

        Set<Point> all=new HashSet<>();

        all.add(new Point(0,0,""));
        long max=Math.max(Math.abs(p.x),Math.abs(p.y));
        double stop=Math.pow(2,max);

        if((p.x+p.y)==0)  return "IMPOSSIBLE";

        long step=1;
        while(all.size()<10000){
            Set<Point> moreOption=new HashSet<>();
            for(Point point:all){
                moreOption.add(new Point(point.x+step,point.y,new StringBuilder(point.direction).append("E").toString()));
                moreOption.add(new Point(point.x-step,point.y,new StringBuilder(point.direction).append("W").toString()));
                moreOption.add(new Point(point.x,point.y+step,new StringBuilder(point.direction).append("N").toString()));
                moreOption.add(new Point(point.x,point.y-step,new StringBuilder(point.direction).append("S").toString()));
            }


            if(moreOption.contains(p)){
                Iterator<Point>  itr=moreOption.iterator();
                while(itr.hasNext())
                {
                    Point sol=itr.next();
                    if(sol.equals(p)){
                        return sol.direction;
                    }
                }
            }
            Iterator<Point>  itr=moreOption.iterator();
            while(itr.hasNext())
            {
                Point sol=itr.next();

                if(sol.x%2==0&&sol.y%2==0){
                    itr.remove();
                }
            }
            all.addAll(moreOption);

            step=step*2;

        }

        return "IMPOSSIBLE";
    }


    static class Point {
        final long x;
        final long y;
        final String direction;

        public Point(long x, long y,String direction) {
            this.x = x;
            this.y = y;
            this.direction=direction;
        }

        public String getDirection() {
            return direction;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
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
            return "Point{" +
                    "start=" + x +
                    ", end=" + y +
                    '}';
        }
    }



}
