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
        intervals.sort(Comparator.comparingInt(a -> a.end));
        int[] assignments = new int[intervals.size()];
        int iteration = 1;

        while (true) {
            int lastEnd = -1;
            boolean assigned = false;
            for (Interval interval : intervals) {
                if (assignments[interval.index] != 0) continue;
                if (lastEnd <= interval.start) {
                    lastEnd = interval.end;
                    assignments[interval.index] = iteration;
                    assigned = true;
                }
            }
            if (!assigned) break;
            iteration++;
        }

        if (iteration > 2) return "IMPOSSIBLE";

        char[] result = new char[intervals.size()];
        for (Interval interval : intervals) {
            result[interval.index] = assignments[interval.index] == 1 ? 'C' : 'J';
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int test = 1; test <= testCases; ++test) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            String result = solve(intervals);
            System.out.println("Case #" + test + ": " + result);
        }
    }
}