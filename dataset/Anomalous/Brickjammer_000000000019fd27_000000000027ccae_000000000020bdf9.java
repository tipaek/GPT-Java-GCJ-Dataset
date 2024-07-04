import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution {
    private final Scanner scanner;
    private final InputStream in;
    private final PrintStream out;

    public Solution(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public static void main(String[] args) {
        Solution solution = new Solution(System.in, System.out);
        solution.process();
    }

    public void process() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            Interval[] intervals = new Interval[activityCount];
            for (int j = 0; j < activityCount; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt() - 1);
            }
            evaluateTestCase(i, intervals);
        }
    }

    private void evaluateTestCase(int testCaseNumber, Interval[] intervals) {
        String result = scheduleActivities(intervals);
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    private String scheduleActivities(Interval[] intervals) {
        int[] cameronSchedule = new int[24 * 60 + 1];
        int[] jamieSchedule = new int[24 * 60 + 1];

        Arrays.sort(intervals, Comparator.comparingInt((Interval v) -> v.start).thenComparingInt(v -> v.end));

        for (Interval interval : intervals) {
            if (isAvailable(jamieSchedule, interval)) {
                bookInterval(jamieSchedule, interval);
                interval.assignedTo = "J";
            } else if (isAvailable(cameronSchedule, interval)) {
                bookInterval(cameronSchedule, interval);
                interval.assignedTo = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return Arrays.stream(intervals)
                     .map(interval -> interval.assignedTo)
                     .collect(Collectors.joining());
    }

    private void bookInterval(int[] schedule, Interval interval) {
        for (int i = interval.start; i <= interval.end; i++) {
            schedule[i] = 1;
        }
    }

    private boolean isAvailable(int[] schedule, Interval interval) {
        for (int i = interval.start; i <= interval.end; i++) {
            if (schedule[i] == 1) return false;
        }
        return true;
    }

    public static class Interval {
        int start;
        int end;
        String assignedTo;

        public Interval(int start, int end) {
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