import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Interval {
        Integer start;
        Integer end;
        Integer index;

        public Interval(int start, int end, Integer index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Interval [start=" + start + ", end=" + end + "]";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            boolean invalidInput = false;
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (start < 0 || end > 1440 || end <= start) {
                    invalidInput = true;
                }
                intervals.add(new Interval(start, end, i));
            }

            if (N < 2 || invalidInput) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                continue;
            }

            Collections.sort(intervals, Comparator.comparingInt(interval -> interval.end));

            int[] endTimes = new int[2]; // endTimes[0] for C, endTimes[1] for J
            char[] result = new char[N];
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (endTimes[0] <= interval.start) {
                    endTimes[0] = interval.end;
                    result[interval.index] = 'C';
                } else if (endTimes[1] <= interval.start) {
                    endTimes[1] = interval.end;
                    result[interval.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + new String(result));
            }
        }

        scanner.close();
    }
}