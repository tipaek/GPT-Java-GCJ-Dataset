import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }

            StringBuilder result = new StringBuilder();
            ArrayList<Interval> jIntervals = new ArrayList<>();
            ArrayList<Interval> cIntervals = new ArrayList<>();

            jIntervals.add(intervals.get(0));
            result.append("J");
            cIntervals.add(intervals.get(1));
            result.append("C");

            intervals.remove(0);
            intervals.remove(0);
            boolean isImpossible = false;

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
                    isImpossible = true;
                    break;
                }
            }

            String output = isImpossible ? "IMPOSSIBLE" : result.toString();
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }

    private static boolean hasOverlap(ArrayList<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if ((interval.start > newInterval.start && interval.start < newInterval.end) ||
                (interval.end > newInterval.start && interval.end < newInterval.end) ||
                (interval.start < newInterval.start && interval.end > newInterval.end)) {
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