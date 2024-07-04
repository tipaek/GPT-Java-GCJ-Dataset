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
        Collections.sort(intervals, Comparator.comparingInt(a -> a.end));
        int[] assignments = new int[intervals.size()];
        Arrays.fill(assignments, 0);

        int lastC = -1, lastJ = -1;
        for (Interval interval : intervals) {
            if (lastC <= interval.start) {
                assignments[interval.index] = 1;
                lastC = interval.end;
            } else if (lastJ <= interval.start) {
                assignments[interval.index] = 2;
                lastJ = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
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