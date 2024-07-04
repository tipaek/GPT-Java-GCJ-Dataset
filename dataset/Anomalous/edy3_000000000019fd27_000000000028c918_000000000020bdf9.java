import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Interval {
        int start, end, order;

        Interval(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }

        @Override
        public String toString() {
            return String.format("[%d - %d]", start, end);
        }
    }

    private static String solve(List<Interval> intervals) {
        int cEnd = 0, jEnd = 0;
        char[] schedule = new char[intervals.size()];

        for (Interval interval : intervals) {
            if (cEnd <= interval.start) {
                cEnd = interval.end;
                schedule[interval.order] = 'C';
            } else if (jEnd <= interval.start) {
                jEnd = interval.end;
                schedule[interval.order] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(n);

            for (int i = 0; i < n; ++i) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt(), i));
            }

            intervals.sort((a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);

            String result = solve(intervals);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}