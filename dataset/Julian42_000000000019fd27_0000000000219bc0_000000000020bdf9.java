import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static class Interval implements Comparable<Interval> {
        public int start, end, index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            // Sort by end, then by start
            if (end == other.end) {
                return Integer.compare(start, other.start);
            }

            return Integer.compare(end, other.end);
        }
    }

    public static void main(String[] args) throws IOException {
        // Scheduling problem, two people, no overlaps allowed

        // Find any schedule that does not require the same person to cover overlapping activities or say that it is impossible

        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int x = 1; x <= numTestCases; x++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                intervals[i] = new Interval(start, end, i);
            }


            Arrays.sort(intervals); // Now sorted by end

            char[] res = new char[n];
            int cEnd = 0;
            int jEnd = 0;
            boolean skip = false;
            for (int i = 0; i < n; i++) {
                if (intervals[i].start >= cEnd) {
                    cEnd = intervals[i].end;
                    // Add this as a c to res
                    res[intervals[i].index] = 'C';
                } else if (intervals[i].start >= jEnd) {
                    jEnd = intervals[i].end;
                    res[intervals[i].index] = 'J';
                } else {
                    // Impossible
                    System.out.println("Case #" + x + ": IMPOSSIBLE");
                    skip = true;
                    break;
                }
            }
            if (!skip)
                System.out.println("Case #" + x + ": " + new String(res));
        }
    }
}
