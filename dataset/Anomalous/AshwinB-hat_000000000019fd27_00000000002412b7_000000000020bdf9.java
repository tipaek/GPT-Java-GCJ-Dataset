import java.util.Arrays;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    int start, end, index;

    public Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }
}

public class Solution {

    public static String solve(Interval[] intervals) {
        Arrays.sort(intervals);
        String[] assignments = new String[intervals.length];

        Interval cameron = null, jamie = null;

        for (Interval interval : intervals) {
            if (cameron == null) {
                cameron = interval;
                assignments[interval.index] = "C";
            } else if (jamie == null) {
                jamie = interval;
                assignments[interval.index] = "J";
            } else {
                if (interval.start >= cameron.end) {
                    cameron = interval;
                    assignments[interval.index] = "C";
                } else if (interval.start >= jamie.end) {
                    jamie = interval;
                    assignments[interval.index] = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String assignment : assignments) {
            result.append(assignment);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }

            String result = solve(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}