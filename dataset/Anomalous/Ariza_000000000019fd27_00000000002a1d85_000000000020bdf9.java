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

    static String solve(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        int[] assignments = new int[intervals.size()];
        Arrays.fill(assignments, 0);

        int lastCameron = -1;
        for (Interval interval : intervals) {
            if (lastCameron <= interval.start) {
                lastCameron = interval.end;
                assignments[interval.index] = 1;
            }
        }

        int lastJamie = -1;
        for (Interval interval : intervals) {
            if (assignments[interval.index] == 0) {
                if (lastJamie > interval.start) return "IMPOSSIBLE";
                lastJamie = interval.end;
            }
        }

        char[] result = new char[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            result[intervals.get(i).index] = assignments[intervals.get(i).index] == 1 ? 'C' : 'J';
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int numberOfIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < numberOfIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }

            String result = solve(intervals);
            System.out.println("Case #" + test + ": " + result);
        }
    }
}