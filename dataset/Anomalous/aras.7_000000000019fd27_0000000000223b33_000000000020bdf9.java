import java.util.*;
import java.io.*;

public class Solution {

    static class Interval implements Comparable<Interval> {
        int id, start, end;

        Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", start, end);
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return other.end - this.end;
        }

        boolean overlaps(Interval other) {
            return Math.max(this.start, other.start) < Math.min(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(i, scanner.nextInt(), scanner.nextInt()));
            }
            System.out.printf("Case #%d: %s\n", testCase, solve(intervals));
        }
    }

    private static String solve(List<Interval> intervals) {
        String[] assignments = new String[intervals.size()];
        Interval cameron = new Interval(-1, -1, -1);
        Interval jamie = new Interval(-1, -1, -1);

        Collections.sort(intervals);
        for (Interval interval : intervals) {
            if (!cameron.overlaps(interval)) {
                cameron = interval;
                assignments[interval.id] = "C";
            } else if (!jamie.overlaps(interval)) {
                jamie = interval;
                assignments[interval.id] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", assignments);
    }
}