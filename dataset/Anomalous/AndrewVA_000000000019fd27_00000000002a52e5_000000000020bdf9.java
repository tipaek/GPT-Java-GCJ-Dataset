import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            Point[] points = new Point[2 * n];
            for (int j = 0; j < n; j++) {
                Point start = new Point(sc.nextInt(), j);
                Point end = new Point(sc.nextInt(), j);
                points[2 * j] = start;
                points[2 * j + 1] = end;
                intervals[j] = new Interval(start, end);
            }
            Arrays.sort(points);
            boolean[] schedule = new boolean[n];
            boolean impossible = false;
            List<Interval> activeIntervals = new ArrayList<>();

            for (int j = 0; j < 2 * n; j++) {
                Point current = points[j];
                Interval interval = intervals[current.index];
                if (activeIntervals.contains(interval)) {
                    activeIntervals.remove(interval);
                } else {
                    interval.person = false;
                    int countC = 0;
                    int countJ = 0;
                    for (Interval activeInterval : activeIntervals) {
                        if (current.compareTo(activeInterval.end) < 0) {
                            if (activeInterval.person) {
                                countJ++;
                            } else {
                                countC++;
                            }
                        }
                    }
                    if (countC > 0 && countJ > 0) {
                        impossible = true;
                    } else if (countC > 0) {
                        interval.person = true;
                    }
                    activeIntervals.add(interval);
                }
            }

            if (impossible) {
                System.out.println("Case " + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Interval interval : intervals) {
                    result.append(interval.person ? "J" : "C");
                }
                System.out.println("Case " + i + ": " + result.toString());
            }
        }
    }
}

class Interval {
    Point start, end;
    boolean person;

    public Interval(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}

class Point implements Comparable<Point> {
    int time, index;

    public Point(int time, int index) {
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.time, other.time);
    }
}