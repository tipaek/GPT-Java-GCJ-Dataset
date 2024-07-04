import java.util.*;

public class Solution {
    static class Interval {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static String solve(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.end));
        int[] assignments = new int[intervals.size()];
        Arrays.fill(assignments, 0);

        int currentIteration = 1;
        while (true) {
            int lastEndTime = -1;
            boolean assigned = false;
            for (Interval interval : intervals) {
                if (assignments[interval.index] != 0) continue;

                if (lastEndTime <= interval.start) {
                    lastEndTime = interval.end;
                    assignments[interval.index] = currentIteration;
                    assigned = true;
                }
            }
            if (!assigned) break;
            currentIteration++;
        }
        currentIteration--;

        if (currentIteration > 2) {
            return "IMPOSSIBLE";
        }

        char[] result = new char[intervals.size()];
        for (Interval interval : intervals) {
            result[interval.index] = (assignments[interval.index] == 1) ? 'C' : 'J';
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; ++test) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            String result = solve(intervals);
            System.out.println("Case #" + test + ": " + result);
        }
    }
}