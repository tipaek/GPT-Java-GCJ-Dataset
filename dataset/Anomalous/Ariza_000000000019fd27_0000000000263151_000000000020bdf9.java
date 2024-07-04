import java.util.*;

public class Solution {
    static class Interval {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static boolean isNonOverlapping(List<Interval> intervals) {
        int lastEnd = -1;
        for (Interval interval : intervals) {
            if (interval.start < lastEnd) return false;
            lastEnd = interval.end;
        }
        return true;
    }

    static String assignTasks(List<Interval> intervals) {
        int n = intervals.size();
        intervals.sort(Comparator.comparingInt(a -> a.end));

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Interval> cameron = new ArrayList<>();
            List<Interval> jamie = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    cameron.add(intervals.get(j));
                } else {
                    jamie.add(intervals.get(j));
                }
            }

            if (isNonOverlapping(cameron) && isNonOverlapping(jamie)) {
                char[] result = new char[n];
                for (Interval interval : cameron) {
                    result[interval.index] = 'C';
                }
                for (Interval interval : jamie) {
                    result[interval.index] = 'J';
                }
                return new String(result);
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}