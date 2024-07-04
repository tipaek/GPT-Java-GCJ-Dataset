import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
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
            intervals.remove(0);

            boolean impossible = false;

            for (Interval current : intervals) {
                boolean overlapJ = hasOverlap(current, jIntervals);
                boolean overlapC = hasOverlap(current, cIntervals);

                if (!overlapJ) {
                    jIntervals.add(current);
                    result.append("J");
                } else if (!overlapC) {
                    cIntervals.add(current);
                    result.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            String output = impossible ? "IMPOSSIBLE" : result.toString();
            System.out.println("Case #" + (caseIndex + 1) + ": " + output);
        }
    }

    private static boolean hasOverlap(Interval interval, ArrayList<Interval> intervals) {
        for (Interval existing : intervals) {
            if ((existing.start < interval.end && existing.end > interval.start) ||
                (existing.start <= interval.start && existing.end >= interval.end)) {
                return true;
            }
        }
        return false;
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}