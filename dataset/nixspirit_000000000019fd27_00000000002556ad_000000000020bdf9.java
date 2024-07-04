
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        //   System.out.println("read T=" + t);
        for (int i = 1; i <= t; ++i)
        {
            int n = in.nextInt();
            in.nextLine();
            //   System.out.println("read N=" + n);

            List<Point> points = new ArrayList<>();
            for (int row = 0; row < n; row++)
            {
                String line = in.nextLine();
                // System.out.println("read line=" + line);
                addPoints(points, row, line);
            }
            System.out.println(String.format("Case #%s: %s", i, solve(points)));
        }
    }

    public static String solve(List<Point> points)
    {
        Collections.sort(points);

        char[] result = new char[points.size() / 2];
        Arrays.fill(result, 'C');

        ActivityBalancer balancer = new ActivityBalancer();
        for (Point p : points)
        {
            if (p.start)
            {
                char r = balancer.assign(p);
                if (r == 'I')
                    return "IMPOSSIBLE";

                result[p.order] = r;
            }
            else
                balancer.remove(p);
        }

        return new String(result);
    }

    public static void addPoints(List<Point> points, int order, String interval)
    {
        String[] startAndEnd = interval.split(" ");
        points.add(new Point(order, Integer.parseInt(startAndEnd[0]), true));
        points.add(new Point(order, Integer.parseInt(startAndEnd[1]), false));
    }

    public static class ActivityBalancer
    {

        public char assign(Point p)
        {
            if (C != -1 && J != -1)
                return 'I';

            if (C == -1)
            {
                C = p.order;
                return 'C';
            }

            J = p.order;
            return 'J';
        }

        public void remove(Point p)
        {
            if (C == p.order)
                C = -1;

            else
                J = -1;
        }

        private int C = -1;
        private int J = -1;
    }

    public static class Point implements Comparable<Point>
    {
        @Override
        public int compareTo(Point o)
        {
            if (time == o.time)
            {
                if (start == o.start)
                    return 0;
                else
                    return start ? 1 : -1;
            }
            return time > o.time ? 1 : -1;
        }

        public Point(int order, int time, boolean isStart)
        {
            this.order = order;
            this.time = time;
            this.start = isStart;
        }

        public boolean start;
        public int order;
        public int time;

        @Override
        public String toString()
        {
            return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                    .add("start=" + start)
                    .add("order=" + order)
                    .add("time=" + time)
                    .toString();
        }
    }
}
