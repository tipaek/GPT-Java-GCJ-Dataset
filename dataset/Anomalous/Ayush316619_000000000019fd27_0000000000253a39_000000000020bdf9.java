import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(reader.readLine().trim());
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().trim().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                intervals[i] = new Interval(start, end);
            }

            Arrays.sort(intervals, new IntervalComparator());

            Interval cameron = new Interval(intervals[0].start, intervals[0].end);
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder("C");

            Interval jamie = new Interval(-1, -1);

            for (int i = 1; i < n; i++) {
                Interval current = intervals[i];
                int newStart = current.start;
                int newEnd = current.end;

                if (cameron.end <= newStart) {
                    cameron.start = newStart;
                    cameron.end = newEnd;
                    schedule.append('C');
                } else if (jamie.start == -1 || jamie.end <= newStart) {
                    jamie.start = newStart;
                    jamie.end = newEnd;
                    schedule.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + tc + ": " + schedule);
            }
        }
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.end, b.end);
        }
    }
}