import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return String.format("[%d - %d]", start, end);
        }
    }

    private static String assignTasks(List<Interval> intervals) {
        int cEnd = 0;
        int jEnd = 0;
        StringBuilder assignment = new StringBuilder();
        for (Interval interval : intervals) {
            if (cEnd <= interval.start) {
                cEnd = interval.end;
                assignment.append('C');
            } else if (jEnd <= interval.start) {
                jEnd = interval.end;
                assignment.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return assignment.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int numIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(numIntervals);
            for (int j = 0; j < numIntervals; ++j) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }
            intervals.sort((a, b) -> {
                if (a.start == b.start) {
                    return Integer.compare(a.end, b.end);
                } else {
                    return Integer.compare(a.start, b.start);
                }
            });

            System.out.println("Case #" + i + ": " + assignTasks(intervals));
        }
        scanner.close();
    }
}