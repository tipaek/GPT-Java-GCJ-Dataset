import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int num_activities = in.nextInt();
            int[][] intervals = new int[num_activities][2];
            for (int j = 0; j < num_activities; j++) {
                intervals[j][0] = Integer.valueOf(in.next());
                intervals[j][1] = Integer.valueOf(in.next());
            }

            System.out.print("Case #" + i + ": ");
            String res = find(intervals);
            System.out.println(res);
        }
    }

    public static String find(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        List<Point> l = new ArrayList<>();
        int index = 0;
        for (int[] interval : intervals) {
            l.add(new Point(index, interval[0], 1));
            l.add(new Point(index++, interval[1], 0));
        }
        Collections.sort(l);
        int c = -1;
        int j = -1;
        for (Point p : l) {
            if (p.status == 1) {
                if (c == -1) {
                    p.c = 'C';
                    c = p.index;
                } else if (j == -1) {
                    p.c = 'J';
                    j = p.index;
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (c == p.index) {
                    c = -1;
                }
                if (j == p.index) {
                    j = -1;
                }
            }
        }
        Collections.sort(l, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                return point.index - t1.index;
            }
        });
        for (Point p : l) {
            if (p.status == 1) {
                sb.append(p.c);
            }
        }
        return sb.toString();
    }

    public static class Point implements Comparable<Point>{
        public int index;
        public int time;
        public int status;
        public char c;
        public Point(int index, int time, int status) {
            this.index = index;
            this.time = time;
            this.status = status;
            c = '\u0000';
        }

        @Override
        public int compareTo(Point point) {
            if (this.time == point.time) {
                return this.status - point.status;
            }
            return this.time - point.time;
        }
    }
}