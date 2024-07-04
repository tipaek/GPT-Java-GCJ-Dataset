import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                TimeSpan[] intervals = new TimeSpan[n];
                TimeSpan[] sortedIntervals = new TimeSpan[n];

                for (int i = 0; i < n; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    intervals[i] = new TimeSpan(start, end);
                    sortedIntervals[i] = intervals[i];
                }

                Arrays.sort(sortedIntervals);

                int lastC = 0;
                sortedIntervals[lastC].assignedTo = "C";
                for (int i = 1; i < n; i++) {
                    if (!sortedIntervals[lastC].overlaps(sortedIntervals[i])) {
                        lastC = i;
                        sortedIntervals[lastC].assignedTo = "C";
                    }
                }

                boolean isImpossible = false;
                int lastJ = -1;
                for (int i = 0; i < n; i++) {
                    if (sortedIntervals[i].assignedTo.equals("J")) {
                        if (lastJ < 0) {
                            lastJ = i;
                        } else if (sortedIntervals[lastJ].overlaps(sortedIntervals[i])) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                String result;
                if (isImpossible) {
                    result = "IMPOSSIBLE";
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (TimeSpan interval : intervals) {
                        sb.append(interval.assignedTo);
                    }
                    result = sb.toString();
                }

                System.out.printf("Case #%d: %s%n", t, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class TimeSpan implements Comparable<TimeSpan> {
        final int start;
        final int end;
        String assignedTo = "J";

        TimeSpan(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeSpan other) {
            return Integer.compare(this.start, other.start);
        }

        boolean overlaps(TimeSpan other) {
            return (this.start < other.end && other.start < this.end);
        }
    }
}