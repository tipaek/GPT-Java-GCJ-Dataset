import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isDisjoint(Range other) {
            return other.end <= this.start || this.end <= other.start;
        }
    }

    public static class Schedule {
        private List<Range> ranges = new ArrayList<>();

        public boolean addRange(Range newRange) {
            for (Range range : ranges) {
                if (!range.isDisjoint(newRange)) {
                    return false;
                }
            }
            ranges.add(newRange);
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

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                Range newRange = new Range(start, end);
                if (cameronSchedule.addRange(newRange)) {
                    result.append("C");
                } else if (jamieSchedule.addRange(newRange)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}