package codejam2020;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingProblem {
    private Scanner scanner;
    private InputStream in;
    private PrintStream out;

    public ParentingProblem(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public static void main(String[] args) {
        new ParentingProblem(System.in, System.out).run();
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            Interval[] intervals = new Interval[activityCount];
            for (int j = 0; j < activityCount; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(intervals, Comparator.comparingInt((Interval v) -> v.start).thenComparingInt(v -> v.end));
            processTestCase(i, intervals);
        }
    }

    private void processTestCase(int testCaseNumber, Interval[] intervals) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (Interval interval : intervals) {
            if (interval.start >= cameronEnd) {
                cameronEnd = interval.end;
                schedule.append('C');
            } else if (interval.start >= jamieEnd) {
                jamieEnd = interval.end;
                schedule.append('J');
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        out.println("Case #" + testCaseNumber + ": " + schedule.toString());
    }

    private static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}