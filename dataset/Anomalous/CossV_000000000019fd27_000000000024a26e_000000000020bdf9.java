import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int intervalsCount = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();

            for (int i = 0; i < intervalsCount; i++) {
                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                Interval currentInterval = new Interval(start, end);

                if (hasOverlap(cIntervals, currentInterval)) {
                    if (hasOverlap(jIntervals, currentInterval)) {
                        result = new StringBuilder("IMPOSSIBLE");
                    } else {
                        jIntervals.add(currentInterval);
                        result.append("J");
                    }
                } else {
                    cIntervals.add(currentInterval);
                    result.append("C");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean hasOverlap(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (isOverlapping(interval, newInterval)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(Interval interval1, Interval interval2) {
        return interval1.start < interval2.end && interval2.start < interval1.end;
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