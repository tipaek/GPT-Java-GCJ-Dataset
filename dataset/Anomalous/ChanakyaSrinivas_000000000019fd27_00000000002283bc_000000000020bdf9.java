import java.util.Arrays;
import java.util.Scanner;

class TimeInterval implements Comparable<TimeInterval> {
    int start;
    int end;
    char assigned;

    TimeInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(TimeInterval other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numIntervals = scanner.nextInt();
            TimeInterval[] intervals = new TimeInterval[numIntervals];
            TimeInterval[] originalOrder = new TimeInterval[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new TimeInterval(start, end);
                originalOrder[i] = intervals[i];
            }

            Arrays.sort(intervals);

            int cEndTime = 0;
            int jEndTime = 0;
            boolean possible = true;

            for (TimeInterval interval : intervals) {
                if (interval.start >= cEndTime) {
                    interval.assigned = 'C';
                    cEndTime = interval.end;
                } else if (interval.start >= jEndTime) {
                    interval.assigned = 'J';
                    jEndTime = interval.end;
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (TimeInterval interval : originalOrder) {
                    System.out.print(interval.assigned);
                }
                System.out.println();
            }
        }
    }
}