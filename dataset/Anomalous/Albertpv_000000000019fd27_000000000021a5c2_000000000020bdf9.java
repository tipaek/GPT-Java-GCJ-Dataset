import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public String solve(Interval[] intervals) {
        int cameronEnd = 0, jamieEnd = 0;
        StringBuilder schedule = new StringBuilder();

        Arrays.sort(intervals);

        for (Interval interval : intervals) {
            if (interval.start >= cameronEnd) {
                schedule.append('C');
                cameronEnd = interval.end;
            } else if (interval.start >= jamieEnd) {
                schedule.append('J');
                jamieEnd = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            Interval[] intervals = new Interval[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                intervals[i] = new Interval(start, end);
            }

            String result = solution.solve(intervals);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}