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

            StringBuilder result = new StringBuilder();
            ArrayList<Interval> jIntervals = new ArrayList<>();
            ArrayList<Interval> cIntervals = new ArrayList<>();

            jIntervals.add(intervals.get(0));
            result.append("J");
            intervals.remove(0);

            boolean impossible = false;

            for (Interval interval : intervals) {
                boolean overlapJ = hasOverlap(jIntervals, interval);
                boolean overlapC = hasOverlap(cIntervals, interval);

                if (!overlapJ) {
                    jIntervals.add(interval);
                    result.append("J");
                } else if (!overlapC) {
                    cIntervals.add(interval);
                    result.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            String output = impossible ? "IMPOSSIBLE" : result.toString();
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }

    private static boolean hasOverlap(ArrayList<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if ((interval.start < newInterval.end && interval.end > newInterval.start)) {
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