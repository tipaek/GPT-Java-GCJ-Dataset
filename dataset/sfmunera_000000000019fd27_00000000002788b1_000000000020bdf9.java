import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                intervals.add(new Interval(in.nextInt(), in.nextInt(), i));
            }
            Collections.sort(intervals);
            boolean impossible = false;
            char[] schedule = new char[N];
            List<Interval> activeIntervals = new ArrayList<>();
            for (Interval interval : intervals) {
                List<Interval> add = new ArrayList<>();
                for (Interval activeInterval : activeIntervals) {
                    if (interval.start < activeInterval.end) {
                        add.add(activeInterval);
                    }
                }
                activeIntervals = new ArrayList<>(add);
                if (activeIntervals.size() >= 2) {
                    impossible = true;
                    break;
                } else if (activeIntervals.size() == 1) {
                    char other = schedule[activeIntervals.get(0).index];
                    schedule[interval.index] = other == 'C' ? 'J' : 'C';
                } else {
                    schedule[interval.index] = 'C';
                }
                activeIntervals.add(interval);
            }
            System.out.println("Case #" + t + ": " + (impossible ? "IMPOSSIBLE" : String.valueOf(schedule)));
        }

        in.close();
    }

    private static class Interval implements Comparable<Interval> {
        int start, end, index;
        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        @Override
        public int compareTo(Interval that) {
            if (this.start != that.start) return this.start - that.start;
            return this.end - that.end;
        }
    }
}
