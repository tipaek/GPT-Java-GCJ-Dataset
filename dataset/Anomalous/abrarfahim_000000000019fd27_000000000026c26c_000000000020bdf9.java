import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Interval(start, end));
            }

            StringBuilder schedule = new StringBuilder();
            ArrayList<Interval> jIntervals = new ArrayList<>();
            ArrayList<Interval> cIntervals = new ArrayList<>();

            cIntervals.add(intervals.get(0));
            schedule.append("C");
            intervals.remove(0);

            boolean isImpossible = false;

            for (Interval interval : intervals) {
                boolean jOverlap = hasOverlap(jIntervals, interval);
                boolean cOverlap = hasOverlap(cIntervals, interval);

                if (!jOverlap) {
                    jIntervals.add(interval);
                    schedule.append("J");
                } else if (!cOverlap) {
                    cIntervals.add(interval);
                    schedule.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static boolean hasOverlap(ArrayList<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if ((interval.start > newInterval.start && interval.start < newInterval.end) ||
                (interval.end > newInterval.start && interval.end < newInterval.end) ||
                (interval.start <= newInterval.start && interval.end >= newInterval.end)) {
                return true;
            }
        }
        return false;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}