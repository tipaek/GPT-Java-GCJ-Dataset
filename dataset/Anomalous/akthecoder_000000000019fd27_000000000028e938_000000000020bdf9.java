import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Interval {
        int start;
        int end;
        int originalIndex;
        String assignedTo;

        public Interval(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
            this.assignedTo = "X";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int N = scanner.nextInt();
            Interval[] intervals = new Interval[N];

            for (int j = 0; j < N; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt(), j);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
            if (assignPartners(intervals)) {
                Arrays.sort(intervals, Comparator.comparingInt(a -> a.originalIndex));
                StringBuilder result = new StringBuilder();
                for (Interval interval : intervals) {
                    result.append(interval.assignedTo);
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static boolean assignPartners(Interval[] intervals) {
        int endJ = 0;
        int endC = 0;

        for (Interval interval : intervals) {
            if (interval.start >= endJ) {
                endJ = interval.end;
                interval.assignedTo = "J";
            } else if (interval.start >= endC) {
                endC = interval.end;
                interval.assignedTo = "C";
            } else {
                return false;
            }
        }
        return true;
    }
}