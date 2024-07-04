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
        solution.processInput();
    }

    public void processInput() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            Interval[] intervals = new Interval[activityCount];
            for (int j = 0; j < activityCount; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(intervals, Comparator.comparingInt((Interval interval) -> interval.start)
                                             .thenComparingInt(interval -> interval.end));
            handleTestCase(i, intervals);
        }
    }

    private void handleTestCase(int testCaseNumber, Interval[] intervals) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (Interval interval : intervals) {
            if (interval.start >= cameronEnd) {
                cameronEnd = interval.end;
                schedule.append("C");
            } else if (interval.start >= jamieEnd) {
                jamieEnd = interval.end;
                schedule.append("J");
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        out.println("Case #" + testCaseNumber + ": " + schedule);
    }

    static class Interval {
        final int start;
        final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}