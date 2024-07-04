import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {

    private final Scanner scanner;
    private final PrintStream out;

    public Solution(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(System.in, System.out);
        solution.run();
    }

    public void run() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            Interval[] intervals = new Interval[activityCount];
            for (int j = 0; j < activityCount; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
            }
            processTestCase(i, intervals);
        }
    }

    private void processTestCase(int testCaseNumber, Interval[] intervals) {
        String result = assignActivities(intervals);
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    private String assignActivities(Interval[] intervals) {
        int[] cameronSchedule = new int[24 * 60];
        int[] jamieSchedule = new int[24 * 60];
        StringBuilder assignment = new StringBuilder();

        for (Interval interval : intervals) {
            if (isAvailable(jamieSchedule, interval)) {
                book(jamieSchedule, interval);
                assignment.append('J');
            } else if (isAvailable(cameronSchedule, interval)) {
                book(cameronSchedule, interval);
                assignment.append('C');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return assignment.toString();
    }

    private boolean isAvailable(int[] schedule, Interval interval) {
        for (int i = interval.start; i < interval.end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private void book(int[] schedule, Interval interval) {
        for (int i = interval.start; i < interval.end; i++) {
            schedule[i] = 1;
        }
    }

    private static class Interval {
        final int start;
        final int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Interval.class.getSimpleName() + "[", "]")
                    .add("start=" + start)
                    .add("end=" + end)
                    .toString();
        }
    }
}