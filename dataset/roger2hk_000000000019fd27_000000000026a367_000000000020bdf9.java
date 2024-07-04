import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int activityCount = in.nextInt();

            StringBuilder sb = new StringBuilder();
            Set<Interval> cIntervals = new HashSet<>();
            Set<Interval> jIntervals = new HashSet<>();
            boolean impossible = false;

            for (int j = 0; j < activityCount; j++) {
                int begin = in.nextInt();
                int end = in.nextInt();
                Interval interval = new Interval(begin, end);

                // Check if Cameron is free
                if (!isIntervalOverlapped(cIntervals, interval)) {
                    cIntervals.add(interval);
                    sb.append("C");
                }
                // Check if Jamie is free
                else if (!isIntervalOverlapped(jIntervals, interval)) {
                    jIntervals.add(interval);
                    sb.append("J");
                }
                // Else
                else {
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : sb.toString()));
        }
    }

    private static boolean isIntervalOverlapped(Set<Interval> intervals, Interval interval) {
        for (Interval i : intervals) {
            if (Math.max(i.begin, interval.begin) < Math.min(i.end, interval.end)) {
                return true;
            }
        }
        return false;
    }

    public static class Interval {
        int begin, end;

        public Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
