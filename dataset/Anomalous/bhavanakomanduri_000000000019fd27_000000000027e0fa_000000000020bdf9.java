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

    public static String assignActivities(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        int cEnd = 0;
        int jEnd = 0;
        char[] result = new char[intervals.size()];

        for (Interval interval : intervals) {
            if (interval.start < cEnd && interval.start < jEnd) {
                return "IMPOSSIBLE";
            }
            if (interval.start >= cEnd) {
                result[interval.index] = 'C';
                cEnd = interval.end;
            } else {
                result[interval.index] = 'J';
                jEnd = interval.end;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }

            String result = assignActivities(intervals);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}