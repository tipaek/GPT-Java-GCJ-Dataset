import java.util.*;

public class Solution {

    public static String getResult(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        int cEnd = -1;
        int jEnd = -1;
        char[] result = new char[intervals.length];
        for (Interval interval : intervals) {
            if (cEnd <= interval.start) {
                result[interval.original] = 'C';
                cEnd = interval.end;
            } else if (jEnd <= interval.start) {
                result[interval.original] = 'J';
                jEnd = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt(), j);
            }
            System.out.println("Case #" + (i + 1) + ": " + getResult(intervals));
        }
    }

    public static class Interval {
        int start;
        int end;
        int original;

        public Interval(int start, int end, int original) {
            this.start = start;
            this.end = end;
            this.original = original;
        }
    }
}