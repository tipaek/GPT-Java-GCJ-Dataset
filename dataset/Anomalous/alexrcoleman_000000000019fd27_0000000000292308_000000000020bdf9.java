import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<TimeRange> timeRanges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeRanges.add(new TimeRange(i, start, end));
            }

            Collections.sort(timeRanges);

            int cEnd = 0;
            int jEnd = 0;
            char[] schedule = new char[n];
            boolean isImpossible = false;

            for (TimeRange range : timeRanges) {
                if (cEnd <= range.start) {
                    cEnd = range.end;
                    schedule[range.index] = 'C';
                } else if (jEnd <= range.start) {
                    jEnd = range.end;
                    schedule[range.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", t, isImpossible ? "IMPOSSIBLE" : new String(schedule));
        }
    }

    static class TimeRange implements Comparable<TimeRange> {
        int start, end, index;

        public TimeRange(int index, int start, int end) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(TimeRange other) {
            return Integer.compare(this.start, other.start);
        }
    }
}