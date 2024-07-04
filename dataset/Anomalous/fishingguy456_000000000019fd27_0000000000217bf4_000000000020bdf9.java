import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            TimeInterval[] intervals = new TimeInterval[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new TimeInterval(start, end);
            }

            Arrays.sort(intervals);

            TimeInterval cameron = new TimeInterval(0, 0);
            TimeInterval james = new TimeInterval(0, 0);
            StringBuilder schedule = new StringBuilder();

            cameron = intervals[0];
            schedule.append("C");

            boolean possible = true;

            for (int j = 1; j < n; j++) {
                if (intervals[j].start >= cameron.end) {
                    schedule.append("C");
                    cameron = intervals[j];
                } else if (intervals[j].start >= james.end) {
                    schedule.append("J");
                    james = intervals[j];
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
            }
        }
    }

    static class TimeInterval implements Comparable<TimeInterval> {
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeInterval other) {
            return Integer.compare(this.start, other.start);
        }
    }
}