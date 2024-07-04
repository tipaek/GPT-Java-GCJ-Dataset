import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Range {
        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Range other) {
            return (other.start < end && other.end > start);
        }
    }

    public static class Schedule {
        private final List<Range> ranges = new ArrayList<>();

        public boolean addRange(Range range) {
            for (Range existingRange : ranges) {
                if (existingRange.overlapsWith(range)) {
                    return false;
                }
            }
            ranges.add(range);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            Schedule cameronSchedule = new Schedule();
            Schedule jamieSchedule = new Schedule();

            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Range currentRange = new Range(start, end);

                if (result.length() == 0 || !result.toString().equals("IMPOSSIBLE")) {
                    if (cameronSchedule.addRange(currentRange)) {
                        result.append("C");
                    } else if (jamieSchedule.addRange(currentRange)) {
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}