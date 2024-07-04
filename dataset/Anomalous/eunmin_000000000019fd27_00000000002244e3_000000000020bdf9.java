import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class TimeRange {
        private int start;
        private int end;

        public TimeRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(TimeRange other) {
            return (this.start < other.end && this.end > other.start);
        }
    }

    public static class Scheduler {
        private List<TimeRange> timeRanges = new ArrayList<>();

        public boolean canAdd(TimeRange newRange) {
            for (TimeRange range : timeRanges) {
                if (range.overlapsWith(newRange)) {
                    return false;
                }
            }
            timeRanges.add(newRange);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCases; ++caseIndex) {
            Scheduler cameronScheduler = new Scheduler();
            Scheduler jamieScheduler = new Scheduler();

            int tasks = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int taskIndex = 0; taskIndex < tasks; taskIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                TimeRange currentRange = new TimeRange(start, end);

                if (isPossible) {
                    if (cameronScheduler.canAdd(currentRange)) {
                        result.append("C");
                    } else if (jamieScheduler.canAdd(currentRange)) {
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}