import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        Solution parentingProblem = new Solution(System.in, System.out);
        parentingProblem.execute();
    }

    public void processTest(int testNum, Interval[] intervals) {
        int[] cameronSchedule = new int[24 * 60];
        int[] jamieSchedule = new int[24 * 60];
        StringBuilder result = new StringBuilder();

        for (Interval interval : intervals) {
            if (isAvailable(cameronSchedule, interval)) {
                reserve(cameronSchedule, interval);
                result.append("C");
            } else if (isAvailable(jamieSchedule, interval)) {
                reserve(jamieSchedule, interval);
                result.append("J");
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        out.println("Case #" + testNum + ": " + result);
    }

    private void reserve(int[] schedule, Interval interval) {
        for (int i = interval.start; i < interval.end; i++) {
            schedule[i] = 1;
        }
    }

    private boolean isAvailable(int[] schedule, Interval interval) {
        for (int i = interval.start; i < interval.end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private void execute() {
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            Interval[] intervals = new Interval[activityCount];
            for (int j = 0; j < activityCount; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
            }

            processTest(i, intervals);
        }
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}