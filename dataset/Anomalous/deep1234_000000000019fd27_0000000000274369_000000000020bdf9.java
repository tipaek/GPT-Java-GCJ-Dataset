import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class Interval {
        int start, end, work;

        public Interval(int start, int end, int work) {
            this.start = start;
            this.end = end;
            this.work = work;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int intervalCount = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < intervalCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            String result = assignIntervals(intervals, intervalCount);
            results.add("Case #" + testCase + ": " + result);
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static String assignIntervals(List<Interval> intervals, int intervalCount) {
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        char[] assignments = new char[intervalCount];
        int endC = 0, endJ = 0;

        for (Interval interval : intervals) {
            if (endC <= interval.start) {
                endC = interval.end;
                assignments[interval.work] = 'C';
            } else if (endJ <= interval.start) {
                endJ = interval.end;
                assignments[interval.work] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}