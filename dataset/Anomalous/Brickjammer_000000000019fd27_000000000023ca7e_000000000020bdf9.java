package codejam2020;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;
    private final PrintStream out;

    public Solution(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(System.in, System.out);
        solution.execute();
    }

    public void execute() {
        int numTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numTests; testCase++) {
            int numActivities = scanner.nextInt();
            Interval[] intervals = new Interval[numActivities];

            for (int i = 0; i < numActivities; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(intervals, Comparator.comparingInt((Interval interval) -> interval.start)
                    .thenComparingInt(interval -> interval.end));

            assignActivities(testCase, intervals);
        }
    }

    private void assignActivities(int testCase, Interval[] intervals) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder assignments = new StringBuilder();

        for (Interval interval : intervals) {
            if (interval.start >= cameronEnd) {
                cameronEnd = interval.end;
                assignments.append("C");
            } else if (interval.start >= jamieEnd) {
                jamieEnd = interval.end;
                assignments.append("J");
            } else {
                assignments = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        out.println("Case #" + testCase + ": " + assignments);
    }

    private static class Interval {
        final int start;
        final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}