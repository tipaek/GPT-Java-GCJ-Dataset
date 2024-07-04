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
            boolean[] result = new boolean[n];
            boolean isImpossible = false;
            ArrayList<Interval> activeIntervals = new ArrayList<>();
            for (int j = 0; j < 2 * n; j++) {
                Point currentPoint = points[j];
                Interval currentInterval = intervals[currentPoint.index];
                if (activeIntervals.contains(currentInterval)) {
                    activeIntervals.remove(currentInterval);
                } else {
                    currentInterval.isAssignedToJ = false;
                    int countJ = 0;
                    int countC = 0;
                    for (Interval interval : activeIntervals) {
                        if (currentPoint.compareTo(interval.end) < 0) {
                            if (interval.isAssignedToJ) {
                                countJ++;
                            } else {
                                countC++;
                            }
                        }
                    }
                    if (countJ > 0 && countC > 0) {
                        isImpossible = true;
                    } else if (countJ > 0) {
                        currentInterval.isAssignedToJ = true;
                    }
                    activeIntervals.add(currentInterval);
                }
            }
            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                for (Interval interval : intervals) {
                    schedule.append(interval.isAssignedToJ ? "J" : "C");
                }
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }
}

class Interval {
    Point start, end;
    boolean isAssignedToJ;

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